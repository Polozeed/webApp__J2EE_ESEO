-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 16 déc. 2021 à 12:40
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vente_en_ligne`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) NOT NULL,
  `mdp` varchar(30) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `adresse_livraison` varchar(30) NOT NULL,
  `est_bloque` tinyint(1) DEFAULT NULL,
  `token` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `client` (`id_client`, `login`, `mdp`, `nom`, `prenom`, `mail`, `adresse_livraison`, `est_bloque`, `token`) VALUES
(1, 'pouplama', '1234', 'Maxime', 'Pouplain', 'maxime.pouplain@reseau.eseo.fr', 'Angers', 0, 'abc'),
(2, 'martin', 'martin', 'Martin', 'Courier de Mere', 'martin.courierdemere@reseau.eseo.fr', 'Tours 62 rue de Boisdenier', 0, 'def'),
(3, 'martin Courier de mere', 'bvc', 'vcvbvc', 'vcvbvc', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(4, 'martin Courier de mere', 'ki', 'kk', 'kk', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(5, 'polo', 'zeze', 'polozed', 'polozed', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(6, 'martin Courier de mere', 'AAAA', 'test14', 'test14', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(7, 'martin Courier de mere', 'aaaa', 'polozed', 'polozed', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(8, 'martin Courier de mere', 'rrrr', 'martin', 'martin', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL),
(9, 'zed', 'qqqq', 'race', 'race', 'martincourierdemere@gmail.com', '62 rue de boisdenier', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prix` varchar(50) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `quantite` int(8) NOT NULL,
  `en_tendance` varchar(4) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `produit` (`id_produit`, `nom`, `prix`, `categorie`, `quantite`, `en_tendance`, `image`) VALUES
(1, 'One plus ', '1800', 'mobiles', 5, 'oui', 'img/oneplus-6.jpg'),
(2, 'Iphone X', '2000', 'mobiles', 3, 'oui', 'img/iphone-x.jpeg'),
(3, 'Pocophone F1', '2000', 'mobiles', 4, 'oui', 'img/pocophone-f1.jpg'),
(4, 'Samsung S9', '1200', 'mobiles', 54, 'non', 'img/samsung-s9.jpg'),
(5, 'Macbook Air', '1200', 'laptops', 0, 'oui', 'img/macbook-air.jpg'),
(6, 'Asus Rog', '3200', 'laptops', 1, 'oui', 'img/asus-rog.jpg'),
(7, 'HP Pavilion', '900', 'laptops', 1, 'oui', 'img/hp-pavilion.png'),
(8, 'Acer Predator', '1600', 'laptops', 0, 'oui', 'img/acer-predator.jpg'),
(9, 'Jeans', '75', 'clothing', 10, 'non', 'img/jeans.jpg'),
(10, 'Shirts', '60', 'clothing', 10, 'non', 'img/shirts.jpg'),
(11, 'T-Shirt', '40', 'clothing', 25, 'non', 'img/t-shirt.jpg'),
(12, 'Sweatshirt', '55', 'clothing', 8, 'oui', 'img/sweatshirt.jpg'),
(13, 'Arduino', '12', 'electronique', 12, 'non', 'img/arduino.jpg'),
(14, 'Camera CSI', '24', 'electronique', 15, 'non', 'img/camera.jpg'),
(18, 'Cable ethernet', '4', 'electronique', 35, 'non', 'img/ethernet.jpg'),
(20, 'Pull Eseo', '35', 'clothing', 200, 'oui', 'img/pullEseo.jpg'),
(21, 'Maillot SCO', '40', 'clothing', 7, 'yes', 'img/scoPull.jpg'),
(22, 'Maillot Duc', '35', 'clothing', 2, 'yes', 'img/ducAngers.png'),
(23, 'Carte Wifi', '4', 'electronique', 10, 'non', 'img/wifi.jpg'),
(24, 'Rapsberry PI', '4', 'electronique', 7, 'non', 'img/raspberry.jpg');


-- --------------------------------------------------------

--
-- Structure de la table `historique_commande`
--

DROP TABLE IF EXISTS `historique_commande`;
CREATE TABLE IF NOT EXISTS `historique_commande` (
  `id_hist_commande` int(11) NOT NULL AUTO_INCREMENT,
  `dateheure` datetime NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (id_hist_commande),
  CONSTRAINT FK_304 FOREIGN KEY (id_client) REFERENCES client (id_client),
  CONSTRAINT FK_305 FOREIGN KEY (id_produit) REFERENCES produit (id_produit)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `historique_commande` (`id_hist_commande`, `dateheure`, `id_client`, `id_produit`, `quantite`) VALUES
(1, '2021-11-16 16:00:00', 1, 1, 2),
(2, '2021-11-16 17:30:00', 2, 3, 1),
(3, '2021-11-16 15:15:00', 1, 4, 3);

COMMIT;
