/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : app

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 04/16/2019 20:03:06 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `app`
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT 'name',
  `version` text COMMENT 'version',
  `short_id` varchar(200) DEFAULT NULL COMMENT 'short',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time',
  `app_stroge_url` text COMMENT 'app_stroge_url',
  `icon_url` text COMMENT 'icon_url',
  `update_time` datetime DEFAULT NULL COMMENT 'update_time',
  `app_plist` text COMMENT 'app_plist',
  `type` varchar(32) DEFAULT NULL COMMENT 'type',
  `api_token` text COMMENT 'api_token',
  `password` varchar(32) DEFAULT NULL COMMENT 'password',
  `desc` text COMMENT 'desc',
  `short_id_desc` text,
  `install_url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `root_admin`
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
