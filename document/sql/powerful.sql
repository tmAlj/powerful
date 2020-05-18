/*
Navicat MySQL Data Transfer

Source Server         : helloworld
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : powerful

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-05-18 17:32:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  `postid` bigint(20) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('1', 'tm', '$2a$10$EU0ahIrWzoZbduAkYP6U/.lpAt7ypr7kIZF.KbLIfqzkAYSIG/Xa.', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, '测试账号', null, '2018-09-29 13:55:30', '2018-09-29 13:55:39', '1', null);
INSERT INTO `ums_admin` VALUES ('3', 'admin', '$2a$10$HIukCOoyY2lk9FP8YSxWNuxPJIfXpORkOfpEP61yHiaM34m6TcMh6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/170157_yIl3_1767531.jpg', 'admin@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-03-20 15:38:50', '1', null);

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_agent` varchar(100) DEFAULT NULL COMMENT '浏览器登录类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户登录日志表';

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for ums_admin_orgn
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_orgn`;
CREATE TABLE `ums_admin_orgn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `orgn_id` bigint(20) DEFAULT NULL COMMENT '组织id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_admin_orgn
-- ----------------------------

-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
-- Records of ums_admin_permission_relation
-- ----------------------------

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES ('17', '1', '1');

-- ----------------------------
-- Table structure for ums_orgn
-- ----------------------------
DROP TABLE IF EXISTS `ums_orgn`;
CREATE TABLE `ums_orgn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级部门ID，一级部门ID为0',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门名称',
  `sort` int(11) DEFAULT '0' COMMENT '序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `manager` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门负责人',
  `mobile` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `status` int(255) DEFAULT NULL COMMENT '是否启用：0->禁用，1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ums_orgn
-- ----------------------------
INSERT INTO `ums_orgn` VALUES ('1', '0', '集团总部', '0', '2020-03-15 15:35:21', '', '', '', '1');
INSERT INTO `ums_orgn` VALUES ('20', '1', '2', '2', '2020-05-13 06:34:57', '2', '2', '2', '1');

-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户权限表';

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
INSERT INTO `ums_permission` VALUES ('1', '0', '用户', null, null, '0', null, '1', '2018-09-29 16:15:14', '0');
INSERT INTO `ums_permission` VALUES ('2', '1', '用户列表', 'ums:admin:list', null, '1', '/ums/admin/list', '1', '2018-09-29 16:17:01', '0');
INSERT INTO `ums_permission` VALUES ('7', '2', '新增用户', 'ums:admin:add', null, '2', '/ums/admin/add', '1', '2018-09-29 16:34:23', '0');
INSERT INTO `ums_permission` VALUES ('8', '2', '删除用户', 'ums:admin:delete', null, '2', '/ums/admin/delete', '1', '2018-09-29 16:38:33', '0');
INSERT INTO `ums_permission` VALUES ('19', '2', '修改用户', 'ums:admin:update', null, '2', '/ums/admin/update', '1', '2018-09-29 16:38:33', '0');

-- ----------------------------
-- Table structure for ums_post
-- ----------------------------
DROP TABLE IF EXISTS `ums_post`;
CREATE TABLE `ums_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '职位名称',
  `code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '职位编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT NULL COMMENT '是否启用：0->禁用，1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ums_post
-- ----------------------------
INSERT INTO `ums_post` VALUES ('37', '1', '1', '2020-05-10 08:33:23', '1', '1');
INSERT INTO `ums_post` VALUES ('38', '2', '22', '2020-05-11 10:03:57', '222', '1');
INSERT INTO `ums_post` VALUES ('39', '33', '33', '2020-05-11 10:04:02', '333', '1');
INSERT INTO `ums_post` VALUES ('40', '44', '44', '2020-05-11 10:04:07', '44', '1');
INSERT INTO `ums_post` VALUES ('41', '55', '55', '2020-05-11 10:04:12', '55', '1');
INSERT INTO `ums_post` VALUES ('42', '66', '66', '2020-05-11 10:04:21', '666', '0');
INSERT INTO `ums_post` VALUES ('43', '77', '77', '2020-05-11 10:04:27', '77', '0');
INSERT INTO `ums_post` VALUES ('44', '88', '88', '2020-05-11 10:04:36', '88', '1');
INSERT INTO `ums_post` VALUES ('45', '9', '99', '2020-05-11 10:04:42', '99', '1');
INSERT INTO `ums_post` VALUES ('46', '10', '00', '2020-05-11 10:04:53', '0', '1');
INSERT INTO `ums_post` VALUES ('47', '5555', '5555', '2020-05-11 10:05:04', '555', '1');
INSERT INTO `ums_post` VALUES ('48', '3', '3', '2020-05-13 06:47:12', '3', '1');
INSERT INTO `ums_post` VALUES ('49', '4', '4', '2020-05-13 06:47:18', '4', '1');

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', 'user', '普通管理员', '0', '2018-09-30 15:46:11', '1', '0');

-- ----------------------------
-- Table structure for ums_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色和权限关系表';

-- ----------------------------
-- Records of ums_role_permission_relation
-- ----------------------------
INSERT INTO `ums_role_permission_relation` VALUES ('1', '1', '1');
INSERT INTO `ums_role_permission_relation` VALUES ('2', '1', '2');
INSERT INTO `ums_role_permission_relation` VALUES ('3', '1', '19');
INSERT INTO `ums_role_permission_relation` VALUES ('4', '1', '7');
INSERT INTO `ums_role_permission_relation` VALUES ('5', '1', '8');
