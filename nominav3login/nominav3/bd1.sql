-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-03-2019 a las 20:33:50
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bancos`
--

DROP TABLE IF EXISTS `bancos`;
CREATE TABLE IF NOT EXISTS `bancos` (
  `bancodigo` varchar(5) NOT NULL,
  `bannombre` varchar(50) DEFAULT NULL,
  `bancuenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`bancodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

DROP TABLE IF EXISTS `concepto`;
CREATE TABLE IF NOT EXISTS `concepto` (
  `concodigo` varchar(5) NOT NULL,
  `connombre` varchar(50) DEFAULT NULL,
  `conefecto` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`concodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE IF NOT EXISTS `departamentos` (
  `depcodigo` varchar(5) NOT NULL,
  `depnombre` varchar(50) DEFAULT NULL,
  `depestatus` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`depcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `empcodigo` varchar(5) NOT NULL,
  `empnombre` varchar(50) DEFAULT NULL,
  `depcodigo` varchar(5) DEFAULT NULL,
  `empestatus` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`empcodigo`),
  KEY `FK_departamentosempleados` (`depcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominadetalles`
--

DROP TABLE IF EXISTS `nominadetalles`;
CREATE TABLE IF NOT EXISTS `nominadetalles` (
  `nomicodigo` varchar(5) NOT NULL,
  `empcodigo` varchar(5) NOT NULL,
  `concodigo` varchar(5) DEFAULT NULL,
  `nomidtotal` int(11) DEFAULT NULL,
  PRIMARY KEY (`nomicodigo`),
  KEY `FK_empleadosnominadetalle` (`empcodigo`),
  KEY `FK_conceptonominadetalle` (`concodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominaencabezado`
--

DROP TABLE IF EXISTS `nominaencabezado`;
CREATE TABLE IF NOT EXISTS `nominaencabezado` (
  `nomicodigo` varchar(5) NOT NULL,
  `nomifecha` date DEFAULT NULL,
  `nomimonto` int(11) DEFAULT NULL,
  `bancodigo` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`nomicodigo`),
  KEY `FK_bancosnominaencabezado` (`bancodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `codusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `estadousuario` tinyint(1) NOT NULL,
  PRIMARY KEY (`codusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codusuario`, `nombre`, `clave`, `estadousuario`) VALUES
(1, 'juan', '123', 1),
(2, 'usu', '345', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `FK_departamentosempleados` FOREIGN KEY (`depcodigo`) REFERENCES `departamentos` (`depcodigo`);

--
-- Filtros para la tabla `nominadetalles`
--
ALTER TABLE `nominadetalles`
  ADD CONSTRAINT `FK_conceptonominadetalle` FOREIGN KEY (`concodigo`) REFERENCES `concepto` (`concodigo`),
  ADD CONSTRAINT `FK_empleadosnominadetalle` FOREIGN KEY (`empcodigo`) REFERENCES `empleados` (`empcodigo`),
  ADD CONSTRAINT `FK_nominaencabezadonominadetalle` FOREIGN KEY (`nomicodigo`) REFERENCES `nominaencabezado` (`nomicodigo`);

--
-- Filtros para la tabla `nominaencabezado`
--
ALTER TABLE `nominaencabezado`
  ADD CONSTRAINT `FK_bancosnominaencabezado` FOREIGN KEY (`bancodigo`) REFERENCES `bancos` (`bancodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
