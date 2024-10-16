-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 06 août 2024 à 18:58
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `informatique`
--

-- --------------------------------------------------------

--
-- Structure de la table `demmande`
--

CREATE TABLE `demmande` (
  `id` int(11) NOT NULL,
  `type` varchar(200) NOT NULL,
  `marque` varchar(200) NOT NULL,
  `serie` varchar(299) NOT NULL,
  `model` varchar(200) NOT NULL,
  `system` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `matricule` varchar(200) NOT NULL,
  `poste` varchar(200) NOT NULL,
  `porte` varchar(200) NOT NULL,
  `message` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `demmande`
--

INSERT INTO `demmande` (`id`, `type`, `marque`, `serie`, `model`, `system`, `nom`, `matricule`, `poste`, `porte`, `message`) VALUES
(2, 'ordinateur portable', 'hp', '123466è', '6em', 'lunix', 'max kely', 'mil3', 'Utilisateur', '12', 'besoin de machne plus flude'),
(5, 'ordinateur portable', 'aaa', 'azeerr', 'zezzzz', 'lunix', 'solomon', 'AZ2c', 'Utilisateur', '13', 'besoin de machine plus flude'),
(6, 'serveur', 'asus', '123èfr', '5em generation', 'windows', 'solo', 'info12', 'Technicien', '23', 'essais de fonctionalister wamp'),
(7, 'ordinateur portable', 'asus', 'aaa11', '6em generation', 'lunix', 'jiapa', 'iua', 'Technicien', '12', 'jzkjd'),
(8, 'imprimante', 'hp', 'E4788', 'aspire', 'windows', 'max', 'mil3', 'Technicien', '2', 'rien'),
(9, 'scaner', 'hp', 'E4788', 'aspire', 'windows', 'max', 'miL3', 'Technicien', '2', 'RS'),
(10, 'ordinateur portable', 'hp', 'E4788', 'aspire', 'windows', 'max', 'mil3', 'Utilisateur', '23', 'dooihoahohoaidhhcqh'),
(11, 'imprimante', 'sony', '12Z', 'del', 'windows', 'max kely', 'mil3', 'Utilisateur', '12', 'besoin d\'impression ');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `user` varchar(200) NOT NULL,
  `mdp` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`id`, `user`, `mdp`) VALUES
(1, 'koto', 'azerty'),
(2, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `id` int(11) NOT NULL,
  `type` varchar(200) NOT NULL,
  `marque` varchar(200) NOT NULL,
  `serie` varchar(200) NOT NULL,
  `model` varchar(200) NOT NULL,
  `status` varchar(200) NOT NULL,
  `system` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `type`, `marque`, `serie`, `model`, `status`, `system`) VALUES
(1, 'Ordinateur bureau', 'dell', '123809gg', 'acer', 'bien', 'linux'),
(2, 'ordinateur portable', 'hp', '123466è', '6em', 'bien', 'lunix'),
(3, 'routeur', 'dell', '12G', '2em', 'bien', 'windows'),
(4, 'scaner', 'hp', '123b-TR', 'azerty', 'critaire', 'windows'),
(5, 'ordinateur portable', 'aaa', 'azeerr', 'zezzzz', 'critaire', 'lunix'),
(6, 'serveur', 'asus', '123èfr', '5em generation', 'critaire', 'windows'),
(7, 'ordinateur portable', 'asus', 'aaa11', '6em generation', 'bien', 'lunix'),
(8, 'imprimante', 'hp', 'E4788', 'aspire', 'bien', 'windows'),
(9, 'scaner', 'hp', 'E4788', 'aspire', 'critaire', 'windows'),
(10, 'ordinateur portable', 'hp', 'E4788', 'aspire', 'critaire', 'windows'),
(11, 'imprimante', 'sony', '12Z', 'del', 'critaire', 'windows'),
(12, 'routeur', 'sony', '21_èza', 'français', 'bien', 'windows');

-- --------------------------------------------------------

--
-- Structure de la table `panne`
--

CREATE TABLE `panne` (
  `id` int(11) NOT NULL,
  `materiel` varchar(200) NOT NULL,
  `serie` varchar(200) NOT NULL,
  `declaration` mediumtext NOT NULL,
  `nom` varchar(200) NOT NULL,
  `matricule` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `panne`
--

INSERT INTO `panne` (`id`, `materiel`, `serie`, `declaration`, `nom`, `matricule`) VALUES
(1, 'ordinateur', 'AZ2&', 'dure faible', 'solo', '12Y'),
(2, 'scaner', 'E19', 'endommager', 'lala', '2EDZ'),
(3, 'serveur', '2ZS2', 'endommager', 'zaka', 'ma1'),
(4, 'ordinateur bureau', 'dell', 'ram perdu', 'max', 'miL3'),
(5, 'routeur', '21A', 'perte ram', 'lola', 'mi32'),
(6, 'dhoizhd', 'hdaoizh', 'ivuiea', 'zadz', 'zadaz'),
(7, 'zdzd', 'zdz', 'dzdz', 'zdd', 'zdz'),
(8, 'ordinateur bureau', '123ZDA', 'ram endomager', 'max kely', 'mil3'),
(9, 'ordinateur bureau', '12478èGA', 'machine plus flude', 'max kely', 'mil3');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  `telephone` varchar(200) NOT NULL,
  `user` varchar(200) NOT NULL,
  `mdp` varchar(200) NOT NULL,
  `poste` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `email`, `adresse`, `telephone`, `user`, `mdp`, `poste`) VALUES
(1, 'kotozafy', 'e@gmail.com', 'azer', '123', 'koto', 'azerty', 'Utilisateur'),
(2, 'max', '@gmail.com', 'isaingy', '123', 'max', '123', 'Utilisateur'),
(3, 'marc', 'aze@gmal.com', 'rn4', '12345', 'marc', 'marc123', 'Technicien'),
(4, 'lola', 'lalo@gmail.com', 'azds', '321', 'lola', 'lola', 'Administrateur'),
(5, 'starim', 'starim@gmail.com', 'tsy aiko', '321', 'starim', 'azerty', 'Utilisateur'),
(6, 'test', 'test@gmail.com', 'azerty', '123', 'usertest', 'test123', 'Utilisateur'),
(7, 'test', 'test@gmail.com', 'azertyu', '123', 'testa', 'azerty', 'Technicien');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `demmande`
--
ALTER TABLE `demmande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `panne`
--
ALTER TABLE `panne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `demmande`
--
ALTER TABLE `demmande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `panne`
--
ALTER TABLE `panne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
