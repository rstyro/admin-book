/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/09/2020 18:04:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_login
-- ----------------------------
DROP TABLE IF EXISTS `admin_login`;
CREATE TABLE `admin_login`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `last_login_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_login
-- ----------------------------
INSERT INTO `admin_login` VALUES (1, 1, '2020-09-29 17:35:51');
INSERT INTO `admin_login` VALUES (2, 1, '2020-09-29 17:37:14');
INSERT INTO `admin_login` VALUES (3, 1, '2020-09-29 17:59:02');

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单地址',
  `menu_type` enum('2','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '2' COMMENT '1 -- 系统菜单，2 -- 业务菜单',
  `menu_icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单Icon',
  `sort_num` int(11) NULL DEFAULT 1 COMMENT '排序',
  `user_id` int(11) NULL DEFAULT 1 COMMENT '创建这个菜单的用户id',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '1-- 删除状态，0 -- 正常',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, 0, '系统管理', '#', '1', 'fa fa-gears', 1, 1, 0, '2017-09-08 16:15:24', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (2, 1, '菜单管理', 'admin/menu/list', '1', '#', 1, 1, 0, '2019-01-16 18:03:44', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (3, 1, '角色管理', 'admin/role/list', '1', NULL, 2, 1, 0, '2019-01-16 18:03:45', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (4, 1, '用户管理', 'admin/user/list', '1', '', 3, 1, 0, '2019-01-16 18:03:48', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (5, 0, '测试管理', '#', '2', 'fa fa-tasks', 2, 1, 1, '2020-09-29 17:58:55', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (6, 5, '文章列表', 'act/acticle/list', '2', '', 1, 1, 0, '2019-08-03 11:00:02', '2017-09-07 14:52:41');
INSERT INTO `admin_menu` VALUES (7, 5, '测试', 'test/people/list', '2', '', 2, 1, 0, '2019-08-03 11:09:46', NULL);
INSERT INTO `admin_menu` VALUES (8, 0, '书库管理', '#', '2', 'fa fa-book', 2, 1, 0, '2020-09-29 17:56:52', NULL);
INSERT INTO `admin_menu` VALUES (9, 8, '书籍列表', 'book/books/list', '2', '', 1, 1, 0, '2020-09-29 17:57:22', NULL);
INSERT INTO `admin_menu` VALUES (10, 8, '书籍分类', 'book/classify/list', '2', '', 1, 1, 0, '2020-09-29 17:57:47', NULL);
INSERT INTO `admin_menu` VALUES (11, 8, '借书记录', 'book/borrowLog/list', '2', '', 1, 1, 0, '2020-09-29 17:58:30', NULL);
INSERT INTO `admin_menu` VALUES (12, 8, '借书申请', 'book/verify/list', '2', '', 1, 1, 0, '2020-09-29 17:58:47', NULL);

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色描述',
  `rights` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '最大权限的值',
  `add_qx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '添加权限',
  `del_qx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除权限',
  `edit_qx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '编辑权限',
  `query_qx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '查看权限',
  `user_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, '管理员', '管理员权限', '1267650600228229401496703205375', '254', '254', '254', '254', '1', '2019-01-17 09:59:29');
INSERT INTO `admin_role` VALUES (2, 'tyro', '111', '254', '254', '160', '190', '254', '1', '2019-08-03 11:09:59');

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pic_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '/images/logo.png' COMMENT '头像地址',
  `status` enum('unlock','lock') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'unlock',
  `sessionId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', '超级管理员', 'd033e22ae348aeb5660fc2140aec35850c4da997', '/images/header.jpg', 'unlock', '05DB1FB3F2BFEC0BA6E86543FDF213F6', '2017-08-18 13:57:32');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (32, 2, 1, '2019-01-03 16:31:04');
INSERT INTO `admin_user_role` VALUES (33, 2, 2, '2019-01-03 16:31:04');
INSERT INTO `admin_user_role` VALUES (34, 4, 1, '2019-08-03 10:51:08');

-- ----------------------------
-- Table structure for book_borrow_log
-- ----------------------------
DROP TABLE IF EXISTS `book_borrow_log`;
CREATE TABLE `book_borrow_log`  (
  `id` bigint(20) NOT NULL,
  `book_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL COMMENT '1 -- 借出，2-- 已归还',
  `is_del` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `return_time` datetime(0) NULL DEFAULT NULL COMMENT '归还时间',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '到期时间',
  `modify_by` bigint(20) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '借出时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '借书记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book_classify
-- ----------------------------
DROP TABLE IF EXISTS `book_classify`;
CREATE TABLE `book_classify`  (
  `id` bigint(20) NOT NULL,
  `classify_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `is_del` tinyint(1) NULL DEFAULT 0,
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '书籍分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book_verify
-- ----------------------------
DROP TABLE IF EXISTS `book_verify`;
CREATE TABLE `book_verify`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `book_id` bigint(20) NULL DEFAULT NULL,
  `verify_type` int(2) NULL DEFAULT NULL COMMENT '1 -- 借，2 -- 还',
  `is_del` tinyint(1) NULL DEFAULT 0,
  `state` int(2) NULL DEFAULT NULL COMMENT '0 -- 未读，1 -- 同意，2 -- 驳回',
  `modify_by` bigint(20) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '书籍借出与归还审核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍编号',
  `classify_id` bigint(20) NULL DEFAULT NULL COMMENT '分类ID',
  `book_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书名',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '简介备注',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面图',
  `stock_num` int(11) NULL DEFAULT 1 COMMENT '库存',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍来源：公司、个人捐献',
  `state` int(2) NULL DEFAULT 1 COMMENT '状态：0 -- 不可借，1 -- 可借，2-- 已借出，3 -- 归还超时，4 -- 遗失',
  `is_del` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `modify_by` bigint(20) NULL DEFAULT NULL COMMENT '最后更新人ID',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniIndex`(`number`) USING BTREE,
  INDEX `classAndState`(`classify_id`, `state`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '书库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '真实姓名',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像地址',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '个性签名',
  `is_del` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `state` int(2) NULL DEFAULT 1 COMMENT '1 -- 正常，2 -- 锁定（借书不还等原因）',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
