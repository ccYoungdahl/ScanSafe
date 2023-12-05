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
-- Table structure for table `proposed_ingredient`
--

CREATE TABLE `proposed_ingredient` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rejected` bit(1) NOT NULL,
  `risk` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proposed_ingredient`
--

INSERT INTO `proposed_ingredient` (`id`, `approved`, `comments`, `name`, `rejected`, `risk`, `website`, `username`) VALUES
(1, b'0', 'This stuff is super dangerous', 'Gluten', b'1', 'Allergic reaction', 'www.glutenisbad.com', 'influencer'),
(12, b'0', 'I can tell when I eat something containing this ingredient', 'Red 40', b'0', 'Causes migraine headheaches.', 'www.whatswrongwithred40.org', 'influencer'),
(45, b'1', 'MSG is not healthy and should be banned!', 'Monosodium Glutamate', b'0', 'Potentially impairs brain growth and development.', 'https://www.healthline.com/nutrition/common-food-additives#TOC_TITLE_HDR_2', 'influencer'),
(46, b'0', 'In moderate amounts it\'s okay, but it still can cause swelling and cramps.', 'Guar Gum', b'1', 'Can cause swelling in the small intestine.', 'https://www.sciencedirect.com/topics/medicine-and-dentistry/guar-gum#:~:text=Guar%20gum%20causes%20abdominal%20pain,cause%20occupational%20rhinitis%20and%20asthma.', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `proposed_ingredient`
--
ALTER TABLE `proposed_ingredient`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `proposed_ingredient`
--
ALTER TABLE `proposed_ingredient`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
