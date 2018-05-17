-- phpMyAdmin SQL Dump
-- version 2.6.4-pl4
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Nov 17, 2014 at 03:22 PM
-- Server version: 5.5.21
-- PHP Version: 5.1.1
-- 
-- Database: `mybatis`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `myuser`
-- 

CREATE TABLE `myuser` (
  `USER_ID` int(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `FIRSTNAME` varchar(20) NOT NULL,
  `LASTNAME` varchar(20) NOT NULL,
  `PHONE` bigint(10) NOT NULL,
  `EMAILID` varchar(50) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `valid` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

-- 
-- Dumping data for table `myuser`
-- 

INSERT INTO `myuser` VALUES (21, 'amit', '123456', 'Amit', 'Bhalerao', 9970446416, 'amit@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (23, 'janhavi', '12345678', 'Janhavi', 'Bhalerao', 7058756668, 'amit@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (28, 'vikas', '123456', 'Vikas', 'Shivankar', 9970446416, 'vikas@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (29, 'anu', '123456', 'Anuradha', 'Pawar', 8796154725, 'amit@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (30, 'sarika', '123456', 'Sarika', 'Sakore', 8796154725, 'sarika@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (31, 'rahul', '123456', 'Rahul', 'Rajsaini', 8796154725, 'rahul@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (32, 'Vignhesh', '123456', 'Vighnesh', 'Shanbaug', 8796154725, 'Vignhesh@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (33, 'kasturi', '123456', 'Kasturi', 'Bhalerao', 8796154725, 'kasturi@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (34, 'shravani', '123456', 'Shravani', 'Kakade', 8796154725, 'Shravani@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (35, 'sachin', '123456', 'Sachin', 'Tambe', 9967978969, 'sachin@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (36, 'abhijit', '123456', 'Abhijit', 'Shinde', 9860960529, 'abhijt@gmail.com', 0, 0);
INSERT INTO `myuser` VALUES (38, 'rohit', '123456', 'Rohit', 'Phaltankar', 9975497472, 'rohit@gmail.com', 0, 0);
