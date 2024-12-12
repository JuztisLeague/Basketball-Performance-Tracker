-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 12:48 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `basketballpt`
--

-- --------------------------------------------------------

--
-- Table structure for table `extrapolation`
--

CREATE TABLE `extrapolation` (
  `id` int(255) NOT NULL,
  `uniqueID` int(5) NOT NULL,
  `x` int(255) NOT NULL,
  `y` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `progress`
--

CREATE TABLE `progress` (
  `x` int(255) NOT NULL,
  `id` int(255) NOT NULL,
  `y1` float(10,2) NOT NULL,
  `y2` float(10,2) NOT NULL,
  `y3` int(255) NOT NULL,
  `name` varchar(256) NOT NULL,
  `level` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `progress`
--

INSERT INTO `progress` (`x`, `id`, `y1`, `y2`, `y3`, `name`, `level`) VALUES
(1, 1, 100.00, 100.00, 200, 'Mar', 1),
(2, 2, 100.00, 100.00, 200, 'Mar', 1),
(3, 3, 133.00, 5.00, 50, 'Mar', 1),
(4, 4, 33.33, 30.00, 230, 'Mar', 1),
(5, 5, 33.33, 50.00, 10, 'Mar', 1),
(6, 6, 13.33, 90.00, 122, 'Mar', 1),
(7, 7, 13.33, 90.00, 122, 'Mar', 1);

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `id` int(255) NOT NULL,
  `shotsMade` int(255) NOT NULL,
  `dribblingErrors` int(255) NOT NULL,
  `runningTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`id`, `shotsMade`, `dribblingErrors`, `runningTime`) VALUES
(1, 5, 10, '00:00:10');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `id` int(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(256) NOT NULL,
  `age` int(255) DEFAULT NULL,
  `weight` float(10,2) DEFAULT NULL,
  `body_Type` varchar(25) DEFAULT NULL,
  `skill_Level` int(25) DEFAULT NULL,
  `training_Days` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`id`, `name`, `password`, `age`, `weight`, `body_Type`, `skill_Level`, `training_Days`) VALUES
(1, 'Mar', '12345', 20, 45.50, 'Slim', 1, 'Thursdays'),
(2, 'Karl', '12345', 21, 80.00, 'Heavy', 2, 'Monday,Wednessday,Friday'),
(3, 'yow', '54321', NULL, NULL, NULL, NULL, NULL),
(4, 'Von', '12345', NULL, NULL, NULL, NULL, NULL),
(5, 'Mar1', '12345', NULL, NULL, NULL, NULL, NULL),
(6, 'test', '12345', NULL, NULL, NULL, NULL, NULL),
(7, 'mar2', '12345', NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `extrapolation`
--
ALTER TABLE `extrapolation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `progress`
--
ALTER TABLE `progress`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `extrapolation`
--
ALTER TABLE `extrapolation`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `progress`
--
ALTER TABLE `progress`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
