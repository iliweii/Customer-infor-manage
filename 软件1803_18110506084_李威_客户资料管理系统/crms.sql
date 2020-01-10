/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.27 : Database - crms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crms`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cityid` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`cityid`,`cityname`) values 
(1,'北京'),
(2,'南京'),
(3,'石家庄'),
(4,'济南'),
(5,'淄博'),
(6,'菏泽'),
(13,'德州'),
(14,'青岛'),
(15,'上海');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `custid` int(11) NOT NULL AUTO_INCREMENT,
  `custname` varchar(20) DEFAULT NULL,
  `custphone` varchar(20) DEFAULT NULL,
  `cuetemail` varchar(20) DEFAULT NULL,
  `custgender` varchar(20) DEFAULT NULL,
  `cityid` int(11) DEFAULT NULL,
  `cuslevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`custid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`custid`,`custname`,`custphone`,`cuetemail`,`custgender`,`cityid`,`cuslevel`) values 
(1,'李威','123456789','12345678@qq.com','男',2,4),
(2,'王飞','234567891','23456789@qq.com','男',1,4),
(3,'蔡徐坤','345678912','34567891@qq.com','男',3,4),
(4,'王五','11111111','1111111@qq.vom','男',6,4),
(5,'李四','2222','89123456@qq.com','男',4,4),
(6,'小林','678912345','67891234@qq.com','女',2,1),
(7,'南宫问天','789123456','78912345@qq.com','女',4,1),
(9,'上官婉儿','110','91234567@qq.com','女',5,2),
(10,'鸡你太美','789','1295@qq.com','女',2,2),
(11,'小林','678912345','67891234@qq.com','女',1,1),
(14,'蔡某人','123','123@qq.com','女',4,2),
(15,'马云','123456','mayun@gmail.com','男',14,1),
(16,'马云','123456','mayun@gmail.com','男',14,1),
(17,'马云','123456','mayun@gmail.com','男',14,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(20) DEFAULT NULL,
  `userpassword` varchar(20) DEFAULT NULL,
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `userlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`username`,`userpassword`,`userid`,`userlevel`) values 
('root','123456',1,1),
('admin','123456',2,2),
('liwei','123456',3,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
