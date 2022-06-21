-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2022 at 04:18 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pet_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(3) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '12345678'),
(3, 'admin1', 'qwertyui');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(5) NOT NULL,
  `id_pembeli` int(5) NOT NULL,
  `id_product` int(5) NOT NULL,
  `quantity` int(5) NOT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cek_transaksi`
--

CREATE TABLE `cek_transaksi` (
  `id` int(11) NOT NULL,
  `id_pembeli` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `kuantiti` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cek_transaksi`
--

INSERT INTO `cek_transaksi` (`id`, `id_pembeli`, `id_produk`, `timestamp`, `kuantiti`, `harga`, `status`) VALUES
(84, 2, 2, '2022-06-20 12:46:46', 3, 225000, 'menunggu pembayaran');

-- --------------------------------------------------------

--
-- Table structure for table `hewan`
--

CREATE TABLE `hewan` (
  `id` int(5) NOT NULL,
  `id_pembeli` int(5) NOT NULL,
  `nama` varchar(15) NOT NULL,
  `tahun_lahir` int(4) NOT NULL,
  `jenis` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hewan`
--

INSERT INTO `hewan` (`id`, `id_pembeli`, `nama`, `tahun_lahir`, `jenis`) VALUES
(1, 1, 'belang', 2011, 'kucing'),
(2, 1, 'blackie', 2014, 'Anjing'),
(5, 2, 'mueza', 2021, 'Kucing'),
(6, 2, 'marshall', 2010, 'Anjing');

-- --------------------------------------------------------

--
-- Table structure for table `history_grooming`
--

CREATE TABLE `history_grooming` (
  `id` int(11) NOT NULL,
  `id_pembeli` int(11) NOT NULL,
  `id_hewan` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `jam` datetime NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history_grooming`
--

INSERT INTO `history_grooming` (`id`, `id_pembeli`, `id_hewan`, `timestamp`, `jam`, `harga`) VALUES
(1, 1, 1, '2021-12-22 05:52:16', '2021-12-22 06:51:58', 50000),
(2, 1, 2, '2021-12-22 05:52:16', '2021-12-22 06:51:58', 50000),
(3, 2, 6, '2021-12-27 06:00:01', '2021-12-27 10:00:00', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `history_penitipan`
--

CREATE TABLE `history_penitipan` (
  `id` int(5) NOT NULL,
  `id_pembeli` int(5) NOT NULL,
  `id_hewan` int(5) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `lama_penitipan` int(4) NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history_penitipan`
--

INSERT INTO `history_penitipan` (`id`, `id_pembeli`, `id_hewan`, `timestamp`, `lama_penitipan`, `harga`) VALUES
(1, 1, 1, '2021-12-22 05:46:12', 7, 90000),
(2, 1, 2, '2021-12-22 05:46:12', 14, 180000),
(3, 2, 6, '2021-12-23 13:30:56', 3, 75000),
(4, 2, 5, '2021-12-27 05:59:16', 3, 75000),
(5, 2, 5, '2022-06-15 15:56:27', 4, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(3) NOT NULL,
  `id_pembeli` int(5) NOT NULL,
  `status` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `id` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `telp` varchar(13) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`id`, `username`, `password`, `nama`, `telp`, `alamat`) VALUES
(1, 'shiro', '12345678', 'Arvia Dwi Cahyani', '082189432748', 'Jalan Cipanas No.4 Desa Pagerageung Kec. Cipanas Kab. Cianjur 64738'),
(2, 'adc', 'qwertyui', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(2) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` int(6) NOT NULL,
  `kategori` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `nama`, `harga`, `kategori`) VALUES
(1, 'Wiskas', 10000, 'Food'),
(2, 'Royal Canin', 75000, 'Food');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_pembeli_cart` (`id_pembeli`),
  ADD KEY `fk_id_product_cart` (`id_product`);

--
-- Indexes for table `cek_transaksi`
--
ALTER TABLE `cek_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_produk_order` (`id_produk`),
  ADD KEY `fk_id_pembeli_order` (`id_pembeli`);

--
-- Indexes for table `hewan`
--
ALTER TABLE `hewan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_pembeli_hewan` (`id_pembeli`) USING BTREE;

--
-- Indexes for table `history_grooming`
--
ALTER TABLE `history_grooming`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_hewan_grooming` (`id_hewan`),
  ADD KEY `fk_id_pembeli_grooming` (`id_pembeli`) USING BTREE;

--
-- Indexes for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_hewan_penitipan` (`id_hewan`),
  ADD KEY `fk_id_pembeli_penitipan` (`id_pembeli`) USING BTREE;

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_pembeli_payment` (`id_pembeli`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cek_transaksi`
--
ALTER TABLE `cek_transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `hewan`
--
ALTER TABLE `hewan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `history_grooming`
--
ALTER TABLE `history_grooming`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_id_pembeli_cart` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`),
  ADD CONSTRAINT `fk_id_product_cart` FOREIGN KEY (`id_product`) REFERENCES `cart` (`id`);

--
-- Constraints for table `cek_transaksi`
--
ALTER TABLE `cek_transaksi`
  ADD CONSTRAINT `fk_id_pembeli_order` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `hewan`
--
ALTER TABLE `hewan`
  ADD CONSTRAINT `fk_id_user_hewan` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`);

--
-- Constraints for table `history_grooming`
--
ALTER TABLE `history_grooming`
  ADD CONSTRAINT `fk_id_hewan_grooming` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id`),
  ADD CONSTRAINT `fk_id_user_grooming` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`);

--
-- Constraints for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  ADD CONSTRAINT `fk_id_hewan_penitipan` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id`),
  ADD CONSTRAINT `fk_id_user_penitipan` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `fk_id_pembeli_payment` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
