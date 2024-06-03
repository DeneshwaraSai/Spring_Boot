USE EMPLOYEE_DIRECTORY;

DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS MEMBERS;

CREATE TABLE `MEMBERS` (
  `USER_ID` VARCHAR(50) NOT NULL,
  `PASSWORD` VARCHAR(68) NOT NULL,
  `ACTIVE` TINYINT NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `MEMBERS` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1),
('James','{bcrypt}$2a$10$is4xj3s6Nr6JIuOSG0xUk.mId6x/xn6sbI/RIm3mFD3ICC0xctfXG', 1),
('haves','{bcrypt}$2a$10$is4xj3s6Nr6JIuOSG0xUk.mId6x/xn6sbI/RIm3mFD3ICC0xctfXG', 1),
('caves','{bcrypt}$2a$10$is4xj3s6Nr6JIuOSG0xUk.mId6x/xn6sbI/RIm3mFD3ICC0xctfXG', 1);

-- ----------------------------------------------------------------

CREATE TABLE `ROLES` (
  `USER_ID` VARCHAR(50) NOT NULL,
  `ROLE` VARCHAR(50) NOT NULL,
  UNIQUE KEY `AUTHORITIES_IDX_1_CUS` (`USER_ID`,`ROLE`),
  CONSTRAINT `AUTHORITIES_IBFK_1_CUS` FOREIGN KEY (`USER_ID`) REFERENCES `MEMBERS` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 INSERT INTO `ROLES` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN'),
('haves', 'ROLE_ADMIN'),
('caves', 'ROLE_MANAGER'),
('James', 'ROLE_EMPLOYEE');

-- ----------------------------------------------------------------
