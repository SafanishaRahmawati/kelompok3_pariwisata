-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2021 at 05:00 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pariwisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_table`
--

CREATE TABLE `admin_table` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pariwisata_konvensional_table`
--

CREATE TABLE `pariwisata_konvensional_table` (
  `id` int(11) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `deskripsi_wisata` text NOT NULL,
  `lokasi_wisata` varchar(50) NOT NULL,
  `thumb_wisata` varchar(300) NOT NULL,
  `nomor_telfon_wisata` varchar(20) NOT NULL,
  `alamat_wisata` varchar(300) NOT NULL,
  `email_wisata` varchar(100) NOT NULL,
  `nonaktifkan_wisata` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pariwisata_konvensional_table`
--

INSERT INTO `pariwisata_konvensional_table` (`id`, `nama_wisata`, `deskripsi_wisata`, `lokasi_wisata`, `thumb_wisata`, `nomor_telfon_wisata`, `alamat_wisata`, `email_wisata`, `nonaktifkan_wisata`) VALUES
(1, 'Wisata Pasar Bawah 12', 'Kalau bingung mencari oleh-oleh di Pekanbaru, datang saja ke Pasar Bawah. Pasar Bawah merupakan pasar tertua di Pekanbaru. Lokasinya berada tepat di sisi Sungai Siak dan pelabuhan', '0.5379612, 101.44361', 'https://sgp1.digitaloceanspaces.com/tz-mag-id/wp-content/uploads/2018/08/111108084141/tempat-wisata-pekanbaru-8-819x1024.jpg', '082285173200', 'Toko keramik khayangan Jl. Saleh Abbas lt.1 blok N no.7 Pasar wisata pasar bawah, Kp. Dalam, Kec. Se', 'dinaspariwisata@riau.co.id', '0'),
(2, 'Wisata Taman Bunga Okura', 'Begitu memasuki taman ini, mata BroSis akan disegarkan dengan aneka bunga yang tertata rapi dan berwarna-warni. Yap, ini adalah Taman Bunga Impian Okura, lokasinya di Tebing Tinggi Okura, Rumbai Pesisir. Mulai dibuka untuk umum sejak April 2017. Dulunya merupakan lahan kosong pribadi, lalu dimanfaatkan oleh warga sekitar dengan ditanami aneka bunga yang menarik', '0.5773934,101.5311478', 'https://www.brosispku.com/assets/imgbank/03092018/brosispku_fdp43_1033.jpg', '0852-6521-3650', 'Tebing Tinggi Okura, Kec. Rumbai Pesisir, Kota Pekanbaru, Riau 28285', '-', '1'),
(3, 'Wisata Danau Bandar Kayangan', 'Danau Wisata Bandar Kayangan diresmikan oleh Wali Kota Pekanbaru pada tahun 2011. \\nFYI, tidak ada pungutan biaya masuk', '0.5838685,101.4716577', 'https://3.bp.blogspot.com/-8146TJ1qofc/WCfx-BcStWI/AAAAAAAAALE/eHwyS46hmuQoK78eA6jfboFYB_MbkpxjgCLcB/s1600/IMG_8233.JPG', '-', 'Lembah Sari, Kec. Rumbai Pesisir, Kota Pekanbaru', '-', '1');

-- --------------------------------------------------------

--
-- Table structure for table `restoran`
--

CREATE TABLE `restoran` (
  `id` int(11) NOT NULL,
  `nama_restoran` varchar(50) NOT NULL,
  `deskripsi_restoran` text NOT NULL,
  `lokasi_restoran` varchar(50) NOT NULL,
  `thumb_restoran` text NOT NULL,
  `nomor_telfon_restoran` varchar(20) NOT NULL,
  `alamat_restoran` varchar(300) NOT NULL,
  `email_restoran` varchar(100) NOT NULL,
  `nonaktifkan_restoran` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restoran`
--

INSERT INTO `restoran` (`id`, `nama_restoran`, `deskripsi_restoran`, `lokasi_restoran`, `thumb_restoran`, `nomor_telfon_restoran`, `alamat_restoran`, `email_restoran`, `nonaktifkan_restoran`) VALUES
(1, 'Restoran Koki Sunda', 'Anda yang ingin merasakan masakan Sunda bisa datang ke Koki Sunda. Tempat kuliner yang satu ini merupakan salah satu restoran khas Sunda yang terkenal di Pekanbaru. Soal citarasa tidak perlu diragukan lagi, sama persis dengan masakan Sunda yang Jawa Barat.\\r\\nMenu lain nya yang bisa Anda pesan adalah nasi timbal, ayam goreng spesial, sayur asem, sambal teri kacang, tempe bacem, ikan asin dan masih banyak lagi lain nya.', '0.4931911,101.4446054', 'https://alexandramar.files.wordpress.com/2017/03/koki-sunda.jpg', '-', 'Jl. Jenderal Sudirman, Tengkerang Tengah, Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28125', '-', '0'),
(2, 'Restoran Pondok Patin HM Yunus', 'Rumah makan langganan para wisatawan dan para pejabat ini memang memiliki kekhasan menu makanan dalam penyajiannya.', '0.4611439,101.4499607', 'https://kulinerpku.files.wordpress.com/2019/02/20190113_141611-03.jpeg', '08127674226', 'Jl. Kopkar Raya, Pandau Jaya, Kec. Siak Hulu, Kabupaten Kampar, Riau 28284', '-', '1');

-- --------------------------------------------------------

--
-- Table structure for table `wisata_religi`
--

CREATE TABLE `wisata_religi` (
  `id` int(11) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `deskripsi_wisata` text NOT NULL,
  `lokasi_wisata` varchar(50) NOT NULL,
  `thumb_wisata` text NOT NULL,
  `nomor_telfon_wisata` varchar(20) NOT NULL,
  `alamat_wisata` varchar(300) NOT NULL,
  `email__wisata` varchar(100) NOT NULL,
  `nonaktifkan_wisata` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wisata_religi`
--

INSERT INTO `wisata_religi` (`id`, `nama_wisata`, `deskripsi_wisata`, `lokasi_wisata`, `thumb_wisata`, `nomor_telfon_wisata`, `alamat_wisata`, `email__wisata`, `nonaktifkan_wisata`) VALUES
(1, 'Wisata Mesjid Agung An-Nur', 'Bagi anda yang berada di Pekanbaru, tidak lengkap rasanya jika tidak berwisata religi ke Masjid Agung An-Nur Provinsi Riau', '0.526663,101.450854', 'https://www.brosispku.com/assets/news/22122017/brosispku_8wldy_65.jpg', '-', 'Jl. Hang Tuah, Sumahilang, Kec. Pekanbaru Kota, Kota Pekanbaru, Riau', '-', '1'),
(2, 'Mesjid Raya Senapelan Pekanabru', 'Masjid yang diberi nama “Senapelan” ini merupakan masjid yang dibangun sekitar abad ke-18, atau sekitar tahun 1762 Masehi. Pada masa pembangunannya adalah pada masa pemerintahan Sultan Abdul Jalil Alamuddin Syah, dilanjutkan pada kekuasaan Sultan Muhammad Ali Abdul Jalil Muazzam Syah', '0.5379933,101.4247033', 'https://www.halloriau.com/foto_berita/85Masjid%20Raya.jpg?wid=54&w=650&v=1&t=jpeg', '08127528661', 'Jl. Senapelan No.128, Kp. Bandar, Kec. Senapelan, Kota Pekanbaru, Riau 28155', '-', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pariwisata_konvensional_table`
--
ALTER TABLE `pariwisata_konvensional_table`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
