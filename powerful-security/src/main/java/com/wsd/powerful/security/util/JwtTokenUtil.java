package com.wsd.powerful.security.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description JwtToken生成的工具类
 * @author      tm
 * @createDate  2020-5-14 12:08
 * @updateDate  2020-5-14 12:08
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Slf4j
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "user_name";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * @description 生成JWT的token
     * @author      tm
     * @createDate  2020-5-14 12:11
     * @updateDate  2020-5-14 12:11
     * @updateUser
     * @updateRemark
     * @version     1.0.0
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * @description 从token中获取JWT中的负载
     * @author      tm
     * @createDate  2020-5-14 12:11
     * @updateDate  2020-5-14 12:11
     * @updateUser
     * @updateRemark
     * @version     1.0.0
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     *@description 生成token的过期时间
     *@params  []
     *@return  java.util.Date
     *@author  tm
     *@createDate  2020-5-14 12:12
     *@updateRemark
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     *@description 从token中获取登录用户名
     *@params  [token]
     *@return  java.lang.String
     *@author  tm
     *@createDate  2020-5-14 12:12
     *@updateRemark
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.get(CLAIM_KEY_USERNAME,String.class);
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     *@description 验证token是否还有效
     *@params  [token, userDetails:用户信息]
     *@return  boolean
     *@author  tm
     *@createDate  2020-5-14 12:13
     *@updateRemark
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     *@description 判断token是否已经失效
     *@params  [token]
     *@return  boolean
     *@author  tm
     *@createDate  2020-5-14 12:13
     *@updateRemark
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     *@description 从token中获取过期时间
     *@params  [token]
     *@return  java.util.Date
     *@author  tm
     *@createDate  2020-5-14 12:14
     *@updateRemark
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     *@description 根据用户信息生成token
     *@params  [userDetails:用户信息]
     *@return  java.lang.String
     *@author  tm
     *@createDate  2020-5-14 12:14
     *@updateRemark
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     *@description 刷新token
     *@params  [oldToken:带tokenHead的token]
     *@return  java.lang.String
     *@author  tm
     *@createDate  2020-5-14 12:17
     *@updateRemark
     */
    public String refreshHeadToken(String oldToken) {
        if(StrUtil.isEmpty(oldToken)){
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //如果token已经过期，不支持刷新
        if(isTokenExpired(token)){
            return null;
        }
        //如果token在30分钟之内刚刷新过，返回原token
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     *@description 判断token在指定时间内是否刚刚刷新过
     *@params  [token:原token, time:指定时间（秒）]
     *@return  boolean
     *@author  tm
     *@createDate  2020-5-14 12:16
     *@updateRemark
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        if(refreshDate.after(created)&&refreshDate.before(DateUtil.offsetSecond(created,time))){
            return true;
        }
        return false;
    }
}
