create database `high-school`;

CREATE TABLE `high-school`.`student` (
  `registration_number` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  PRIMARY KEY (`registration_number`));


CREATE TABLE `high-school`.`teacher` (
  `id_teacher` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  PRIMARY KEY (`id_teacher`));


CREATE TABLE `high-school`.`course` (
  `id_course` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `hours_by_week` INT NULL,
  `teacher` INT NULL,
  PRIMARY KEY (`id_course`),
  INDEX `teacher_id_idx` (`teacher` ASC),
  CONSTRAINT `teacher_id`
    FOREIGN KEY (`teacher`)
    REFERENCES `high-school`.`teacher` (`id_teacher`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `high-school`.`student_x_course` (
  `student` INT NOT NULL,
  `course` INT NOT NULL,
  PRIMARY KEY (`student`, `course`),
  INDEX `course_id_idx` (`course` ASC),
  CONSTRAINT `student_id`
    FOREIGN KEY (`student`)
    REFERENCES `high-school`.`student` (`registration_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `course_id`
    FOREIGN KEY (`course`)
    REFERENCES `high-school`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `high-school`.`grade_type` (
  `grade_type_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`grade_type_id`));


CREATE TABLE `high-school`.`grade` (
  `student` INT NOT NULL,
  `course` INT NOT NULL,
  `grade` INT NULL,
  `grade_type` INT NULL,
  PRIMARY KEY (`student`, `course`),
  INDEX `course_id_idx` (`course` ASC),
  INDEX `grade_type_idx` (`grade_type` ASC),
  CONSTRAINT `student_id_grade`
    FOREIGN KEY (`student`)
    REFERENCES `high-school`.`student_x_course` (`student`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `course_id_grade`
    FOREIGN KEY (`course`)
    REFERENCES `high-school`.`student_x_course` (`course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `grade_type`
    FOREIGN KEY (`grade_type`)
    REFERENCES `high-school`.`grade_type` (`grade_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `high-school`.`course_schedule` (
  `course_schedule_id` INT NOT NULL AUTO_INCREMENT,
  `day` VARCHAR(45) NULL,
  `start` TIME NULL,
  `end` TIME NULL,
  `course` INT NULL,
  PRIMARY KEY (`course_schedule_id`),
  INDEX `course_idx` (`course` ASC),
  CONSTRAINT `course`
    FOREIGN KEY (`course`)
    REFERENCES `high-school`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



