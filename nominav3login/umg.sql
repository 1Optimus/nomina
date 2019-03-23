CREATE DATABASE umg;
USE umg;
DROP TABLE IF EXISTS bancos;
CREATE TABLE IF NOT EXISTS bancos (
  ban_codigo int(5) NOT NULL,
  ban_nombre VARCHAR(50) DEFAULT NULL,
  ban_cuenta int(11) DEFAULT NULL,
  PRIMARY KEY (ban_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS concepto;
CREATE TABLE IF NOT EXISTS concepto (
 con_codigo int(5) NOT NULL,
  con_nombre VARCHAR(50) DEFAULT NULL,
  con_efecto VARCHAR(5) DEFAULT NULL,
  PRIMARY KEY (con_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS departamentos;
CREATE TABLE IF NOT EXISTS departamentos (
  dep_codigo int(5) NOT NULL,
  dep_nombre VARCHAR(50) DEFAULT NULL,  
  PRIMARY KEY (dep_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS empleados;
CREATE TABLE IF NOT EXISTS empleados (
  emp_codigo int(5) NOT NULL,
  emp_nombre VARCHAR(50),
  emp_nit VARCHAR(10),
  emp_direccion VARCHAR(40),
  dep_cod int(5) NOT NULL,
  pues_codi int(5) NOT NULL,
  emp_sueldonom double(4,2),
  emp_estatus boolean,
  PRIMARY KEY (emp_codigo),
  CONSTRAINT fk_empleados2 FOREIGN KEY(dep_cod) REFERENCES departamentos(dep_codigo),
  CONSTRAINT fkpuesto1 FOREIGN KEY(pues_codi) REFERENCES puesto(pues_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS nominaencabezado;
CREATE TABLE IF NOT EXISTS nominaencabezado (
  nomi_codigo int(5) NOT NULL,
  nomi_fecha date DEFAULT NULL,
  nomi_monto int(11) DEFAULT NULL,
  ban_codigo int(5) DEFAULT NULL,
  PRIMARY KEY (nomi_codigo),
  CONSTRAINT FK_nominaencabezado FOREIGN KEY(ban_codigo) REFERENCES bancos(ban_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS usuario;
CREATE TABLE IF NOT EXISTS usuario (
 us_codigo int(11) NOT NULL ,
  us_nombre VARCHAR(10) NOT NULL,
  us_clave VARCHAR(10) NOT NULL,
  us_estadousuario tinyint(1) NOT NULL,
  emp_codi VARCHAR(5) NOT NULL,
  PRIMARY KEY (us_codigo),
  CONSTRAINT fkempleado FOREIGN KEY(emp_codi) references empleados(emp_codigo)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS nominadetalles;
CREATE TABLE IF NOT EXISTS nominadetalles (
  nomi_codigo int(5) NOT NULL,
  emp_codigo int(5) NOT NULL,
  con_codigo int(5) NOT NULL,
  nomi_total double(7,2) DEFAULT NULL,
  PRIMARY KEY (nomi_codigo, emp_codigo, con_codigo),
  CONSTRAINT fk_nominaenc FOREIGN KEY(nomi_codigo) REFERENCES nominaencabezado(nomi_codigo),
  CONSTRAINT FK_concepto FOREIGN KEY(con_codigo) REFERENCES concepto(con_codigo),
CONSTRAINT fkempleados FOREIGN KEY(emp_codigo) REFERENCES empleados(emp_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS puesto;
CREATE TABLE IF NOT EXISTS puesto(
pues_codigo int(5) NOT NULL,
pues_nombre VARCHAR(15),
PRIMARY KEY(pues_codigo)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;