/*
SQLyog Enterprise - MySQL GUI v8.05 
MySQL - 5.6.34 : Database - task_assigner_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`task_assigner_demo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `task_assigner_demo`;

/*Table structure for table `Feature` */

DROP TABLE IF EXISTS `Feature`;

CREATE TABLE `Feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `Feature` */

insert  into `Feature`(`id`,`code`,`name`,`status`) values (1,'TEST','Test','Y'),(2,'SM','Simple','Y'),(3,'CM','Complex','Y');

/*Table structure for table `feature` */

DROP TABLE IF EXISTS `feature`;

CREATE TABLE `feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `feature` */

insert  into `feature`(`id`,`code`,`name`,`status`) values (1,'1','Test','Y'),(2,'2','Demo','N');

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `taskid` bigint(20) NOT NULL AUTO_INCREMENT,
  `assign_to_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `task_assign_from_date` datetime DEFAULT NULL,
  `task_assign_to_date` datetime DEFAULT NULL,
  `task_code` varchar(255) DEFAULT NULL,
  `task_completed_date` datetime DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `created_by_id` bigint(20) DEFAULT NULL,
  `featureid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`taskid`),
  KEY `FK_lmi70tdmu2hv5onj3xk8ay66s` (`created_by_id`),
  KEY `FK_fa72fay6x5ystyyx2crcula6g` (`featureid`),
  CONSTRAINT `FK_fa72fay6x5ystyyx2crcula6g` FOREIGN KEY (`featureid`) REFERENCES `feature` (`id`),
  CONSTRAINT `FK_lmi70tdmu2hv5onj3xk8ay66s` FOREIGN KEY (`created_by_id`) REFERENCES `user_info` (`userinfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `task` */

insert  into `task`(`taskid`,`assign_to_id`,`created_date`,`description`,`name`,`status`,`task_assign_from_date`,`task_assign_to_date`,`task_code`,`task_completed_date`,`task_name`,`title`,`created_by_id`,`featureid`) values (1,6,'2017-01-26 00:00:00','asd','asd','Y','2017-01-26 00:00:00','2017-01-26 00:00:00','asd','2017-01-27 00:00:00',NULL,'asddd',15,1),(4,8,'2017-01-07 00:00:00','abccc','Binita','Y','2017-01-21 00:00:00','2017-01-19 00:00:00','8','2017-01-17 00:00:00',NULL,'aggg',7,1),(5,9,'2017-01-14 00:00:00','hyjjj','addd','Y','2017-01-10 00:00:00','2017-01-09 00:00:00','88','2017-01-03 00:00:00',NULL,'dddd',7,1),(8,6,'2017-01-07 00:00:00','aaa','abc','Y','2017-01-19 00:00:00','2017-01-18 00:00:00','4','2017-01-10 00:00:00',NULL,'aaaa',7,1),(9,14,'2017-01-12 00:00:00','abc','front end design','Y','2017-01-19 00:00:00','2017-01-25 00:00:00','3','2017-01-16 00:00:00',NULL,'sss',14,1);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `userinfoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `addeddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `user_role` char(1) DEFAULT NULL,
  `assignToId` bigint(20) DEFAULT NULL,
  `createdById` bigint(20) DEFAULT NULL,
  `admin_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`userinfoid`),
  KEY `FK_jmwrlcwceaw999ewwhybkvm2u` (`assignToId`),
  KEY `FK_cc2cwmmud5qjn0xayeck7skd6` (`createdById`),
  CONSTRAINT `FK_cc2cwmmud5qjn0xayeck7skd6` FOREIGN KEY (`createdById`) REFERENCES `feature` (`id`),
  CONSTRAINT `FK_jmwrlcwceaw999ewwhybkvm2u` FOREIGN KEY (`assignToId`) REFERENCES `feature` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `user_info` */

insert  into `user_info`(`userinfoid`,`active`,`addeddate`,`email`,`last_login_time`,`mobileno`,`name`,`password`,`status`,`user_role`,`assignToId`,`createdById`,`admin_type`) values (6,'Y','2017-01-21 22:47:50','sunita44joshi@gmail.com',NULL,'98222222','Sunita Joshi','$2a$10$Rxl8RneErTlig6XWWE67wOxM/YmEIcJXiSckeASzzgNdtDZtNyuVm',NULL,'A',NULL,NULL,NULL),(7,'Y','2017-01-21 22:49:31','admin@f1soft.com',NULL,'12345678990','sonu Joshi','$2a$10$luidu2yM2oL5PKi//8QMsuDQPH5YPRRJBHg3TVgPu0SWafWIdfXW2',NULL,'A',NULL,NULL,NULL),(8,'Y','2017-01-21 23:31:03','binita@gmail.com',NULL,'8724569456','binita Bista','$2a$10$m3qxqJlAC9Bc/WhFUbksLOVsRy1nUCrYJaXD2K70RW57ner1v.cs2',NULL,'A',NULL,NULL,NULL),(9,'Y','2017-01-22 22:13:43','santosh@gmail.com',NULL,'8928345670','Santosh Joshi','$2a$10$gIY1WxFR5YSuJGAS56M12OahNulAoTk4D0vYvYjy9MKOnHtZVuFN.',NULL,'A',NULL,NULL,NULL),(10,'Y','2017-01-22 22:20:34','ashmita@gmail.com',NULL,'3456789000','Ashmita Ojha','$2a$10$qevPaJZCOdkpY8GmBwcPcOJ0jU7bfeCvkgGqOZ6sweyqKdxMGfWv2',NULL,'A',NULL,NULL,NULL),(11,'Y','2017-01-25 01:06:07','shyam@gmail.com',NULL,'8796577888','shyam bista','$2a$10$XThy9WmWcaw5svutn1PDHunkMsxmENt.9hNBz7RLEWWhhfJMIKeJ.',NULL,'A',NULL,NULL,NULL),(12,'Y','2017-01-26 03:13:07','nanu@gmail.com',NULL,'982345666666','Nanu Joshi','$2a$10$rImnLReSqnrjIKRw2IIY6eJSmFiMouVzTMXAndNUdzygtgKlrQOhe',NULL,'A',NULL,NULL,NULL),(13,'Y','2017-01-26 22:23:57','bhawana@gmail.com',NULL,'8735677777','bhawana joshi','$2a$10$n3iHO0D2TDABM6EFjzda1OFuzsamuFUYU9l46528coWfG2ftyef4W',NULL,'U',NULL,NULL,NULL),(14,'Y','2017-01-26 23:08:46','arjun@f1soft.com',NULL,'9848428055','Arjun Dhami','$2a$10$JgVytEdhBmiK7Kc8p/sNbuvMEOA/Ebfkb4uMHs2.QCdHgQNwF/8hS',NULL,'U',NULL,NULL,NULL),(15,'Y','2017-01-27 02:23:50','surya@f1soft.com',NULL,'9988766666','Surya Bhatta','$2a$10$eB3gEs0322ReVbf8RZxPkOGFBjLU69zgOhKCq8GIMtRDm5fTPsfjC',NULL,'U',NULL,NULL,NULL),(16,'Y','2017-01-27 03:45:11','kamala@f1soft.com',NULL,'983455667799','Kamala Joshi','$2a$10$0Q8jqepKKX.BudFM3u3CouObYdO2jdm3orPofj3nxEqqcvbayIvzy',NULL,'A',NULL,NULL,NULL),(17,'Y','2017-01-28 20:04:45','ram@f1soft.com',NULL,'984567777','Ram Joshi','$2a$10$twopsLJzjC0KtTRRLobfqOB0K9AtEno6wCJYeL7PdMeUwZr5Sujz2',NULL,'U',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
