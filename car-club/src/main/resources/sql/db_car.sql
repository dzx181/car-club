/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_car

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-12-12 13:21:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_consume
-- ----------------------------
DROP TABLE IF EXISTS `car_consume`;
CREATE TABLE `car_consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费分析',
  `consume_analyes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消费分析',
  `consume_day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日消费',
  `consume_month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '月消费',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id,关联到会员表',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_doc
-- ----------------------------
DROP TABLE IF EXISTS `car_doc`;
CREATE TABLE `car_doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DOCUMENT_USER` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_employ
-- ----------------------------
DROP TABLE IF EXISTS `car_employ`;
CREATE TABLE `car_employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工性别',
  `telphone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工电话',
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '员工生日',
  `entryDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入职日期',
  `basicSalary` varchar(255) DEFAULT NULL COMMENT '基本工资',
  `fullWork` varchar(2) DEFAULT NULL COMMENT '是否全勤',
  `status` int(11) DEFAULT NULL COMMENT '1表在职，2表离职，3表其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_member
-- ----------------------------
DROP TABLE IF EXISTS `car_member`;
CREATE TABLE `car_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '会员姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '性别',
  `telphone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '手机号码',
  `weChatID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `importanceGrade` int(11) DEFAULT NULL COMMENT '重要程度：1代表重点，2代表优质，3一般，4放弃，5未知',
  `pay` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会费',
  `ifContinu` varchar(1) DEFAULT NULL COMMENT '是否续费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_profess
-- ----------------------------
DROP TABLE IF EXISTS `car_profess`;
CREATE TABLE `car_profess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务名称',
  `vehicle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车辆型号',
  `member_id` int(11) DEFAULT NULL COMMENT '关联到会员id',
  `insurance_type` varchar(255) DEFAULT NULL COMMENT '投保的种类',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_user
-- ----------------------------
DROP TABLE IF EXISTS `car_user`;
CREATE TABLE `car_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `status` int(2) DEFAULT NULL COMMENT '1：管理员账户 2会员账户',
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
