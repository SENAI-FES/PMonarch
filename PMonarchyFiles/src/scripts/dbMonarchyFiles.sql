-- MySQL Script generated by MySQL Workbench
-- 07/06/15 21:48:21
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbmonarchyfiles
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `dbmonarchyfiles`;
-- NÃO TIREM A LINHA ACIMA, É MELHOR ASSIM PARA LIMPAR O BANCO E RECRIAR AS TABELAS COM VALORES ZERADOS.
CREATE SCHEMA IF NOT EXISTS `dbmonarchyfiles` DEFAULT CHARACTER SET utf8 ;
USE `dbmonarchyfiles` ;

-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`armazem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`armazem` (
  `rua` VARCHAR(100) NOT NULL,
  `estante` VARCHAR(100) NOT NULL,
  `coluna` INT(11) NOT NULL,
  `andar` VARCHAR(100) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`rua`, `estante`, `coluna`, `andar`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`caixa` (
  `idCaixa` INT(11) NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NOT NULL,
  `estante` VARCHAR(45) NOT NULL,
  `coluna` VARCHAR(45) NOT NULL,
  `andar` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCaixa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`empresa` (
  `idEmpresa` INT(11) NOT NULL AUTO_INCREMENT,
  `razaoSocial` VARCHAR(45) NOT NULL,
  `nomeFantasia` VARCHAR(45) NOT NULL,
  `CNPJ` VARCHAR(45) NOT NULL,
  `IE` VARCHAR(45) NULL DEFAULT NULL,
  `site` VARCHAR(45) NULL DEFAULT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  `CEP` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`contato` (
  `idContato` INT(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `ramal` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idContato`),
  INDEX `fk_Contato_Empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_Contato_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `dbmonarchyfiles`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`contrato` (
  `idContrato` INT(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT(11) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `dataInicial` DATE NOT NULL,
  `validade` DATE NOT NULL,
  PRIMARY KEY (`idContrato`),
  INDEX `fk_Contrato_Empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_Contrato_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `dbmonarchyfiles`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`usuario` (
  `matricula` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(45) NOT NULL,
  `perfil` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(240) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`protocolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`protocolo` (
  `idProtocolo` INT(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT(11) NOT NULL,
  `idResponsavelCadastro` INT(11) NOT NULL,
  `idResponsavelSeparacao` INT(11) NULL DEFAULT NULL,
  `idResponsavelEstocagem` INT(11) NULL DEFAULT NULL,
  `idTipoDocumento` INT(11) NULL DEFAULT NULL,
  `numeroProtocolo` INT(11) NOT NULL,
  `quantidadeDocumento`int NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `responsavelEntrega` VARCHAR(100) NOT NULL,
  `tipoProtocolo` INT(11) NOT NULL,
  `dataHora` DATETIME NOT NULL,
  PRIMARY KEY (`idProtocolo`),
  INDEX `fk_Protocolo_Empresa1_idx` (`idEmpresa` ASC),
  INDEX `fk_Protocolo_Usuario1_idx` (`idResponsavelCadastro` ASC),
  CONSTRAINT `fk_Protocolo_Usuario1`
    FOREIGN KEY (`idResponsavelCadastro`)
    REFERENCES `dbmonarchyfiles`.`usuario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Protocolo_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `dbmonarchyfiles`.`empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`tipodocumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`tipodocumento` (
  `idTipoDocumento` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoDocumento`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`documento` (
  `idDocumento` INT(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` INT(11) NOT NULL,
  `idProtocolo` INT(11) NOT NULL,
  `idTipoDocumento` INT(11) NOT NULL,
  `idCaixa` INT(11) NOT NULL,
  `data` DATE NOT NULL,
  `qtdeFolha` VARCHAR(45) NOT NULL,
  `formatoPapel` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idDocumento`),
  INDEX `fk_Documento_Protocolo1_idx` (`idProtocolo` ASC),
  INDEX `fk_Documento_TipoDocumento1_idx` (`idTipoDocumento` ASC),
  INDEX `fk_Documento_Armazem1_idx` (`idCaixa` ASC),
  CONSTRAINT `fk_Documento_Protocolo1`
    FOREIGN KEY (`idProtocolo`)
    REFERENCES `dbmonarchyfiles`.`protocolo` (`idProtocolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Documento_TipoDocumento1`
    FOREIGN KEY (`idTipoDocumento`)
    REFERENCES `dbmonarchyfiles`.`tipodocumento` (`idTipoDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Documento_Armazem1`
    FOREIGN KEY (`idCaixa`)
    REFERENCES `dbmonarchyfiles`.`caixa` (`idCaixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`marcador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`marcador` (
  `idMarcador` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMarcador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`marcadordocumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`marcadordocumento` (
  `idDocumento` INT(11) NOT NULL,
  `idMarcador` INT(11) NOT NULL,
  PRIMARY KEY (`idDocumento`, `idMarcador`),
  INDEX `fk_Documento_has_Marcador_Marcador1_idx` (`idMarcador` ASC),
  INDEX `fk_Documento_has_Marcador_Documento1_idx` (`idDocumento` ASC),
  CONSTRAINT `fk_Documento_has_Marcador_Documento1`
    FOREIGN KEY (`idDocumento`)
    REFERENCES `dbmonarchyfiles`.`documento` (`idDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Documento_has_Marcador_Marcador1`
    FOREIGN KEY (`idMarcador`)
    REFERENCES `dbmonarchyfiles`.`marcador` (`idMarcador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbmonarchyfiles`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbmonarchyfiles`.`telefone` (
  `idTelefone` INT(11) NOT NULL AUTO_INCREMENT,
  `idContato` INT(11) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `ramal` INT(11) NOT NULL,
  PRIMARY KEY (`idTelefone`),
  INDEX `fk_Telefone_Contato_idx` (`idContato` ASC),
  CONSTRAINT `fk_Telefone_Contato`
    FOREIGN KEY (`idContato`)
    REFERENCES `dbmonarchyfiles`.`contato` (`idContato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `dbmonarchyfiles`.`usuario` (`matricula`, `status`, `nome`, `CPF`, `perfil`, `email`, `senha`) VALUES ('1', 'Ativo', 'Adm', '999999', '0', 'adm', '123');

INSERT INTO `dbmonarchyfiles`.`empresa` (`idEmpresa`, `nomeFantasia`, `razaoSocial`, `CNPJ`, `IE`, `site`, `logradouro`, `complemento`, `cidade`, `CEP`, `UF`, `tipo`, `status` )  
VALUES ('1','Projeto Criaça Feliz','Projeto Criaça Feliz','07.524.113/0001-06','254413919','www.criancaesperanca.com.br','Francisco Tolentino','-','Rio de Janeiro','96820-524','RJ','RUA', 'Ativo');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '1', 'Rudinei Silva', 'Gerente', '(21)3278-7878', '454', 'rudinei@cfeliz.com.br', '1');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '2', 'Aderbal Rocha', 'Coordenador', '(21)3278-7878', '455', 'aderbal@cfeliz.com.br', '1');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '3', 'Fernando Moura', 'Auxiliar', '(21)3278-7878', '456', 'fernando@cfeliz.com.br', '1');
insert into `dbmonarchyfiles`.`contrato` (`idContrato`, `tipo`, `dataInicial`, `validade`, `idEmpresa`) 
values( '1', 'Mensal', '2015/05/12', '2019/05/12', '1');

INSERT INTO `dbmonarchyfiles`.`empresa` (`idEmpresa`, `nomeFantasia`, `razaoSocial`, `CNPJ`, `IE`, `site`, `logradouro`, `complemento`, `cidade`, `CEP`, `UF`, `tipo`, `status` )  
VALUES ('2','Krolow Atacado','Comercio de Atacado e Varejo Ltda','02.554.718/0001-22','266418219','www.krolow.com.br','Jarbas Manoeltino','-','Pelotas','92825-500','RS','AVENIDA', 'Ativo');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '4', 'Jonas Souza', 'Gerente', '(53)3274-7474', '001', 'jonas@krolow.com.br', '2');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '5', 'Marcelo Borges', 'Operador', '(53)3274-7474', '013', 'marcelo@krolow.com.br', '2');
insert into `dbmonarchyfiles`.`contato` (`idContato`, `nome`, `cargo`, `telefone`, `ramal`, `email`, `idEmpresa`) 
values( '6', 'Alicia Men', 'Assistente', '(53)3274-7474', '011', 'alicia@krolow.com.br', '2');
insert into `dbmonarchyfiles`.`contrato` (`idContrato`, `tipo`, `dataInicial`, `validade`, `idEmpresa`) 
values( '2', 'Mensal', '2015/05/12', '2019/05/12', '2');
