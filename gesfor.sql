-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Sam 31 Mai 2014 à 20:41
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gesfor`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `login` varchar(30) NOT NULL,
  `pswd` varchar(30) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`login`, `pswd`) VALUES
('gestioncentre', 'gesforpfe');

-- --------------------------------------------------------

--
-- Structure de la table `attestation`
--

CREATE TABLE IF NOT EXISTS `attestation` (
  `id_attestation` int(11) NOT NULL AUTO_INCREMENT,
  `cin_etudiant` int(8) NOT NULL,
  `projet` varchar(50) NOT NULL,
  PRIMARY KEY (`id_attestation`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `attestation`
--

INSERT INTO `attestation` (`id_attestation`, `cin_etudiant`, `projet`) VALUES
(1, 12345678, 'projet java gestion stock'),
(2, 13447961, 'projet php4 gestion paie'),
(3, 13414529, 'projet java gestion stock');

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE IF NOT EXISTS `caisse` (
  `id_paiement` int(11) NOT NULL,
  `id_form` int(11) NOT NULL,
  `prix_total` int(11) NOT NULL,
  `montant_recu` int(11) NOT NULL,
  `montant _rester` int(11) NOT NULL,
  PRIMARY KEY (`id_paiement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `depenses`
--

CREATE TABLE IF NOT EXISTS `depenses` (
  `id_depense` int(11) NOT NULL AUTO_INCREMENT,
  `libele` varchar(30) NOT NULL,
  `montant` int(7) NOT NULL,
  `benificiaire` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_depense`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `depenses`
--

INSERT INTO `depenses` (`id_depense`, `libele`, `montant`, `benificiaire`, `date`) VALUES
(1, 'électricité', 30000, 'steg', '2014-04-26'),
(3, 'location', 250000, 'Mr Ali', '2014-04-28'),
(4, 'Eau', 30000, 'soned', '2014-04-26');

-- --------------------------------------------------------

--
-- Structure de la table `diplome`
--

CREATE TABLE IF NOT EXISTS `diplome` (
  `id_dip` int(11) NOT NULL AUTO_INCREMENT,
  `cin_etudiant` int(8) NOT NULL,
  `type_formation` varchar(3) NOT NULL,
  `nom_formation` varchar(40) NOT NULL,
  `niveau` varchar(30) NOT NULL,
  `date_obtention` date NOT NULL,
  PRIMARY KEY (`id_dip`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `diplome`
--

INSERT INTO `diplome` (`id_dip`, `cin_etudiant`, `type_formation`, `nom_formation`, `niveau`, `date_obtention`) VALUES
(1, 12345678, 'FCT', 'formation android', 'niveau 1', '2014-05-26'),
(2, 12345678, 'FCO', 'formation informatique', 'niveau 1', '2014-05-26'),
(3, 13447961, 'FCO', 'formation informatique', 'niveau 1', '2014-05-27'),
(4, 13447961, 'FCT', 'formation android', 'niveau 1', '2014-05-29');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `cin_etudiant` int(8) NOT NULL,
  `groupe` varchar(30) DEFAULT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `date_naiss` date NOT NULL,
  `niveau` varchar(40) NOT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `num_tel` int(8) NOT NULL,
  PRIMARY KEY (`cin_etudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`cin_etudiant`, `groupe`, `nom`, `prenom`, `date_naiss`, `niveau`, `mail`, `num_tel`) VALUES
(12345678, 'groupe1', 'aloui', 'ali', '1991-05-23', '1 ère année', 'aloui.ali@gmail.com', 25963258),
(13254785, 'groupe1', 'ayachi', 'lobna', '1991-05-24', '1 ère année', 'lobna.ayachi@gmail.com', 25963183),
(13414529, 'groupe1', 'addali', 'riadh', '1991-05-21', '3ème année superieur', 'ridh.add@hotmail.fr', 24509516),
(13414795, 'groupe1', 'addali', 'issra', '1991-05-05', '1ère année superieur', 'issra.add@hotmail.fr', 21774523),
(13447348, 'groupe1', 'aloui', 'iyad', '1994-08-10', '1ère année superieur', 'ayouda2013@hotmail.fr', 25124796),
(13447742, 'groupe1', 'aloui', 'wahid', '1994-05-07', '1ère année superieur', 'wahid2013@hotmail.fr', 25123456),
(13447756, 'groupe1', 'askri', 'wahid', '1994-05-07', '1ère année superieur', 'wahid2013@hotmail.fr', 25445585),
(13447961, 'groupe1', 'askri', 'rachida', '1994-12-07', '1ère année superieur', 'askrirach2013@hotmail.fr', 25933900),
(14785236, 'groupe1', 'zaabi', 'sofien', '1991-05-06', '1 ère année', 'sofie.sofien@gmail.com', 25874136),
(14785276, 'groupe1', 'zaabi', 'mabrouk', '1991-05-17', '1 ère année', 'mabrouk2013@gmail.com', 25852741),
(14785279, 'groupe1', 'berrajeh', 'akrem', '1991-11-08', '1 ère année', 'akrem.21@gmail.com', 23456852),
(14785963, 'groupe1', 'jmal', 'ikram', '1991-06-05', '1 ère année', 'jmal.ikram@gmail.com', 25874189),
(14787125, 'groupe1', 'othmani', 'imen', '1991-12-29', '1 ère année', 'imen.imen@gmail.com', 25872466),
(14787721, 'groupe1', 'maaloul', 'ayda', '1991-09-06', '1 ère année', 'm.ayda.12@gmail.com', 258789652),
(14787753, 'groupe1', 'germazi', 'mohammed', '1991-12-03', '1 ère année', 'germazi.moh@gmail.com', 258789652);

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE IF NOT EXISTS `formateur` (
  `cin_formateur` int(8) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `num_tel` int(8) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  PRIMARY KEY (`cin_formateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `formateur`
--

INSERT INTO `formateur` (`cin_formateur`, `nom`, `prenom`, `num_tel`, `adresse`, `mail`) VALUES
(13415429, 'addali', 'riadh', 21773520, 'Sfax_route_tunis', 'riadh.add@gmail.com'),
(13415859, 'said', 'wassim', 22458135, 'Sfax_route_tunis', 'wassolem3allem@gmail.com'),
(13417713, 'aloui', 'zied', 25933900, 'Sfax_route_tunis', 'aloui.zied.1991@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `formation_co`
--

CREATE TABLE IF NOT EXISTS `formation_co` (
  `id_form` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` varchar(50) NOT NULL,
  `nom_formation` varchar(40) NOT NULL,
  `prix_par_mois` int(6) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_form`),
  KEY `id_formateur` (`niveau`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `formation_co`
--

INSERT INTO `formation_co` (`id_form`, `niveau`, `nom_formation`, `prix_par_mois`, `date_debut`, `date_fin`) VALUES
(1, 'niveau 1', 'formation informatique', 200000, '2013-09-15', '2014-05-10'),
(2, 'niveau 1', 'formation anglais', 150000, '2014-05-03', '2014-07-03');

-- --------------------------------------------------------

--
-- Structure de la table `formation_ct`
--

CREATE TABLE IF NOT EXISTS `formation_ct` (
  `id_form` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` varchar(40) NOT NULL,
  `nom_formation` varchar(40) NOT NULL,
  `matiere` varchar(30) NOT NULL,
  `cin_formateur` int(8) NOT NULL,
  `nb_heures` int(3) NOT NULL,
  `prix_heure` int(6) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY (`id_form`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `formation_ct`
--

INSERT INTO `formation_ct` (`id_form`, `niveau`, `nom_formation`, `matiere`, `cin_formateur`, `nb_heures`, `prix_heure`, `date_debut`, `date_fin`) VALUES
(1, 'niveau 1', 'formation android', 'ajax', 13415429, 20, 9000, '2014-05-01', '2014-06-01'),
(2, 'niveau 1', 'formation php5', 'php5', 13415429, 20, 8000, '2014-05-01', '2014-06-01'),
(3, 'niveau 2', 'formation android', 'php5', 13415429, 15, 8000, '2014-05-01', '2014-06-01');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `id_groupe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_groupe` varchar(30) NOT NULL,
  PRIMARY KEY (`id_groupe`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`id_groupe`, `nom_groupe`) VALUES
(1, 'groupe1'),
(2, 'groupe2'),
(3, 'groupe3'),
(4, 'groupe4'),
(5, 'groupe5');

-- --------------------------------------------------------

--
-- Structure de la table `heures_enseignee`
--

CREATE TABLE IF NOT EXISTS `heures_enseignee` (
  `id_formation` int(11) NOT NULL,
  `matiere` varchar(30) NOT NULL,
  `cin_formateur` int(8) NOT NULL,
  `nbheures_par_mois` int(3) NOT NULL,
  `coeffecient` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `heures_enseignee`
--

INSERT INTO `heures_enseignee` (`id_formation`, `matiere`, `cin_formateur`, `nbheures_par_mois`, `coeffecient`) VALUES
(1, 'ajax', 13415429, 10, 2),
(1, 'algorithme', 13415859, 10, 3);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` int(11) NOT NULL AUTO_INCREMENT,
  `type_formation` varchar(3) NOT NULL,
  `formation` varchar(40) NOT NULL,
  `niveau` varchar(40) NOT NULL,
  `cin_etudiant` int(8) NOT NULL,
  `montant_payer` int(6) NOT NULL,
  `montant_reste` int(6) NOT NULL,
  `date_inscription` date NOT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `id_form` (`formation`,`cin_etudiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `type_formation`, `formation`, `niveau`, `cin_etudiant`, `montant_payer`, `montant_reste`, `date_inscription`) VALUES
(1, 'FCT', 'formation android', 'niveau 1', 12345678, 20000, 160000, '2014-05-20'),
(2, 'FCT', 'formation android', 'niveau 1', 13447756, 120000, 60000, '2014-05-21'),
(3, 'FCT', 'formation android', 'niveau 1', 14785236, 120000, 60000, '2014-05-21'),
(4, 'FCT', 'formation android', 'niveau 1', 13447961, 120000, 60000, '2014-05-21'),
(5, 'FCT', 'formation android', 'niveau 1', 13447742, 120000, 60000, '2014-05-21'),
(6, 'FCT', 'formation android', 'niveau 1', 14785276, 120000, 60000, '2014-05-21'),
(7, 'FCT', 'formation android', 'niveau 1', 14785279, 120000, 60000, '2014-05-21'),
(8, 'FCT', 'formation android', 'niveau 1', 14787412, 120000, 60000, '2014-05-21'),
(9, 'FCT', 'formation android', 'niveau 1', 14785963, 120000, 60000, '2014-05-21'),
(10, 'FCT', 'formation android', 'niveau 1', 14787753, 120000, 60000, '2014-05-21'),
(11, 'FCT', 'formation android', 'niveau 1', 14787721, 120000, 60000, '2014-05-21'),
(12, 'FCT', 'formation android', 'niveau 1', 13414795, 120000, 60000, '2014-05-21'),
(13, 'FCT', 'formation android', 'niveau 1', 14787125, 120000, 60000, '2014-05-21'),
(14, 'FCT', 'formation android', 'niveau 1', 13447348, 120000, 60000, '2014-05-21'),
(15, 'FCT', 'formation android', 'niveau 1', 13254785, 120000, 60000, '2014-05-21');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `id_matiere` int(2) NOT NULL AUTO_INCREMENT,
  `nom_matiere` varchar(30) NOT NULL,
  PRIMARY KEY (`id_matiere`),
  KEY `nom_matiere` (`nom_matiere`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `matiere`
--

INSERT INTO `matiere` (`id_matiere`, `nom_matiere`) VALUES
(2, 'ajax'),
(1, 'algorithme'),
(12, 'Analyse numerique'),
(16, 'android'),
(6, 'anglais'),
(11, 'chemie'),
(7, 'comptabilité'),
(8, 'conception'),
(5, 'francais'),
(14, 'infographie'),
(15, 'language de compilation'),
(3, 'pascal'),
(4, 'php5'),
(10, 'physique'),
(13, 'traitement d''image'),
(9, 'visual basic');

-- --------------------------------------------------------

--
-- Structure de la table `paiement_formateur`
--

CREATE TABLE IF NOT EXISTS `paiement_formateur` (
  `id_paiement` int(11) NOT NULL AUTO_INCREMENT,
  `cin_formateur` int(8) NOT NULL,
  `montant` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_paiement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `paiement_formateur`
--

INSERT INTO `paiement_formateur` (`id_paiement`, `cin_formateur`, `montant`, `date`) VALUES
(1, 13415859, 200000, '2014-04-26'),
(2, 13417713, 100000, '2014-04-27'),
(3, 13417713, 200000, '2014-04-27');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id_projet` int(11) NOT NULL AUTO_INCREMENT,
  `sujet` varchar(100) NOT NULL,
  `cin_formateur` int(8) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY (`id_projet`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `projet`
--

INSERT INTO `projet` (`id_projet`, `sujet`, `cin_formateur`, `date_debut`, `date_fin`) VALUES
(1, 'projet java gestion stock', 13415429, '2014-04-24', '2014-05-24'),
(3, 'projet php4 gestion paie', 13415429, '2014-04-25', '2014-05-24'),
(4, 'projet vb gestion etudiant', 13415429, '2014-04-26', '2014-05-30'),
(5, 'projet vb gestion park', 13415429, '2014-05-29', '2014-06-29');

-- --------------------------------------------------------

--
-- Structure de la table `recette_formation`
--

CREATE TABLE IF NOT EXISTS `recette_formation` (
  `id_paiement` int(11) NOT NULL AUTO_INCREMENT,
  `cin_etudiant` int(8) NOT NULL,
  `id_formation` int(11) NOT NULL,
  `mois` varchar(10) NOT NULL,
  PRIMARY KEY (`id_paiement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `seance_encadrement`
--

CREATE TABLE IF NOT EXISTS `seance_encadrement` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `projet` varchar(50) NOT NULL,
  `cin_etudiant` int(8) NOT NULL,
  `nb_heures` int(2) NOT NULL,
  `prix_heure` int(6) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_seance`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `seance_encadrement`
--

INSERT INTO `seance_encadrement` (`id_seance`, `projet`, `cin_etudiant`, `nb_heures`, `prix_heure`, `date`) VALUES
(1, 'projet java gestion stock', 13414529, 2, 10000, '2014-04-30'),
(2, 'projet php4 gestion paie', 13447961, 2, 10000, '2014-04-30'),
(3, 'projet php4 gestion paie', 13447961, 2, 10000, '2014-05-06'),
(4, 'projet java gestion stock', 12345678, 2, 10000, '2014-05-06');

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE IF NOT EXISTS `tache` (
  `id_tache` int(11) NOT NULL AUTO_INCREMENT,
  `tache` varchar(100) CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `nb_heures` int(2) NOT NULL,
  PRIMARY KEY (`id_tache`),
  KEY `id_forma` (`tache`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `tache`
--

INSERT INTO `tache` (`id_tache`, `tache`, `date`, `heure`, `nb_heures`) VALUES
(2, 'encadrement projet gesfor', '2014-04-29', '15:00:00', 2),
(3, 'formation android groupe 2', '2014-04-29', '00:00:02', 2),
(4, 'formation java g1', '2014-05-30', '00:00:02', 2),
(5, 'formation java g2', '2014-05-30', '14:00:00', 2),
(6, 'encadrement projet2', '2014-04-29', '09:00:00', 3),
(7, 'formation php groupe4', '2014-04-29', '10:00:00', 4),
(8, 'formation vb', '2014-05-21', '11:00:00', 2);

-- --------------------------------------------------------

--
-- Structure de la table `test_evaluation`
--

CREATE TABLE IF NOT EXISTS `test_evaluation` (
  `id_test` int(11) NOT NULL AUTO_INCREMENT,
  `cin_etudiant` int(8) NOT NULL,
  `matiere` varchar(40) NOT NULL,
  `note` float NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `test_evaluation`
--

INSERT INTO `test_evaluation` (`id_test`, `cin_etudiant`, `matiere`, `note`, `date`) VALUES
(1, 13414529, 'ajax', 16.75, '2014-05-08'),
(2, 13414529, 'ajax', 12.5, '2014-05-08'),
(3, 13414529, 'algorithme', 13, '2014-05-11');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
