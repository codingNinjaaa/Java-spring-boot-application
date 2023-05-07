-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.33 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for java_spring_application
DROP DATABASE IF EXISTS `java_spring_application`;
CREATE DATABASE IF NOT EXISTS `java_spring_application` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java_spring_application`;

-- Dumping structure for table java_spring_application.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `Id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Price` decimal(20,6) DEFAULT NULL,
  `Product_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_product_product_type` (`Product_type`),
  CONSTRAINT `FK_product_product_type` FOREIGN KEY (`Product_type`) REFERENCES `product_type` (`Product_type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table java_spring_application.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
REPLACE INTO `product` (`Id`, `Name`, `Quantity`, `Price`, `Product_type`) VALUES
	('123', 'Name 1', 100, 2.500000, '123');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table java_spring_application.product_type
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE IF NOT EXISTS `product_type` (
  `Product_type_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Product_type_description` blob,
  PRIMARY KEY (`Product_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table java_spring_application.product_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
REPLACE INTO `product_type` (`Product_type_id`, `Product_type_description`) VALUES
	('123', _binary 0x4465736372697074696f6e2031);
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
