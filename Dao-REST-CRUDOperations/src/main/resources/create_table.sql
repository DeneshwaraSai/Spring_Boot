CREATE DATABASE IF NOT EXISTS `EMPLOYEE_DIRECTORY`;

USE `EMPLOYEE_DIRECTORY`;

DROP TABLE IF EXISTS `EMPLOYEE`;

CREATE TABLE `EMPLOYEE` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(null, 'Leslie','Andrews','leslie@luv2code.com'),
	(null, 'Emma','Baumgarten','emma@luv2code.com'),
	(null, 'Avani','Gupta','avani@luv2code.com'),
	(null, 'Yuri','Petrov','yuri@luv2code.com'),
	(null, 'Juan','Vega','juan@luv2code.com');

