-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 25 Des 2024 pada 13.42
-- Versi Server: 5.5.32
-- Versi PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `objek_wisata_db`
--
CREATE DATABASE IF NOT EXISTS `objek_wisata_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `objek_wisata_db`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `objek_wisata`
--

CREATE TABLE IF NOT EXISTS `objek_wisata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `lokasi` varchar(150) DEFAULT NULL,
  `harga_tiket` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data untuk tabel `objek_wisata`
--

INSERT INTO `objek_wisata` (`id`, `nama`, `lokasi`, `harga_tiket`) VALUES
(1, 'Puncak Tahura Sultan Adam', 'Mandiangin, Tahura Sultan Adam', 17000),
(2, 'Villa Belanda', 'Mandiangin, Tahura Sultan Adam', 450000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_objek_wisata` int(11) DEFAULT NULL,
  `jumlah_tiket` int(11) DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_objek_wisata` (`id_objek_wisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `id_objek_wisata`, `jumlah_tiket`, `total_harga`) VALUES
(1, 2, 1, 450000),
(2, 1, 5, 85000),
(3, 1, 2, 34000),
(4, 2, 5, 2250000),
(5, 2, 10, 4500000);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_objek_wisata`) REFERENCES `objek_wisata` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
