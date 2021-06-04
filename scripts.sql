DROP SCHEMA IF EXISTS `flightdb`;

CREATE SCHEMA `flightdb`;

use `flightdb`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `airline`;

CREATE TABLE `airline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) DEFAULT NULL,
  `contact_number` VARCHAR(128) DEFAULT NULL,
  `write_up` VARCHAR(128) DEFAULT NULL,
  `is_block` BOOLEAN DEFAULT NULL,

  PRIMARY KEY (`id`),

  UNIQUE KEY `AIRLINE_NAME_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `flight`;

CREATE TABLE `flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `airline_id` INT DEFAULT NULL,
  `from_place` VARCHAR(128) DEFAULT NULL,
  `to_place` VARCHAR(128) DEFAULT NULL,
  `start_date_time` DATETIME DEFAULT NULL,
  `end_date_time` DATETIME DEFAULT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `FK_AIRLINE` FOREIGN KEY (`airline_id`) 
  REFERENCES `airline` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `plane`;

CREATE TABLE `plane` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_full` BOOLEAN DEFAULT NULL,
  `flight_id` INT DEFAULT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `FK_FLIGHT` FOREIGN KEY (`flight_id`) 
  REFERENCES `flight` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plane_id` INT DEFAULT NULL,
  `seat_number` VARCHAR(128) DEFAULT NULL,
  `is_avaliable` BOOLEAN DEFAULT NULL,

  PRIMARY KEY (`id`),

  UNIQUE KEY `PLANE_SEAT_UNIQUE` (`plane_id`, `seat_number`),

  CONSTRAINT `FK_PLANE` FOREIGN KEY (`plane_id`) 
  REFERENCES `plane` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `passenger`;

CREATE TABLE `passenger` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(128) DEFAULT NULL,
  `last_name` VARCHAR(128) DEFAULT NULL,
  `gender` VARCHAR(128) DEFAULT NULL,
  `age` INT DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flight_id` INT NOT NULL,
  `passenger_id` INT NOT NULL,
  
  PRIMARY KEY (`flight_id`,`passenger_id`),
  
  CONSTRAINT `FK_TICKET_FLIGHT` FOREIGN KEY (`flight_id`) 
  REFERENCES `flight` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_TICKET_PASSENGER` FOREIGN KEY (`passenger_id`) 
  REFERENCES `passenger` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


------------------------------------------------------------------

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) 
  REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_COURSE_ID_idx` (`course_id`),

  CONSTRAINT `FK_COURSE` 
  FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `course_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  
  PRIMARY KEY (`course_id`,`student_id`),
  
  KEY `FK_STUDENT_idx` (`student_id`),
  
  CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
