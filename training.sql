-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2024 at 07:40 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `id` int(255) NOT NULL,
  `level` int(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `title` varchar(256) NOT NULL,
  `description` varchar(255) NOT NULL,
  `goal` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `training`
--

INSERT INTO `training` (`id`, `level`, `type`, `title`, `description`, `goal`) VALUES
(1, 1, 'Dribbling', 'Hand Dribble', 'Dribble in a straight line using both hands alternately (1 min)', '20'),
(2, 1, 'Dribbling', 'Simple Crossover', 'Perform simple crossovers. (30 secs)', '20'),
(3, 1, 'Dribbling', 'Dribble Walk', 'Practice dribbling while walking, focus on maintaining control of the ball. (1 min)', '20'),
(4, 2, 'Dribbling', 'Behind Back', 'Perform behind the back dribbling while moving. (1 min)\r\n', '40'),
(5, 2, 'Dribbling', 'Alternating Dribbles', 'Alternate between left and right dribbles while moving forward. (1 min)\r\n', '40'),
(6, 2, 'Dribbling', 'Improved Crossover', 'Perform crossover while moving. (1 min)', '40'),
(7, 3, 'Dribbling', 'Cross Pressured', 'Perform crossover while being defended/with traffic. (1 min and 30 secs)\r\n', '40'),
(8, 3, 'Dribbling', 'Alternating Pace', 'Change your speed and pacing while dribbling with defender/traffic. (1 min)\r\n', '40'),
(9, 3, 'Dribbling', 'Finisher', 'Dribble towards the basket and shoot the ball towards the basket. (1 min and 5 shots)\r\n', '40'),
(10, 1, 'Running', 'Posture Drill', 'Run slowly with proper posture and stance. (5 mins)\r\n', '5:00'),
(11, 1, 'Running', 'Leg Raise', 'Perform knee raises while jogging in place. (2 mins)', '5:00'),
(12, 1, 'Running', 'Continuous', 'Run continuously. (2 mins)', '5:00'),
(13, 2, 'Running', 'Hill Run\r\n', 'Run up and down a hill continuously. (10 mins)\r\n', '5:00'),
(14, 2, 'Running', 'Kick Back', 'Perform back kicks while running. (10 mins)', '5:00'),
(15, 2, 'Running', 'Running Jog', 'Jog/Run at a stable pace. (20 mins)', '5:00'),
(16, 3, 'Running', 'Alternating Movement', 'Perform running and jogging alternately. (30 mins)', '5:00'),
(17, 3, 'Running', 'Sprinting', 'Run continuously with proper posture. (30 mins)', '5:00'),
(18, 3, 'Running', 'Traffic Run', 'Perform agility running using cones. (20 mins)', '5:00'),
(19, 1, 'Shooting', 'Close Shot', 'Perform 10 shots with proper leg positioning near the paint', '15'),
(20, 1, 'Shooting', 'Catch Shoot', 'Perform 10 shots in a catch-and-shoot stance near the paint\r\n', '15'),
(21, 1, 'Shooting', 'Basic Finish', 'Perform 10 basic layup shots\r\n', '15'),
(22, 2, 'Shooting', 'Mid Range', 'Perform 25 shots with proper leg positioning free throw/mid range\r\n', '15'),
(23, 2, 'Shooting', 'Mid Jumper', 'Perform 25 shots in a catch-and-shoot stance free throw/mid range', '15'),
(24, 2, 'Shooting', 'Reverse Finish', 'Perform 25 reverse-layup shots', '15'),
(25, 3, 'Shooting', 'Long Range', 'Perform 50 shots with proper leg positioning in the mid/three point range\r\n', '15'),
(26, 3, 'Shooting', 'Quick Release', 'Perform 50 shots in a catch-and-shoot stance in the mid/three point range\r\n', '15'),
(27, 3, 'Shooting', 'Weak Hand', 'Perform 50 off-hand layup shots\r\n', '15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
