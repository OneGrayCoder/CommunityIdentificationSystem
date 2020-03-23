/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50122
Source Host           : localhost:3306
Source Database       : idensystem

Target Server Type    : MYSQL
Target Server Version : 50122
File Encoding         : 65001

Date: 2020-03-20 23:49:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_number` int(11) NOT NULL AUTO_INCREMENT,
  `username` int(11) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `enabled` varchar(1) DEFAULT NULL,
  `CompanyLv` varchar(1) DEFAULT NULL,
  `belongCompany` int(11) NOT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for `basicdata`
-- ----------------------------
DROP TABLE IF EXISTS `basicdata`;
CREATE TABLE `basicdata` (
  `basicData_number` int(11) NOT NULL AUTO_INCREMENT,
  `dataName` varchar(50) NOT NULL,
  `data_ps` varchar(50) DEFAULT NULL,
  `dataType` int(11) DEFAULT NULL,
  PRIMARY KEY (`basicData_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basicdata
-- ----------------------------

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_number` int(11) NOT NULL AUTO_INCREMENT,
  `company_account` varchar(30) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`company_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '1', '阿里巴巴集团', '1');
INSERT INTO `company` VALUES ('2', '2', '百度', '2');
INSERT INTO `company` VALUES ('3', '3', '腾讯', '3');
INSERT INTO `company` VALUES ('4', '4', '其他', '4');

-- ----------------------------
-- Table structure for `credit_card_records`
-- ----------------------------
DROP TABLE IF EXISTS `credit_card_records`;
CREATE TABLE `credit_card_records` (
  `record_card_Number` int(11) NOT NULL AUTO_INCREMENT,
  `record_ComanyNumber` int(11) NOT NULL,
  `money` decimal(8,2) NOT NULL,
  `charge_time` datetime NOT NULL,
  `charge_Type` int(11) NOT NULL,
  PRIMARY KEY (`record_card_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit_card_records
-- ----------------------------

-- ----------------------------
-- Table structure for `deal`
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `deal_number` int(11) NOT NULL AUTO_INCREMENT,
  `company_number` int(11) DEFAULT NULL,
  `employer_number` int(11) DEFAULT NULL,
  `worker_number` int(11) DEFAULT NULL,
  `agent_number` int(11) DEFAULT NULL,
  `record_time_deal` datetime DEFAULT NULL,
  `transactionValidity` datetime DEFAULT NULL,
  `statu` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `employ_type` varchar(50) DEFAULT NULL,
  `referral_fee` int(11) DEFAULT NULL,
  `fixture_date` datetime DEFAULT NULL,
  PRIMARY KEY (`deal_number`),
  KEY `company_number` (`company_number`),
  KEY `employer_number` (`employer_number`),
  KEY `worker_number` (`worker_number`),
  CONSTRAINT `deal_ibfk_1` FOREIGN KEY (`company_number`) REFERENCES `company` (`company_number`),
  CONSTRAINT `deal_ibfk_2` FOREIGN KEY (`employer_number`) REFERENCES `employer` (`employer_number`),
  CONSTRAINT `deal_ibfk_3` FOREIGN KEY (`worker_number`) REFERENCES `worker` (`worker_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal
-- ----------------------------

-- ----------------------------
-- Table structure for `employer`
-- ----------------------------
DROP TABLE IF EXISTS `employer`;
CREATE TABLE `employer` (
  `employer_number` int(11) NOT NULL AUTO_INCREMENT,
  `company_number` int(11) DEFAULT NULL,
  `employer_name` varchar(50) DEFAULT NULL,
  `employer_sex` varchar(2) DEFAULT NULL,
  `employer_age` int(11) DEFAULT NULL,
  `employer_nation` varchar(20) DEFAULT NULL,
  `employer_jiguan` varchar(50) DEFAULT NULL,
  `employer_education` varchar(30) DEFAULT NULL,
  `IDCardNumber` varchar(50) DEFAULT NULL,
  `work_unit` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `contract_number` varchar(50) DEFAULT NULL,
  `contract_term` datetime DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `house` varchar(50) DEFAULT NULL,
  `place_of_domicile` varchar(50) DEFAULT NULL,
  `service_location` varchar(50) DEFAULT NULL,
  `familyInfo_liveAddress` varchar(50) DEFAULT NULL,
  `familyInfo_peopleCount` varchar(50) DEFAULT NULL,
  `employ_requirement` varchar(50) DEFAULT NULL,
  `familyInfo_serviceContent` varchar(50) DEFAULT NULL,
  `familyInfo_hourseArea` varchar(50) DEFAULT NULL,
  `familyInfo_dietaryHabit` varchar(50) DEFAULT NULL,
  `familyInfo_other` varchar(50) DEFAULT NULL,
  `agent` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `highest_salary_received` varchar(50) DEFAULT NULL,
  `lowest_salary_received` varchar(50) DEFAULT NULL,
  `birthDay` datetime DEFAULT NULL,
  PRIMARY KEY (`employer_number`),
  KEY `company_number` (`company_number`),
  CONSTRAINT `employer_ibfk_1` FOREIGN KEY (`company_number`) REFERENCES `company` (`company_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employer
-- ----------------------------

-- ----------------------------
-- Table structure for `familymember`
-- ----------------------------
DROP TABLE IF EXISTS `familymember`;
CREATE TABLE `familymember` (
  `member_number` int(11) NOT NULL AUTO_INCREMENT,
  `worker_number` int(11) DEFAULT NULL,
  `relation` varchar(30) DEFAULT NULL,
  `member_name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `work_place` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`member_number`),
  KEY `worker_number` (`worker_number`),
  CONSTRAINT `familymember_ibfk_1` FOREIGN KEY (`worker_number`) REFERENCES `worker` (`worker_number`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of familymember
-- ----------------------------
INSERT INTO `familymember` VALUES ('2', '7', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('3', '7', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('4', '8', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('5', '8', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('6', '9', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('7', '9', '1', '1', '1', '1', '');
INSERT INTO `familymember` VALUES ('8', '10', '1', '1', '1', '1', '2');
INSERT INTO `familymember` VALUES ('9', '11', '1', '1', '1', '1', '2');
INSERT INTO `familymember` VALUES ('10', '12', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('11', '12', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('12', '13', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('13', '13', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('22', '14', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('23', '14', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('24', '16', '', '', '0', '', '');
INSERT INTO `familymember` VALUES ('25', '17', '', '', '0', '', '');
INSERT INTO `familymember` VALUES ('26', '18', '', '', '0', '', '');
INSERT INTO `familymember` VALUES ('27', '19', '', '', '0', '', '');
INSERT INTO `familymember` VALUES ('46', '20', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('47', '20', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('48', '2', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('49', '2', '2', '2', '2', '2', '2');
INSERT INTO `familymember` VALUES ('50', '15', '1', '1', '1', '1', '1');
INSERT INTO `familymember` VALUES ('51', '21', '', '', '0', '', '');

-- ----------------------------
-- Table structure for `inform`
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `inform_number` int(11) NOT NULL AUTO_INCREMENT,
  `inform_content` varchar(50) DEFAULT NULL,
  `inform_date` datetime DEFAULT NULL,
  PRIMARY KEY (`inform_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inform
-- ----------------------------

-- ----------------------------
-- Table structure for `job_training`
-- ----------------------------
DROP TABLE IF EXISTS `job_training`;
CREATE TABLE `job_training` (
  `training_number` int(11) NOT NULL AUTO_INCREMENT,
  `worker_number` int(11) DEFAULT NULL,
  `training_agency` varchar(50) DEFAULT NULL,
  `training_content` varchar(50) DEFAULT NULL,
  `training_situation` varchar(50) DEFAULT NULL,
  `training_time` date DEFAULT NULL,
  PRIMARY KEY (`training_number`),
  KEY `worker_number` (`worker_number`),
  CONSTRAINT `job_training_ibfk_1` FOREIGN KEY (`worker_number`) REFERENCES `worker` (`worker_number`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_training
-- ----------------------------
INSERT INTO `job_training` VALUES ('1', '13', '1', '1', '1', '2020-03-11');
INSERT INTO `job_training` VALUES ('2', '13', '2', '2', '2', '2020-03-04');
INSERT INTO `job_training` VALUES ('11', '14', '1', '1', '1', '2020-03-05');
INSERT INTO `job_training` VALUES ('12', '14', '2', '2', '2', '2020-03-05');
INSERT INTO `job_training` VALUES ('13', '16', '', '', '', null);
INSERT INTO `job_training` VALUES ('14', '17', '', '', '', null);
INSERT INTO `job_training` VALUES ('15', '18', '', '', '', null);
INSERT INTO `job_training` VALUES ('16', '19', '', '', '', null);
INSERT INTO `job_training` VALUES ('32', '20', '1', '1', '1', '2020-03-05');
INSERT INTO `job_training` VALUES ('33', '2', '1', '1', '1', '2020-03-05');
INSERT INTO `job_training` VALUES ('34', '2', '4', '4', '4', '2020-03-06');
INSERT INTO `job_training` VALUES ('35', '15', '1', '1', '1', '2020-03-20');
INSERT INTO `job_training` VALUES ('36', '21', '', '', '', null);

-- ----------------------------
-- Table structure for `messageinfo`
-- ----------------------------
DROP TABLE IF EXISTS `messageinfo`;
CREATE TABLE `messageinfo` (
  `messageNumber` int(11) NOT NULL AUTO_INCREMENT,
  `messageThem` varchar(50) DEFAULT NULL,
  `messageContent` varchar(100) DEFAULT NULL,
  `messageDate` datetime DEFAULT NULL,
  PRIMARY KEY (`messageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messageinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `recharge_card`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_card`;
CREATE TABLE `recharge_card` (
  `recharge_cardNumber` int(11) NOT NULL AUTO_INCREMENT,
  `creditCard_Number` int(11) NOT NULL,
  `charge_Standard` int(11) NOT NULL,
  `amtall` int(11) DEFAULT NULL,
  `balance` int(11) NOT NULL,
  `recharge_CompanyNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`recharge_cardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge_card
-- ----------------------------

-- ----------------------------
-- Table structure for `recharge_record`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record` (
  `recharge_record_number` int(11) NOT NULL AUTO_INCREMENT,
  `recharge_record_CompanyNumber` int(11) NOT NULL,
  `rechargeMoney` int(11) DEFAULT NULL,
  `operator` int(11) DEFAULT NULL,
  `recharge_time` datetime DEFAULT NULL,
  `postScript` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`recharge_record_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------

-- ----------------------------
-- Table structure for `sendmessage`
-- ----------------------------
DROP TABLE IF EXISTS `sendmessage`;
CREATE TABLE `sendmessage` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `messageNumber` int(11) DEFAULT NULL,
  `sender` int(11) DEFAULT NULL,
  `receiver` int(11) DEFAULT NULL,
  `statu` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`),
  KEY `messageNumber` (`messageNumber`),
  CONSTRAINT `sendmessage_ibfk_1` FOREIGN KEY (`messageNumber`) REFERENCES `messageinfo` (`messageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sendmessage
-- ----------------------------

-- ----------------------------
-- Table structure for `work_history`
-- ----------------------------
DROP TABLE IF EXISTS `work_history`;
CREATE TABLE `work_history` (
  `history_number` int(11) NOT NULL AUTO_INCREMENT,
  `worker_number` int(11) DEFAULT NULL,
  `unit` varchar(30) DEFAULT NULL,
  `work_type` varchar(30) DEFAULT NULL,
  `duty` varchar(20) DEFAULT NULL,
  `work_time` date DEFAULT NULL,
  PRIMARY KEY (`history_number`),
  KEY `worker_number` (`worker_number`),
  CONSTRAINT `work_history_ibfk_1` FOREIGN KEY (`worker_number`) REFERENCES `worker` (`worker_number`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_history
-- ----------------------------
INSERT INTO `work_history` VALUES ('1', '13', '1', '1', '1', '2020-03-20');
INSERT INTO `work_history` VALUES ('2', '13', '2', '2', '2', '2020-03-20');
INSERT INTO `work_history` VALUES ('11', '14', '1', '1', '1', '2020-03-20');
INSERT INTO `work_history` VALUES ('12', '14', '2', '2', '2', '2020-03-16');
INSERT INTO `work_history` VALUES ('13', '16', '', '', '', null);
INSERT INTO `work_history` VALUES ('14', '17', '', '', '', null);
INSERT INTO `work_history` VALUES ('15', '18', '', '', '', null);
INSERT INTO `work_history` VALUES ('16', '19', '', '', '', null);
INSERT INTO `work_history` VALUES ('27', '20', '1', '1', '1', '2020-03-09');
INSERT INTO `work_history` VALUES ('28', '20', '2', '2', '2', '2020-03-05');
INSERT INTO `work_history` VALUES ('29', '15', '1', '1', '1', '2020-03-20');
INSERT INTO `work_history` VALUES ('30', '21', '', '', '', null);

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `worker_number` int(11) NOT NULL AUTO_INCREMENT,
  `company_number` int(11) DEFAULT NULL,
  `worker_name` varchar(50) DEFAULT NULL,
  `worker_sex` varchar(2) DEFAULT NULL,
  `worker_IDNumber` varchar(50) DEFAULT NULL,
  `worker_birth` date DEFAULT NULL,
  `worker_age` int(11) DEFAULT NULL,
  `worker_height` int(11) DEFAULT NULL,
  `worker_mobile` varchar(20) DEFAULT NULL,
  `worker_telephone` varchar(20) DEFAULT NULL,
  `typeOfWork` varchar(30) DEFAULT NULL,
  `worker_time` date DEFAULT NULL,
  `defect` varchar(50) DEFAULT NULL,
  `album` varchar(50) DEFAULT NULL,
  `permanent_address` varchar(50) DEFAULT NULL,
  `address_Now` varchar(50) DEFAULT NULL,
  `bankCardNumber` varchar(50) DEFAULT NULL,
  `policyNo` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `worker_statu` varchar(20) DEFAULT NULL,
  `marriage_status` varchar(2) DEFAULT NULL,
  `certification_status` varchar(50) DEFAULT NULL,
  `health_examination` varchar(50) DEFAULT NULL,
  `healExamTime` date DEFAULT NULL,
  `skills` varchar(50) DEFAULT NULL,
  `introduce` varchar(50) DEFAULT NULL,
  `timeRequire` varchar(50) DEFAULT NULL,
  `moneyRequire` varchar(50) DEFAULT NULL,
  `live` varchar(50) DEFAULT NULL,
  `eatDrink` varchar(50) DEFAULT NULL,
  `input_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`worker_number`),
  KEY `company_number` (`company_number`),
  CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`company_number`) REFERENCES `company` (`company_number`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('2', '1', '111', '男', '11', '2015-10-10', '0', '0', '12', null, '12', '2020-03-02', '1', '大专', '3434', '434', '1', null, '普通话,广州话', '待岗', '未婚', '健康证', '肝功,胸透', null, '带小孩,拖地', null, '4', '4', '4', '4', '2020-03-20 00:17:14');
INSERT INTO `worker` VALUES ('3', '1', '12', '男', '12', '2015-10-10', '12', '1', '1', '1', '1', '2016-10-10', '1', '大专', '1', '1', '1', '1', '普通话', '在岗', '已婚', null, '肝功', '2015-10-10', '照顾婴儿', '11', '11', '11', '11', '11', '2020-03-20 00:20:34');
INSERT INTO `worker` VALUES ('5', '1', '12', '男', '12', null, '0', '0', '', '', '', null, '', null, '', '', '', '', '普通话,广州话', '待岗', '已婚', '计生证,健康证', '肝功,胸透', null, '照顾婴儿,扫地', '', '', '', '', '', '2020-03-20 00:49:41');
INSERT INTO `worker` VALUES ('6', '1', '1', '男', '1', null, '1', '0', '1', null, null, null, null, '大专', null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', '1', '1', '2020-03-20 13:16:10');
INSERT INTO `worker` VALUES ('7', '1', '1', '男', '1', '2018-10-10', '1', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-03-20 13:42:03');
INSERT INTO `worker` VALUES ('8', '1', '4', '男', '4', '2020-03-20', '4', '0', '4', null, '4', '2020-03-20', null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', '11', '1', '1', '1', '1', '2020-03-20 14:05:05');
INSERT INTO `worker` VALUES ('9', '1', '5', '男', '5', '2020-03-20', '5', '0', '5', null, '5', '2020-03-20', null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', '11', '1', '1', '1', '1', '2020-03-20 14:07:14');
INSERT INTO `worker` VALUES ('10', '1', '5', '男', '5', '2020-03-20', '5', '0', '5', null, '5', '2020-03-20', null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', '11', '1', '1', '1', '1', '2020-03-20 14:08:09');
INSERT INTO `worker` VALUES ('11', '1', '5', '男', '5', '2020-03-20', '5', '0', '5', null, '5', '2020-03-20', null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', '11', '1', '1', '1', '1', '2020-03-20 14:09:31');
INSERT INTO `worker` VALUES ('12', '1', '6', '男', '6', '2020-03-20', '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 14:13:29');
INSERT INTO `worker` VALUES ('13', '1', '6', '男', '6', null, '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 14:17:19');
INSERT INTO `worker` VALUES ('14', '1', '8', '男', '8', '2020-03-06', '8', '8', '8', '8', '8', '2020-03-05', '8', '大专', '8', '8', '8', '8', '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', '8', '8', '8', '8', '8', '2020-03-20 19:39:10');
INSERT INTO `worker` VALUES ('15', '1', '1', '男', '1', null, '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, '1', '1', null, null, '2020-03-20 19:42:05');
INSERT INTO `worker` VALUES ('16', '1', '1', '男', '1', null, '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 19:52:43');
INSERT INTO `worker` VALUES ('17', '1', '1', '男', '1', null, '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 20:34:49');
INSERT INTO `worker` VALUES ('18', '2', '2', '男', '2', null, '2', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 21:50:33');
INSERT INTO `worker` VALUES ('19', '3', '45', '男', '45', null, '45', '0', '45', null, null, null, null, '大专', null, null, null, null, '普通话,广州话,英语', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 22:24:03');
INSERT INTO `worker` VALUES ('20', '1', '9', '男', '9', '2020-03-11', '9', '9', '9', '9', '9', '2020-03-05', '9', '高中', '9', '9', '9', '9', '普通话,广州话,英语', '在岗', '已婚', '计生证,健康证', '肝功', '2020-03-02', '照顾婴儿,带小孩', '1', '4', '4', '1', '1', '2020-03-20 22:58:25');
INSERT INTO `worker` VALUES ('21', '1', '1', '男', null, null, '0', '0', null, null, null, null, null, '大专', null, null, null, null, '普通话', '在岗', '已婚', '健康证', '肝功', null, '照顾婴儿,带小孩', null, null, null, null, null, '2020-03-20 23:47:33');
