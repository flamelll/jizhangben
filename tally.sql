/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : tally

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2020-02-23 10:06:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tally
-- ----------------------------
DROP TABLE IF EXISTS `tally`;
CREATE TABLE `tally` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) NOT NULL,
  `money` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `style` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tally
-- ----------------------------
INSERT INTO `tally` VALUES ('26', '2020-02-04', '15', '收入', '买菜');
INSERT INTO `tally` VALUES ('28', '2020-02-04', '11', '支出', '买菜');
INSERT INTO `tally` VALUES ('29', '2020-02-05', '300', '收入', '买衣服');
INSERT INTO `tally` VALUES ('30', '2020-01-01', '16', '支出', '买玩具');
INSERT INTO `tally` VALUES ('31', '2020-02-18', '15', '收入', '买菜');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'uuuuuu', '123456');
INSERT INTO `user` VALUES ('2', 'eeeeee', 'aaaaaa');
