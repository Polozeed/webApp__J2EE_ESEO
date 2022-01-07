--
-- Base de données : `vente_en_ligne`
--
CREATE DATABASE vente_en_ligne;
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
  `adresse_livraison` varchar(100) NOT NULL,
  `est_bloque` tinyint(1) DEFAULT NULL,
  `token` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DELETE FROM `client`;
INSERT INTO `client` (`id_client`, `login`, `mdp`, `nom`, `prenom`, `mail`, `adresse_livraison`, `est_bloque`, `token`) VALUES
(1, 'pouplama', '1234', 'Pouplain', 'Maxime', 'maxime.pouplain@reseau.eseo.fr', '32 rue de Belgique Angers 49000', 0, 'abc'),
(2, 'martin', 'martin', 'Courier de mere', 'Martin', 'martin.courierdemere@reseau.eseo.fr', '62 rue de Boisdenier Tours 37000', 0, 'def'),
(3, 'Polozed', '1234', 'Berranger', 'louis', 'louisdebrranger@gmail.com', '42 Avenue Pasteur Angers 490000', 1, NULL),
(4, 'Zinzin', 'ki', 'Antoine', 'legendre', 'antoine-legendre@gmail.com', '37 Avenue de Grammont Vannes 56000', 0, NULL),
(5, 'MLeboss', 'zeze', 'Nolwen', 'leroy', 'nolwen_leroy_72@gmail.com', '45 rue Zinédine Zidane Paris 72000 ', 0, NULL),
(6, 'Antoine47', 'aaaa', 'Corneau', 'antoine', 'antoineCorneau@hotmail.com', '22 Rue Réné Paris 72000 ', 0, NULL),
(7, 'Maxime175', 'aaaa', 'Delatour', 'Maxime', 'martincourierdemere@reseau.eseo.fr', '12 impasse de la pucelle Angers 49000', 0, NULL),
(8, 'JohnnyDansMonCoeur', 'Haliday', 'Johnny', 'martin', 'johHaliday@amerique.com', '64 Avenue de la soif Rennes 74100', 0, NULL),
(9, 'Fredo', 'fred', 'Lemarie', 'frederique', 'frederique_lemarie@orange.com', '89 Avenue de la Réplublique 72100 Paris', 0, NULL);

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

DELETE FROM `produit`;
INSERT INTO `produit` (`id_produit`, `nom`, `prix`, `categorie`, `quantite`, `en_tendance`, `image`) VALUES
(1, 'One plus ', '1800', 'Telephones', 5, 'oui', 'img/oneplus-6.jpg'),
(2, 'Iphone X', '2000', 'Telephones', 3, 'oui', 'img/iphone-x.jpeg'),
(3, 'Pocophone F1', '2000', 'Telephones', 4, 'oui', 'img/pocophone-f1.jpg'),
(4, 'Samsung S9', '1200', 'Telephones', 54, 'non', 'img/samsung-s9.jpg'),
(5, 'Macbook Air', '1200', 'Ordinateurs portables', 0, 'oui', 'img/macbook-air.jpg'),
(6, 'Asus Rog', '3200', 'Ordinateurs portables', 1, 'oui', 'img/asus-rog.jpg'),
(7, 'HP Pavilion', '900', 'Ordinateurs portables', 1, 'oui', 'img/hp-pavilion.png'),
(8, 'Acer Predator', '1600', 'Ordinateurs portables', 0, 'oui', 'img/acer-predator.jpg'),
(9, 'Jeans', '75', 'Vetements', 10, 'non', 'img/jeans.jpg'),
(10, 'Shirts', '60', 'Vetements', 10, 'non', 'img/shirts.jpg'),
(11, 'T-Shirt', '40', 'Vetements', 25, 'non', 'img/t-shirt.jpg'),
(12, 'Sweatshirt', '55', 'Vetements', 8, 'oui', 'img/sweatshirt.jpg'),
(13, 'Arduino', '12', 'Electronique', 12, 'non', 'img/arduino.jpg'),
(14, 'Camera CSI', '24', 'Electronique', 15, 'non', 'img/camera.jpg'),
(18, 'Cable ethernet', '4', 'Electronique', 35, 'non', 'img/ethernet.jpg'),
(20, 'Pull Eseo', '35', 'Vetements', 200, 'oui', 'img/pullEseo.jpg'),
(21, 'Maillot SCO', '40', 'Vetements', 7, 'oui', 'img/scoPull.jpg'),
(22, 'Maillot Duc', '35', 'Vetements', 2, 'oui', 'img/ducAngers.png'),
(23, 'Carte Wifi', '4', 'Electronique', 10, 'non', 'img/wifi.jpg'),
(24, 'Rapsberry PI', '4', 'Electronique', 7, 'non', 'img/raspberry.jpg');


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
(2, '2021-11-16 23:30:00', 2, 3, 1),
(3, '2021-11-16 19:15:00', 1, 4, 3),
(4, '2021-11-16 16:00:00', 1, 1, 2),
(5, '2021-11-16 17:30:00', 2, 3, 1),
(6, '2021-11-16 19:15:00', 1, 4, 3),
(7, '2021-12-14 16:10:00', 1, 1, 2),
(8, '2021-12-13 17:30:00', 1, 8, 1),
(9, '2021-11-18 22:23:00', 1, 9, 1),
(10, '2021-11-23 16:22:00', 1, 11, 1),
(11, '2021-11-27 21:21:00', 2, 3, 1),
(12, '2021-11-8 15:10:00', 1, 14, 1);

COMMIT;
