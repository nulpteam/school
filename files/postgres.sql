CREATE  TABLE IF NOT EXISTS users (
  id bigint NOT NULL  ,
  Name VARCHAR(30) NOT NULL ,
  Pass VARCHAR(30) NOT NULL ,
  PRIMARY KEY (id) );



-- -----------------------------------------------------
-- Table `sgdb`.`infstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS infstatistics (
  id bigint NOT NULL ,
  Wins bigint NOT NULL DEFAULT '0' ,
  Losses bigint NOT NULL DEFAULT '0');
 


-- -----------------------------------------------------
-- Table `sgdb`.`ptsstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS ptsstatistics (
  id bigint NOT NULL ,
  Wins bigint NOT NULL DEFAULT '0' ,
  Losses bigint NOT NULL DEFAULT '0' ,
  Draws bigint NOT NULL DEFAULT '0' );
  
  


-- -----------------------------------------------------
-- Table `sgdb`.`reversystatistic`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS reversystatistic (
  id bigint NOT NULL ,
  Wins bigint NOT NULL DEFAULT '0' ,
  Losses bigint NOT NULL DEFAULT '0' ,
  nichija bigint NOT NULL DEFAULT '0' );


-- -----------------------------------------------------
-- Table `sgdb`.`sbstatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS sbstatistics (
  id bigint NOT NULL ,
  Wins bigint NOT NULL DEFAULT '0' ,
  Losses bigint NOT NULL DEFAULT '0' );


-- -----------------------------------------------------
-- Table `sgdb`.`useraddinfo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS useraddinfo (
  id bigint NOT NULL ,
  email VARCHAR(30) NULL DEFAULT NULL ,
  birthday VARCHAR(30) NULL DEFAULT NULL ,
  about VARCHAR(999) NULL DEFAULT NULL );


-- -----------------------------------------------------
-- Table `sgdb`.`xostatistics`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS xostatistics (
  id bigint NOT NULL ,
  Wins bigint NOT NULL DEFAULT '0' ,
  Losses bigint NOT NULL DEFAULT '0' );
 
