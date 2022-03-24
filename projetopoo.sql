-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Mar-2022 às 05:18
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetopoo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `escolaridade` varchar(40) NOT NULL,
  `pessoa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `escolaridade`, `pessoa_id`) VALUES
(1, 'Ensino Medio', 3),
(2, 'Ensino Medio', 4),
(5, 'ENSINO SUPERIOR', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `nomeArea` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `area`
--

INSERT INTO `area` (`id`, `nomeArea`) VALUES
(1, 'HUMANAS'),
(2, 'EXATAS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `uf_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `uf_id`) VALUES
(1, 'IGUATU', 1),
(2, 'CEDRO', 1),
(3, 'ICO', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nomeCurso` varchar(30) DEFAULT NULL,
  `ch` varchar(30) DEFAULT NULL,
  `area_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `nomeCurso`, `ch`, `area_id`) VALUES
(1, 'DIREITO', '3.700H', 1),
(2, 'MATEMATICA', '3.200H', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `filial`
--

CREATE TABLE `filial` (
  `id` int(11) NOT NULL,
  `nomeFilial` varchar(50) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `numerodolocal` int(11) NOT NULL,
  `cidade_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filial`
--

INSERT INTO `filial` (`id`, `nomeFilial`, `rua`, `bairro`, `numerodolocal`, `cidade_id`) VALUES
(1, 'FILIAL - IGUATU', 'R Chiquinho Carteiro', 'alto do juca', 156, 1),
(2, 'FILIAL - CEDRO', 'QUADRA A', 'Centro Gerencial.', 320, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `instrutor`
--

CREATE TABLE `instrutor` (
  `id` int(11) NOT NULL,
  `formacao` varchar(30) NOT NULL,
  `pessoa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `instrutor`
--

INSERT INTO `instrutor` (`id`, `formacao`, `pessoa_id`) VALUES
(1, 'Matemática Aplicada', 1),
(2, 'Pedagogia', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `matricula`
--

CREATE TABLE `matricula` (
  `id` int(11) NOT NULL,
  `aluno_id` int(11) NOT NULL,
  `turma_id` int(11) NOT NULL,
  `dataMatricula` varchar(20) NOT NULL,
  `estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `matricula`
--

INSERT INTO `matricula` (`id`, `aluno_id`, `turma_id`, `dataMatricula`, `estatus`) VALUES
(1, 1, 2, '22/05/22', 'NOMALIZADO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `mae` varchar(40) NOT NULL,
  `sexo` varchar(40) NOT NULL,
  `nascimento` varchar(40) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numerodacasa` int(11) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `cidade_id` int(11) NOT NULL,
  `estadocivil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `mae`, `sexo`, `nascimento`, `email`, `rua`, `bairro`, `numerodacasa`, `cep`, `telefone`, `cidade_id`, `estadocivil`) VALUES
(1, 'Rogerio dos Santos', 'Maria dos Santos', 'M', '16/11/1998', 'rogeiosdp@hotmail.com', 'rua dos inocentes', 'alto do juca', 244, '63500000', '8892654455', 1, 'Solteiro'),
(2, 'Maria Alves', 'Regina Alves', 'F', '18/05/1999', 'mariaalves@gmail.com', 'RUA S ALVES', 'BAIRRO IFCE DO LADO', 555, '62502210', '88993234466', 2, 'Solteira'),
(3, 'Izabel Silva', 'Dores Silva', 'F', '15/11/2000', 'iza@mail.com', 'Rua Cruzeiro do Sul', 'Alto do Juca', 234, '63500000', '8892245465', 1, 'Solteira'),
(4, 'Pedro de Souza', 'Ferreira Maria', 'M', '18/05/1998', 'p@gmail.com.br', 'Rua paulo sarazate', 'Vila Neuma', 47, '63500000', '88993257518', 1, 'Solteiro'),
(7, 'ROB STONE', 'MARY STONE', 'Masculino', '13/04/1997', 'ROb@gmail.com', 'Rua A', 'Quadra A', 99, '63503210', '88992452931', 1, 'SOLTEIRO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id` int(11) NOT NULL,
  `horarioInicio` varchar(10) NOT NULL,
  `horarioFim` varchar(10) NOT NULL,
  `dataInicial` varchar(10) NOT NULL,
  `dataFim` varchar(10) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `instrutor_id` int(11) NOT NULL,
  `filial_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id`, `horarioInicio`, `horarioFim`, `dataInicial`, `dataFim`, `curso_id`, `instrutor_id`, `filial_id`) VALUES
(1, '13H', '17H', '22/03/2022', '31/03/2022', 1, 2, 1),
(2, '09H', '13H', '22/03/2022', '31/03/2022', 2, 1, 1),
(4, '19Horas', '22Horas', '24/05/2022', '24/06/2022', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `uf`
--

CREATE TABLE `uf` (
  `id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `uf`
--

INSERT INTO `uf` (`id`, `nome`) VALUES
(1, 'CE'),
(2, 'PE');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_pessoaAluno` (`pessoa_id`);

--
-- Índices para tabela `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_cidadeuf` (`uf_id`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_areaCurso` (`area_id`);

--
-- Índices para tabela `filial`
--
ALTER TABLE `filial`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_filialcidade` (`cidade_id`);

--
-- Índices para tabela `instrutor`
--
ALTER TABLE `instrutor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_pessoaIntrutor` (`pessoa_id`);

--
-- Índices para tabela `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_matriculaAluno` (`aluno_id`),
  ADD KEY `Fk_matriculaTurma` (`turma_id`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_cidadepessoa` (`cidade_id`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_cursoTurma` (`curso_id`),
  ADD KEY `Fk_instrutorTurma` (`instrutor_id`),
  ADD KEY `Fk_filalTurma` (`filial_id`);

--
-- Índices para tabela `uf`
--
ALTER TABLE `uf`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `filial`
--
ALTER TABLE `filial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `instrutor`
--
ALTER TABLE `instrutor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `uf`
--
ALTER TABLE `uf`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `Fk_pessoaAluno` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `Fk_cidadeuf` FOREIGN KEY (`uf_id`) REFERENCES `uf` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `Fk_areaCurso` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `filial`
--
ALTER TABLE `filial`
  ADD CONSTRAINT `Fk_filialcidade` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `instrutor`
--
ALTER TABLE `instrutor`
  ADD CONSTRAINT `Fk_pessoaIntrutor` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `Fk_matriculaAluno` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_matriculaTurma` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `Fk_cidadepessoa` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `Fk_cursoTurma` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_filalTurma` FOREIGN KEY (`filial_id`) REFERENCES `filial` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_instrutorTurma` FOREIGN KEY (`instrutor_id`) REFERENCES `instrutor` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
