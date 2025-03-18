-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET @@session.restrict_fk_on_non_standard_key=OFF;
-- -----------------------------------------------------
-- Schema green_univ
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema green_univ
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `green_univ` DEFAULT CHARACTER SET utf8 ;
USE `green_univ` ;

-- -----------------------------------------------------
-- Table `green_univ`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `contact` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`user` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `social_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(45) NULL,
  `role` ENUM("professor", "student", "admin") NOT NULL,
  `agreed_terms` TINYINT NOT NULL DEFAULT 0,
  `register_date` DATETIME NOT NULL,
  `leave_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `contact_UNIQUE` (`contact` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`professor` (
  `id` CHAR(7) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `department_id` INT NOT NULL,
  `is_chief` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_professor_department1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_professor_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_professor_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_professor_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(255) NOT NULL,
  `thumbnail_location` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`article_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`article_status` (
  `status` ENUM("open", "close") NOT NULL,
  PRIMARY KEY (`status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`article_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`article_category` (
  `category` ENUM("notice", "news", "column", "employment", "bulletin", "qna") NOT NULL,
  PRIMARY KEY (`category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`article` (
  `id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `category` ENUM("notice", "news", "column", "employment", "bulletin", "qna") NOT NULL,
  `status` ENUM("open", "close") NULL,
  `content` TEXT NOT NULL,
  `view` INT NOT NULL DEFAULT 0,
  `image_id` INT NULL,
  `file_id` INT NULL,
  `register_date` DATE NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_article_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_article_image1_idx` (`image_id` ASC) VISIBLE,
  INDEX `fk_article_file1_idx` (`file_id` ASC) VISIBLE,
  INDEX `fk_article_article_status1_idx` (`status` ASC) VISIBLE,
  INDEX `fk_article_article_category1_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_article_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_article_file1`
    FOREIGN KEY (`file_id`)
    REFERENCES `green_univ`.`file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_article_article_status1`
    FOREIGN KEY (`status`)
    REFERENCES `green_univ`.`article_status` (`status`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_article_article_category1`
    FOREIGN KEY (`category`)
    REFERENCES `green_univ`.`article_category` (`category`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(25) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`student` (
  `student_number` CHAR(8) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `department_id` INT NOT NULL,
  `image_id` INT NULL,
  `grade` TINYINT NOT NULL DEFAULT 1,
  `semester` TINYINT NOT NULL DEFAULT 1,
  `status` ENUM("in", "grad", "break") NULL DEFAULT 'in',
  PRIMARY KEY (`student_number`, `user_id`),
  INDEX `fk_student_department_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_student_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`lecture` (
  `id` CHAR(6) NOT NULL,
  `department_id` INT NOT NULL,
  `professor_id` CHAR(7) NOT NULL,
  `level` TINYINT NOT NULL,
  `classification` ENUM("전공", "선택교양") NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `credit` TINYINT NOT NULL,
  `semester` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lecture_department1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_lecture_professor1_idx` (`professor_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `green_univ`.`department` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_lecture_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `green_univ`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`registry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`registry` (
  `student_number` CHAR(8) NOT NULL,
  `lecture_id` CHAR(6) NOT NULL,
  `register_date` DATE NULL,
  PRIMARY KEY (`lecture_id`, `student_number`),
  INDEX `fk_registry_student1_idx` (`student_number` ASC) VISIBLE,
  INDEX `fk_registry_lecture1_idx` (`lecture_id` ASC) VISIBLE,
  CONSTRAINT `fk_registry_student1`
    FOREIGN KEY (`student_number`)
    REFERENCES `green_univ`.`student` (`student_number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registry_lecture1`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `green_univ`.`lecture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`score`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`score` (
  `student_number` CHAR(8) NOT NULL,
  `lecture_id` CHAR(6) NOT NULL,
  `attend_score` TINYINT NULL,
  `mid_score` TINYINT NULL,
  `final_score` TINYINT NULL,
  `etc_score` TINYINT NULL,
  `grade` CHAR(1) NULL,
  PRIMARY KEY (`student_number`, `lecture_id`),
  INDEX `fk_score_lecture1_idx` (`lecture_id` ASC) VISIBLE,
  CONSTRAINT `fk_score_student1`
    FOREIGN KEY (`student_number`)
    REFERENCES `green_univ`.`student` (`student_number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_score_lecture1`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `green_univ`.`lecture` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`student_council`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`student_council` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `sns_url` TEXT NULL,
  `image_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_council_image1_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_council_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`club` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `url` TEXT NULL,
  `image_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_club_image1_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `fk_club_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `green_univ`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`menu` (
  `menu_id` INT NOT NULL AUTO_INCREMENT,
  `main` VARCHAR(10) NOT NULL,
  `soup` VARCHAR(10) NOT NULL,
  `rice` VARCHAR(10) NOT NULL,
  `side_1` VARCHAR(10) NULL,
  `side_2` VARCHAR(10) NULL,
  PRIMARY KEY (`menu_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`meal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `meal_time` ENUM("breakfast", "lunch", "dinner") NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_meal_menu1_idx` (`menu_id` ASC) VISIBLE,
  CONSTRAINT `fk_meal_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `green_univ`.`menu` (`menu_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `article_id` INT NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `register_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comment_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `green_univ`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `green_univ`.`article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`faq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`faq` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(100) NOT NULL,
  `question` VARCHAR(255) NOT NULL,
  `answer` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `green_univ`.`term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `green_univ`.`term` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `content` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
