CREATE TABLE patio (
  id_patio INT PRIMARY KEY,
  nome VARCHAR(100),
  localizacao VARCHAR(100),
  descricao VARCHAR(255)
);

CREATE TABLE usuario (
  id_usuario INTEGER PRIMARY KEY,
  nome VARCHAR2(100) NOT NULL,
  email VARCHAR2(100) UNIQUE NOT NULL,
  senha VARCHAR2(255) NOT NULL,
  status VARCHAR2(20) DEFAULT 'ativo',
  patio_id_patio INTEGER NOT NULL,
  CONSTRAINT usuario_patio_FK FOREIGN KEY (patio_id_patio) REFERENCES patio(id_patio)
);


CREATE TABLE moto (
  id_moto INT PRIMARY KEY,
  placa VARCHAR(7) UNIQUE,
  modelo VARCHAR(50),
  status VARCHAR(65),
  data_cadastro DATE
);

CREATE TABLE posicao (
  id_posicao INT PRIMARY KEY,
  x_pos FLOAT,
  y_pos FLOAT,
  data_hora TIMESTAMP,
  moto_id_moto INT,
  patio_id_patio INT,
  FOREIGN KEY (moto_id_moto) REFERENCES moto(id_moto),
  FOREIGN KEY (patio_id_patio) REFERENCES patio(id_patio)
);

CREATE TABLE marcador_fixo (
  id_marcador_aruco_fixo INT PRIMARY KEY,
  codigo_aruco VARCHAR(50),
  x_pos FLOAT,
  y_pos FLOAT,
  patio_id_patio INT,
  FOREIGN KEY (patio_id_patio) REFERENCES patio(id_patio)
);

CREATE TABLE marcador_aruco_movel (
  id_marcador_movel INT PRIMARY KEY,
  codigo_aruco VARCHAR(50),
  data_instalacao DATE,
  moto_id_moto INT,
  FOREIGN KEY (moto_id_moto) REFERENCES moto(id_moto)
);

CREATE TABLE medicao_posicao (
  id_medicao INT PRIMARY KEY,
  distancia_m FLOAT,
  posicao_id_posicao INT,
  marcador_fixo_id_marcador_aruco_fixo INT,
  FOREIGN KEY (posicao_id_posicao) REFERENCES posicao(id_posicao),
  FOREIGN KEY (marcador_fixo_id_marcador_aruco_fixo) REFERENCES marcador_fixo(id_marcador_aruco_fixo)
);
