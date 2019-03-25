/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : meteorologicalinterface

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 25/03/2019 10:19:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_privileges
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
BEGIN;
INSERT INTO `sys_privileges` VALUES (1, 'add_user', '添加用户');
INSERT INTO `sys_privileges` VALUES (2, 'delete_user', '删除用户');
INSERT INTO `sys_privileges` VALUES (3, 'modify_user', '修改用户');
INSERT INTO `sys_privileges` VALUES (4, 'query_user', '查询用户');
INSERT INTO `sys_privileges` VALUES (5, 'add_role', '添加角色');
INSERT INTO `sys_privileges` VALUES (6, 'delete_role', '删除角色');
INSERT INTO `sys_privileges` VALUES (7, 'modify_role', '修改角色');
INSERT INTO `sys_privileges` VALUES (8, 'query_role', '查询角色');
INSERT INTO `sys_privileges` VALUES (9, 'add_privilege', '添加权限');
INSERT INTO `sys_privileges` VALUES (10, 'delete_privilege', '删除权限');
INSERT INTO `sys_privileges` VALUES (11, 'modify_privilege', '修改权限');
INSERT INTO `sys_privileges` VALUES (12, 'query_privilege', '查询权限');
INSERT INTO `sys_privileges` VALUES (13, 'add_unit', '添加单位');
INSERT INTO `sys_privileges` VALUES (14, 'delete_unit', '删除组织架构');
INSERT INTO `sys_privileges` VALUES (15, 'modify_unit', '修改组织架构');
INSERT INTO `sys_privileges` VALUES (16, 'query_unit', '查询组织架构');
INSERT INTO `sys_privileges` VALUES (17, 'add_user_role', '添加用户角色');
INSERT INTO `sys_privileges` VALUES (18, 'delete_user_role', '删除用户角色');
INSERT INTO `sys_privileges` VALUES (19, 'modify_user_role', '修改用户角色');
INSERT INTO `sys_privileges` VALUES (20, 'query_user_role', '查询用户角色');
INSERT INTO `sys_privileges` VALUES (21, 'add_role_priv', '添加角色权限');
INSERT INTO `sys_privileges` VALUES (22, 'delete_role_priv', '删除角色权限');
INSERT INTO `sys_privileges` VALUES (23, 'modify_role_priv', '修改角色权限');
INSERT INTO `sys_privileges` VALUES (24, 'query_role_priv', '查询角色权限');
INSERT INTO `sys_privileges` VALUES (25, 'add_notice', '发布公告');
INSERT INTO `sys_privileges` VALUES (26, 'add_picinfo', '发布图文信息');
INSERT INTO `sys_privileges` VALUES (27, 'add_news', '发布工作动态');
INSERT INTO `sys_privileges` VALUES (28, 'add_law', '发布政策支持');
INSERT INTO `sys_privileges` VALUES (29, 'add_doc', '发布资料下载');
INSERT INTO `sys_privileges` VALUES (30, 'add_help', '发布帮助中心');
INSERT INTO `sys_privileges` VALUES (31, 'add_hrreq', '发布人员需求');
INSERT INTO `sys_privileges` VALUES (32, 'add_hrsup', '发布人员供给');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_privilege
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
BEGIN;
INSERT INTO `sys_role_privilege` VALUES (1, 1, 'role_admin', '系统管理员', 1, 'add_user', '添加用户');
INSERT INTO `sys_role_privilege` VALUES (2, 1, 'role_admin', '系统管理员', 2, 'delete_user', '删除用户');
INSERT INTO `sys_role_privilege` VALUES (3, 1, 'role_admin', '系统管理员', 3, 'modify_user', '修改用户');
INSERT INTO `sys_role_privilege` VALUES (4, 1, 'role_admin', '系统管理员', 4, 'query_user', '查询用户');
INSERT INTO `sys_role_privilege` VALUES (5, 1, 'role_admin', '系统管理员', 5, 'add_role', '添加角色');
INSERT INTO `sys_role_privilege` VALUES (6, 1, 'role_admin', '系统管理员', 6, 'delete_role', '删除角色');
INSERT INTO `sys_role_privilege` VALUES (7, 1, 'role_admin', '系统管理员', 7, 'modify_role', '修改角色');
INSERT INTO `sys_role_privilege` VALUES (8, 1, 'role_admin', '系统管理员', 8, 'query_role', '查询角色');
INSERT INTO `sys_role_privilege` VALUES (9, 1, 'role_admin', '系统管理员', 9, 'add_privilege', '添加权限');
INSERT INTO `sys_role_privilege` VALUES (10, 1, 'role_admin', '系统管理员', 10, 'delete_privilege', '删除权限');
INSERT INTO `sys_role_privilege` VALUES (11, 1, 'role_admin', '系统管理员', 11, 'modify_privilege', '修改权限');
INSERT INTO `sys_role_privilege` VALUES (12, 1, 'role_admin', '系统管理员', 12, 'query_privilege', '查询权限');
INSERT INTO `sys_role_privilege` VALUES (13, 1, 'role_admin', '系统管理员', 13, 'add_unit', '添加单位');
INSERT INTO `sys_role_privilege` VALUES (14, 1, 'role_admin', '系统管理员', 14, 'delete_unit', '删除组织架构');
INSERT INTO `sys_role_privilege` VALUES (15, 1, 'role_admin', '系统管理员', 15, 'modify_unit', '修改组织架构');
INSERT INTO `sys_role_privilege` VALUES (16, 1, 'role_admin', '系统管理员', 16, 'query_unit', '查询组织架构');
INSERT INTO `sys_role_privilege` VALUES (17, 1, 'role_admin', '系统管理员', 17, 'add_user_role', '添加用户角色');
INSERT INTO `sys_role_privilege` VALUES (18, 1, 'role_admin', '系统管理员', 18, 'delete_user_role', '删除用户角色');
INSERT INTO `sys_role_privilege` VALUES (19, 1, 'role_admin', '系统管理员', 19, 'modify_user_role', '修改用户角色');
INSERT INTO `sys_role_privilege` VALUES (20, 1, 'role_admin', '系统管理员', 20, 'query_user_role', '查询用户角色');
INSERT INTO `sys_role_privilege` VALUES (21, 1, 'role_admin', '系统管理员', 21, 'add_role_priv', '添加角色权限');
INSERT INTO `sys_role_privilege` VALUES (22, 1, 'role_admin', '系统管理员', 22, 'delete_role_priv', '删除角色权限');
INSERT INTO `sys_role_privilege` VALUES (23, 1, 'role_admin', '系统管理员', 23, 'modify_role_priv', '修改角色权限');
INSERT INTO `sys_role_privilege` VALUES (24, 1, 'role_admin', '系统管理员', 24, 'query_role_priv', '查询角色权限');
INSERT INTO `sys_role_privilege` VALUES (25, 1, 'role_admin', '系统管理员', 25, 'add_notice', '发布公告');
INSERT INTO `sys_role_privilege` VALUES (26, 1, 'role_admin', '系统管理员', 26, 'add_picinfo', '发布图文信息');
INSERT INTO `sys_role_privilege` VALUES (27, 1, 'role_admin', '系统管理员', 27, 'add_news', '发布工作动态');
INSERT INTO `sys_role_privilege` VALUES (28, 1, 'role_admin', '系统管理员', 28, 'add_law', '发布政策支持');
INSERT INTO `sys_role_privilege` VALUES (29, 1, 'role_admin', '系统管理员', 29, 'add_doc', '发布资料下载');
INSERT INTO `sys_role_privilege` VALUES (30, 1, 'role_admin', '系统管理员', 30, 'add_help', '发布帮助中心');
INSERT INTO `sys_role_privilege` VALUES (31, 1, 'role_admin', '系统管理员', 31, 'add_hrreq', '发布人员需求');
INSERT INTO `sys_role_privilege` VALUES (32, 1, 'role_admin', '系统管理员', 32, 'add_hrsup', '发布人员供给');
COMMIT;

-- ----------------------------
-- Table structure for sys_roles
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
BEGIN;
INSERT INTO `sys_roles` VALUES (1, 'role_admin', '系统管理员');
INSERT INTO `sys_roles` VALUES (2, 'role_user', '普通用户');
INSERT INTO `sys_roles` VALUES (3, 'role_hr_admin', '运输公司人力资源岗');
INSERT INTO `sys_roles` VALUES (4, 'role_hr_user', '分公司人力资源岗');
COMMIT;

-- ----------------------------
-- Table structure for sys_units
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
BEGIN;
INSERT INTO `sys_units` VALUES (1, NULL, '中国石油运输有限公司', '中国石油运输有限公司');
INSERT INTO `sys_units` VALUES (2, 1, '人力资源部', '中国石油运输有限公司人力资源部');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
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
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 'admin', '系统管理员', 1, 'role_admin', '系统管理员');
INSERT INTO `sys_user_role` VALUES (2, 3, 'test@webyun.cn', '测试', 1, 'role_admin', '系统管理员');
COMMIT;

-- ----------------------------
-- Table structure for sys_users
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
BEGIN;
INSERT INTO `sys_users` VALUES (1, 'admin', '系统管理员', '$2a$12$a6gYflu1gfvnqsk51tze4uzq//XdHmvw3FI6RIfdKejHJpZxsKphK', 1, '中国石油运输有限公司', '中国石油运输有限公司', 0, 0, 0, 1, NULL, '010010', '010');
INSERT INTO `sys_users` VALUES (2, 'user', '测试用户', '$2a$12$bLg1H4ux/57eMnhDpaNMEO1eN8Iwo.AANlJ6sTrZWpoRxkvAhFEr2', 2, '人力资源部', '中国石油运输有限公司人力资源部', 0, 0, 0, 1, NULL, NULL, '139');
INSERT INTO `sys_users` VALUES (3, 'test@webyun.cn', '系统管理员', '$2a$10$3x9DVwFiylgBuDQJJyfp/uPhHZCqVlTZpRwMmkUVkCA4fGTlWGYYK', 1, '中国石油运输有限公司', '中国石油运输有限公司', 0, 0, 0, 1, NULL, '010010', '010');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
