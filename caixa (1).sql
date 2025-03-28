-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 28-Mar-2025 às 03:50
-- Versão do servidor: 5.7.25
-- versão do PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `caixa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`id`, `data`, `descricao`, `valor`, `tipo`) VALUES
(1, '2025-03-28', 'oi', 100, 1),
(2, '2025-03-26', 'testeAmem', 100, 1),
(3, '2025-03-20', 'coxinha', 20, 0),
(4, '2025-03-27', 'ola', 10, 0),
(6, '2025-03-27', '2', 30, 1),
(7, '2025-03-27', 'oi', 30, 0),
(8, '2025-03-27', 'oi', 30, 0),
(9, '2025-03-27', 'oi', 30, 0),
(10, '2025-03-01', 'teste 3', 200, 1),
(11, '2025-03-27', 'teste 4', 30, 0),
(12, '2025-03-27', 'h', 0.01, 0),
(13, '2025-03-27', 'teste que vai dar certo', 10000, 1),
(14, '2025-03-27', 'teste que vai dar certo', 10000, 1),
(15, '2025-03-27', 'teste que vai dar certo', 10000, 1),
(16, '2025-03-27', 'teste que vai dar certo', 10000, 1),
(17, '2025-03-27', 'a', 0.1, 0),
(18, '2025-03-27', 'chega', 10, 0),
(19, '2025-03-27', 'gbn', 0, 0),
(20, '2025-03-27', 'chegaaaaaaaaa', 9999999, 1),
(21, '2025-03-27', 'chegaaaaaaaaa', 9999999, 1),
(22, '2025-03-27', 'parooo', 99, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
