/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : asset

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-04-17 14:58:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for root_admin
-- ----------------------------
DROP TABLE IF EXISTS `root_admin`;
CREATE TABLE `root_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of root_admin
-- ----------------------------
INSERT INTO `root_admin` VALUES ('1', null, '13273091192', '091192', null, null);
INSERT INTO `root_admin` VALUES ('2', null, '18637171855', '171855', null, null);
INSERT INTO `root_admin` VALUES ('3', null, '18749422377', '422377', null, null);
INSERT INTO `root_admin` VALUES ('4', null, '17337122077', '122077', null, null);
INSERT INTO `root_admin` VALUES ('5', null, '17839908056', '908056', null, null);
