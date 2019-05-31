-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 31 mai 2019 à 17:49
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `club`
--

-- --------------------------------------------------------

--
-- Structure de la table `abscence`
--

DROP TABLE IF EXISTS `abscence`;
CREATE TABLE IF NOT EXISTS `abscence` (
  `nom` varchar(20) NOT NULL,
  `dateAbscence` varchar(20) NOT NULL,
  `raison` varchar(20) NOT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `abscence`
--

INSERT INTO `abscence` (`nom`, `dateAbscence`, `raison`, `id`) VALUES
('zayd', '4-05-2019', 'Malade', 1),
('mami', '7-05-2019', 'Malade', 2);

-- --------------------------------------------------------

--
-- Structure de la table `comptabilité`
--

DROP TABLE IF EXISTS `comptabilité`;
CREATE TABLE IF NOT EXISTS `comptabilité` (
  `id_compta` int(11) NOT NULL AUTO_INCREMENT,
  `charge` varchar(20) NOT NULL,
  `montant_charge` varchar(30) NOT NULL,
  PRIMARY KEY (`id_compta`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptabilité`
--

INSERT INTO `comptabilité` (`id_compta`, `charge`, `montant_charge`) VALUES
(1, 'transport', '31000dh');

-- --------------------------------------------------------

--
-- Structure de la table `comptaproduit`
--

DROP TABLE IF EXISTS `comptaproduit`;
CREATE TABLE IF NOT EXISTS `comptaproduit` (
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `produit` varchar(20) NOT NULL,
  `montant` varchar(30) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptaproduit`
--

INSERT INTO `comptaproduit` (`id_produit`, `produit`, `montant`) VALUES
(1, 'credit', '21000dh');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `image` longblob NOT NULL,
  `a_propos` varchar(200) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_event`, `image`, `a_propos`) VALUES

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id_membre` int(50) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `role` varchar(200) DEFAULT NULL,
  `password` int(10) NOT NULL,
  PRIMARY KEY (`id_membre`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`id_membre`, `login`, `nom`, `prenom`, `email`, `role`, `password`) VALUES
(2, 'zayd123', 'zayd', 'mami', 'zaydmami@gmail.com', 'Membre', 0),
(3, 'houda', 'houda', 'makhchoune', 'hzefz@gmail.com', 'Membre', 0),
(9, 'kbi', 'ugàoui', 'gugoçu', 'ugouh', 'ljou', 0),
(6, 'zayd@hotmail.fr', 'mami', 'zayd', 'zayda', 'tresorier', 123);

-- --------------------------------------------------------

--
-- Structure de la table `pv`
--

DROP TABLE IF EXISTS `pv`;
CREATE TABLE IF NOT EXISTS `pv` (
  `id_pv` int(11) NOT NULL,
  `ordre_du_jour` varchar(50) NOT NULL,
  `heure_levee` int(11) NOT NULL,
  `resume` varchar(100) NOT NULL,
  `signature` varchar(10) NOT NULL,
  `AnimReunion` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pv`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pv`
--

INSERT INTO `pv` (`id_pv`, `ordre_du_jour`, `heure_levee`, `resume`, `signature`, `AnimReunion`) VALUES
(1, 'gestionetu', 2, 'dd', 'zayd', 'zayd');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;