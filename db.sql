
--创建Admin对应的数据库以及表
CREATE DATABASE admin DEFAULT CHARACTER SET utf8;
USE admin;
CREATE TABLE admin(USER VARCHAR(40) PRIMARY KEY,pwd VARCHAR(40),email VARCHAR(40));

--创建Page对应的数据库以及表
CREATE DATABASE employee DEFAULT CHARACTER SET utf8;
USE employee;
CREATE TABLE employee(emId INT PRIMARY KEY,emName VARCHAR(40),dept_id INT);
