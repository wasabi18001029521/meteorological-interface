/*
Navicat MySQL Data Transfer

Source Server         : liuhanyu
Source Server Version : 50633
Source Host           : 10.0.66.237:3306
Source Database       : meteorologicalinterface

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-04-10 20:49:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `myweb_mail_retrieve`
-- ----------------------------
DROP TABLE IF EXISTS `myweb_mail_retrieve`;
CREATE TABLE `myweb_mail_retrieve` (
  `id` int(10) NOT NULL DEFAULT '0',
  `account` varchar(20) DEFAULT NULL,
  `sid` char(25) DEFAULT NULL,
  `out_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myweb_mail_retrieve
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_interface`
-- ----------------------------
DROP TABLE IF EXISTS `sys_interface`;
CREATE TABLE `sys_interface` (
  `interface_id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(255) NOT NULL,
  PRIMARY KEY (`interface_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_interface
-- ----------------------------
INSERT INTO `sys_interface` VALUES ('1', '/station/nation/area');

-- ----------------------------
-- Table structure for `sys_privileges`
-- ----------------------------
DROP TABLE IF EXISTS `sys_privileges`;
CREATE TABLE `sys_privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priv_name` varchar(64) NOT NULL,
  `priv_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privileges
-- ----------------------------
INSERT INTO `sys_privileges` VALUES ('1', 'add_user', '添加用户');
INSERT INTO `sys_privileges` VALUES ('2', 'delete_user', '删除用户');
INSERT INTO `sys_privileges` VALUES ('3', 'modify_user', '修改用户');
INSERT INTO `sys_privileges` VALUES ('4', 'query_user', '查询用户');
INSERT INTO `sys_privileges` VALUES ('5', 'add_role', '添加角色');
INSERT INTO `sys_privileges` VALUES ('6', 'delete_role', '删除角色');
INSERT INTO `sys_privileges` VALUES ('7', 'modify_role', '修改角色');
INSERT INTO `sys_privileges` VALUES ('8', 'query_role', '查询角色');
INSERT INTO `sys_privileges` VALUES ('9', 'add_privilege', '添加权限');
INSERT INTO `sys_privileges` VALUES ('10', 'delete_privilege', '删除权限');
INSERT INTO `sys_privileges` VALUES ('11', 'modify_privilege', '修改权限');
INSERT INTO `sys_privileges` VALUES ('12', 'query_privilege', '查询权限');
INSERT INTO `sys_privileges` VALUES ('13', 'add_unit', '添加单位');
INSERT INTO `sys_privileges` VALUES ('14', 'delete_unit', '删除组织架构');
INSERT INTO `sys_privileges` VALUES ('15', 'modify_unit', '修改组织架构');
INSERT INTO `sys_privileges` VALUES ('16', 'query_unit', '查询组织架构');
INSERT INTO `sys_privileges` VALUES ('17', 'add_user_role', '添加用户角色');
INSERT INTO `sys_privileges` VALUES ('18', 'delete_user_role', '删除用户角色');
INSERT INTO `sys_privileges` VALUES ('19', 'modify_user_role', '修改用户角色');
INSERT INTO `sys_privileges` VALUES ('20', 'query_user_role', '查询用户角色');
INSERT INTO `sys_privileges` VALUES ('21', 'add_role_priv', '添加角色权限');
INSERT INTO `sys_privileges` VALUES ('22', 'delete_role_priv', '删除角色权限');
INSERT INTO `sys_privileges` VALUES ('23', 'modify_role_priv', '修改角色权限');
INSERT INTO `sys_privileges` VALUES ('24', 'query_role_priv', '查询角色权限');
INSERT INTO `sys_privileges` VALUES ('25', 'add_notice', '发布公告');
INSERT INTO `sys_privileges` VALUES ('26', 'add_picinfo', '发布图文信息');
INSERT INTO `sys_privileges` VALUES ('27', 'add_news', '发布工作动态');
INSERT INTO `sys_privileges` VALUES ('28', 'add_law', '发布政策支持');
INSERT INTO `sys_privileges` VALUES ('29', 'add_doc', '发布资料下载');
INSERT INTO `sys_privileges` VALUES ('30', 'add_help', '发布帮助中心');
INSERT INTO `sys_privileges` VALUES ('31', 'add_hrreq', '发布人员需求');
INSERT INTO `sys_privileges` VALUES ('32', 'add_hrsup', '发布人员供给');

-- ----------------------------
-- Table structure for `sys_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  `role_desc` varchar(128) DEFAULT NULL,
  `priv_id` int(11) NOT NULL,
  `priv_name` varchar(64) DEFAULT NULL,
  `priv_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('1', '1', 'role_admin', '系统管理员', '1', 'add_user', '添加用户');
INSERT INTO `sys_role_privilege` VALUES ('2', '1', 'role_admin', '系统管理员', '2', 'delete_user', '删除用户');
INSERT INTO `sys_role_privilege` VALUES ('3', '1', 'role_admin', '系统管理员', '3', 'modify_user', '修改用户');
INSERT INTO `sys_role_privilege` VALUES ('4', '1', 'role_admin', '系统管理员', '4', 'query_user', '查询用户');
INSERT INTO `sys_role_privilege` VALUES ('5', '1', 'role_admin', '系统管理员', '5', 'add_role', '添加角色');
INSERT INTO `sys_role_privilege` VALUES ('6', '1', 'role_admin', '系统管理员', '6', 'delete_role', '删除角色');
INSERT INTO `sys_role_privilege` VALUES ('7', '1', 'role_admin', '系统管理员', '7', 'modify_role', '修改角色');
INSERT INTO `sys_role_privilege` VALUES ('8', '1', 'role_admin', '系统管理员', '8', 'query_role', '查询角色');
INSERT INTO `sys_role_privilege` VALUES ('9', '1', 'role_admin', '系统管理员', '9', 'add_privilege', '添加权限');
INSERT INTO `sys_role_privilege` VALUES ('10', '1', 'role_admin', '系统管理员', '10', 'delete_privilege', '删除权限');
INSERT INTO `sys_role_privilege` VALUES ('11', '1', 'role_admin', '系统管理员', '11', 'modify_privilege', '修改权限');
INSERT INTO `sys_role_privilege` VALUES ('12', '1', 'role_admin', '系统管理员', '12', 'query_privilege', '查询权限');
INSERT INTO `sys_role_privilege` VALUES ('13', '1', 'role_admin', '系统管理员', '13', 'add_unit', '添加单位');
INSERT INTO `sys_role_privilege` VALUES ('14', '1', 'role_admin', '系统管理员', '14', 'delete_unit', '删除组织架构');
INSERT INTO `sys_role_privilege` VALUES ('15', '1', 'role_admin', '系统管理员', '15', 'modify_unit', '修改组织架构');
INSERT INTO `sys_role_privilege` VALUES ('16', '1', 'role_admin', '系统管理员', '16', 'query_unit', '查询组织架构');
INSERT INTO `sys_role_privilege` VALUES ('17', '1', 'role_admin', '系统管理员', '17', 'add_user_role', '添加用户角色');
INSERT INTO `sys_role_privilege` VALUES ('18', '1', 'role_admin', '系统管理员', '18', 'delete_user_role', '删除用户角色');
INSERT INTO `sys_role_privilege` VALUES ('19', '1', 'role_admin', '系统管理员', '19', 'modify_user_role', '修改用户角色');
INSERT INTO `sys_role_privilege` VALUES ('20', '1', 'role_admin', '系统管理员', '20', 'query_user_role', '查询用户角色');
INSERT INTO `sys_role_privilege` VALUES ('21', '1', 'role_admin', '系统管理员', '21', 'add_role_priv', '添加角色权限');
INSERT INTO `sys_role_privilege` VALUES ('22', '1', 'role_admin', '系统管理员', '22', 'delete_role_priv', '删除角色权限');
INSERT INTO `sys_role_privilege` VALUES ('23', '1', 'role_admin', '系统管理员', '23', 'modify_role_priv', '修改角色权限');
INSERT INTO `sys_role_privilege` VALUES ('24', '1', 'role_admin', '系统管理员', '24', 'query_role_priv', '查询角色权限');
INSERT INTO `sys_role_privilege` VALUES ('25', '1', 'role_admin', '系统管理员', '25', 'add_notice', '发布公告');
INSERT INTO `sys_role_privilege` VALUES ('26', '1', 'role_admin', '系统管理员', '26', 'add_picinfo', '发布图文信息');
INSERT INTO `sys_role_privilege` VALUES ('27', '1', 'role_admin', '系统管理员', '27', 'add_news', '发布工作动态');
INSERT INTO `sys_role_privilege` VALUES ('28', '1', 'role_admin', '系统管理员', '28', 'add_law', '发布政策支持');
INSERT INTO `sys_role_privilege` VALUES ('29', '1', 'role_admin', '系统管理员', '29', 'add_doc', '发布资料下载');
INSERT INTO `sys_role_privilege` VALUES ('30', '1', 'role_admin', '系统管理员', '30', 'add_help', '发布帮助中心');
INSERT INTO `sys_role_privilege` VALUES ('31', '1', 'role_admin', '系统管理员', '31', 'add_hrreq', '发布人员需求');
INSERT INTO `sys_role_privilege` VALUES ('32', '1', 'role_admin', '系统管理员', '32', 'add_hrsup', '发布人员供给');

-- ----------------------------
-- Table structure for `sys_roles`
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `role_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', 'role_admin', '系统管理员');
INSERT INTO `sys_roles` VALUES ('2', 'role_user', '普通用户');
INSERT INTO `sys_roles` VALUES ('3', 'role_hr_admin', '运输公司人力资源岗');
INSERT INTO `sys_roles` VALUES ('4', 'role_hr_user', '分公司人力资源岗');

-- ----------------------------
-- Table structure for `sys_units`
-- ----------------------------
DROP TABLE IF EXISTS `sys_units`;
CREATE TABLE `sys_units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `unit_name` varchar(64) DEFAULT NULL,
  `unit_full_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_units
-- ----------------------------
INSERT INTO `sys_units` VALUES ('1', null, '中国石油运输有限公司', '中国石油运输有限公司');
INSERT INTO `sys_units` VALUES ('2', '1', '人力资源部', '中国石油运输有限公司人力资源部');

-- ----------------------------
-- Table structure for `sys_user_interface`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_interface`;
CREATE TABLE `sys_user_interface` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `interface_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_interface
-- ----------------------------
INSERT INTO `sys_user_interface` VALUES ('1', '73', '1');
INSERT INTO `sys_user_interface` VALUES ('2', '74', '1');
INSERT INTO `sys_user_interface` VALUES ('3', '75', '1');
INSERT INTO `sys_user_interface` VALUES ('4', '76', '1');
INSERT INTO `sys_user_interface` VALUES ('5', '77', '1');
INSERT INTO `sys_user_interface` VALUES ('6', '78', '1');
INSERT INTO `sys_user_interface` VALUES ('7', '79', '1');
INSERT INTO `sys_user_interface` VALUES ('8', '80', '1');
INSERT INTO `sys_user_interface` VALUES ('9', '81', '1');
INSERT INTO `sys_user_interface` VALUES ('10', '82', '1');
INSERT INTO `sys_user_interface` VALUES ('11', '83', '1');
INSERT INTO `sys_user_interface` VALUES ('12', '84', '1');
INSERT INTO `sys_user_interface` VALUES ('13', '85', '1');
INSERT INTO `sys_user_interface` VALUES ('14', '86', '1');
INSERT INTO `sys_user_interface` VALUES ('15', '87', '1');
INSERT INTO `sys_user_interface` VALUES ('16', '88', '1');
INSERT INTO `sys_user_interface` VALUES ('17', '89', '1');
INSERT INTO `sys_user_interface` VALUES ('18', '90', '1');
INSERT INTO `sys_user_interface` VALUES ('19', '91', '1');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_full_name` varchar(64) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  `role_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', 'admin', '系统管理员', '1', 'role_admin', '系统管理员');
INSERT INTO `sys_user_role` VALUES ('2', '3', 'test@webyun.cn', '测试', '1', 'role_admin', '系统管理员');

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `user_full_name` varchar(64) DEFAULT NULL,
  `user_password` varchar(128) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `unit_name` varchar(64) DEFAULT NULL,
  `unit_full_name` varchar(256) DEFAULT NULL,
  `account_expired` int(11) NOT NULL DEFAULT '0',
  `account_locked` int(11) NOT NULL DEFAULT '0',
  `password_expired` int(11) NOT NULL DEFAULT '0',
  `account_enabled` int(11) NOT NULL DEFAULT '1',
  `email` varchar(128) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `user_key` varchar(32) NOT NULL,
  `user_register` varchar(255) DEFAULT NULL,
  `user_login` varchar(255) DEFAULT NULL,
  `user_effective` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('2', 'user', '测试用户', '$2a$12$bLg1H4ux/57eMnhDpaNMEO1eN8Iwo.AANlJ6sTrZWpoRxkvAhFEr2', '2', '人力资源部', '中国石油运输有限公司人力资源部', '0', '0', '0', '1', null, null, '139', '', null, null, null);
INSERT INTO `sys_users` VALUES ('3', 'test@webyun.cn', '系统管理员', '$2a$10$3x9DVwFiylgBuDQJJyfp/uPhHZCqVlTZpRwMmkUVkCA4fGTlWGYYK', '1', '中国石油运输有限公司', '中国石油运输有限公司', '0', '0', '0', '1', null, '010010', '010', '', null, '2019-04-10 05:53:54', null);
INSERT INTO `sys_users` VALUES ('73', 'new4@qq.com', null, '$2a$10$Wye8qabR/pvfykH50EC5jOml9XWJjhJBEH0cy44eIqXYKm118KhJq', null, null, null, '0', '0', '0', '1', null, null, null, '26f0c5f04bbf744e47e9049e9012f944', null, null, null);
INSERT INTO `sys_users` VALUES ('74', 'new3@163.com', null, '$2a$10$5qbc9r6m4YcDaPNBXhpLNu.knfga2KIggEGs.1DFSbBVV/BXUgkzu', null, null, null, '0', '0', '0', '1', null, null, null, '3984b3c5855abed2acdd6df71bb2e648', null, null, null);
INSERT INTO `sys_users` VALUES ('75', 'test1@webyun.cn', null, '$2a$10$PtSsj3M2eNCntXxR76plXemyxlx4NliKC9foGDt0putqoLo36rm/y', null, null, null, '0', '0', '0', '1', null, null, null, 'c481bf4312ee6c147a2862d0d264171d', null, null, null);
INSERT INTO `sys_users` VALUES ('76', 'new4@163.com', null, '$2a$10$rNCvUHN7LXNt/uIMAOz4Oug0DXMlRmzodZHjFfhCWt/RFR4ZS0ie6', null, null, null, '0', '0', '0', '1', null, null, null, '0952d7d8de604913c301a4057f269bd4', null, null, null);
INSERT INTO `sys_users` VALUES ('77', 'qaz@qq.com', null, '$2a$10$p4ItbMSiEnR/MXRdMjiJVuDCawcxUFtxkKTM59YNtvBR6Bnt3n9We', null, null, null, '0', '0', '0', '1', null, null, null, '5f2945b821dcf2fab7197ed5da908a9f', null, null, null);
INSERT INTO `sys_users` VALUES ('78', 'new@123.com', null, '$2a$10$ehXL6lPyY3LpLLEKm0Kk/O2Ry/OaGhI2jIgv6bCTz79Xpaw06SJbu', null, null, null, '0', '0', '0', '1', null, null, null, '8d2d098780624c5acca5a6a45aca42ca', null, null, null);
INSERT INTO `sys_users` VALUES ('79', 'tes2t@webyun.cn', null, '$2a$10$YALs.qRe.fkm1dGdO2e1mOe7xYm1XWDI7nb5SQEgYj/s44VeoqADi', null, null, null, '0', '0', '0', '1', null, null, null, '2809639d97c1e907ac14b2ba34ec729b', null, '2019-04-03 10:13:55', null);
INSERT INTO `sys_users` VALUES ('80', 'qwe@123.com', null, '$2a$10$2ZQ8S2K1VVjR6A32h9bOz.5A0puwHkKhYjFh65Bp2axdsVJH6BF8i', null, null, null, '0', '0', '0', '1', null, null, null, '04acc4b03442220ac9517deba7b85fcc', null, null, null);
INSERT INTO `sys_users` VALUES ('81', 'qwe2@123.com', null, '$2a$10$g8T.TtPyBK1OpzriqUscO.7DB2wqhe9ft/mrwBEfCxqsKhOUWwIB6', null, null, null, '0', '0', '0', '1', null, null, null, 'f17961ad045c66d1ddbd7cd69680a557', null, null, null);
INSERT INTO `sys_users` VALUES ('82', 'new7@163.com', null, '$2a$10$pNCzAT0Hq9wxw7Aif4a0He63k/7FOQUC2T2Iht5QQsQBlJxJ9bALK', null, null, null, '0', '0', '0', '1', null, null, null, '7c6f05d33892eb3dc10dd1ae50413140', null, null, null);
INSERT INTO `sys_users` VALUES ('83', 'API@qq.com', null, '$2a$10$wS2.ZrAq1CsN7TIbF6LKceXukImQDHZ9N8DjS1jUyhZuPW8Zm/HqS', null, null, null, '0', '0', '0', '1', null, null, null, '5dad304f2ad175d0e10cb8638c968afd', null, '2019-04-02 10:39:09', null);
INSERT INTO `sys_users` VALUES ('84', 'zxc@123.com', null, '$2a$10$mMlJStYfKhi024xSrUGFVu4IydkNMZ1w8C8jr//uUTEB6uTdYkHve', null, null, null, '0', '0', '0', '1', null, null, null, '31c6bd2d53313038e55d941f6f687b4d', null, '2019-04-03 09:46:19', null);
INSERT INTO `sys_users` VALUES ('85', 'qwe123@123.com', null, '$2a$10$kCn9kSp1uUBMaJDJ9XdW5es6ElCgD9S6qnYKnqiTZDxyP.uZ3XFeS', null, null, null, '0', '0', '0', '1', null, null, null, '7e0d59fef75e93476dde006924647aee', '2019-04-01 05:58:15', '2019-04-10 06:21:00', null);
INSERT INTO `sys_users` VALUES ('86', 'aaa@123.com', null, '$2a$10$AqNymnaMgD7Ce83L0IDwr.n4whiovG0I7oNrNGeOdU8X/Mvj.0WWe', null, null, null, '0', '0', '0', '1', null, null, null, 'a57dd73bc095bf66d8e67daf7c560f37', '2019-04-01 06:01:57', '2019-04-02 08:17:42', null);
INSERT INTO `sys_users` VALUES ('87', 'wei@qq.com', null, '$2a$10$o/Vl7kPvejeJYHQ6EMglW.FyhC46Ntzrs7FlcyaWVoe4zShnxSKSe', null, null, null, '0', '0', '0', '1', null, null, null, 'e293ec28a350992e11eb5185bf8eb035', '2019-04-02 03:11:49', '2019-04-10 06:21:46', null);
INSERT INTO `sys_users` VALUES ('88', '123@345.cm', null, '$2a$10$YZ2hxTlRP9/5rYkvFyPK6OcBgz7ES.jonh2j0H.QIjaW4PZiYNzW2', null, null, null, '0', '0', '0', '1', null, null, null, 'f6407b20eb1ce410ad3f4313332e993e', '2019-04-02 07:43:37', '2019-04-09 04:35:53', null);
INSERT INTO `sys_users` VALUES ('89', 'aa@22.cp', null, '$2a$10$4OCrH.rGhDB0AVVSXKUmqOeMm/Poepm/6G7JWdQdoHQ3NllTbIGka', null, null, null, '0', '0', '0', '1', null, null, null, '4a7be0ac45f3310fa81beca25571f1e9', '2019-04-09 06:30:27', null, '2019-04-09 06:30:27');
INSERT INTO `sys_users` VALUES ('90', 'aaa@22.cp', null, '$2a$10$pqwBho/ZzYnrwv9KTpxI9uQLAte8ctl6AAzGwwLV3nMK7Ek/cJ77W', null, null, null, '0', '0', '0', '1', null, null, null, 'ae566413a4d15dfc90bc43152100178c', '2019-04-09 06:30:47', null, '2019-04-09 06:30:47');
INSERT INTO `sys_users` VALUES ('91', '123456789@qq.com', null, '$2a$10$A5zSJ1JbqqiEAfzGHHUPaeqarMPCRAS./VTj4.5IMmtU22Pee9fX2', null, null, null, '0', '0', '0', '1', null, null, null, '315be36db8ad7b3e3a7bb0839d6fa839', '2019-04-10 12:04:48', '2019-04-10 12:05:36', '2019-04-01 06:30:47');
