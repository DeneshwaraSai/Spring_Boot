CREATE TABLE STUDENT_INFO(
ID INT NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(50) NOT NULL,
MIDDLE_NAME VARCHAR(50) DEFAULT NULL,
LAST_NAME VARCHAR(50) NOT NULL,
ROLL_NO VARCHAR(15) NOT NULL,
UHID LONG NOT NULL,
GENDER VARCHAR(1) NOT NULL,
BIRTH_DATE DATE NOT NULL,
ABOUT VARCHAR (1000) DEFAULT NULL,
STATUS VARCHAR(2) NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE ADDRESS (
ID INT NOT NULL AUTO_INCREMENT,
STUDENT_ID INT NOT NULL,
TYPE VARCHAR(1) NOT NULL,
LINE_ONE VARCHAR(40) NOT NULL,
LINE_TWO VARCHAR(40) DEFAULT NULL,
LINE_THREE VARCHAR(40) DEFAULT NULL,
CITY VARCHAR(25) NOT NULL,
STATE VARCHAR(25) NOT NULL,
DISTRICT VARCHAR(25) NOT NULL,
POSTAL_CODE VARCHAR(10) NOT NULL,
PRIMARY KEY(ID),
CONSTRAINT FK_TELEPHONE_INFO FOREIGN KEY(STUDENT_ID) REFERENCES STUDENT_INFO(ID)
);

CREATE TABLE TELEPHONE (
ID INT NOT NULL AUTO_INCREMENT,
STUDENT_ID INT NOT NULL,
TYPE VARCHAR(2) NOT NULL,
DIAL_NUMBER VARCHAR(12) NOT NULL,
COUNTRY_DIALING VARCHAR(5) NOT NULL,
AREA_DIALING VARCHAR(5) DEFAULT NULL,
EXTENSION VARCHAR(5) DEFAULT NULL,
PRIMARY KEY (ID),
CONSTRAINT FK_TELEPHONE_INFO FOREIGN KEY(STUDENT_ID) REFERENCES STUDENT_INFO(ID)
);

CREATE TABLE QUALIFICATION_INFO(
ID INT NOT NULL AUTO_INCREMENT,
STUDENT_ID INT NOT NULL,
QUALIFICATION_NAME VARCHAR(100) NOT NULL,
SCHOOL_NAME VARCHAR(100) NOT NULL,
START_DATE DATE DEFAULT NULL,
END_DATE DATE DEFAULT NULL,
AT_PRESENT BOOLEAN DEFAULT NULL,
PRIMARY KEY (ID),
CONSTRAINT FK_QUALLIFICATION_INFO FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT_INFO(ID)
);

CREATE TABLE PROFESSIONAL_INFO (
ID INT NOT NULL AUTO_INCREMENT,
STUDENT_ID INT NOT NULL,
EMPLOYER_NAME VARCHAR(100) NOT NULL,
POSITION VARCHAR(50) NOT NULL,
START_DATE DATE DEFAULt NULL,
END_DATE  DATE DEFAULT NULL,
AT_PRESENT BOOLEAN DEFAULT NULL,
PRIMARY KEY (ID),
CONSTRAINT FK_PROFESSIONAL_INFO FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT_INFO(ID)
);