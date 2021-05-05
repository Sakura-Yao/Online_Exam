/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : online_exam

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 04/05/2021 19:52:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_course
-- ----------------------------
DROP TABLE IF EXISTS `class_course`;
CREATE TABLE `class_course` (
  `classes_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级Id(不是班号是classes表的Id)',
  `user_Id` varchar(11) NOT NULL COMMENT '教师工号',
  `cou_Id` varchar(32) NOT NULL COMMENT '课程Id',
  PRIMARY KEY (`classes_Id`,`user_Id`,`cou_Id`) USING BTREE,
  KEY `cou_Id` (`cou_Id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `class_course_ibfk_1` FOREIGN KEY (`classes_Id`) REFERENCES `classes` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_course_ibfk_2` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_course_ibfk_3` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级和课程的关系';

-- ----------------------------
-- Records of class_course
-- ----------------------------
BEGIN;
INSERT INTO `class_course` VALUES ('61dbccdfded143ce859014c53c03f0e1', 'H011000', 'MF86683708');
INSERT INTO `class_course` VALUES ('61dbccdfded143ce859014c53c03f0e1', 'H011000', 'NJ96116427');
INSERT INTO `class_course` VALUES ('7f66cac4c9c04bd985955e28d74c22b9', 'H011000', 'MF86683708');
INSERT INTO `class_course` VALUES ('935b36869b4e43de96741a044252fddd', 'H011000', 'MF86683708');
INSERT INTO `class_course` VALUES ('86f1c2a0e4224799a08a2fc5a6c89f4a', 'H011006', 'MF86683708');
INSERT INTO `class_course` VALUES ('935b36869b4e43de96741a044252fddd', 'H011052', 'SF14864420');
COMMIT;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `Id` varchar(32) NOT NULL,
  `class_Id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班号',
  `people_Num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级人数',
  `class_Col_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级所属学院',
  `class_Spe_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级所属专业',
  PRIMARY KEY (`Id`),
  KEY `fk_classes_college_1` (`class_Col_Id`),
  KEY `fk_classes_specialty_1` (`class_Spe_Id`),
  CONSTRAINT `fk_classes_college_1` FOREIGN KEY (`class_Col_Id`) REFERENCES `college` (`Id`),
  CONSTRAINT `fk_classes_specialty_1` FOREIGN KEY (`class_Spe_Id`) REFERENCES `specialty` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级信息';

-- ----------------------------
-- Records of classes
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('102838e075a847829240f3d3b938a119', '1801312', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('61dbccdfded143ce859014c53c03f0e1', '2009202', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('7dd6f467c2744d53ae5fba00db6398ee', '1909211', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('7f66cac4c9c04bd985955e28d74c22b9', '2009211', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('86f1c2a0e4224799a08a2fc5a6c89f4a', '2009201', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('935b36869b4e43de96741a044252fddd', '1801301', '3', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('96f675bafdef4d0590b1ee6ac91f3fba', '1909212', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('ae32ea8c894844bf8032e801e787c434', '2009212', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('bb8bb3f8170c49889dce092011800bf7', '1909201', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('bc022ffd7ecd4c50a021f10a471f9775', '1802000', '1', '033d5e75b2ba46628ad1472111d385cb', '13ac3cb6785543f9a22690a33ffa2806');
INSERT INTO `classes` VALUES ('c220565ecd3a42db8f890b4835a2a97a', '1909202', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `classes` VALUES ('cb20bc3ff74e40729351c4b23ec4f09f', '1801311', '0', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `Id` varchar(32) NOT NULL,
  `col_Name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学院信息';

-- ----------------------------
-- Records of college
-- ----------------------------
BEGIN;
INSERT INTO `college` VALUES ('033d5e75b2ba46628ad1472111d385cb', '艺术与传媒学院');
INSERT INTO `college` VALUES ('03c722d5bcb84931913e00413ec8c284', '服装学院');
INSERT INTO `college` VALUES ('2f25dc4bff3848129d5f4544f283bac3', '经济管理学院');
INSERT INTO `college` VALUES ('3cb8d052e08f43cda361595bee5bee77', '机器人工程学院');
INSERT INTO `college` VALUES ('657b1f31c1c844e88e7c45ddd9ae9590', '电子信息工程学院');
INSERT INTO `college` VALUES ('75d2a68ba28146e08414f1a6f9c3afef', '数据科学与人工智能学院');
INSERT INTO `college` VALUES ('919d2ccfb6c24fa28ff3156e67a84ff4', '智能汽车与航空学院');
INSERT INTO `college` VALUES ('c34afcf78f214465ac039e99bb343cd9', '外语学院');
INSERT INTO `college` VALUES ('cfa0cb4f01a045c89a048bb4c7d191a3', '机电与材料工程学院');
INSERT INTO `college` VALUES ('db8e18fc61d943f6a8029d79f63dffef', '建筑与土木工程学院');
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` varchar(32) NOT NULL,
  `cou_Name` varchar(255) DEFAULT NULL COMMENT '科目名称',
  `spe_Id` varchar(32) DEFAULT NULL COMMENT '专业Id',
  PRIMARY KEY (`Id`),
  KEY `spe_Id` (`spe_Id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`spe_Id`) REFERENCES `specialty` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目';

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('LT96785089', 'Java语言程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('MF86683708', 'C语言程序设计', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('NJ96116427', '数据结构与算法', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('SF14864420', '软件测试', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `course` VALUES ('TT001', 'Spring Boot开发实战', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for error_question
-- ----------------------------
DROP TABLE IF EXISTS `error_question`;
CREATE TABLE `error_question` (
  `Id` varchar(32) NOT NULL,
  `user_Id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `question_Id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_error_question_user_1` (`user_Id`),
  KEY `fk_error_question_question_1` (`question_Id`),
  CONSTRAINT `fk_error_question_question_1` FOREIGN KEY (`question_Id`) REFERENCES `question` (`Id`),
  CONSTRAINT `fk_error_question_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='错题表';

-- ----------------------------
-- Records of error_question
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for exam_rule
-- ----------------------------
DROP TABLE IF EXISTS `exam_rule`;
CREATE TABLE `exam_rule` (
  `Id` varchar(32) NOT NULL,
  `rule_Name` longtext COMMENT '考试大纲名称',
  `exam_Id` varchar(32) DEFAULT NULL COMMENT '考试Id',
  `cou_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '适用班级',
  `classes` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '适用班级',
  `totalMark` varchar(255) DEFAULT NULL COMMENT '总题数',
  `difficulty` varchar(255) DEFAULT NULL COMMENT '总体难度系数',
  `singleNum` varchar(255) DEFAULT NULL COMMENT '单选题数目',
  `singleScore` varchar(255) DEFAULT NULL COMMENT '单选题分值',
  `completeNum` varchar(255) DEFAULT NULL COMMENT '填空题数目',
  `completeScore` varchar(255) DEFAULT NULL COMMENT '填空题分值',
  `judgeNum` varchar(255) DEFAULT NULL,
  `judgeScore` varchar(255) DEFAULT NULL,
  `nounNum` varchar(255) DEFAULT NULL,
  `nounScore` varchar(255) DEFAULT NULL,
  `subjectNum` varchar(255) DEFAULT NULL COMMENT '主观题数目',
  `subjectScore` varchar(255) DEFAULT NULL COMMENT '主观题分值',
  `fillcodeNum` varchar(255) DEFAULT NULL,
  `fillcodeScore` varchar(255) DEFAULT NULL,
  `codingNum` varchar(255) DEFAULT NULL,
  `codingScore` varchar(255) DEFAULT NULL,
  `pointIds` longtext COMMENT '包含知识点',
  `pointNames` longtext,
  `rule_Time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`Id`),
  KEY `cou_Id` (`cou_Id`),
  CONSTRAINT `exam_rule_ibfk_1` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_rule
-- ----------------------------
BEGIN;
INSERT INTO `exam_rule` VALUES ('0f106ebdda16401d983906ce1a0e7444', '数据科学与人工智能学院2020-2021学年第二学期软件工程专业命题计划', '4470d8d72bc441de9cd6d7293be87139', 'MF86683708', '2009202', '100', '0.9', '10', '2', '10', '2', '0', '0', '5', '2', '4', '5', '4', '5', '2', '5', '7dfe952b59894e058827358b5a142e4c', NULL, '2021-04-29 15:43:49');
INSERT INTO `exam_rule` VALUES ('526bb66281664a578d2e527ff898a6a2', 'C语言程序设计2020级命题计划', 'ce6ea3044fef4ae7a9af0ddc79774be2', 'MF86683708', '2009202,2009211', '100', '0.6', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', '7dfe952b59894e058827358b5a142e4c', '未归档', '2021-04-29 00:47:47');
INSERT INTO `exam_rule` VALUES ('6a3ed366fbcc4f08bb93c04605d8f9d2', 'C语言程序设计2020级命题计划', '5e5e67f90fda464c932d99938427113e', 'MF86683708', '2009202', '100', '0.45', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', 'f71863bc33074a018f1d6e644713dfa5,9a17cee7074f401abce2730059cabe8c,dfda4b929afd453b87c9b7d41606f369,c2c66085341d4619abf76ef61df0d663,b033ac13d6e9459b89d1cfb5d8e08ae8,93d82723279a43a69c99b2b877ef774e,10381356432c4e03a577b1a47090f4ce,b655696450cf4ce5a3157bff01509207,cb4c9175250847f6976cf46ad6de30d0,ca02fad4a726496a8994ff6cc2c1eb35', '函数的概念及分类,函数的定义, 函数的参数和返回值,函数的调用,函数的递归调用', '2021-04-29 00:50:55');
INSERT INTO `exam_rule` VALUES ('b41453d0f8274e04b6c547523ccd50da', 'C语言程序设计2020级命题计划', '71ae38fc454e495caac17db0c9cfaa42', 'MF86683708', '2009202', '100', '0.75', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', '69408646a8e8427f80c184965f538820,303045bd01cf48c6a76307048e1da3d0,69e68b27139144a1ad39d992f2676d4b,9f35daec5200451eae5f4f4f0ac9cb9a,61071ee6867d4fda9d33963e7b7ea32b', '函数的概念及分类,函数的定义, 函数的参数和返回值,函数的调用,函数的递归调用', '2021-04-29 00:51:00');
INSERT INTO `exam_rule` VALUES ('c024fe24871f4f5c9bf79d1ea8af05ce', 'C语言程序设计2020级命题计划1', '1fab5defa1e644a79d9b9f7ca738a65c', 'MF86683708', '2009202', '40', '0.45', '20', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '91e9d69f389442d5a50fc02c0be54a24,b77656c9093c48a8adea7b3fe4234fde,3e47d8fa63e9458f94f0823708d0d93d,19022964ecc948e5aeeb3ea22161c67f,affb722a2c4742fd938eaf3239438f5b,48a8027a3b9f417e8de440ad79eed25b,767da24c48c84c78ba425e3dc08ff6be,4779bf0b4fe64342b3026b1a71dfeb56', NULL, '2021-04-29 01:06:33');
INSERT INTO `exam_rule` VALUES ('d74fcfe1396a4ec29e629d9d9b6cc1a8', 'C语言程序设计2020级命题计划', '53f80a7991e148b1b11bda2a25ebf478', 'MF86683708', '2009202', '100', '0.3', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', '4d580d4d934049f189c9754653af0ede,29a8661836f34a19928af2367b508526,d5d35cbb836948e8ae05995e49cabd27,4640572460954a8cbaaa92b44622ea49,f1a51f9e128f482cb1139c7fd66e60a0,fc08ce9b340e455089f4b45172a1ded0', '函数的概念及分类,函数的定义, 函数的参数和返回值,函数的调用,函数的递归调用', '2021-04-29 00:51:02');
INSERT INTO `exam_rule` VALUES ('dc97d7eb98484d5191198b83c6c6167d', 'C语言程序设计2020级命题计划', '149d56267d21471c8ebac4153f2b0fbe', 'MF86683708', '2009202', '100', '0.9', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', '91e9d69f389442d5a50fc02c0be54a24,b77656c9093c48a8adea7b3fe4234fde,3e47d8fa63e9458f94f0823708d0d93d,19022964ecc948e5aeeb3ea22161c67f,affb722a2c4742fd938eaf3239438f5b,48a8027a3b9f417e8de440ad79eed25b,767da24c48c84c78ba425e3dc08ff6be,4779bf0b4fe64342b3026b1a71dfeb56', '函数的概念及分类,函数的定义, 函数的参数和返回值,函数的调用,函数的递归调用', '2021-04-29 00:51:02');
INSERT INTO `exam_rule` VALUES ('e441986fd8044444a0cb98dfba748c90', '测试GA组卷', '7de49387bfeb47328e693c6868b135e0', 'MF86683708', '2009202', '100', '0.9', '10', '2', '10', '2', '0', '0', '0', '0', '4', '5', '4', '5', '4', '5', '7dfe952b59894e058827358b5a142e4c', NULL, '2021-04-29 02:03:04');
INSERT INTO `exam_rule` VALUES ('ed1de46d41234f88865fad4596c5ccd0', 'C语言程序设计2020级命题计划', 'c8bdb8674ddd47d3b060ad9659faa1e4', 'MF86683708', '1801301', '100', '0.6', '10', '2', '10', '2', '10', '1', '5', '2', '2', '5', '4', '5', '2', '5', '91e9d69f389442d5a50fc02c0be54a24,b77656c9093c48a8adea7b3fe4234fde,3e47d8fa63e9458f94f0823708d0d93d,19022964ecc948e5aeeb3ea22161c67f,affb722a2c4742fd938eaf3239438f5b,5ee32dafd99048f6bee82a9a3ea956c8,abfa92ec893b436bb2f0d081355b4d55,3514bf02a3df4193ac928aa068425933,f71863bc33074a018f1d6e644713dfa5,9a17cee7074f401abce2730059cabe8c,dfda4b929afd453b87c9b7d41606f369,c2c66085341d4619abf76ef61df0d663', '函数的概念及分类,函数的定义, 函数的参数和返回值,函数的调用,函数的递归调用', '2021-04-29 00:51:03');
COMMIT;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `Id` varchar(32) NOT NULL,
  `cou_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学科Id',
  `kwl_Level` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '知识点等级',
  `chapter_Num` int(10) NOT NULL COMMENT '章数',
  `section_Num` int(10) NOT NULL DEFAULT '0' COMMENT '节数',
  `kwl_Name` varchar(255) DEFAULT NULL COMMENT '知识点名称',
  `parent_Id` varchar(32) DEFAULT NULL COMMENT '若为二级知识点，标注一级知识点Id',
  PRIMARY KEY (`Id`),
  KEY `fk_knowledge_course_1` (`cou_Id`),
  CONSTRAINT `fk_knowledge_course_1` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识点';

-- ----------------------------
-- Records of knowledge
-- ----------------------------
BEGIN;
INSERT INTO `knowledge` VALUES ('043ff27869544a9380972f340204a43a', 'MF86683708', '2', 5, 2, 'do...whille语句', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('047ec7f88aab4be78709a5414890651e', 'LT96785089', '1', 9, 0, '输入流和输出流', '');
INSERT INTO `knowledge` VALUES ('04a3d8ae06bb4d22aac7f3f4005fe5af', 'TT001', '2', 8, 4, '访问HDFS', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('0583cf627bad47b6adb40f52b4171b63', 'TT001', '2', 4, 3, 'Thymeleaf的语法与使用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('05e6ef05fa9846b4bbc8864535f09c47', 'LT96785089', '2', 10, 19, '计时器', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('07ba02be0ff44bcb819fedd97aa6248e', 'TT001', '1', 2, 0, 'Spring Boot 开发起步', '');
INSERT INTO `knowledge` VALUES ('07ffd3bb345b4f35b4f209a6d442534b', 'LT96785089', '1', 6, 0, '字符串和正则表达式', '');
INSERT INTO `knowledge` VALUES ('0999c66ff41d468aacea4930185a80c7', 'LT96785089', '2', 11, 5, 'InetAddress类', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('09f93e691e5b4dcea405fae594080763', 'TT001', '2', 6, 5, '实现跨域资源共享的RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('0a49911bf8eb4153b7e384b0793e8fcf', 'LT96785089', '2', 4, 16, '反编译和文档生成器', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('0a7597a1f72d48af93c01ee64ecc2cce', 'LT96785089', '2', 12, 3, '在命令行链接Derby 数据库', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('0a9ecc3aa44b47769ea1c675b55bb67c', 'TT001', '2', 3, 1, 'Java 注解', '8044a638c1514897a42431c6dd6b3baa');
INSERT INTO `knowledge` VALUES ('0aa586fdd72f479bacb73a63509c32e0', 'LT96785089', '2', 10, 23, '对话框', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('0d1670fbd343456dbe15454e58ce2fce', 'LT96785089', '2', 8, 1, 'Java 中的线程', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('0dd79d65d4cb40eb8d89bbf1e406b1c5', 'LT96785089', '2', 3, 11, '分支语句', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('0e1d5b834523427abe48ad3343bb192d', 'MF86683708', '2', 8, 7, '应用举例', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('0f2b590b0a64465b8f43f62615f7c52f', 'TT001', '2', 5, 7, '访问数据库完整示例', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('101f7c5e02874aae99a2a046fc531718', 'TT001', '2', 9, 3, '实现基于WebFlux的RESTflu服务', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('10381356432c4e03a577b1a47090f4ce', 'MF86683708', '2', 6, 7, '局部变量和全局变量', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('109e9ee6dc3b477cb335c7ea51fc7d08', 'LT96785089', '2', 4, 4, '构造方法和对象的创建', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('10a7666a39cd4f9693c9268fd01fa235', 'TT001', '2', 7, 2, '数据缓存', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('10d2ab63adaf460d9770220acf21474f', 'TT001', '2', 8, 1, '文件上传', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('1191efe8d4274677889445af15169357', 'TT001', '2', 10, 2, '案例实现', '5bb75bb3fadf4218b26cfc5443cfb3bb');
INSERT INTO `knowledge` VALUES ('11f08044f9b04ef08baf7e530e62cc6a', 'LT96785089', '2', 5, 12, '接口回调', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('131fc47b373f4999a403f9f1a2a2ed85', 'TT001', '2', 8, 5, '用Elasticsearch实现全文搜索', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('13cd9f851bc3450191a4d86bc17ee4e3', 'TT001', '2', 1, 3, 'Spring Boot 的工作机制', '7e717d8963804a79862773bb6ea0c29a');
INSERT INTO `knowledge` VALUES ('13e85e41602f44bba1f67a33baa0e3cf', 'LT96785089', '2', 11, 8, 'UDP 数据报', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('141267f2f9684a15901e4d1d39ba6540', 'LT96785089', '2', 12, 8, 'CachedRowSetImpl类', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('165e877c50ec4c0d85ee1edfbaddbd42', 'LT96785089', '2', 12, 7, '用结果集更新数据库中的表', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('1689e9211e444f95ae6ba5b5c77cab21', 'LT96785089', '2', 12, 10, '事务', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('170180964ef14d89a1dc317a58f0ba33', 'TT001', '2', 8, 2, '文件下载', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('17d959c87c284ed389a61dacde13338e', 'LT96785089', '2', 5, 1, '子类和父类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('19022964ecc948e5aeeb3ea22161c67f', 'MF86683708', '2', 2, 4, '变量', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('19563ee9afbe4cd395a2f0c2f3f3e597', 'MF86683708', '2', 9, 6, '常见错误', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('196415b7ff334a40aa6bbf65ba6b8c2a', 'LT96785089', '2', 6, 2, 'StringBuffer 类', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('19894b2dedab4a05baaf45d39cfa9a92', 'MF86683708', '2', 9, 4, '函数与指针', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('19dd664a47ac422d908674b4e64b9862', 'TT001', '2', 2, 2, '创建项目', '07ba02be0ff44bcb819fedd97aa6248e');
INSERT INTO `knowledge` VALUES ('1c45d697d51846e1853269445ab18c35', 'LT96785089', '2', 6, 4, '正则表达式及字符串的替换和分解', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('1e7b38da6c2c498cb6276cf9f4e481ce', 'LT96785089', '2', 10, 17, '键盘事件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('1eb80332424e4f44a12f2a4e5d3fbf38', 'LT96785089', '2', 5, 13, '面向接口', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('1f2a9d94e4714cb69b2c2bac2d2b99df', 'TT001', '2', 9, 2, 'WebFlux入门应用', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('21c0e0637c7d4e87bb659738b8810344', 'MF86683708', '2', 5, 6, '程序应用举例', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('2352722e99d84c0a8cfa166c832b502e', 'MF86683708', '2', 1, 4, 'C程序的上机步骤', 'f3540ae5c90d41e4a12cf325bc8ba920');
INSERT INTO `knowledge` VALUES ('254f93894f6e4aecb31d5a038b1047f9', 'LT96785089', '2', 10, 6, '文本组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('2684e091878e460e911914c4fbaebf29', 'MF86683708', '2', 5, 1, 'while语句', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('268ebda8441744a089c1e9f0e3646d89', 'LT96785089', '2', 3, 2, '关系运算符和关系表达式', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('27a71788352043b9a58f77aa2d9e0b55', 'LT96785089', '2', 1, 7, 'JDK1.6 编译器的兼容性', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('27cea2c137c24316a6afc30ceed7dca6', 'TT001', '2', 4, 5, 'Spring Boot对Ajax的应用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('285d4de4e01145f0af3ab971fb18308c', 'LT96785089', '2', 8, 7, '线程同步', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('28e658120db747e08387b40bbf800a7f', 'LT96785089', '2', 8, 4, 'Thread 的子类创建线程', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('29a8661836f34a19928af2367b508526', 'MF86683708', '2', 7, 2, '二维数组的定义和引用', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('29c4ada6282d44e0b9ef3d5d2304a4e6', 'NJ96116427', '2', 0, 2, '该示例将在你添加第一条章节知识点时自动删除，请勿重复操作', 'ba02e5e0d477484588e3520d611752a6');
INSERT INTO `knowledge` VALUES ('29cd109e20174d6eaed5a11276c557a4', 'LT96785089', '1', 12, 0, '数据库操作', '');
INSERT INTO `knowledge` VALUES ('2b1ffbea455141108d7ed9e664465a32', 'LT96785089', '2', 5, 14, '抽象类和接口的比较', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('2b68f74585fa466ca36eb9e5db495b33', 'LT96785089', '2', 4, 9, '关键字 this', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('2c548c1b727e4b76a737912ce249b7f9', 'MF86683708', '2', 9, 3, '字符串与指针', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('2d63fc016bfc4e219893aa799fde1700', 'LT96785089', '2', 12, 14, '使用纯Java 数据库驱动', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('2d9c0ff075ad46f38ec4be25b613f4a6', 'LT96785089', '2', 1, 6, 'Java 程序开发', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('2e7e83922e114323a29bfa706dcd1094', 'LT96785089', '2', 4, 14, '基本类型数据的类包装', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('2ff83cbf15ad4bc4b6c5fd7e6c4e1f98', 'TT001', '2', 2, 4, '以Hello World的应用为例说明项目属性配置', '07ba02be0ff44bcb819fedd97aa6248e');
INSERT INTO `knowledge` VALUES ('30037f1d85274f288b3037331ec0bc55', 'LT96785089', '2', 10, 20, 'MVC 设计模式', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('303045bd01cf48c6a76307048e1da3d0', 'MF86683708', '2', 3, 2, '赋值语句', '976117a38bfc4f01864a25526c8c25b9');
INSERT INTO `knowledge` VALUES ('313d9370986046d8945a60c6b1022d82', 'TT001', '2', 4, 8, '使用Servlet、过滤器、监听器和拦截器', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('329063dd26434ea48740772711eff137', 'LT96785089', '2', 10, 18, 'AWT 线程', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('32cfe15d3b454a248800b32fa60faa71', 'LT96785089', '2', 7, 3, 'Math 类和BigInteger 类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('338bf6ee20474c4ea23adde8d07ef567', 'MF86683708', '2', 1, 3, '程序开发周期', 'f3540ae5c90d41e4a12cf325bc8ba920');
INSERT INTO `knowledge` VALUES ('348f81ae752843ea86118797202c9d5a', 'LT96785089', '2', 12, 2, 'Derby 数据库', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('3514bf02a3df4193ac928aa068425933', 'MF86683708', '2', 4, 3, '选择结构程序设计举例', 'f153d365ad644d8f9af0856e4a525b6b');
INSERT INTO `knowledge` VALUES ('3554cc391ecf4e7cbac3ea54f8f8d912', 'TT001', '2', 8, 3, '图片文件上传和显示', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('3583be09c4dd4481b9bdd7da98834d37', 'TT001', '2', 9, 4, '基于WebFlux访问MongoDB数据库', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('3587bdc69e54417eb7bc57884ea70009', 'TT001', '2', 2, 1, '配置开发环境', '07ba02be0ff44bcb819fedd97aa6248e');
INSERT INTO `knowledge` VALUES ('35934ce5026c420cb2bb86ab54ebbc47', 'SF14864420', '2', 1, 6, '测试驱动开发的思想', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('3715b86dfc454fde81b305f17fe80864', 'TT001', '2', 6, 3, '使用带AngularJS的RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('373eb37bd4744d468a02a2e79fb08738', 'LT96785089', '2', 4, 8, '方法重载', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('377e6966f92a4e179e7b7ab3a963868e', 'TT001', '2', 6, 4, '基于Actuator实现RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('39a49d209a274b7b8baefbaff038a97f', 'TT001', '2', 5, 2, '使用Spring Data JPA访问H2数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('39ba8b48822c48f094594d01d567081e', 'LT96785089', '2', 9, 6, '字符串流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('3c917c649c1f48e284935782798b2a06', 'LT96785089', '2', 7, 8, 'TreeSet<E>泛型类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('3d901f420903472686181fda0ad015e4', 'SF14864420', '2', 1, 5, '测试和质量保证的关系', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('3e47d8fa63e9458f94f0823708d0d93d', 'MF86683708', '2', 2, 3, '常量', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('3eb814f8e59a44d19176005ca8806f10', 'LT96785089', '2', 12, 5, '查询操作', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('3eeddc25760449208662ad58100e2787', 'TT001', '2', 2, 3, '实现Hello World的Web应用', '07ba02be0ff44bcb819fedd97aa6248e');
INSERT INTO `knowledge` VALUES ('42de084d83ee459190c28bd35c3e01ba', 'LT96785089', '2', 3, 9, '一般表达式', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('43c984a003024ac38ba1c7e79b270e0f', 'LT96785089', '2', 9, 4, '缓冲流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('44bc6fd3e2b84b0fb973cc59e8c30215', 'LT96785089', '2', 7, 2, 'Calendar 类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('44fcf0b0ed2b432ca5a590dc3cbb7676', 'LT96785089', '2', 2, 4, '数据的输入和输出', '6f93b61aaa354729b3c38c1bf0930923');
INSERT INTO `knowledge` VALUES ('45b4130f622244b49ab19531e18bc7cf', 'MF86683708', '2', 1, 2, '简单的C程序介绍', 'f3540ae5c90d41e4a12cf325bc8ba920');
INSERT INTO `knowledge` VALUES ('461cf7a696994a46b7902e04ebfb02bb', 'MF86683708', '2', 10, 1, '文件概述', '5ab4a5384cd446bc9e55db84e8027184');
INSERT INTO `knowledge` VALUES ('4640572460954a8cbaaa92b44622ea49', 'MF86683708', '2', 7, 4, '数组作为函数参数', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('4691001d03dc46e49d7c24c7ab589ff7', 'LT96785089', '2', 6, 5, 'Scanner 类', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('46adffb59adb46b2826e1f1992a478da', 'LT96785089', '2', 11, 6, '套接字 Socket', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('4779bf0b4fe64342b3026b1a71dfeb56', 'MF86683708', '2', 2, 8, '位运算', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('48a8027a3b9f417e8de440ad79eed25b', 'MF86683708', '2', 2, 6, '各类数值型数据之间的混合运算', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('49bb0e6bcdc94851b09c233f9bed998a', 'MF86683708', '1', 6, 0, '函数', 'MF86683708');
INSERT INTO `knowledge` VALUES ('4a10f0e6274842278bf9f85d55581b73', 'LT96785089', '2', 4, 2, '类声明和类体', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('4a5219de3c90404fa17ffaf5f5873442', 'LT96785089', '2', 12, 9, '预处理语句', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('4bafef445aa840008993cce00d66f0e2', 'LT96785089', '2', 11, 4, '处理超链接', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('4bc4481798564ebeb5ec541b2139377e', 'LT96785089', '2', 5, 2, '子类的继承性', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('4d580d4d934049f189c9754653af0ede', 'MF86683708', '2', 7, 1, '一位数组的定义和引用', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('4df2ef6884524b51bab4938eefc8941b', 'LT96785089', '2', 4, 13, '对象的组合', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('4dfd29417ae543428c4f857da123f84a', 'LT96785089', '2', 4, 1, '面向对象编程', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('4e2572cdc1274414acbf25fa2e5530e0', 'LT96785089', '2', 4, 6, '成员变量', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('4eab54845a654dd3b7c87d9bb9aeceff', 'LT96785089', '2', 11, 3, '显示URL 资源中的HTML 文件', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('507500fefbff41b39388d2b22f2b3e31', 'NJ96116427', '2', 0, 1, '本处填写小节名称', 'ba02e5e0d477484588e3520d611752a6');
INSERT INTO `knowledge` VALUES ('50aac289876940debf5dfc7cd0cdd76b', 'LT96785089', '1', 4, 0, '类和对象', '');
INSERT INTO `knowledge` VALUES ('51cd7cc3ce434b8db63c9dd272086a37', 'TT001', '2', 5, 3, '使用Spring Data JPA和RESTful访问H2数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('52a0977072ae41be8bb95b0983066f25', 'LT96785089', '2', 10, 7, '按钮与标签组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('544bffced9914e21873e35b1b4e398ec', 'LT96785089', '2', 1, 1, 'Java 语言的诞生', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('546392d8a7d74f05974d8c51b1b5a92f', 'LT96785089', '2', 9, 3, '文件字符流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('56c71ce588fc4c18bb4c31ee4cae50f2', 'SF14864420', '2', 1, 4, '测试和开发的关系', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('57be1708198d4b1ba2eedbd8f7fd8cf2', 'LT96785089', '2', 1, 5, 'Java 运行平台', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('5871062388114cafba1ba00255724993', 'LT96785089', '2', 9, 5, '数组流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('596c5a54fc7c4ec7a976227973bd60a0', 'LT96785089', '2', 7, 5, 'LinkedList<E>泛型类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('5ab4a5384cd446bc9e55db84e8027184', 'MF86683708', '1', 10, 0, '文件', 'MF86683708');
INSERT INTO `knowledge` VALUES ('5bb75bb3fadf4218b26cfc5443cfb3bb', 'TT001', '1', 10, 0, 'Spring Boot开发案例', '');
INSERT INTO `knowledge` VALUES ('5c3fe19bc5da49f4a471af4a9e137b36', 'LT96785089', '2', 4, 10, '包', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('5d2f11c7ec7042aca87b538217977ec9', 'LT96785089', '2', 7, 9, 'Stack<E>泛型类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('5d3a41649547472abdcfa4c359faff06', 'LT96785089', '2', 9, 11, '使用 Scanner 解析文件', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('5d4882a3d0344bb698a9d86763f45378', 'LT96785089', '2', 10, 1, 'AWT组件与SWING组件概述', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('5d8280f484f54e079836fd0ef29369c4', 'LT96785089', '2', 4, 11, 'import 语句', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('5e4de51cc4a141efbdfc3d352eb0f857', 'TT001', '2', 9, 7, '基于WebFlux使用WebSocket', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('5e5926fe274b437f8644b9468dab69e7', 'LT96785089', '2', 12, 6, '更新、插入和删除操作', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('5ee32dafd99048f6bee82a9a3ea956c8', 'MF86683708', '2', 4, 1, 'if语句', 'f153d365ad644d8f9af0856e4a525b6b');
INSERT INTO `knowledge` VALUES ('60b4a828822b4f888ca125beba906921', 'TT001', '2', 9, 1, 'WebFlux及其编程模型', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('61071ee6867d4fda9d33963e7b7ea32b', 'MF86683708', '2', 3, 5, '顺序结构程序设计举例', '976117a38bfc4f01864a25526c8c25b9');
INSERT INTO `knowledge` VALUES ('63a60b3e205448f2beddfc5530c82acf', 'LT96785089', '2', 10, 13, '组件常用方法', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('64570ff7b02941c594ad5707b67cd4a9', 'SF14864420', '2', 1, 1, '软件测试的必要性', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('64adfed124764f2cb6c857dd06d52347', 'LT96785089', '2', 5, 15, '内部类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('67844d1d5e36409c9ac943de268c3cc4', 'MF86683708', '2', 9, 1, '指针变量', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('6800991f969b42f19f62d598c7d0c81b', 'MF86683708', '2', 5, 5, '程序跳转语句', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('688f95a4d2e544df817eab56389a30a4', 'LT96785089', '2', 6, 1, 'String 类', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('69408646a8e8427f80c184965f538820', 'MF86683708', '2', 3, 1, 'C语言概述', '976117a38bfc4f01864a25526c8c25b9');
INSERT INTO `knowledge` VALUES ('69e68b27139144a1ad39d992f2676d4b', 'MF86683708', '2', 3, 3, '输入/输出函数', '976117a38bfc4f01864a25526c8c25b9');
INSERT INTO `knowledge` VALUES ('6a4e0003ab0349b6a24e5b2303c8871a', 'TT001', '2', 8, 7, '用REST Docs创建API文档', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('6aa61e9ef656406caf61cccaec9aa8e6', 'LT96785089', '2', 10, 10, '表格组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('6b40a3df051f4a2db0d8dcd7baac3d9f', 'LT96785089', '2', 12, 4, 'Java 程序链接Derby 数据库', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('6e3a5d08706044b9bc6b82ebfa007b06', 'LT96785089', '2', 13, 4, '在Java Applet 中使用组件', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('6e5e83a479914bc68be5421530bc800c', 'TT001', '1', 9, 0, 'Spring Boot的WebFlux开发', '');
INSERT INTO `knowledge` VALUES ('6e6d6b4318c8432e8b939bce708a33e3', 'TT001', '2', 6, 6, '实现超媒体驱动的RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('6f519c442afd473b8849c0baff6b31b5', 'LT96785089', '2', 6, 3, 'StringTokenizer 类', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('6f93b61aaa354729b3c38c1bf0930923', 'LT96785089', '1', 2, 0, '基础数据类型和数组', '');
INSERT INTO `knowledge` VALUES ('6fcaef227fb54014ad5ab41f0c707da9', 'LT96785089', '2', 11, 10, 'Java 远程调用', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('706cf4a39e13448b8e1b692cde2ca278', 'LT96785089', '1', 7, 0, '常用实用类', '');
INSERT INTO `knowledge` VALUES ('7129536aac6f4d92907c36948c829eef', 'LT96785089', '2', 2, 1, '标识符和关键字', '6f93b61aaa354729b3c38c1bf0930923');
INSERT INTO `knowledge` VALUES ('730985f429384170b355b048652e3ce2', 'LT96785089', '2', 3, 10, '语句概述', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('73266de6ab934d49bd378fdf116a0a26', 'LT96785089', '2', 10, 2, 'Jframe 窗体', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('73436359d3e147988b815edf512c172d', 'LT96785089', '2', 3, 3, '逻辑运算符和逻辑表达式', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('737a74a848cd47229b0f6ff707ce23e3', 'MF86683708', '1', 7, 0, '数组', 'MF86683708');
INSERT INTO `knowledge` VALUES ('74fa1c3ff84443fc82d8ea14b5e761e6', 'TT001', '2', 6, 7, '整合CXF的Web服务开发', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('76371909ed2e45a8bbe687d2270cfa00', 'MF86683708', '2', 9, 2, '指针与数组', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('767da24c48c84c78ba425e3dc08ff6be', 'MF86683708', '2', 2, 7, '运算符和表达式', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('78766f3d2f6048d3bb23c1bc9d9ab011', 'MF86683708', '1', 9, 0, '指针', 'MF86683708');
INSERT INTO `knowledge` VALUES ('79b0e4053fbc4d67bd6d2ebe46d55a1a', 'LT96785089', '1', 10, 0, '图形用户界面设计', '');
INSERT INTO `knowledge` VALUES ('7b14d9b24df0421d9bd47e67378d16d6', 'TT001', '1', 8, 0, 'Spring Boot的文件应用', '');
INSERT INTO `knowledge` VALUES ('7c807dbbfae34200aa9ad7c88e61f541', 'MF86683708', '2', 8, 2, '结构体数组', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('7cf3690696714b68b0482c837da87c85', 'TT001', '2', 4, 1, '实现静态Web页面', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('7dfe952b59894e058827358b5a142e4c', 'MF86683708', '2', 1, 5, '未归档', 'f3540ae5c90d41e4a12cf325bc8ba920');
INSERT INTO `knowledge` VALUES ('7e560f00fce1413ea5dada3cee74af4e', 'LT96785089', '2', 10, 14, '窗口事件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('7e717d8963804a79862773bb6ea0c29a', 'TT001', '1', 1, 0, 'Spring Boot 简介', '');
INSERT INTO `knowledge` VALUES ('7ec43bf394dc44b49a13c3a98b86b5f9', 'LT96785089', '2', 11, 9, '广播数据报', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('7ef952e687674cd8b696c9e7934fddd3', 'LT96785089', '2', 3, 5, '移位运算符', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('8026419233a844aba09fc65426c5d057', 'LT96785089', '2', 10, 16, '焦点事件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('8044a638c1514897a42431c6dd6b3baa', 'TT001', '1', 3, 0, 'Spring Boot 的相关注解', '');
INSERT INTO `knowledge` VALUES ('82d4e3db4d2d470187d3265210fc1c17', 'LT96785089', '2', 7, 4, '数字格式化', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('8511f0f61bca4a2fa8477973e8686988', 'LT96785089', '2', 3, 7, '条件运算符', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('878bc3351e5741efa934c2e7591dfc25', 'LT96785089', '2', 8, 10, '线程联合', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('88fa50b0c7ce4403a43bbcb6b3feea00', 'LT96785089', '2', 1, 3, 'Java 的特点', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('8abbc2de84f344d99be46ece2b2b364b', 'TT001', '1', 5, 0, 'Spring Boot的数据库访问', '');
INSERT INTO `knowledge` VALUES ('8adba69ea4ac4765bef79ce563a2e2d0', 'SF14864420', '2', 1, 2, '为什么要进行软件测试', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('8aef0f6eb9294cd384615aaf19f6b63f', 'LT96785089', '2', 13, 1, 'Java Applet 的运行原理', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('8b280ffcfbeb4a6991260dd55ba2b164', 'LT96785089', '2', 10, 8, '复选框与单选框组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('8bf7e170dc0e4b3684d05157c7a2dc78', 'LT96785089', '2', 13, 5, '在Java Applet 中绘制图形', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('8c5f66f7f5c2468db52978be22f3d6eb', 'TT001', '2', 10, 1, '案例分析', '5bb75bb3fadf4218b26cfc5443cfb3bb');
INSERT INTO `knowledge` VALUES ('8cac636620494719a4dd0b8c9b381322', 'MF86683708', '2', 10, 2, '文件基本操作', '5ab4a5384cd446bc9e55db84e8027184');
INSERT INTO `knowledge` VALUES ('8caf25e3a245452b8b960302a43edf27', 'LT96785089', '2', 10, 25, '发布应用程序', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('8d3a9025b3944787a4425dfaa37c3e09', 'LT96785089', '2', 5, 8, '继承和多态', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('8dbaecc4ce4144289a4bb8e443b2b3af', 'TT001', '2', 1, 2, 'Spring Boot 的特征', '7e717d8963804a79862773bb6ea0c29a');
INSERT INTO `knowledge` VALUES ('8e13d6d79dae4539a6c90db5c2aa8b24', 'LT96785089', '2', 9, 1, '文件', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('8f42f97a50d143818889f2513a71903d', 'TT001', '2', 4, 2, '实现基于Thymeleaf的Web应用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('8fe2c27c162945e9852332f3e9f2f9bd', 'TT001', '2', 7, 6, '整合Spring Batch和Quartz', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('91e9d69f389442d5a50fc02c0be54a24', 'MF86683708', '2', 2, 1, 'C语言的数据类型', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('932adf625af14aa4b202a57c9976125d', 'LT96785089', '2', 9, 9, '序列化和对象克隆', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('93bf4f7b828148a08a009477071b0037', 'LT96785089', '2', 3, 1, '算术运算符和算术表达式', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('93d82723279a43a69c99b2b877ef774e', 'MF86683708', '2', 6, 6, '函数的递归调用', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('9544ef0012d347a08c8a44ad7ec7d695', 'LT96785089', '2', 4, 12, '访问权限', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('95b5fdec46784aebbebcab1f19f2f088', 'LT96785089', '2', 10, 9, '列表组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('96c36f44a30c47b99da79ce22e1251bb', 'TT001', '2', 6, 1, '基于Jersey实现RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('976117a38bfc4f01864a25526c8c25b9', 'MF86683708', '1', 3, 0, '顺序结构程序设计', 'MF86683708');
INSERT INTO `knowledge` VALUES ('979e6f355bc84ed783b702541897825f', 'LT96785089', '2', 12, 12, '使用Jtable 组件操作表', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('97a0e44e72464a37bda7b5b8103be823', 'LT96785089', '2', 5, 10, '面向抽象', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('97d1d609092d4dc394e02c0b3916a9d9', 'MF86683708', '1', 5, 0, '循环结构程序设计', 'MF86683708');
INSERT INTO `knowledge` VALUES ('97f2c06f9ede49e1be16d547b95c27d2', 'LT96785089', '2', 9, 12, '文件锁', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('9956405427ee41e58166bbd3560010ef', 'LT96785089', '2', 4, 7, '方法', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('9960481014a84b0589409dded406f031', 'LT96785089', '2', 10, 5, '中间容器', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('99b9a2afb8214bc188efb0eed3dcc1e0', 'TT001', '2', 6, 2, '使用RESTful风格Web服务', 'ea9b4a53a45749b3b8c13b67a6bcc412');
INSERT INTO `knowledge` VALUES ('9a17cee7074f401abce2730059cabe8c', 'MF86683708', '2', 6, 2, '函数的定义', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('9a42b8e3b0c24203b374d39e0a05e768', 'LT96785089', '2', 13, 8, 'Java Applet 网络聊天室', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('9b11009218f74f05ab406ac203ec4e96', 'LT96785089', '2', 3, 6, '位运算符', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('9cebab742c504487ac93c95423e25325', 'LT96785089', '2', 8, 9, '挂起、恢复和终止线程', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('9e2453fa5afc41b08947e7ea218e54c8', 'LT96785089', '2', 7, 1, 'Date 类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('9f35daec5200451eae5f4f4f0ac9cb9a', 'MF86683708', '2', 3, 4, '结构化程序设计思想', '976117a38bfc4f01864a25526c8c25b9');
INSERT INTO `knowledge` VALUES ('9f8854bcf12541dc80a28d58e44afc19', 'LT96785089', '2', 7, 6, 'HashSet<E>泛型类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('9fa6dab79dab49a3b05d3673507b9bda', 'LT96785089', '2', 9, 2, '文件字节流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('a03954d379cf467da3d5b869fa033b90', 'LT96785089', '2', 12, 11, '批处理', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('a0e1bf8c2bb6493bb1ff28a6f6449b3f', 'LT96785089', '2', 9, 7, '数据流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('a0ed8ba797834f299bf5c4e9cac8e0cc', 'SF14864420', '1', 1, 0, '引论', '');
INSERT INTO `knowledge` VALUES ('a214125bd8f246fb8c93f983166cbfc3', 'LT96785089', '2', 13, 2, '在Java Applet 中播放音频', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('a234b4f5790944d09e5a1b0ca6181dbf', 'MF86683708', '2', 10, 4, '文件的定位', '5ab4a5384cd446bc9e55db84e8027184');
INSERT INTO `knowledge` VALUES ('a2ca664d41a84608a0d324e8e7f3218b', 'LT96785089', '2', 4, 17, 'JAR 文件', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('a3c5db1293b041089d9ea6e5c71642d0', 'SF14864420', '2', 1, 3, '什么是软件测试', 'a0ed8ba797834f299bf5c4e9cac8e0cc');
INSERT INTO `knowledge` VALUES ('a4a82fc8ba9a4c1a8e31929c01536f18', 'MF86683708', '2', 8, 5, '共用体', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('a4f952437bd74b049e8d85430a5c4763', 'MF86683708', '2', 10, 5, '预处理', '5ab4a5384cd446bc9e55db84e8027184');
INSERT INTO `knowledge` VALUES ('a5683270e2df4004a3a615fc6c8c07c4', 'LT96785089', '2', 12, 13, 'SQL Server 2000 数据库', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('a65c955573114314a36e8adadb65273e', 'TT001', '2', 4, 7, '带Bootstrap的jQuery的Web应用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('a71fd4c5c0e9472abb74d7c6b00bf54a', 'LT96785089', '1', 5, 0, '继承、接口和泛型', '');
INSERT INTO `knowledge` VALUES ('a76bd611f6a2491ba7b76fe762cdb301', 'LT96785089', '2', 9, 8, '对象流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('a7a6caa6ca8b4b63a903704d686060fd', 'LT96785089', '2', 3, 8, 'instanceof运算符', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('ab76208530e74ffba1d57ab128d5e35a', 'LT96785089', '2', 5, 11, '接口', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('abfa92ec893b436bb2f0d081355b4d55', 'MF86683708', '2', 4, 2, 'switch语句', 'f153d365ad644d8f9af0856e4a525b6b');
INSERT INTO `knowledge` VALUES ('aec3c31ee0d84d3086cbfc34e3a4f60a', 'LT96785089', '2', 5, 7, '对象的上传型对象', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('affb722a2c4742fd938eaf3239438f5b', 'MF86683708', '2', 2, 5, '变量赋初值', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('b033ac13d6e9459b89d1cfb5d8e08ae8', 'MF86683708', '2', 6, 5, '函数的嵌套调用', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('b0857d7c637c4eb48359535730692727', 'TT001', '2', 3, 2, 'Spring 注解及注解注入', '8044a638c1514897a42431c6dd6b3baa');
INSERT INTO `knowledge` VALUES ('b0a6a0ea687f4f51a442a1cf737701c6', 'TT001', '2', 9, 5, '基于WebFlux使用ThyMeleaf和MongoDB', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('b0cb298b0e794097b7c04c54bc2cfc4a', 'LT96785089', '2', 2, 2, '基本数据类型', '6f93b61aaa354729b3c38c1bf0930923');
INSERT INTO `knowledge` VALUES ('b28674f6da89415ebba9e0445e307c0e', 'LT96785089', '2', 10, 21, '播放音频', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('b3298e94585642d7a9e35e940b1553b6', 'LT96785089', '2', 5, 17, '异常类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('b3fcafe8af3d42ccaf23acc51eb598e1', 'LT96785089', '2', 3, 13, '跳转语句', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('b59dd2c28ccf4bcca5a405c95f437381', 'LT96785089', '2', 5, 5, '关键字 super', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('b5b57b064a08409c87eb413a34c6a61d', 'LT96785089', '2', 9, 10, '随机读写流', '047ec7f88aab4be78709a5414890651e');
INSERT INTO `knowledge` VALUES ('b655696450cf4ce5a3157bff01509207', 'MF86683708', '2', 6, 8, '变量的存储类型', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('b7538f93dd414bb985a7360635dd0323', 'LT96785089', '2', 10, 11, '树组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('b77656c9093c48a8adea7b3fe4234fde', 'MF86683708', '2', 2, 2, '标识符', 'b9197994536241bfb28f2cad5b8d9dfb');
INSERT INTO `knowledge` VALUES ('b9197994536241bfb28f2cad5b8d9dfb', 'MF86683708', '1', 2, 0, '数据类型、运算符与表达式', 'MF86683708');
INSERT INTO `knowledge` VALUES ('ba02e5e0d477484588e3520d611752a6', 'NJ96116427', '1', 0, 0, '示例-本处填写章节名称', '');
INSERT INTO `knowledge` VALUES ('ba3c84b5d4af4b0490240bf7fa61f227', 'TT001', '2', 5, 6, '访问Neo4j数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('bace3c784d4243c097ac26b1835b49c4', 'LT96785089', '2', 5, 3, '子类对象的构造过程', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('bb9c808d2d874941bc017bf3771bdea1', 'LT96785089', '2', 13, 7, '在Java Applet 中播放幻灯片', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('bbf5113fabdd424f92c04988e82f52ca', 'LT96785089', '2', 5, 9, '抽象类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('bbfcd3028f6146a59083450a0e2430ad', 'LT96785089', '2', 13, 6, '在Java Applet 中绘制图像', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('bfb47370d58945be86aceae02c9c4713', 'LT96785089', '1', 1, 0, 'Java 语言概述', '');
INSERT INTO `knowledge` VALUES ('c0494828f5f74983bbbbbfda8cfedbf9', 'LT96785089', '2', 5, 4, '成员变量隐藏和方法重写', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('c16fbf3b15774fa3a8c35b92b0003d18', 'LT96785089', '2', 12, 1, 'JDBC 简介', '29cd109e20174d6eaed5a11276c557a4');
INSERT INTO `knowledge` VALUES ('c1a91f6153824f7399a92878bf0b2abf', 'LT96785089', '2', 10, 12, '进度条组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('c2c66085341d4619abf76ef61df0d663', 'MF86683708', '2', 6, 4, '函数的调用', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('c2f19cb72a89448485dcbd7d3e2c85d9', 'LT96785089', '2', 5, 6, 'final 类和 final 方法', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('c3219ad9d79c484c893d40f8bb778562', 'LT96785089', '2', 2, 3, '基本数据类型的转换', '6f93b61aaa354729b3c38c1bf0930923');
INSERT INTO `knowledge` VALUES ('c3ee9bf0cbab4a76b6b2a5b3d31c2a48', 'LT96785089', '2', 3, 4, '赋值运算符和赋值表达式', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('c4931665073f4d0ca6427c3a61be8cf3', 'LT96785089', '2', 8, 3, '线程的优先级和调度管理', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('c5ef907136834d68bb5360911a8c3bcd', 'LT96785089', '2', 7, 7, 'HashMap<K,V>泛型类', '706cf4a39e13448b8e1b692cde2ca278');
INSERT INTO `knowledge` VALUES ('c6cc6d8667ba418f849b63bf58abc7e2', 'TT001', '2', 3, 3, 'Spring Boot的注解', '8044a638c1514897a42431c6dd6b3baa');
INSERT INTO `knowledge` VALUES ('c795c6b761954bd391e7cad4cff61a69', 'TT001', '2', 1, 1, 'Spring Boot 的发展背景', '7e717d8963804a79862773bb6ea0c29a');
INSERT INTO `knowledge` VALUES ('c7a3d7fa1610430eae57acee4bcad9ea', 'LT96785089', '1', 8, 0, '线程', '');
INSERT INTO `knowledge` VALUES ('c89ea4cf1db94085bc5065061cfbc62d', 'TT001', '2', 2, 5, 'Spring Boot 开发的一般步骤', '07ba02be0ff44bcb819fedd97aa6248e');
INSERT INTO `knowledge` VALUES ('ca02fad4a726496a8994ff6cc2c1eb35', 'MF86683708', '2', 6, 10, '综合应用举例', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('ca47d0b0822d4768ae45c496b7c2d6fb', 'LT96785089', '1', 13, 0, 'Java Applet', '');
INSERT INTO `knowledge` VALUES ('cb4c9175250847f6976cf46ad6de30d0', 'MF86683708', '2', 6, 9, '内部函数和外部函数', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('cc9cb57aae064ce69ecf188db911fda8', 'MF86683708', '2', 5, 4, '循环的嵌套', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('cd490ff3f9d8495588dc9a1cece4ee69', 'MF86683708', '2', 9, 5, '指针数组和指向指针的指针', '78766f3d2f6048d3bb23c1bc9d9ab011');
INSERT INTO `knowledge` VALUES ('ce0a379dac40463d90258242c25b5787', 'LT96785089', '2', 10, 22, '按钮绑定到键盘', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('cf65ee85b5c14fd8b6a5c3549bcb71b9', 'TT001', '2', 8, 6, '实现邮件发送', '7b14d9b24df0421d9bd47e67378d16d6');
INSERT INTO `knowledge` VALUES ('cf8c0bd946d8462eb9a71d7e0fdcff0e', 'LT96785089', '2', 8, 6, '线程的常用方法', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('cf9c0716fa1d49b487822f2f7c7cff11', 'MF86683708', '2', 5, 3, 'for语句', '97d1d609092d4dc394e02c0b3916a9d9');
INSERT INTO `knowledge` VALUES ('d04e135d09744ce58e4c56ca1aa43a35', 'LT96785089', '1', 3, 0, '运算符、表达式和语句', '');
INSERT INTO `knowledge` VALUES ('d1dad31c4d8a41c29117e595c239cbfc', 'LT96785089', '2', 11, 7, '使用多线程处理套接字链接', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('d3e1018680234c129bed0269e1d81f28', 'TT001', '2', 9, 6, '基于WebFlux访问Redis数据库', '6e5e83a479914bc68be5421530bc800c');
INSERT INTO `knowledge` VALUES ('d4043055130a4419becef25db6b75392', 'MF86683708', '1', 8, 0, '结构体与共用体', 'MF86683708');
INSERT INTO `knowledge` VALUES ('d59631a8c68642e39188a625e720be9a', 'LT96785089', '1', 11, 0, 'Java 中的网络编程', '');
INSERT INTO `knowledge` VALUES ('d5d35cbb836948e8ae05995e49cabd27', 'MF86683708', '2', 7, 3, '字符数组', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('daf542385d954166bef587e4d0bfc651', 'LT96785089', '2', 10, 4, '布局设计', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('dbfc96c0194f461e98f39bc969d8fe0c', 'TT001', '2', 5, 4, '使用Spring Data JPA访问MySQL数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('dc34bf3e40fa4de0a26c0e9d2ae8fef0', 'TT001', '2', 7, 4, '使用表单验证', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('dc5b6d791e6c4dfb8f9361554b5678a4', 'LT96785089', '2', 10, 3, '菜单组件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('ddd4f220d0ca4f6ba7c336d023112a8c', 'TT001', '2', 7, 3, '使用Druid', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('de1e5a9f6d344901bea5aaa02311e6a7', 'LT96785089', '2', 5, 16, '匿名类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('deabc5fce9de46479441621a1adb0ace', 'TT001', '2', 7, 1, '声明式事务', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('dfda4b929afd453b87c9b7d41606f369', 'MF86683708', '2', 6, 3, '函数的参数和返回值', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('e164b879bcf6452dbd397a835ff93243', 'TT001', '1', 4, 0, 'Spring Boot的Web应用开发', '');
INSERT INTO `knowledge` VALUES ('e2ed1669086a4252b6a56621e4099815', 'LT96785089', '2', 6, 6, '模式匹配', '07ffd3bb345b4f35b4f209a6d442534b');
INSERT INTO `knowledge` VALUES ('e364bd17d6e8467dafb9d85aea13de6f', 'LT96785089', '2', 10, 15, '鼠标事件', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('e3823c007edd48948e23aaa026bdc8fe', 'LT96785089', '2', 8, 2, '线程的生命周期', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('e3b07837d26143a8a384e01582cdb115', 'TT001', '1', 7, 0, 'Spring Boot的数据处理', '');
INSERT INTO `knowledge` VALUES ('e5a123f2472048e18510f5ef2eb9f8b0', 'TT001', '2', 7, 5, '整合MyBatis访问数据库', 'e3b07837d26143a8a384e01582cdb115');
INSERT INTO `knowledge` VALUES ('e6447355d3e1483e800df20a8f9aa251', 'MF86683708', '2', 8, 1, '结构体', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('ea9b4a53a45749b3b8c13b67a6bcc412', 'TT001', '1', 6, 0, 'Spring Boot的Web服务开发', '');
INSERT INTO `knowledge` VALUES ('ead3ba555e384350b48d7cb7a1427a8c', 'LT96785089', '2', 5, 18, '泛型类', 'a71fd4c5c0e9472abb74d7c6b00bf54a');
INSERT INTO `knowledge` VALUES ('eb925240e5ec4fcaa7dd350899f705e5', 'TT001', '2', 4, 4, '实现基于Freemarker的Web应用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('edfec28d42ab48c69a40e73ed45c16cb', 'LT96785089', '2', 10, 24, '多文档界面', '79b0e4053fbc4d67bd6d2ebe46d55a1a');
INSERT INTO `knowledge` VALUES ('eeb5d1bc31d849b7883bd312b3df4870', 'MF86683708', '2', 1, 1, 'C语言的发展历史及特点', 'f3540ae5c90d41e4a12cf325bc8ba920');
INSERT INTO `knowledge` VALUES ('f081f9a6be6143dabe657f3d511fdc28', 'LT96785089', '2', 11, 2, '读取URL 中的资源', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('f11340b9e84c4171846c152369ce612c', 'MF86683708', '2', 8, 6, '类型定义', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('f153d365ad644d8f9af0856e4a525b6b', 'MF86683708', '1', 4, 0, '选择结构程序设计', 'MF86683708');
INSERT INTO `knowledge` VALUES ('f1a51f9e128f482cb1139c7fd66e60a0', 'MF86683708', '2', 7, 5, '数组程序举例', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('f1e1b94464d94bd286172b81cfeedd2a', 'LT96785089', '2', 8, 5, 'Runnable 接口', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('f1e1caaf52de408eaa77dd5ce34fd9b2', 'LT96785089', '2', 4, 3, '类体的构成', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('f33b485550a148a2bc2b0e22ca83c4fa', 'LT96785089', '2', 8, 8, '使用 wait()、notify()和notifyAll()协调同步线程', 'c7a3d7fa1610430eae57acee4bcad9ea');
INSERT INTO `knowledge` VALUES ('f3540ae5c90d41e4a12cf325bc8ba920', 'MF86683708', '1', 1, 0, 'C语言概述', 'MF86683708');
INSERT INTO `knowledge` VALUES ('f3aef68ab80d4d6dbc819d94549982fe', 'LT96785089', '2', 1, 4, 'Java 与C/C++之关系', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('f3b5ec2bab3943209028452f8d4291b6', 'LT96785089', '2', 1, 2, '学习Java 的必要性', 'bfb47370d58945be86aceae02c9c4713');
INSERT INTO `knowledge` VALUES ('f47c60bf15d047d5bc194e65599b7dcd', 'LT96785089', '2', 4, 5, '对象的引用和实体', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('f5003d4c0c624f3caba5ba353f38ec82', 'LT96785089', '2', 3, 12, '循环语句', 'd04e135d09744ce58e4c56ca1aa43a35');
INSERT INTO `knowledge` VALUES ('f5e6b824418741d983454eb13eca3a55', 'MF86683708', '2', 8, 3, '结构体类型指针', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('f62a345d275e41be9579545b1b90f2f3', 'TT001', '2', 5, 1, '使用JDBC访问H2数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('f6f7334a2d1c4cab9ece91e4e744b26a', 'TT001', '2', 4, 6, 'Spring Boot是RESTful风格Web应用', 'e164b879bcf6452dbd397a835ff93243');
INSERT INTO `knowledge` VALUES ('f71863bc33074a018f1d6e644713dfa5', 'MF86683708', '2', 6, 1, '函数的概念及分类', '49bb0e6bcdc94851b09c233f9bed998a');
INSERT INTO `knowledge` VALUES ('f780d7dea0f64a2395f17d3401791ea8', 'LT96785089', '2', 2, 5, '数组', '6f93b61aaa354729b3c38c1bf0930923');
INSERT INTO `knowledge` VALUES ('f89fc271411743afa41b1446fc28cd07', 'MF86683708', '2', 10, 3, '文件的读写', '5ab4a5384cd446bc9e55db84e8027184');
INSERT INTO `knowledge` VALUES ('fb30ff9355d04c3fb23492206e6fccd7', 'MF86683708', '2', 8, 4, '动态内存分配', 'd4043055130a4419becef25db6b75392');
INSERT INTO `knowledge` VALUES ('fc08ce9b340e455089f4b45172a1ded0', 'MF86683708', '2', 7, 6, '数组应用举例', '737a74a848cd47229b0f6ff707ce23e3');
INSERT INTO `knowledge` VALUES ('fd81402ff11a4118ad26a17b421f15bd', 'LT96785089', '2', 11, 1, 'URL 类', 'd59631a8c68642e39188a625e720be9a');
INSERT INTO `knowledge` VALUES ('fda0ff40f2114ec4bf594e26735363f2', 'LT96785089', '2', 13, 3, '网页向Java Applet 传值', 'ca47d0b0822d4768ae45c496b7c2d6fb');
INSERT INTO `knowledge` VALUES ('fddb24c140a943d481ff58c07c86951b', 'LT96785089', '2', 4, 15, '对象数组', '50aac289876940debf5dfc7cd0cdd76b');
INSERT INTO `knowledge` VALUES ('fe4b008154bd4cf9b0c495f87c18e28c', 'TT001', '2', 5, 5, '访问MongoDB数据库', '8abbc2de84f344d99be46ece2b2b364b');
INSERT INTO `knowledge` VALUES ('fe856214450b4c6eb478b81bc688f087', 'LT96785089', '2', 8, 11, '守护线程', 'c7a3d7fa1610430eae57acee4bcad9ea');
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `Id` varchar(32) NOT NULL,
  `cou_Id` varchar(32) DEFAULT NULL COMMENT '科目',
  `type_Id` varchar(32) DEFAULT NULL COMMENT '题目类型',
  `subject` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '题目',
  `choice_A` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_B` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_C` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `choice_D` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `answer` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `degree` varchar(255) DEFAULT NULL COMMENT '难度系数0.85，0.65，0.45，0.25',
  `kwl_Id` varchar(32) DEFAULT NULL COMMENT '所属知识点',
  `analysis` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '解析',
  PRIMARY KEY (`Id`),
  KEY `fk_question_course_1` (`cou_Id`),
  KEY `fk_question_question_type_1` (`type_Id`),
  KEY `fk_question_knowledge_1` (`kwl_Id`),
  CONSTRAINT `fk_question_course_1` FOREIGN KEY (`cou_Id`) REFERENCES `course` (`Id`),
  CONSTRAINT `fk_question_knowledge_1` FOREIGN KEY (`kwl_Id`) REFERENCES `knowledge` (`Id`),
  CONSTRAINT `fk_question_question_type_1` FOREIGN KEY (`type_Id`) REFERENCES `question_type` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库';

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('02011e9f1f84460487570aec3cb737ac', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>输入一个华氏温度，要求输出摄氏温度。公式为C=5/9(F-32),结果取两位小数。</p>', '-', '-', '-', '-', '<p>#include&quot;stdio.h&quot;</p><p>main( )</p><p>{ float&nbsp; c,f;</p><p>scanf(“%f”,&amp;f);</p><p>c=5.0/9*(f-32);</p><p>printf(“c=%.2f\\n”,c);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#include&quot;stdio.h&quot;</p><p>main( )</p><p>{ float&nbsp; c,f;</p><p>scanf(“%f”,&amp;f);</p><p>c=5.0/9*(f-32);</p><p>printf(“c=%.2f\\n”,c);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('03ac042bd6c34133860ffbdd6c0f939b', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>猜数游戏：程序随机生成的一个数，然后用户从键盘输入一个数与生成的随机数进行比较，每次比较有大小提示，直到猜对为止。</p>', '-', '-', '-', '-', '<p>main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; magic;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; guess;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; counter;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; magic = rand() % 100 + 1;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; counter = 0;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; do{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Please guess a magic number:&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; scanf(&quot;%d&quot;, &amp;guess);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; counter ++;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (guess &gt; magic)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Wrong! Too high!\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; else if (guess &lt; magic)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Wrong! Too low!\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }while (guess != magic);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Right!\\n&quot;);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;counter = %d \\n&quot;, counter);&nbsp;</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; magic;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; guess;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int&nbsp; counter;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; magic = rand() % 100 + 1;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; counter = 0;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; do{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Please guess a magic number:&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; scanf(&quot;%d&quot;, &amp;guess);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; counter ++;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (guess &gt; magic)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Wrong! Too high!\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; else if (guess &lt; magic)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Wrong! Too low!\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }while (guess != magic);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;Right!\\n&quot;);&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;counter = %d \\n&quot;, counter);&nbsp;</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('048832ac1e6f4c438d1dc5334ce314ee', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main()</p><p>{&nbsp;&nbsp; char c；</p><p>&nbsp;&nbsp;&nbsp;&nbsp;while((c=getchar())!=’?’)</p><p>&nbsp;&nbsp;putchar(c++)；}</p><p>当如下程序输入为：“abc?efg”时，程序运行结果：_______________________________</p><p><br/></p>', '-', '-', '-', '-', '<p>abc</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>abc</p>');
INSERT INTO `question` VALUES ('0d4871a304d043bd83f516ec2f86eeb4', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main()</p><p>{</p><p>int a=8,b=6,c=11；</p><p>&nbsp;if(a&gt;b)</p><p>&nbsp;b=a；</p><p>&nbsp;&nbsp;else</p><p>a=b；a=c；c=b；</p><p>&nbsp;printf(“a=%d,b=%d,c=%d\\n”,a,b,c)；}</p><p>程序运行结果：_______________________________</p><p><br/></p>', '-', '-', '-', '-', '<p>a=11,b=8,c=8</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>a=11,b=8,c=8</p>');
INSERT INTO `question` VALUES ('13f557cd572e49099c496e938f9610a5', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main()</p><p>{ char c1,c2;</p><p>&nbsp; c1=‘a’;c2=‘b’;</p><p>&nbsp; c1=c1-32;c2=c2-32;</p><p>&nbsp; printf(“%c,%c,%d,%d”,c1,c2,c1,c2);</p><p>}</p><p>&nbsp;</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p>', '-', '-', '-', '-', '<p>A,B,65,66</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A,B,65,66</p>');
INSERT INTO `question` VALUES ('17c126e85f4d44f79b9d657e935f1b5c', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>在C语言中运算对象必须是整型的运算符是（）。</p>', '<p>%</p>', '<p>/</p>', '<p>&nbsp;= =</p>', '<p>&lt;=</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('18b3059671ba4ac8b2291c8ee248e9ea', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>设X、Y和Z均为int型变量，则以下语句：Z=X；X=Y；Y=Z；的功能是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>交换</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>交换</p>');
INSERT INTO `question` VALUES ('1d45092b3de6405291c37749009899f6', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>输入两个实数，按由大到小的顺序输出这两个数。</p>', '-', '-', '-', '-', '<p>#include “stdio.h”</p><p>main()</p><p>{&nbsp; int a,b,t;</p><p>&nbsp;&nbsp; scanf(“%d,%d”,&amp;a,&amp;b);</p><p>if(a&lt;b)</p><p>{t=a;a=b;b=t;}</p><p>printf(“%d,%d\\n”,a,b);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#include “stdio.h”</p><p>main()</p><p>{&nbsp; int a,b,t;</p><p>&nbsp;&nbsp; scanf(“%d,%d”,&amp;a,&amp;b);</p><p>if(a&lt;b)</p><p>{t=a;a=b;b=t;}</p><p>printf(“%d,%d\\n”,a,b);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('256af77ebc424241a14c274af99921fe', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main( )</p><p>{ &nbsp;int i,a[10];</p><p>&nbsp; &nbsp;for(i=0;i&lt;=9;i++)</p><p>&nbsp;&nbsp;&nbsp;a[i]=i;</p><p>&nbsp; &nbsp;for(i=9;i&gt;=0;i--)</p><p>&nbsp;&nbsp;&nbsp;printf(“%d”,a[i]);</p><p>&nbsp;&nbsp;&nbsp;pritnf(“\\n”);</p><p>}</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>', '-', '-', '-', '-', '<p>9,8,7,6,5,4,3,2,1,0</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>9,8,7,6,5,4,3,2,1,0</p>');
INSERT INTO `question` VALUES ('29a0bea789af48ceb396f4e9cd66643b', 'SF14864420', 'a3514b0394a940cea19d5e1ef74b041f', '<p>什么是软件测试？<span style=\"font-size: 16px;\"></span><br/></p>', '-', '-', '-', '-', '<p>软件测试是验证和确认。</p>', '0.6', 'a3c5db1293b041089d9ea6e5c71642d0', '<p><span style=\"font-size: 24px;\">铭记验证和确认！！！</span></p>');
INSERT INTO `question` VALUES ('2cb904d8a02d443b98d5e86d64aae6a1', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C语言中，逻辑运算包括：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>与、或、非</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>与、或、非</p>');
INSERT INTO `question` VALUES ('30d01c9884bc43b59575dee825341c76', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>有如下程序，该程序的执行结果是（&nbsp;&nbsp;&nbsp; ）。</p><p>main()</p><p>{ &nbsp;int x=3;</p><p>do { printf(“%d”,x--);}while(!x);</p><p>}</p>', '<p>陷入死循环</p>', '<p>3</p>', '<p>32</p>', '<p>321</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('32ce6c01dc7e43e9a522d18417af8f2d', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下各组标识符中都为合法标识符的一组是（&nbsp;&nbsp;&nbsp; ）。</p>', '<p>int&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; xy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; hello!&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; bye</p>', '<p>Abc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; _china&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; Char</p>', '<p>&nbsp;hh&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 22&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; H_2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 2_H</p>', '<p>s-t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; sit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; s_t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; s*t</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('3468d3a3e3a54f9a86e4133725c9544e', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>从10个数中找出其中最大值和最小值，要求不改变元素的排列顺序。</p><p>int &nbsp;max, min; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>void &nbsp;max_min_value(int array[ ], int n)</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp; int *p, *array_end; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp; array_end = array + n; &nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp; max = min = *array; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp; for(p=array+1; p&lt;array_end; p++)&nbsp;&nbsp;</p><p>&nbsp;&nbsp; if (*p &gt; max)<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>;</p><p>&nbsp;&nbsp; else if (<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>) min = *p;</p><p>}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>main()</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;int i, number[10];</p><p>&nbsp;printf(&quot;enter 10 data\\n&quot;);</p><p>&nbsp;for(i=0;i&lt;10;i++)</p><p>&nbsp;scanf(&quot;%d&quot;,&amp;number[i]);</p><p>&nbsp;max_min_value(number,10);</p><p>&nbsp;printf(&quot;\\nmax=%d,min=%d\\n&quot;,max,min);</p><p>}</p><p><br/></p>', '-', '-', '-', '-', '<p>(1)max = *p</p><p>(2)*p &lt; min</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1)max = *p</p><p>(2)*p &lt; min</p>');
INSERT INTO `question` VALUES ('374268a4d1164aa1b60314ccf29fbdc5', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main( )</p><p>{&nbsp; int i,j,m,n;</p><p>&nbsp; &nbsp;&nbsp;i=7; j=9;</p><p>&nbsp; &nbsp;&nbsp;m=++i;</p><p>&nbsp; &nbsp;&nbsp;n=j++;</p><p>&nbsp; &nbsp;&nbsp;printf(“i=%d,j=%d,m=%d,n=%d”,i,j,m,n);</p><p>}</p><p>&nbsp;</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>', '-', '-', '-', '-', '<p>i=8,j=10,m=8,n=9</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>i=8,j=10,m=8,n=9</p>');
INSERT INTO `question` VALUES ('3ccebe0a1c22418d9d5e3769c0fe95b1', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>若a,b和c均是int型变量,则计算表达式 a=(b=4)+(c=2) 后，a值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>，b值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>，c值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>6、4、2</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>6、4、2</p>');
INSERT INTO `question` VALUES ('3d4bf1dd025f42318aa7dc8496414d30', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在printf函数格式字符中，只能输出一个字符的格式字符是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>、用于输出字符串的格式字符是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>&nbsp;%c、%s</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;%c、%s</p>');
INSERT INTO `question` VALUES ('3feb740f49644ea0b0ba70b142777707', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>编程实现输出下面的图形。（空白处均为一个空格）</p><table><tbody><tr class=\"firstRow\"><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td></tr><tr><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td></tr><tr><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td></tr><tr><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td></tr><tr><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\"><br/></td></tr><tr><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\" style=\"word-break: break-all;\">*</td><td width=\"180\" valign=\"top\"><br/></td><td width=\"180\" valign=\"top\"><br/></td></tr></tbody></table><p><br/></p>', '-', '-', '-', '-', '<p>main()</p><p>{int i,j,k;</p><p>clrscr();</p><p>for(i=0;i&lt;3;i++)</p><p>&nbsp; {&nbsp; for(j=0;j&lt;2-i;j++)</p><p>&nbsp; printf(&quot; &quot;);</p><p>&nbsp; for(k=0;k&lt;i+1;k++)</p><p>&nbsp; printf(&quot;*&quot;);</p><p>&nbsp; printf(&quot;\\n&quot;);&nbsp; }</p><p>for(i=0;i&lt;3;i++)</p><p>&nbsp; {&nbsp; printf(&quot;&nbsp; &quot;);</p><p>&nbsp; for(k=0;k&lt;3-i;k++)</p><p>&nbsp; printf(&quot;*&quot;);</p><p>&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp; }}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>main()</p><p>{int i,j,k;</p><p>clrscr();</p><p>for(i=0;i&lt;3;i++)</p><p>&nbsp; {&nbsp; for(j=0;j&lt;2-i;j++)</p><p>&nbsp; printf(&quot; &quot;);</p><p>&nbsp; for(k=0;k&lt;i+1;k++)</p><p>&nbsp; printf(&quot;*&quot;);</p><p>&nbsp; printf(&quot;\\n&quot;);&nbsp; }</p><p>for(i=0;i&lt;3;i++)</p><p>&nbsp; {&nbsp; printf(&quot;&nbsp; &quot;);</p><p>&nbsp; for(k=0;k&lt;3-i;k++)</p><p>&nbsp; printf(&quot;*&quot;);</p><p>&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp; }}</p><p><br/></p>');
INSERT INTO `question` VALUES ('44433163bea64538b9f7e4a74e479cc7', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>当执行完以下语句i=15；j=14；m=++i；n=j--；后，i=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>，j=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>，m=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> ，n=&nbsp;&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>16、13、16、14</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>16、13、16、14</p>');
INSERT INTO `question` VALUES ('4d109c56da204276b65a318f2edd3bdd', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>标识符和关键字间，要用 (&nbsp;&nbsp;&nbsp;&nbsp; ) 隔开。</p>', '<p>回车符</p>', '<p>冒号</p>', '<p>空格</p>', '<p>分号</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('500f2d56f7e04190a9618584c9520a71', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>能够判断字符变量c是大写字母的表达式是（ ）。</p>', '<p>c&gt;=’A’&amp;&amp;c&lt;=’Z’</p>', '<p>c&gt;=’A’||c&lt;=’Z’</p>', '<p>’A’&lt;=c&lt;=’Z’</p>', '<p>’A’&gt;=c&gt;=’Z’</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('51923e931f7f4c3eacb5d2a94a435365', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>执行完循环 for(i=1;i&lt;10;i++){}后，i 的值为（&nbsp; ）。</p>', '<p>9</p>', '<p>10</p>', '<p>11</p>', '<p>12</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('55b533ea1abb4474843678f536b46124', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>计算一组学生的平均成绩和不及格人数</p><p>struct student</p><p>{</p><p>&nbsp;&nbsp;&nbsp; int id;</p><p>&nbsp;&nbsp;&nbsp; char name[20];</p><p>&nbsp;&nbsp;&nbsp; char sex;</p><p>float score;</p><p>}stu1[5]=</p><p>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;{101,&quot;Li ping&quot;,&#39;M&#39;,45},</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;{102,&quot;Zhang ping&quot;,&#39;M&#39;,62.5},</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;{103,&quot;He fang&quot;,&#39;F&#39;,92.5},</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;{104,&quot;Cheng ling&quot;,&#39;F&#39;,87},</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;{105,&quot;Wang ming&quot;,&#39;M&#39;,58},</p><p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;};</p><p>main( )</p><p>{</p><p>&nbsp;&nbsp; struct student *ps;</p><p>&nbsp;&nbsp; void ave(struct student *ps);</p><p>&nbsp;&nbsp; ps= stu1;</p><p>&nbsp;&nbsp; ave(<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp; &nbsp;&nbsp;&nbsp;</span>);</p><p>}</p><p>void ave(struct student *ps)</p><p>{</p><p>&nbsp;&nbsp; int c=0,i;</p><p>&nbsp;&nbsp; float ave,s=0;</p><p>&nbsp;&nbsp; for(i=0;i&lt;5;i++,<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; (2) &nbsp;&nbsp;&nbsp;&nbsp;</span>)</p><p>&nbsp; &nbsp;&nbsp;{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; s+=ps-&gt;score;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (3)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>) c+=1;</p><p>&nbsp; &nbsp;&nbsp;&nbsp;}</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;s=%f\\n&quot;,s);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ave=s/5;</p><p>&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;average=%f\\ncount=%d\\n&quot;,ave,c);</p><p>}</p>', '-', '-', '-', '-', '<p>(1)ps</p><p>(2)ps++&nbsp;</p><p>(3) ps-&gt;score&lt;60</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1)ps</p><p>(2)ps++&nbsp;</p><p>(3) ps-&gt;score&lt;60</p>');
INSERT INTO `question` VALUES ('596ff02913414a899b81250681e13c3a', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>函数由&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>和<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>构成。</p><p><br/></p>', '-', '-', '-', '-', '<p>&nbsp;函数首部、函数体</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;函数首部、函数体</p>');
INSERT INTO `question` VALUES ('5a4e8cf7c5ff431f8b9f5d546c97366a', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>复合语句是由一对_______括起来的若干语句的组合,其在语法上与一个<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>相同。</p>', '-', '-', '-', '-', '<p>{}、语句</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>{}、语句</p>');
INSERT INTO `question` VALUES ('5aa1961c968441e7b0e6bf3bd63d4185', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>若x为int型变量x=6，则执行以下语句后， x+=x-=x*x;的值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>-12</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>-12</p>');
INSERT INTO `question` VALUES ('5d49bc5b85ff49f5a2ad753ab3410041', 'LT96785089', '1996a697e26a4453a80900a82c1df699', '<p style=\"white-space: normal;\">现在有一个MYSQL数据库hd，在该数据库中有一个数据表为student，表的结构如下图所示，请按如下要求完成程序设计。</p><p style=\"white-space: normal;\"><img src=\"http://localhost/api/images/e6869cb004df45c59243852c262d7b2c.png\" title=\"image\" alt=\"image\" width=\"205\" height=\"138\"/></p><p style=\"white-space: normal;\">（1）请写出实现查询student表中所有哈尔滨市成绩在70分以上的准考号以“1001”开头的学生信息的SQL语句。</p><p style=\"white-space: normal;\">（2）编写程序实现向student表中插入一条记录，所插入的记录信息如下图所示。</p><p style=\"white-space: normal;\"><img src=\"http://localhost/api/images/6a389a4cbd90467ca0e451834e56ada7.png\" title=\"image\" alt=\"image\"/></p><p><br/></p>', '-', '-', '-', '-', '<p>本试题暂无答案</p>', '0.30', '3eb814f8e59a44d19176005ca8806f10', '<p>本试题暂无解析</p>');
INSERT INTO `question` VALUES ('5de35adaee204ed99675bf59256fa71d', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在循环语句中，continue 的作用是结束本次循环，break的作用是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>跳出整个循环</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>跳出整个循环</p>');
INSERT INTO `question` VALUES ('5e31b0941d244bee833cdd16ff9a01bb', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>用函数计算球的体积，公式v=4/3πR<sup>2</sup>，要求计算多个球，半径分别为R=1,3,5,7…99。</p>', '-', '-', '-', '-', '<p>#define PI 3.14</p><p>float volume (int r)</p><p>{ &nbsp;float vo;</p><p>&nbsp;&nbsp; vo=4/3*PI*r*r*r;</p><p>&nbsp;&nbsp; return vo;</p><p>}</p><p>main()</p><p>{ &nbsp;int R;</p><p>float v;</p><p>for(R=1;R&lt;=99;R=R+2)</p><p>{</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;v=volume(R);</p><p>printf(&quot;v=%.2f\\n&quot;,v);</p><p>}</p><p>}</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#define PI 3.14</p><p>float volume (int r)</p><p>{ &nbsp;float vo;</p><p>&nbsp;&nbsp; vo=4/3*PI*r*r*r;</p><p>&nbsp;&nbsp; return vo;</p><p>}</p><p>main()</p><p>{ &nbsp;int R;</p><p>float v;</p><p>for(R=1;R&lt;=99;R=R+2)</p><p>{</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;v=volume(R);</p><p>printf(&quot;v=%.2f\\n&quot;,v);</p><p>}</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('6443dd660aff4f9ca9b373f44a8849ae', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下不正确的定义语句是（&nbsp; ）。</p>', '<p>double x[5]={2.0,4.0,6.0,8.0,10.0};</p>', '<p>int y[5]={0,1,3,5,7};</p>', '<p>char c1[]={‘1’,‘2’,‘3’,‘4’,‘5’};</p>', '<p>char c2[3]={‘\\x10’, ‘\\xa’, ‘\\x8’ ,‘\\x8’};</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('65ad6267eb4c4c20ae366b5e427886cf', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>以下程序段的功能是输出如下所示的九九乘法表，请将画线部分填充完整。</p><p>1*1= 1</p><p>1*2= 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2*2= 4</p><p>1*3= 3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2*3= 6&nbsp;&nbsp;&nbsp; 3*3= 9</p><p>……</p><p>1*9= 9&nbsp; 2*9=18&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3*9=27&nbsp; 4*9=36&nbsp;&nbsp; 5*9=45&nbsp;&nbsp; 6*9=54&nbsp;&nbsp; 7*9=63&nbsp;&nbsp; 8*9=72&nbsp;&nbsp; 9*9=81</p><p>void main()</p><p>{&nbsp;&nbsp; int i,j;</p><p>for(i=1; i&lt;=9 ; i++)</p><p>{</p><p>for(j=1;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>; j++&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; )</p><p>{</p><p>&nbsp; &nbsp; &nbsp;printf(“%d*%d=%2d”,<span style=\"text-decoration: underline;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>);</p><p>}</p><p>printf(“\\n”) ;</p><p>}&nbsp;</p><p>}</p><p><br/></p>', '-', '-', '-', '-', '<p>(1) j&lt;=i&nbsp;</p><p>(2) i,j,i*j</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1) j&lt;=i&nbsp;</p><p>(2) i,j,i*j</p>');
INSERT INTO `question` VALUES ('67688cc2eefc43a9a6adc6ca62641c88', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>下列为字符常量的是（ ）。</p>', '<p>“a”</p>', '<p>‘ab’</p>', '<p>&nbsp;‘\\n’</p>', '<p>‘\\084’</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('680cbeddc93f4818aaae2189c969667f', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>设有如下程序段，若要求输出c1=M,c2=N ,则正确的输入是（&nbsp;&nbsp;&nbsp; ）。</p><p>char c1,c2;</p><p>scanf(“%c%c”,&amp;c1,&amp;c2);</p><p>printf(“c1=%c,c2=%c\\n”,c1,c2);</p><p><br/></p>', '<p>MN</p>', '<p>M&lt;回车&gt;N</p>', '<p>M&lt;空格&gt;N</p>', '<p>M&lt;Tab&gt;N</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('683013bdb26644c5b7b22a8ae91b9b16', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>从变量值的生存期角度来分，变量可以分为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>和<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>静态、动态</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>静态、动态</p>');
INSERT INTO `question` VALUES ('6ae3a93487944dcd918747d7c8d79fd0', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在C程序运行过程中，值可以被改变的量叫<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span>&nbsp;，在作用域内值不可以被改变的量叫<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>变量、常量</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>变量、常量</p>');
INSERT INTO `question` VALUES ('6b2fd7727cc24b2bb3d0a1d21ab41dff', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>下列各语句序列中，能够且仅输出整型变量a、b 中最小值的是(&nbsp;&nbsp; )。</p>', '<p>if(a&lt;b) printf(&quot;%d\\n&quot;,a); printf(&quot;%d\\n&quot;,b);</p>', '<p>if(a&lt;b) printf(&quot;%d\\n&quot;,a); else printf(&quot;%d\\n&quot;,b);</p>', '<p>if(a&gt;b) printf(&quot;%d\\n&quot;,a); printf(&quot;%d\\n&quot;,b);</p>', '<p>if(a&gt;b) printf(&quot;%d\\n&quot;,a); else printf(&quot;%d\\n&quot;,b);</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('6c4b1a2f70f04a8fb1e676be0c74d1ec', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在c语言程序中，每一个声明、每个语句都必须以<span style=\"text-decoration: underline;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>结尾。</p>', '-', '-', '-', '-', '<p>分号（或；）</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>本题暂无解析</p>');
INSERT INTO `question` VALUES ('6d2cf3d5248741c6b39a3739797d92d2', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>设a=0,b=2,c=3,则表达式a+=b*3/c计算的结果是（&nbsp;&nbsp;&nbsp; ）。</p>', '<p>6</p>', '<p>4</p>', '<p>2</p>', '<p>0</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('7acc88a5d7034669a018cf0a4d3c9a3d', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>C 语言中，有关函数的说法，以下正确的是（ ）。</p>', '<p>函数可嵌套定义，也可嵌套调用</p>', '<p>函数可嵌套定义，但不可嵌套调用</p>', '<p>函数不可嵌套定义，但可嵌套调用</p>', '<p>函数不可嵌套定义，也不可嵌套调用</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('7aec4e1656e04185853dd1e3a17b6ae5', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>下面程序的输出结果是（ ）。</p><p>main（）</p><p>{ int i=10；</p><p>&nbsp;switch（i）</p><p>{<br/>case 9：i+=1；</p><p>&nbsp;case 10：i+=1；</p><p>&nbsp;case 11：i+=1；</p><p>&nbsp;case 12：i+=1；</p><p>&nbsp;}</p><p>printf（“i=%d\\n”，i）；</p><p>&nbsp;}</p>', '<p>10</p>', '<p>11</p>', '<p>12</p>', '<p>13</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('7eb66638b4f343f0b5458d0aef2c8a1a', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>复合语句中定义的变量的作用范围是（&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ）</p>', '<p>整个源文件</p>', '<p>整个函数</p>', '<p>整个程序</p>', '<p>所定义的复合语句</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('8a41740878f144cb92bee6b14e82f9e1', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>已知int&nbsp;a=3,b=4,c=5；则表达式a&gt;b&amp;&amp;!c||1的值为_______。</p>', '-', '-', '-', '-', '<p>1</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>1</p>');
INSERT INTO `question` VALUES ('8dc1b69e938b43f886addce0969a0f61', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>输入10个正整数，用“起泡法”对它们排序（由小到大）。</p>', '-', '-', '-', '-', '<p>&nbsp;main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a[11];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int i,j,t;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;input 10 numbers:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;11;i++)</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scanf(&quot;%d&quot;,&amp;a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=1;j&lt;=9;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;=10-j; i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (a[i] &gt; a[i+1])</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; { t = a[i]; a[i] = a[i+1]; a[i+1] = t; }</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;the sorted numbers:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;11;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a[11];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int i,j,t;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;input 10 numbers:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;11;i++)</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scanf(&quot;%d&quot;,&amp;a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=1;j&lt;=9;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;=10-j; i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (a[i] &gt; a[i+1])</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; { t = a[i]; a[i] = a[i+1]; a[i+1] = t; }</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;the sorted numbers:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=1;i&lt;11;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('8ede901319a64ba295ef83e4eb6e53c4', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C程序是由<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>构成的，C程序的执行是从&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>开始的。</p>', '-', '-', '-', '-', '<p>函数 、主函数</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>函数 、主函数</p>');
INSERT INTO `question` VALUES ('8f21e93fc532463fa275ae4708cc6b02', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下对 C语言函数调用时实参与形参的值传递有关描述中，正确的是（&nbsp;&nbsp; ）。</p>', '<p>值的传递与对应位置有关，与变量名无关</p>', '<p>值的传递与对应位置无关，与变量名有关</p>', '<p>值的传递与对应位置有关，也与变量名有关</p>', '<p>无法传递</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('91014a7531c345208dd18981b36f4299', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在C语言中规定：标识符只能由字母、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>和下划线三种字符组成。</p>', '-', '-', '-', '-', '<p>数字</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>数字</p>');
INSERT INTO `question` VALUES ('915710ff17dd4f8592fd372145083d55', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>求1~100的和。</p>', '-', '-', '-', '-', '<p>#include &quot;stdio.h&quot;</p><p>main()</p><p>{int i,s=0;</p><p>clrscr();</p><p>for(i=1;i&lt;=100;i++)</p><p>s+=i;</p><p>printf(&quot;s=%d&quot;,s);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#include &quot;stdio.h&quot;</p><p>main()</p><p>{int i,s=0;</p><p>clrscr();</p><p>for(i=1;i&lt;=100;i++)</p><p>s+=i;</p><p>printf(&quot;s=%d&quot;,s);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('966316fdd2c84c1eb7d8e8abc0d415c5', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>下列说法中错误的是 (&nbsp;&nbsp; )。</p>', '<p>程序可以从任何非主函数开始执行</p>', '<p>主函数可以调用任何非主函数的其他函数</p>', '<p>任何非主函数可以调用其他任何非主函数</p>', '<p>函数可以分为两个部分：函数说明部分和函数体</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('97ad0649d29b4ecf94b24cb567d4797e', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>有30个人，其中有男人、女人和小孩，在一家饭馆里吃饭共花了50先令，每个男人各花3先令，每个女人各花2先令，每个小孩各花1先令，问男人、女人和小孩各有几人？</p>', '-', '-', '-', '-', '<p>&nbsp;main()</p><p>{</p><p>&nbsp;&nbsp; int x,y,z;</p><p>&nbsp;&nbsp; printf(&quot;Man \\t Women \\t Childern\\n&quot;);</p><p>&nbsp;&nbsp; for (x=0; x&lt;=16; x++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for (y=0; y&lt;=25; y++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; z = 30 – x - y;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (3*x+2*y+z == 50)&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%3d \\t %5d \\t %8d\\n&quot;,x,y,z);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;main()</p><p>{</p><p>&nbsp;&nbsp; int x,y,z;</p><p>&nbsp;&nbsp; printf(&quot;Man \\t Women \\t Childern\\n&quot;);</p><p>&nbsp;&nbsp; for (x=0; x&lt;=16; x++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for (y=0; y&lt;=25; y++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; z = 30 – x - y;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (3*x+2*y+z == 50)&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%3d \\t %5d \\t %8d\\n&quot;,x,y,z);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('9866136b73a4415bb64629b076592dc2', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>编程求一维数组元素中的最大值。</p>', '-', '-', '-', '-', '<p>main()</p><p>{</p><p>&nbsp; int a[10],i,max=0;</p><p>&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp; {</p><p>scanf(“%d”,&amp;a[i]);</p><p>if(a[i]&gt;max) max=a[i];</p><p>&nbsp; }</p><p>&nbsp; printf(“Max is %d\\n”,max);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>main()</p><p>{</p><p>&nbsp; int a[10],i,max=0;</p><p>&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp; {</p><p>scanf(“%d”,&amp;a[i]);</p><p>if(a[i]&gt;max) max=a[i];</p><p>&nbsp; }</p><p>&nbsp; printf(“Max is %d\\n”,max);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('995cfeddcafb45ffa6508ee4ca4aed96', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下选项中不是常量的是（&nbsp;&nbsp;&nbsp; ）。</p>', '<p>15</p>', '<p>0xff</p>', '<p>‘\\t’</p>', '<p>x</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('9abf9f5e04894fdfac2a69776a2ad4dd', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>为表示关系x&gt;=y&gt;=z,应用C语言表达式<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>（x&gt;=y）&amp;&amp;(y&lt;=z)</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>（x&gt;=y）&amp;&amp;(y&lt;=z)</p>');
INSERT INTO `question` VALUES ('9c63c4486c1b4f84989a02f97032d00f', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main( )</p><p>{</p><p>int x;</p><p>&nbsp; &nbsp;&nbsp;for(x=3;x&lt;6;x++)</p><p>&nbsp; &nbsp;&nbsp;{</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;printf ((x%2) ? “**%d” : “##%d\\n”, x );</p><p>}</p><p>}</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>', '-', '-', '-', '-', '<p>**3##4</p><p>&nbsp; **5</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>**3##4</p><p>&nbsp; **5</p><p><br/></p>');
INSERT INTO `question` VALUES ('9d6a2d86d4fb4ea7a07532926550f35c', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>设int x=17,y=5；&nbsp;执行语句x*=x++/--y后x的值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>。</p>', '-', '-', '-', '-', '<p>69</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>69</p>');
INSERT INTO `question` VALUES ('9f0f5ddf0a8c4435beb5b37b17b44d68', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>feof(fp)函数用来判断文件是否结束，如果遇到文件结束，函数值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>， 否则为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>非0值、0</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>非0值、0</p>');
INSERT INTO `question` VALUES ('a2b883c9ba9440dd95b2f40cea4e51cf', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>编程求3~100之间的所有素数，按每行4列输出。</p>', '-', '-', '-', '-', '<p>main()</p><p>{</p><p>&nbsp;int i,m,k,j=0;</p><p>&nbsp;for(m=3;m&lt;=100;m++)</p><p>&nbsp; {k=0;</p><p>&nbsp;&nbsp; for(i=2;i&lt;=m-1;i++)</p><p>&nbsp;&nbsp;&nbsp; if(m%i==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; {k=1;break;}</p><p>&nbsp;&nbsp;&nbsp; if(k==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%3d&quot;,m);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; j=j+1;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(j%4==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp; }</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>main()</p><p>{</p><p>&nbsp;int i,m,k,j=0;</p><p>&nbsp;for(m=3;m&lt;=100;m++)</p><p>&nbsp; {k=0;</p><p>&nbsp;&nbsp; for(i=2;i&lt;=m-1;i++)</p><p>&nbsp;&nbsp;&nbsp; if(m%i==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; {k=1;break;}</p><p>&nbsp;&nbsp;&nbsp; if(k==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%3d&quot;,m);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; j=j+1;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(j%4==0)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp; }</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('a37fb8bc7b7f46bba337f6bd73c1e991', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>int swap(int *pt1, int *pt2)</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int p;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; p=*pt1;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *pt1=*pt2;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *pt2=p;</p><p>}</p><p>int exchange(int *q1, int *q2, int *q3)</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (*q1&lt;*q2) swap(q1,q2);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (*q1&lt;*q3) swap(q1,q3);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (*q2&lt;*q3) swap(q2,q3);</p><p>}</p><p>main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a,b,c, *p1, *p2, *p3;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; scanf(&quot;%d,%d,%d&quot;, &amp;a, &amp;b, &amp;c);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; p1 = &amp;a; p2 = &amp;b; p3 = &amp;c;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; exchange(p1,p2,p3);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n%d,%d,%d\\n&quot;, a,b,c);</p><p>}</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>', '-', '-', '-', '-', '<p>23,35,6</p><p>&nbsp;&nbsp; 6,35,23</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>23,35,6</p><p>&nbsp;&nbsp; 6,35,23</p><p><br/></p>');
INSERT INTO `question` VALUES ('a3dd5d50919c4edca6a5ea03626d5eb5', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C语言中没有逻辑量，在给出逻辑运算结果时，以<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>代表&quot;真&quot;，用<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>代表&quot;假&quot;。</p>', '-', '-', '-', '-', '<p>1、0</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>1、0</p>');
INSERT INTO `question` VALUES ('a4cddb50642b495fb5b4aed2f8998cff', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>若int x=2,y=3,z=4 则表达式x&lt;z?y:z的结果是(&nbsp;&nbsp;&nbsp;&nbsp; )</p>', '<p>3</p>', '<p>2</p>', '<p>1</p>', '<p>0</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('a60e45b5b28e493b9575d5cd3e0c8295', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>设x 和y均为 int 型变量，则执行下面的循环后，x的值为 (&nbsp;&nbsp;&nbsp;&nbsp; )。</p><p>for (y=1,x=1;y&lt;=20;y++)&nbsp;</p><p>{&nbsp; if (y&gt;5 ) break;</p><p>&nbsp;&nbsp; x+=3;</p><p>}</p>', '<p>1</p>', '<p>6</p>', '<p>16</p>', '<p>不确定</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('a6c56a898843495185cb44fc2902c6b8', 'SF14864420', 'b5046eea8c484ec8ab011da3a650a1e5', '<p>软件测试在软件开发的生命周期中是否必要？</p>', '-', '-', '-', '-', 'T', '0.30', '64570ff7b02941c594ad5707b67cd4a9', '<p>没啥好说的 ，看第一章。</p>');
INSERT INTO `question` VALUES ('a9aa9a4dd03a4a71b12617df7345e25d', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>在函数调用时，以下说法正确的是（&nbsp;&nbsp;&nbsp; &nbsp;）</p>', '<p>函数调用后必须带回返回值</p>', '<p>实际参数和形式参数可以同名</p>', '<p>函数间的数据传递不可以使用全局变量</p>', '<p>主调函数和被调函数总是在同一个文件里</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('acdce4655d4f4610a8b3a3dff9adddf2', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>设a=4，b=5，c=6。各逻辑表达式独立运算，f=a&gt;b&gt;c，f值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>；a||b+c&amp;&amp;b-c，逻辑值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>；!(a+b)+c-1&amp;&amp;b+c/2，逻辑值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>0、1、1</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>0、1、1</p>');
INSERT INTO `question` VALUES ('ae5398132f9a41fbaf508fa25e517a29', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C语言中，程序设计的三种基本结构为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p><p><br/></p>', '-', '-', '-', '-', '<p>顺序、选择、循环</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>顺序、选择、循环</p>');
INSERT INTO `question` VALUES ('b320642b967e445eaae14694c63aa5f6', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>编程实现根据自变量x的值，求得y值。</p><p>　&nbsp;&nbsp;&nbsp;&nbsp; 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; x&lt;2</p><p>&nbsp; y=&nbsp; &nbsp;0&nbsp;&nbsp;&nbsp;&nbsp; 2≤x&lt;7</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -1&nbsp;&nbsp;&nbsp;&nbsp; x≥7</p><p><br/></p>', '-', '-', '-', '-', '<p>#include&quot;stdio.h&quot;</p><p>main()</p><p>{float&nbsp; x,y;</p><p>scanf(“%f”,&amp;x);</p><p>if(x&lt;2) y=1;</p><p>else&nbsp; if(x&lt;7) y=0;</p><p>else&nbsp; y=-1;</p><p>printf(“x=%f,y=%f\\n”); }</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#include&quot;stdio.h&quot;</p><p>main()</p><p>{float&nbsp; x,y;</p><p>scanf(“%f”,&amp;x);</p><p>if(x&lt;2) y=1;</p><p>else&nbsp; if(x&lt;7) y=0;</p><p>else&nbsp; y=-1;</p><p>printf(“x=%f,y=%f\\n”); }</p><p><br/></p>');
INSERT INTO `question` VALUES ('b6749ae33abd4bfb80afb526a914cd06', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>设a=1,b=2,c=3,则表达式a+b&gt;c&amp;&amp;b==c计算的结果是（&nbsp;&nbsp; ）。</p>', '<p>3</p>', '<p>2</p>', '<p>1</p>', '<p>0</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('b9ea33480971440ca509ece2f81edf40', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>在二维数组a中选出各行最大的元素组成一个一维数组b。</p><p><img src=\"/api/images/444998d6420d4c4e9798826b8212b572.png\" title=\"截屏2021-04-24下午2\" alt=\"截屏2021-04-24下午2\"/></p>', '-', '-', '-', '-', '<p>main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp; &nbsp; int a[][4]={3,16,87,65,4,32,11,108,10,25,12,27};</p><p>&nbsp;&nbsp;&nbsp; &nbsp; int b[3],i,j,l;</p><p>&nbsp;&nbsp;&nbsp; &nbsp; for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp; &nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; l=a[i][0];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=1;j&lt;=3;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(a[i][j]&gt;l) l=a[i][j];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b[i]=l;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\narray a:\\n&quot;);</p><p>for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=0;j&lt;=3;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%5d&quot;,a[i][j]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\narray b:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp; &nbsp; for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; printf(&quot;%5d&quot;,b[i]);</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\n&quot;);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>main()</p><p>{</p><p>&nbsp;&nbsp;&nbsp; &nbsp; int a[][4]={3,16,87,65,4,32,11,108,10,25,12,27};</p><p>&nbsp;&nbsp;&nbsp; &nbsp; int b[3],i,j,l;</p><p>&nbsp;&nbsp;&nbsp; &nbsp; for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp; &nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; l=a[i][0];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=1;j&lt;=3;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(a[i][j]&gt;l) l=a[i][j];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b[i]=l;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\narray a:\\n&quot;);</p><p>for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(j=0;j&lt;=3;j++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%5d&quot;,a[i][j]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\narray b:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp; &nbsp; for(i=0;i&lt;=2;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; printf(&quot;%5d&quot;,b[i]);</p><p>&nbsp;&nbsp;&nbsp; &nbsp; printf(&quot;\\n&quot;);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('bb492882a41f4e82bd170c551fea226e', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>设变量定义为&quot;int x=3， *p=&amp;x;&quot;，设变量x的地址为2000，则*p=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;</span> ，&amp;(*p)=<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>(填数字)。</p>', '-', '-', '-', '-', '<p>3、2000</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>3、2000</p>');
INSERT INTO `question` VALUES ('bf29d167d8e449f1860ce38c1e572d2b', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>已知x=2.4,y=5.1,a=4,则表达式x+a%3*(int)(x+y)%5/3的值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>3.400000</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>3.400000</p>');
INSERT INTO `question` VALUES ('c17df732130842f6864caef5c7d48878', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>下列运算符中优先级最高的是（&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ）</p>', '<p>&lt;</p>', '<p>+</p>', '<p>&amp;&amp;</p>', '<p>!=</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('c4036ce65dee432682bb9f1278b7eeec', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p style=\"text-align: left;\">用函数编程计算：</p><p style=\"text-align: left;\"><img src=\"http://localhost/api/images/9dbcaf18746845a985aed543ef8b7621.png\" title=\"截屏2021-04-24下午1\" alt=\"截屏2021-04-24下午1\"/><br/></p>', '-', '-', '-', '-', '<p>float fac(int k)</p><p>{float t=1;int i;</p><p>&nbsp;for(i=2;i&lt;=k;i++)</p><p>&nbsp; t=t*i;</p><p>&nbsp;&nbsp; return t;</p><p>}</p><p>main()</p><p>{float c;</p><p>int m,n;</p><p>scanf(“%d%d”,&amp;m,&amp;n);</p><p>c=fac(n)/(fac(m)*fac(n-m));</p><p>printf(“%.2f\\n”,c);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>float fac(int k)</p><p>{float t=1;int i;</p><p>&nbsp;for(i=2;i&lt;=k;i++)</p><p>&nbsp; t=t*i;</p><p>&nbsp;&nbsp; return t;</p><p>}</p><p>main()</p><p>{float c;</p><p>int m,n;</p><p>scanf(“%d%d”,&amp;m,&amp;n);</p><p>c=fac(n)/(fac(m)*fac(n-m));</p><p>printf(“%.2f\\n”,c);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('c467b4f15e6c4c5f97f3375ecb28fd87', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>打印出所有“水仙花数”。</p><p>main( )</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; { int a, b, c ,n ;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(“水仙花数是：”) ；</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(n=100 ; n&lt;1000 ;n++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; a=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (2) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c=&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (3) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(a*100+b*10+c==a*a*a+b*b*b+c*c*c)</p><p>&nbsp; &nbsp; printf(“%5d” , n) ;</p><p>&nbsp; &nbsp; }</p><p>}</p>', '-', '-', '-', '-', '<p>(1)&nbsp;&nbsp; n/100</p><p>(2)&nbsp;&nbsp; n/10-a*10</p><p>(3)&nbsp;&nbsp; n%10</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1)&nbsp;&nbsp; n/100</p><p>(2)&nbsp;&nbsp; n/10-a*10</p><p>(3)&nbsp;&nbsp; n%10</p><p><br/></p>');
INSERT INTO `question` VALUES ('c5215d15e2bd4cbe9e1808f18e36c162', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C语言源程序文件的后缀是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>，经过编译后，生成文件的后缀是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>，经过连接后，生成文件的后缀是______。</p>', '-', '-', '-', '-', '<p>&nbsp;.c、.obj、.exe</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;.c、.obj、.exe</p>');
INSERT INTO `question` VALUES ('c5da979cd0c74f8c980e01b8a4fde21f', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>输入一组学生成绩，统计出及格和不及格额人数。当输入成绩为-1时结束输入。根据程序的功能，在横线处填写正确的语句和表达式，使程序完整。</p><p>main()</p><p>{</p><p>int grade,n1,n2;</p><p>n1=n2= 0;</p><p>printf(&quot;输入一组学生成绩：\\n&quot;);</p><p>&nbsp; scanf(&quot;%d&quot;,&amp;grade);</p><p>while(<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>)</p><p>{ if ( grade &gt;= 60) n1++;</p><p>else<span style=\"text-decoration: underline;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>;</p><p>scanf(&quot;%d&quot;,&amp;grade);</p><p>}</p><p>printf (“及格人数为：%d\\n不及格人数为：%d&quot;,n1,n2);</p><p>}</p><p><br/></p>', '-', '-', '-', '-', '<p>(1)&nbsp; grade != -1;</p><p>(2) n2++ ;&nbsp;</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1)&nbsp; grade != -1;</p><p>(2) n2++ ;&nbsp;</p>');
INSERT INTO `question` VALUES ('ca86753a846747a78ec615c7e9c75564', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>在循环语句中，break作用是结束整个循环，continue作用是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>结束本次循环</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>结束本次循环</p>');
INSERT INTO `question` VALUES ('dbbfd11e623348708970a74a12e0b27a', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下初始化操作正确的是（&nbsp;&nbsp;&nbsp; ）。</p>', '<p>int a=b=5;</p>', '<p>char c=“a”;&nbsp; &nbsp;&nbsp;</p>', '<p>float b[]={1.1};</p>', '<p>int *p=5;</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('e0f29dfde36947ebad5fd9e59f66dffc', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>指针是变量的<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>；整型属于基本数据类型，结构体属于<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>数据类型。</p>', '-', '-', '-', '-', '<p>地址、构造&nbsp;</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>地址、构造&nbsp;</p>');
INSERT INTO `question` VALUES ('e4e32ba78ec7466180747300da45f55c', 'MF86683708', 'fd09a3873f184169b4fd335934078123', '<p>把一个整数按大小顺序插入已排好序的数组中</p><p>main()</p><p>{&nbsp; int i,j,p,q,s,n,a[11]={127,3,6,28,54,68,87,105,162,18};</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {&nbsp; p=i;q=a[i];</p><p>for(j=i+1;j&lt;10;j++)</p><p>if(<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>)</p><p>{ p=j;</p><p>&nbsp; q=a[j];</p><p>}</p><p>if(&nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>)</p><p>{&nbsp; s=a[i];</p><p>&nbsp; &nbsp;a[i]=a[p];</p><p>&nbsp; &nbsp;a[p]=s;}</p><p>&nbsp; &nbsp;printf(&quot;%d&quot;,a[i]);</p><p>}</p><p>printf(&quot;\\ninput number:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;scanf(&quot;%d&quot;,&amp;n);</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;if(n&gt;a[i])</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(s=9;s&gt;=i;s--)</p><p><span style=\"text-decoration: none;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span style=\"text-decoration: none;\">&nbsp;</span><span style=\"text-decoration: none;\"> &nbsp; &nbsp;</span><span style=\"text-decoration: underline;\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; (3)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; break;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;a[i]=n;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;=10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;printf(&quot;%d&quot;,a[i]);</p><p>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;printf(&quot;\\n&quot;);</p><p>}</p>', '-', '-', '-', '-', '<p>(1)q&lt;a[j]</p><p>(2)p!=i&nbsp;</p><p>(3) a[s+1]=a[s]&nbsp; &nbsp;&nbsp;</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>(1)q&lt;a[j]</p><p>(2)p!=i&nbsp;</p><p>(3) a[s+1]=a[s]</p>');
INSERT INTO `question` VALUES ('e591d427c0a34330a24a1345af29ebd7', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>写出下面表达式运算后的值，设原来a=12。设a已定义为整形变量。各表达式独立运算。a+=a的值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>；a*=2+3的值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span>；a-=2的值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>&nbsp;；a/=a+a的值为：<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>&nbsp;。</p>', '-', '-', '-', '-', '<p>24、60、10、0</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>24、60、10、0</p>');
INSERT INTO `question` VALUES ('e6063ecd0ed74086b10b1dd255541c0f', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>main()</p><p>{</p><p>&nbsp;&nbsp; int i=6,j=5,p,q;</p><p>&nbsp;&nbsp; p=(i++)+(i++)+(i++);</p><p>&nbsp;&nbsp; q=(++j)+(++j)+(++j);</p><p>&nbsp;&nbsp; printf(“p=%d,q=%d,i=%d,j=%d”,p,q,i,j);</p><p>}</p><p>程序运行结果：<span style=\"text-decoration: underline;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>', '-', '-', '-', '-', '<p>&nbsp;p=18，q=24，i=9，j=8</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;p=18，q=24，i=9，j=8</p>');
INSERT INTO `question` VALUES ('e7f340ab988e4faa96d888d8766b6112', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>语句printf(&quot;%c,%d&quot;,&#39;c&#39;, &#39;c&#39;)；的输出结果是（&nbsp;&nbsp; ）。</p>', '<p>c,c</p>', '<p>c,99</p>', '<p>99,c</p>', '<p>99,99</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('eb6bd395bd194e34b313aef4ca8eb606', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>用近似公式e=1+1/1!+1/2!+……1/n!求自然对数的底e的值，取n为10（n愈大愈接近e的真值），用一层循环实现程序。</p>', '-', '-', '-', '-', '<p>#include &quot;stdio.h&quot;</p><p>main()</p><p>{int n,i;</p><p>float e=1,p=1;</p><p>clrscr();</p><p>scanf(&quot;%d&quot;,&amp;n);</p><p>for(i=1;i&lt;=n;i++)</p><p>{p=p*i;</p><p>e=e+1/p;}</p><p>printf(&quot;%f&quot;,e);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>#include &quot;stdio.h&quot;</p><p>main()</p><p>{int n,i;</p><p>float e=1,p=1;</p><p>clrscr();</p><p>scanf(&quot;%d&quot;,&amp;n);</p><p>for(i=1;i&lt;=n;i++)</p><p>{p=p*i;</p><p>e=e+1/p;}</p><p>printf(&quot;%f&quot;,e);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('eba62589d6114984a3e773dad654c431', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>语句int i=3;k=(i++)+ (i++)+ (++i);则执行过后k,i的值是 (&nbsp; ) 。</p>', '<p>12,6</p>', '<p>12,5</p>', '<p>18,6</p>', '<p>15,5</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('ef38f36010bc4ed9b7a11be6a84c5961', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>用数组名作为函数的实参时，传递给形参的是（&nbsp;&nbsp;&nbsp; ）</p>', '<p>数组的首地址</p>', '<p>数组的第一个元素</p>', '<p>数组中的全部元素</p>', '<p>数组的元素个数</p>', 'A', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>A</p>');
INSERT INTO `question` VALUES ('f2e0f58f78cd4f67bf92cf32670c1c15', 'MF86683708', '1996a697e26a4453a80900a82c1df699', '<p>将数组a中n个元素按相反顺序存放。</p>', '-', '-', '-', '-', '<p>void inv(inta[],intn)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; intt,i,j,m=(n-1)/2;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;=m;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; j=n-1-i;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; t=a[i];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a[i]=a[j];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a[j]=t;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>}</p><p>main()</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; static int i,a[10]={3,7,9,1,0,6,7,5,4,2};</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;theoriginalarray:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;inv(a,10);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;thearrayhasbeeninverted:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>}</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>void inv(inta[],intn)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; intt,i,j,m=(n-1)/2;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;=m;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; j=n-1-i;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; t=a[i];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a[i]=a[j];</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a[j]=t;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p><p>}</p><p>main()</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; static int i,a[10]={3,7,9,1,0,6,7,5,4,2};</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;theoriginalarray:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;inv(a,10);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;thearrayhasbeeninverted:\\n&quot;);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(i=0;i&lt;10;i++)</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d&quot;,a[i]);</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;\\n&quot;);</p><p>}</p><p><br/></p>');
INSERT INTO `question` VALUES ('f30f29497bc345c6914a38fb4a615e78', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>若x和n均是int型变量，且x和n的初值均为5，则计算表达式 x+=n++后x的值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>，n的值为<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>10、6</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>10、6</p>');
INSERT INTO `question` VALUES ('f3c166de8c3041fb8547fe542611ae47', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>设int类型的数据长度为2字节，则int类型数据的取值范围是（ ）。</p>', '<p>0～255</p>', '<p>-32768～32767</p>', '<p>-256～255</p>', '<p>0～65535</p>', 'B', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>B</p>');
INSERT INTO `question` VALUES ('f3d7622c60e84a11b9de0c6ce5e9ebf8', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>能正确表示逻辑关系：“a≥10或a≤0”的C语言表达式是（&nbsp;&nbsp;&nbsp; ）。</p>', '<p>a&gt;=10 or a&lt;=0</p>', '<p>a&gt;=0|a&lt;=10</p>', '<p>a&gt;=10 &amp;&amp;a&lt;=0</p>', '<p>a&gt;=10‖a&lt;=0</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('f6dc1b2652dc4af8958513412103f17b', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>123</p>', '-', '-', '-', '-', '<p>123</p>', '0.75', 'eeb5d1bc31d849b7883bd312b3df4870', '<p>123</p>');
INSERT INTO `question` VALUES ('f71cf31f4ff34e7c8b2ecdaead700f39', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>C语言的基本数据类型分别为 &nbsp;<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>、<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 、和枚举类型。</p>', '-', '-', '-', '-', '<p>整型、实型（浮点型）、字符型</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>整型、实型（浮点型）、字符型</p>');
INSERT INTO `question` VALUES ('f7ac89abd02d420f8950e02dfb5fce2a', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下数组定义不正确的是（&nbsp;&nbsp;&nbsp;&nbsp; ）。</p>', '<p>int a[2][3];</p>', '<p>int b[][3]={1,2,3,4};</p>', '<p>int c[10][10]={0};</p>', '<p>int d[3][]={{1,2},{1,2,3},{1,2,4,5}};</p>', 'D', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>D</p>');
INSERT INTO `question` VALUES ('f82bd062ae1540388f93ea774de5f4e5', 'MF86683708', '9d1ec85c8fdd40ba8b4cc733d4d72581', '<p>设有语句“int a=3;”,执行语句“printf(“%d”,a++);”后，输出结果是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>，变量a的值是<span style=\"text-decoration: underline;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>。</p>', '-', '-', '-', '-', '<p>3、4</p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>3、4</p>');
INSERT INTO `question` VALUES ('f96e28553a834be3be5498fb76846aaa', 'LT96785089', '1f45bd0005c541b998731546b3b8909a', '<p>A</p>', '<p>A</p>', '<p>B</p>', '<p>C</p>', '<p>D</p>', 'A', '0.30', '544bffced9914e21873e35b1b4e398ec', '<p>ABCD</p>');
INSERT INTO `question` VALUES ('fbfb6b2674a54b42ae6f694069ba01c7', 'MF86683708', '1f45bd0005c541b998731546b3b8909a', '<p>以下说法中正确的是（ ）。</p>', '<p>C语言程序总是从第一个函数开始执行</p>', '<p>C语言程序中，要调用的函数必须在main()函数中定义</p>', '<p>C语言程序总是从main( )函数开始执行</p>', '<p>C语言程序中的main( )函数必须放在程序的开始部分</p>', 'C', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>C</p>');
INSERT INTO `question` VALUES ('fd59ea5c2ed04f41aaa0c1748a665687', 'MF86683708', 'a3514b0394a940cea19d5e1ef74b041f', '<p>&nbsp;main()</p><p>{&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;&nbsp; int a,b;</p><p>&nbsp;&nbsp; int *pointer_1, *pointer_2;</p><p>a = 20; b = 200;</p><p>&nbsp;&nbsp; pointer_1 = &amp;a;</p><p>&nbsp;&nbsp; pointer_2 = &amp;b;</p><p>printf(&quot;%d,%d\\n&quot;,a,b);</p><p>&nbsp;&nbsp; printf(&quot;%d,%d\\n&quot;,*pointer_1,*pointer_2);</p><p>}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>程序运行结果：_______________________________</p>', '-', '-', '-', '-', '<p>&nbsp;20,200</p><p>&nbsp; 20,200</p><p><br/></p>', '0.9', '7dfe952b59894e058827358b5a142e4c', '<p>&nbsp;20,200</p><p>&nbsp; 20,200</p><p><br/></p>');
COMMIT;

-- ----------------------------
-- Table structure for question_collection
-- ----------------------------
DROP TABLE IF EXISTS `question_collection`;
CREATE TABLE `question_collection` (
  `id` varchar(32) NOT NULL,
  `user_Id` varchar(11) DEFAULT NULL COMMENT '学号',
  `question_Id` varchar(32) DEFAULT NULL COMMENT '试题编号',
  PRIMARY KEY (`id`),
  KEY `question_collection_ibfk_1` (`question_Id`),
  KEY `question_collection_ibfk_2` (`user_Id`),
  CONSTRAINT `question_collection_ibfk_1` FOREIGN KEY (`question_Id`) REFERENCES `question` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_collection_ibfk_2` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_collection
-- ----------------------------
BEGIN;
INSERT INTO `question_collection` VALUES ('247d3c8ab81e4de59817b0e145469842', '1180130101', '5d49bc5b85ff49f5a2ad753ab3410041');
INSERT INTO `question_collection` VALUES ('e41b5b957f43407980c5dbea54be4387', '1180130101', '17c126e85f4d44f79b9d657e935f1b5c');
COMMIT;

-- ----------------------------
-- Table structure for question_times
-- ----------------------------
DROP TABLE IF EXISTS `question_times`;
CREATE TABLE `question_times` (
  `question_Id` varchar(32) NOT NULL,
  `times` int(11) DEFAULT '0',
  PRIMARY KEY (`question_Id`),
  CONSTRAINT `question_times_ibfk_1` FOREIGN KEY (`question_Id`) REFERENCES `question` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_times
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `Id` varchar(32) NOT NULL,
  `type_Name` varchar(255) DEFAULT NULL COMMENT ' 题目类型名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目类型';

-- ----------------------------
-- Records of question_type
-- ----------------------------
BEGIN;
INSERT INTO `question_type` VALUES ('1996a697e26a4453a80900a82c1df699', '编程题');
INSERT INTO `question_type` VALUES ('1f45bd0005c541b998731546b3b8909a', '单选题');
INSERT INTO `question_type` VALUES ('3eb9b37cff394f3fa9a1a052e1685105', '名词解释');
INSERT INTO `question_type` VALUES ('9d1ec85c8fdd40ba8b4cc733d4d72581', '填空题');
INSERT INTO `question_type` VALUES ('a3514b0394a940cea19d5e1ef74b041f', '简答题');
INSERT INTO `question_type` VALUES ('b5046eea8c484ec8ab011da3a650a1e5', '判断题');
INSERT INTO `question_type` VALUES ('fd09a3873f184169b4fd335934078123', '程序填空');
COMMIT;

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `Id` varchar(32) NOT NULL,
  `spe_Name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `col_Id` varchar(32) DEFAULT NULL COMMENT '学院Id',
  PRIMARY KEY (`Id`),
  KEY `fk_specialty_college_1` (`col_Id`),
  CONSTRAINT `fk_specialty_college_1` FOREIGN KEY (`col_Id`) REFERENCES `college` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业';

-- ----------------------------
-- Records of specialty
-- ----------------------------
BEGIN;
INSERT INTO `specialty` VALUES ('03f39602d3734ec5b3013186090bad95', '国际经济与贸易', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('09b9ea4b517e4b359b0f77461d32a543', '土木工程', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('0fd82b0f96f748eba7500c93c94a9d47', '机器人工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('13ac3cb6785543f9a22690a33ffa2806', '环境设计', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('19b5da2e6c2340f6aa61a7a2aae95539', '材料成型与控制工程', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('2169e356cbc74af78207815ef5a0f1a8', '财务管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('27667d513ea44288ad9d5bfb70bca22a', '工程管理', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('3a94a30d0c2b44aaa62f6b0514f921ca', '车辆工程', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('3cf197e385704e65ab7bf55e5918e8fc', '人力资源管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('3d388d1aed544d319a1488677651c276', '智能制造工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('4534e357736b4836b214e88101d14250', '市场营销', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('518c6e0c4fdb419d882c7c7a91da1027', '英语', 'c34afcf78f214465ac039e99bb343cd9');
INSERT INTO `specialty` VALUES ('5225f30b772f43a7b6c563b935b7d936', '交通运输', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('6122800037604242be3dc38af7edd886', '工商管理', '2f25dc4bff3848129d5f4544f283bac3');
INSERT INTO `specialty` VALUES ('64d5b831e62d4b26abf3bd7eeb8e0083', '机械电子工程', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('699be5f8e1184ff69e8e3699456973af', '工业设计', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('6c250a73c72d45ad811bc7cd250e93e9', '自动化', '3cb8d052e08f43cda361595bee5bee77');
INSERT INTO `specialty` VALUES ('6c6c150715414f1abbe5b649a88e02c8', '机械设计制造及其自动化', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('7219d6469da2483c8e45593c6f6dce80', '建筑学', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('7b7519c5b88a4f6dbf717f56f9275196', '软件工程', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('7d918a6ef934497aba2489be2f2ad58a', '工程造价', 'db8e18fc61d943f6a8029d79f63dffef');
INSERT INTO `specialty` VALUES ('8f757c7f6f714cf79083f1d78d47ed18', '信息工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('9c6f95cd7e714389b762751d26e26824', '俄语', 'c34afcf78f214465ac039e99bb343cd9');
INSERT INTO `specialty` VALUES ('9eb4116974154261a1b0cbb63ac9f58e', '视觉传达设计', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('9f398d36c98146baa9a6200b64b35aaf', '广播电视编导', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('9f7a39fd7ecf4bc6a9b88d5bb2b542bb', '焊接技术与工程', 'cfa0cb4f01a045c89a048bb4c7d191a3');
INSERT INTO `specialty` VALUES ('aacc98e96d1a4118b59ea87d2f870428', '数字媒体艺术', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('b9d8b5e294a1464ea51b9793c944aa54', '动画', '033d5e75b2ba46628ad1472111d385cb');
INSERT INTO `specialty` VALUES ('c139109142b94af4bdbe1ee5cecf5de7', '汽车服务工程', '919d2ccfb6c24fa28ff3156e67a84ff4');
INSERT INTO `specialty` VALUES ('c3149e70342f41cf81971daecf630ab3', '电子信息工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('c9ab76be552a4fb38179a8f39f28094a', '信息管理与信息系统', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('cd4d595ffc4645c9bc0170704f698dc1', '计算机科学与技术', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('d3e4d49690d6406c89569618cbe7925d', '物联网科学与大数据技术', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('db8eb08297ba44bb8c19cf0d9227403e', '服装设计与工程', '03c722d5bcb84931913e00413ec8c284');
INSERT INTO `specialty` VALUES ('ec0d778bf76b4c038ec6f629464e0c89', '通信工程', '657b1f31c1c844e88e7c45ddd9ae9590');
INSERT INTO `specialty` VALUES ('f02f730c6fb642ed894f75b8c8d63c20', '大数据', '75d2a68ba28146e08414f1a6f9c3afef');
INSERT INTO `specialty` VALUES ('f822ccd2f2c64bed9b1342ef281d1709', '服装与服装设计', '03c722d5bcb84931913e00413ec8c284');
INSERT INTO `specialty` VALUES ('fa869406e4ca414ead05726fea7a9f9d', '电器工程及其自动化', '3cb8d052e08f43cda361595bee5bee77');
COMMIT;

-- ----------------------------
-- Table structure for student_basic
-- ----------------------------
DROP TABLE IF EXISTS `student_basic`;
CREATE TABLE `student_basic` (
  `user_Id` varchar(20) NOT NULL,
  `stu_ClassId` varchar(32) DEFAULT NULL COMMENT '所属班级',
  `stu_College` varchar(32) DEFAULT NULL COMMENT '所属学院',
  `stu_Specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`user_Id`),
  KEY `fk_student_basic_classes_1` (`stu_ClassId`),
  KEY `fk_student_basic_college_1` (`stu_College`),
  KEY `fk_student_basic_specialty_1` (`stu_Specialty`),
  CONSTRAINT `fk_student_basic_classes_1` FOREIGN KEY (`stu_ClassId`) REFERENCES `classes` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_college_1` FOREIGN KEY (`stu_College`) REFERENCES `college` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_specialty_1` FOREIGN KEY (`stu_Specialty`) REFERENCES `specialty` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_basic_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生基础信息';

-- ----------------------------
-- Records of student_basic
-- ----------------------------
BEGIN;
INSERT INTO `student_basic` VALUES ('1180130101', '935b36869b4e43de96741a044252fddd', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `student_basic` VALUES ('1180130102', 'bc022ffd7ecd4c50a021f10a471f9775', '033d5e75b2ba46628ad1472111d385cb', '13ac3cb6785543f9a22690a33ffa2806');
INSERT INTO `student_basic` VALUES ('1180130103', '935b36869b4e43de96741a044252fddd', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `student_basic` VALUES ('1180130116', '935b36869b4e43de96741a044252fddd', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for teacher_basic
-- ----------------------------
DROP TABLE IF EXISTS `teacher_basic`;
CREATE TABLE `teacher_basic` (
  `user_Id` varchar(20) NOT NULL,
  `college_Id` varchar(32) DEFAULT NULL COMMENT '所属学院',
  `specialty_Id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`user_Id`),
  KEY `fk_teacher_basic_college_1` (`college_Id`),
  KEY `fk_teacher_basic_specialty_1` (`specialty_Id`),
  CONSTRAINT `fk_teacher_basic_college_1` FOREIGN KEY (`college_Id`) REFERENCES `college` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_basic_specialty_1` FOREIGN KEY (`specialty_Id`) REFERENCES `specialty` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_basic_user_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师基础信息';

-- ----------------------------
-- Records of teacher_basic
-- ----------------------------
BEGIN;
INSERT INTO `teacher_basic` VALUES ('H011000', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011001', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011002', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011003', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011004', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011005', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011006', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
INSERT INTO `teacher_basic` VALUES ('H011052', '75d2a68ba28146e08414f1a6f9c3afef', '7b7519c5b88a4f6dbf717f56f9275196');
COMMIT;

-- ----------------------------
-- Table structure for test_ueditor
-- ----------------------------
DROP TABLE IF EXISTS `test_ueditor`;
CREATE TABLE `test_ueditor` (
  `Id` varchar(32) NOT NULL,
  `text` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_ueditor
-- ----------------------------
BEGIN;
INSERT INTO `test_ueditor` VALUES ('15aa0bd91e81405a8c0174e62775326d', '<p>123</p>');
INSERT INTO `test_ueditor` VALUES ('2e111ff8078e4934a8c2940b507ab143', '<p>Question:123</p><p><img src=\"/images/61f7adbcbb8c453ea6665ddc1982cdae.png\" title=\"坑1\" alt=\"坑1\"/></p><p>Answer:123</p><p><img src=\"/images/d3541fc2a496470d88e28fb520a02c5c.png\" title=\"集成5\" alt=\"集成5\"/></p>');
INSERT INTO `test_ueditor` VALUES ('80985e818afc4afd8a9becc59e288c6e', '<p>Question:123</p><p>Answer:123</p>');
INSERT INTO `test_ueditor` VALUES ('c83711d75f6b4fbf8f02ee7740834b6a', '<h2 style=\"box-sizing: border-box; font-family: &quot;open sans&quot;, sans-serif; font-weight: 500; line-height: 32px; color: rgb(51, 51, 51); margin-top: 20px; margin-bottom: 10px; font-size: 30px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box;\">SSM接入UEditor编辑器及会遇到的坑</span></h2><p>&nbsp;</p><blockquote style=\"box-sizing: border-box; padding: 10px 20px; margin: 0px 0px 20px; font-size: 17.5px; border-left: 5px solid rgb(238, 238, 238);\"><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px;\">背景：项目要用到富文本编辑器。<br/>ueditor下载地址：<a href=\"https://ueditor.baidu.com/website/download.html\" target=\"_blank\" style=\"box-sizing: border-box; background: 0px 0px; color: rgb(66, 139, 202); text-decoration-line: none;\">https://ueditor.baidu.com/website/download.html</a><br/>官方配置文档：<a href=\"https://fex.baidu.com/ueditor/#server-jsp\" target=\"_blank\" style=\"box-sizing: border-box; background: 0px 0px; color: rgb(66, 139, 202); text-decoration-line: none;\">https://fex.baidu.com/ueditor/#server-jsp</a></p></blockquote><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">记录仓促，后续持续更新……</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">视频效果：<br/><img src=\"images/6d9222bc05cc4c5e8578a0b8f5b06696.png\" title=\"\" alt=\"视频效果\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">富文本效果：<br/><img src=\"images/101c05d83df548a0b57b71d7a616e216.png\" title=\"\" alt=\"富文本效果\"/>目前进展：无法配置tomcat虚拟目录，无法导入重编译的jar，只能将文件放在tomcat目录。大家可以研究下。</p><hr/><p>Web集成UEditor步骤：<br/>1.环境： jdk 7，tomcat7，jsp，windows<br/>2.建立web项目 3.将官网下载的rar解压</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/40290471419d455292490c61bbe3b700.png\" title=\"\" alt=\"集成1\"/>4.文件夹重命名为ueditor，其他命名也可以。<br/><br/>5.整体导入项目<br/><img src=\"images/a01506bff9a6414d9061c338f6363628.png\" title=\"\" alt=\"集成2\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">如图所示，这里放在了webContent目录，红叉是json文件有注释。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/5eec7c02ab18430e987e90a0942a8aa9.png\" title=\"\" alt=\"集成3\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">6.将ueditor-》jsp-》lib下的5个jar包，同时复制到web-info-》lib下。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">至此，图文上传可以实现。下面讲到上传后回显，及页面可以读到上传的文件。</p><hr/><p>7.编辑框要实现回显，同时页面能读取，需要：1.json配置参数 2. tomcat配置虚拟路径</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">8.json配置</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><img src=\"images/1caf344e9fce4a53b880dc44fb707f2b.png\" title=\"\" alt=\"集成4\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">官方下载下来，红框这里是“”，需要手动配置，才能实现回显和读取。<br/>9.tomcat虚拟路径<br/><img src=\"images/5daab79c94d84b5abc74d306ce9a184c.png\" title=\"\" alt=\"集成5\"/>两个参数：docBase：磁盘物理路径，path：虚拟路径，对应第8步的“/upload”</p><hr/><p>至此，上传、回显、读取实现。缺点，无法实现tomcat目录外虚拟路径，也是目前研究的问题。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\"><span style=\"color:red\">下面说些坑：</span><br/>1.官网下载的rar解压后，5个jar包不能做任何改动，包括移动、复制等操作。否则，就会报错：大意为，目标jar包jdk版本与当前项目不匹配。<br/>2.解决方案，参考步骤1-5，不要动jar文件夹，只重命名，然后整体拷贝进项目。<br/><img src=\"images/bcd262d9682c4fa99a385e2bd5ceff73.png\" title=\"\" alt=\"坑1\"/></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 10px;\">如果配置不正确，这里的图片上传等多个上传相关的插件无法使用，提示异常。同时控制台会报错。</p><hr/><p>修改了ueditor-1.2.1.jar，重新打成jar，导入项目会报错，导致无法解决部署tomcat外的虚拟目录。目前正在寻求解决方案，正在研究中，欢迎大家提供经验。</p><blockquote style=\"box-sizing: border-box; padding: 10px 20px; margin: 0px 0px 20px; font-size: 17.5px; border-left: 5px solid rgb(238, 238, 238);\"><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px;\">文章仓促，仅作笔记，后续修改，欢迎探讨。</p></blockquote><p><br/></p>');
INSERT INTO `test_ueditor` VALUES ('cf5ee57914f84ca1bddc70fc332190f2', '<p>Question_Subject<br/></p><p>Question_Answer<br/></p>');
INSERT INTO `test_ueditor` VALUES ('d7f12fcd46594566b6f2418a1ab7c75f', '<p>Java</p><pre class=\"brush:java;toolbar:false\">public&nbsp;static&nbsp;void&nbsp;main(String&nbsp;[]&nbsp;args){\r\n&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(&quot;Hello&nbsp;World!&quot;);\r\n}</pre><p><img src=\"images/435a9f1c37f84dfe971361f0272d0510.png\" title=\"\" alt=\"富文本效果\" width=\"819\" height=\"531\"/><br/></p><p><br/></p><p><br/></p>');
INSERT INTO `test_ueditor` VALUES ('e7a039fc233247b981e7da21203d18d2', '<p>123</p>');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_Id` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_Name` varchar(255) DEFAULT NULL,
  `user_Type` varchar(32) DEFAULT NULL COMMENT '用户类型',
  `user_Sex` varchar(4) DEFAULT NULL,
  `user_Mobile` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `fk_user_user_type_1` (`user_Type`),
  CONSTRAINT `fk_user_user_type_1` FOREIGN KEY (`user_Type`) REFERENCES `user_type` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1180130101', 'e10adc3949ba59abbe56e057f20f883e', '李双权', '629fa6a84a254a9996518829910154d0', '男', '13836115702');
INSERT INTO `user` VALUES ('1180130102', 'e10adc3949ba59abbe56e057f20f883e', '1180130102', '629fa6a84a254a9996518829910154d0', '男', '13836115702');
INSERT INTO `user` VALUES ('1180130103', 'e10adc3949ba59abbe56e057f20f883e', '姚远', '629fa6a84a254a9996518829910154d0', '男', '23836115702');
INSERT INTO `user` VALUES ('1180130116', 'e10adc3949ba59abbe56e057f20f883e', '姚远', '629fa6a84a254a9996518829910154d0', '男', '13836115702');
INSERT INTO `user` VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'Admin', 'c8d4c17743b14deebda71170c43f12b4', '女', '12345678901');
INSERT INTO `user` VALUES ('H011000', 'e10adc3949ba59abbe56e057f20f883e', '王婧', 'c97b09ac65ba4684839a905646b3eff3', '女', '15845001020');
INSERT INTO `user` VALUES ('H011001', 'e10adc3949ba59abbe56e057f20f883e', '潘巍', 'c97b09ac65ba4684839a905646b3eff3', '男', '13069701145');
INSERT INTO `user` VALUES ('H011002', 'e10adc3949ba59abbe56e057f20f883e', '翟霞', 'c97b09ac65ba4684839a905646b3eff3', '女', '13766882883');
INSERT INTO `user` VALUES ('H011003', 'e10adc3949ba59abbe56e057f20f883e', '郑罡', 'c97b09ac65ba4684839a905646b3eff3', '女', '18646379760');
INSERT INTO `user` VALUES ('H011004', 'e10adc3949ba59abbe56e057f20f883e', '吕志峰', 'c97b09ac65ba4684839a905646b3eff3', '男', '15846637495');
INSERT INTO `user` VALUES ('H011005', 'e10adc3949ba59abbe56e057f20f883e', '蒋东玉', 'c97b09ac65ba4684839a905646b3eff3', '女', '15904503931');
INSERT INTO `user` VALUES ('H011006', 'e10adc3949ba59abbe56e057f20f883e', '于晓婷', 'c97b09ac65ba4684839a905646b3eff3', '女', '15145086176');
INSERT INTO `user` VALUES ('H011052', 'e10adc3949ba59abbe56e057f20f883e', '方海诺', 'c97b09ac65ba4684839a905646b3eff3', '男', '15846812058');
COMMIT;

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `Id` varchar(32) NOT NULL,
  `user_Type` varchar(255) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型';

-- ----------------------------
-- Records of user_type
-- ----------------------------
BEGIN;
INSERT INTO `user_type` VALUES ('629fa6a84a254a9996518829910154d0', '学生');
INSERT INTO `user_type` VALUES ('c8d4c17743b14deebda71170c43f12b4', '教学秘书');
INSERT INTO `user_type` VALUES ('c97b09ac65ba4684839a905646b3eff3', '教师');
COMMIT;

-- ----------------------------
-- View structure for view_class_info
-- ----------------------------
DROP VIEW IF EXISTS `view_class_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_class_info` AS select `classes`.`Id` AS `Id`,`classes`.`class_Id` AS `class_Id`,`classes`.`people_Num` AS `people_Num`,`classes`.`class_Col_Id` AS `col_Id`,`college`.`col_Name` AS `col_Name`,`classes`.`class_Spe_Id` AS `spe_Id`,`specialty`.`spe_Name` AS `spe_Name` from ((`classes` join `college`) join `specialty`) where ((`college`.`Id` = `classes`.`class_Col_Id`) and (`specialty`.`Id` = `classes`.`class_Spe_Id`));

-- ----------------------------
-- View structure for view_college_info
-- ----------------------------
DROP VIEW IF EXISTS `view_college_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_college_info` AS select `college`.`Id` AS `Id`,`college`.`col_Name` AS `col_Name`,`specialty`.`spe_Name` AS `spe_Name` from (`college` join `specialty` on((`college`.`Id` = `specialty`.`col_Id`)));

-- ----------------------------
-- View structure for view_course_info
-- ----------------------------
DROP VIEW IF EXISTS `view_course_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_course_info` AS select `course`.`Id` AS `Id`,`course`.`cou_Name` AS `cou_Name`,`course`.`spe_Id` AS `spe_Id`,`specialty`.`spe_Name` AS `spe_Name`,`specialty`.`col_Id` AS `col_Id`,`college`.`col_Name` AS `col_Name` from ((`course` join `specialty` on((`course`.`spe_Id` = `specialty`.`Id`))) join `college` on((`specialty`.`col_Id` = `college`.`Id`)));

-- ----------------------------
-- View structure for view_exam_rule
-- ----------------------------
DROP VIEW IF EXISTS `view_exam_rule`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_exam_rule` AS select `exam_rule`.`Id` AS `Id`,`exam_rule`.`rule_Name` AS `rule_Name`,`exam_rule`.`exam_Id` AS `exam_Id`,`exam_rule`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name`,`exam_rule`.`classes` AS `classes`,`exam_rule`.`totalMark` AS `totalMark`,`exam_rule`.`difficulty` AS `difficulty`,`exam_rule`.`singleNum` AS `singleNum`,`exam_rule`.`singleScore` AS `singleScore`,`exam_rule`.`completeNum` AS `completeNum`,`exam_rule`.`completeScore` AS `completeScore`,`exam_rule`.`judgeNum` AS `judgeNum`,`exam_rule`.`judgeScore` AS `judgeScore`,`exam_rule`.`nounNum` AS `nounNum`,`exam_rule`.`nounScore` AS `nounScore`,`exam_rule`.`subjectNum` AS `subjectNum`,`exam_rule`.`subjectScore` AS `subjectScore`,`exam_rule`.`fillcodeNum` AS `fillcodeNum`,`exam_rule`.`fillcodeScore` AS `fillcodeScore`,`exam_rule`.`codingNum` AS `codingNum`,`exam_rule`.`codingScore` AS `codingScore`,`exam_rule`.`pointIds` AS `pointIds`,`exam_rule`.`pointNames` AS `pointNames`,`exam_rule`.`rule_Time` AS `rule_Time` from (`exam_rule` join `course` on((`exam_rule`.`cou_Id` = `course`.`Id`)));

-- ----------------------------
-- View structure for view_knowledge
-- ----------------------------
DROP VIEW IF EXISTS `view_knowledge`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_knowledge` AS select `knowledge`.`Id` AS `Id`,`knowledge`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name`,`knowledge`.`kwl_Level` AS `kwl_Level`,`knowledge`.`chapter_Num` AS `chapter_Num`,`knowledge`.`section_Num` AS `section_Num`,`knowledge`.`kwl_Name` AS `kwl_Name`,`knowledge`.`parent_Id` AS `parent_Id` from (`knowledge` join `course` on((`knowledge`.`cou_Id` = `course`.`Id`)));

-- ----------------------------
-- View structure for view_question_collection
-- ----------------------------
DROP VIEW IF EXISTS `view_question_collection`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_question_collection` AS select `question_collection`.`id` AS `id`,`question_collection`.`question_Id` AS `question_Id`,`question_collection`.`user_Id` AS `user_Id`,`question`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name`,`question`.`type_Id` AS `type_Id`,`question`.`subject` AS `subject`,`question`.`choice_A` AS `choice_A`,`question`.`choice_B` AS `choice_B`,`question`.`choice_C` AS `choice_C`,`question`.`choice_D` AS `choice_D`,`question`.`answer` AS `answer`,`knowledge`.`kwl_Name` AS `kwl_Name` from (((`question_collection` join `question` on((`question_collection`.`question_Id` = `question`.`Id`))) join `knowledge` on((`question`.`kwl_Id` = `knowledge`.`Id`))) join `course` on(((`knowledge`.`cou_Id` = `course`.`Id`) and (`question`.`cou_Id` = `course`.`Id`))));

-- ----------------------------
-- View structure for view_question_info
-- ----------------------------
DROP VIEW IF EXISTS `view_question_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_question_info` AS select `question`.`Id` AS `Id`,`question`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name`,`question`.`type_Id` AS `type_Id`,`question_type`.`type_Name` AS `type_Name`,`question`.`subject` AS `subject`,`question`.`choice_A` AS `choice_A`,`question`.`choice_B` AS `choice_B`,`question`.`choice_C` AS `choice_C`,`question`.`choice_D` AS `choice_D`,`question`.`answer` AS `answer`,`question`.`degree` AS `degree`,`question`.`kwl_Id` AS `kwl_Id`,`knowledge`.`kwl_Name` AS `kwl_Name`,`question`.`analysis` AS `analysis` from (((`question` join `question_type` on((`question`.`type_Id` = `question_type`.`Id`))) join `course` on((`question`.`cou_Id` = `course`.`Id`))) join `knowledge` on(((`question`.`kwl_Id` = `knowledge`.`Id`) and (`course`.`Id` = `knowledge`.`cou_Id`))));

-- ----------------------------
-- View structure for view_studentbasic_info
-- ----------------------------
DROP VIEW IF EXISTS `view_studentbasic_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_studentbasic_info` AS select `user`.`user_Id` AS `user_Id`,`user`.`user_Name` AS `user_Name`,`user`.`user_Sex` AS `user_Sex`,`classes`.`Id` AS `classes_Id`,`classes`.`class_Id` AS `class_Id`,`college`.`Id` AS `col_Id`,`college`.`col_Name` AS `col_Name`,`specialty`.`Id` AS `spe_Id`,`specialty`.`spe_Name` AS `spe_Name`,`user`.`user_Mobile` AS `user_Mobile` from ((((`user` join `student_basic` on((`user`.`user_Id` = `student_basic`.`user_Id`))) join `classes` on((`student_basic`.`stu_ClassId` = `classes`.`Id`))) join `college` on(((`classes`.`class_Col_Id` = `college`.`Id`) and (`student_basic`.`stu_College` = `college`.`Id`)))) join `specialty` on(((`classes`.`class_Spe_Id` = `specialty`.`Id`) and (`student_basic`.`stu_Specialty` = `specialty`.`Id`) and (`college`.`Id` = `specialty`.`col_Id`))));

-- ----------------------------
-- View structure for view_teacher_basic_info
-- ----------------------------
DROP VIEW IF EXISTS `view_teacher_basic_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_teacher_basic_info` AS select `teacher_basic`.`user_Id` AS `user_Id`,`user`.`user_Name` AS `user_Name`,`user`.`user_Sex` AS `user_Sex`,`user`.`user_Mobile` AS `user_Mobile`,`teacher_basic`.`college_Id` AS `col_Id`,`college`.`col_Name` AS `col_Name`,`teacher_basic`.`specialty_Id` AS `spe_Id`,`specialty`.`spe_Name` AS `spe_Name` from (((`teacher_basic` join `user` on((`teacher_basic`.`user_Id` = `user`.`user_Id`))) join `college` on((`teacher_basic`.`college_Id` = `college`.`Id`))) join `specialty` on(((`teacher_basic`.`specialty_Id` = `specialty`.`Id`) and (`college`.`Id` = `specialty`.`col_Id`))));

-- ----------------------------
-- View structure for view_teacher_class_info
-- ----------------------------
DROP VIEW IF EXISTS `view_teacher_class_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `view_teacher_class_info` AS select `class_course`.`user_Id` AS `user_Id`,`user`.`user_Name` AS `user_Name`,`class_course`.`classes_Id` AS `classes_Id`,`classes`.`class_Id` AS `class_Id`,`class_course`.`cou_Id` AS `cou_Id`,`course`.`cou_Name` AS `cou_Name` from (((`class_course` join `user` on((`class_course`.`user_Id` = `user`.`user_Id`))) join `classes` on((`class_course`.`classes_Id` = `classes`.`Id`))) join `course` on((`class_course`.`cou_Id` = `course`.`Id`)));

-- ----------------------------
-- Function structure for first_func
-- ----------------------------
DROP FUNCTION IF EXISTS `first_func`;
delimiter ;;
CREATE FUNCTION `first_func`(param1 varchar(5))
 RETURNS tinyint(4)
begin
return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for update_people_num
-- ----------------------------
DROP FUNCTION IF EXISTS `update_people_num`;
delimiter ;;
CREATE FUNCTION `update_people_num`(param1 varchar(10))
 RETURNS text CHARSET utf8
begin
DECLARE student_val varchar(10);
declare result varchar(3000);
DECLARE classId_peopleNum CURSOR FOR select count(*),stu_ClassId from student_basic GROUP BY stu_ClassId;
set @student_val = @param1;
return @student_val;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
