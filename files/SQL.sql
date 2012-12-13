SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sgdb` DEFAULT CHARACTER SET utf8 ;
USE `sgdb` ;

-- -----------------------------------------------------
-- Table `sgdb`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(30) NOT NULL ,
  `Pass` VARCHAR(30) NOT NULL ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`infstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`infstatistics` (
  `id` INT(11) NOT NULL ,
  `Wins` INT(11) NOT NULL DEFAULT '0' ,
  `Losses` INT(11) NOT NULL DEFAULT '0' ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `id_idx` (`id` ASC) ,
  CONSTRAINT `inf_stat_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`ptsstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`ptsstatistics` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `Wins` INT(11) NOT NULL DEFAULT '0' ,
  `Losses` INT(11) NOT NULL DEFAULT '0' ,
  `Draws` INT(11) NOT NULL DEFAULT '0' ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `id_idx` (`id` ASC) ,
  CONSTRAINT `pts_stat_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`reversystatistic`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`reversystatistic` (
  `id` INT(11) NOT NULL ,
  `Wins` INT(11) NOT NULL DEFAULT '0' ,
  `Losses` INT(11) NOT NULL DEFAULT '0' ,
  `nichija` INT(11) NOT NULL DEFAULT '0' ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `id_idx` (`id` ASC) ,
  CONSTRAINT `reversy_stat_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`sbstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`sbstatistics` (
  `id` INT(11) NOT NULL ,
  `Wins` INT(11) NOT NULL DEFAULT '0' ,
  `Losses` INT(11) NOT NULL DEFAULT '0' ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `id_idx` (`id` ASC) ,
  CONSTRAINT `sb_stat_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`useraddinfo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`useraddinfo` (
  `id` INT(11) NOT NULL ,
  `email` VARCHAR(30) NULL DEFAULT NULL ,
  `birthday` VARCHAR(30) NULL DEFAULT NULL ,
  `about` VARCHAR(999) NULL DEFAULT NULL ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `id_idx` (`id` ASC) ,
  CONSTRAINT `user_info_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgdb`.`xostatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sgdb`.`xostatistics` (
  `id` INT(11) NOT NULL ,
  `Wins` INT(11) NOT NULL DEFAULT '0' ,
  `Losses` INT(11) NOT NULL DEFAULT '0' ,
  INDEX `id_idx` (`id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `xo_stat_id`
    FOREIGN KEY (`id` )
    REFERENCES `sgdb`.`users` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
