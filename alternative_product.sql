-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2023 at 01:37 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scansafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `alternative_product`
--

CREATE TABLE `alternative_product` (
  `id` bigint(20) NOT NULL,
  `alt_product` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `replaces_product` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alternative_product`
--

INSERT INTO `alternative_product` (`id`, `alt_product`, `notes`, `replaces_product`, `upc`, `username`) VALUES
(102, 'Beanfields Nacho Cheese Chips', 'So tasty!', 'Doritos', '058449410003', 'influencer'),
(103, 'Olipop Lemon Lime Soda', 'Tastes so sugary and good you\'d thought it really was Mountain Dew!', 'Mountain Dew', '028400516464', 'influencer'),
(104, 'Nature\'s Path Organic Frosted Strawberry Toaster Pastries', 'Love these pastries!', 'Kellog\'s Strawberry Pop-Tarts', '028400516464', 'influencer'),
(105, 'Natural Bliss Vanilla Almond Milk Creamer ', 'The taste is exactly the same; you won\'t ever tell the difference!', 'Coffee-Mate\'s Vanilla Bean Liquid Creamer', '050000322756', 'influencer'),
(109, '', '', '', '', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alternative_product`
--
ALTER TABLE `alternative_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alternative_product`
--
ALTER TABLE `alternative_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
