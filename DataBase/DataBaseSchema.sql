-- MySQL Script generated by MySQL Workbench
-- Wed May 17 01:01:07 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema irrigation_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema irrigation_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `irrigation_db` DEFAULT CHARACTER SET utf8mb3 ;
USE `irrigation_db` ;

-- -----------------------------------------------------
-- Table `irrigation_db`.`crops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irrigation_db`.`crops` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plant_type` VARCHAR(128) NOT NULL,
  `irrigation_delay` INT NOT NULL,
  `irrigation_duration` INT NOT NULL,
  `water_amount` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_s324c4uv5gstj1cueyvmkcmm7` (`plant_type` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `irrigation_db`.`plots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irrigation_db`.`plots` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` DOUBLE NOT NULL,
  `delay` INT NOT NULL,
  `water_amount` DOUBLE NOT NULL,
  `crop_id` INT NULL DEFAULT NULL,
  `slot` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfxihstw2my2b2q1yeny9kdp0u` (`crop_id` ASC) VISIBLE,
  CONSTRAINT `FKfxihstw2my2b2q1yeny9kdp0u`
    FOREIGN KEY (`crop_id`)
    REFERENCES `irrigation_db`.`crops` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `irrigation_db`.`irrigation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irrigation_db`.`irrigation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `irrigated` BIT(1) NULL DEFAULT NULL,
  `irrigated_date` DATETIME(6) NULL DEFAULT NULL,
  `plot_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKr56qvvsycfrqbar2a2lut27k8` (`plot_id` ASC) VISIBLE,
  CONSTRAINT `FKr56qvvsycfrqbar2a2lut27k8`
    FOREIGN KEY (`plot_id`)
    REFERENCES `irrigation_db`.`plots` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 403
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
