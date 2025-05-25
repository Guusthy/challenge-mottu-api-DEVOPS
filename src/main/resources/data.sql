INSERT INTO patio (id_patio, nome, localizacao, descricao) VALUES (1, 'Pátio Central', 'São Paulo - SP', 'Unidade principal de operações');
INSERT INTO patio (id_patio, nome, localizacao, descricao) VALUES (2, 'Pátio Norte', 'Fortaleza - CE', 'Cobertura ampla e climatizada');
INSERT INTO patio (id_patio, nome, localizacao, descricao) VALUES (3, 'Pátio Sul', 'Porto Alegre - RS', 'Instalação de testes');
INSERT INTO patio (id_patio, nome, localizacao, descricao) VALUES (4, 'Pátio Oeste', 'Cuiabá - MT', 'Alta capacidade de motos');
INSERT INTO patio (id_patio, nome, localizacao, descricao) VALUES (5, 'Pátio Leste', 'Vitória - ES', 'Operação recente');

INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (1, 'ABC1D23', 'Mottu Sport 110i', 'ativa', '2024-03-01');
INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (2, 'DEF4G56', 'Mottu-e', 'em manutenção', '2024-04-15');
INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (3, 'GHI7J89', 'Mottu POP', 'disponível', '2024-02-20');
INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (4, 'JKL0M12', 'Mottu Sport 110i', 'ativa', '2024-03-05');
INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (5, 'MNO3P45', 'Mottu Sport 110i', 'indisponível', '2024-01-10');
INSERT INTO moto (id_moto, placa, modelo, status, data_cadastro) VALUES (6, 'DWE3L09', 'Mottu POP', 'indisponível', '2024-01-16');

INSERT INTO usuario VALUES (1, 'Carlos Oliveira', 'carlos.oliveira@mottu.com', 'HASH1234567890', 'ativo', 1);
INSERT INTO usuario VALUES (2, 'Ana Souza', 'ana.souza@mottu.com', 'HASHabcdefghij', 'ativo', 2);
INSERT INTO usuario VALUES (3, 'Bruno Lima', 'bruno.lima@mottu.com', 'HASHklmnopqrst', 'ativo', 3);
INSERT INTO usuario VALUES (4, 'Marina Rocha', 'marina.rocha@mottu.com', 'HASHuvwxyz9876', 'ativo', 4);
INSERT INTO usuario VALUES (5, 'João Pedro', 'joao.pedro@mottu.com', 'HASHsenha2024', 'ativo', 5);

INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (1, 2.5, 3.0, '2024-05-01 08:30:00', 1, 1);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (2, 4.1, 5.2, '2024-05-01 09:15:00', 2, 1);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (3, 7.0, 8.0, '2024-05-01 10:00:00', 3, 2);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (4, 1.5, 1.0, '2024-05-01 07:45:00', 4, 3);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (5, 9.0, 6.5, '2024-05-01 11:30:00', 5, 4);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (6, 3.2, 3.7, '2024-05-02 08:15:00', 1, 1);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (7, 4.0, 5.5, '2024-05-02 09:45:00', 2, 1);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (8, 7.5, 8.3, '2024-05-02 10:20:00', 3, 2);
INSERT INTO posicao (id_posicao, x_pos, y_pos, data_hora, moto_id_moto, patio_id_patio) VALUES (9, 6.5, 8.0, '2024-05-03 12:40:00', 6, 4);

-- PÁTIO 1
INSERT INTO marcador_fixo VALUES (1, 'ARUCO_001', 0.0, 0.0, 1);
INSERT INTO marcador_fixo VALUES (2, 'ARUCO_002', 10.0, 0.0, 1);
INSERT INTO marcador_fixo VALUES (3, 'ARUCO_003', 5.0, 8.66, 1);

-- PÁTIO 2
INSERT INTO marcador_fixo VALUES (4, 'ARUCO_004', 0.0, 0.0, 2);
INSERT INTO marcador_fixo VALUES (5, 'ARUCO_005', 10.0, 0.0, 2);
INSERT INTO marcador_fixo VALUES (6, 'ARUCO_006', 5.0, 8.66, 2);

-- PÁTIO 3
INSERT INTO marcador_fixo VALUES (7, 'ARUCO_007', 0.0, 0.0, 3);
INSERT INTO marcador_fixo VALUES (8, 'ARUCO_008', 10.0, 0.0, 3);
INSERT INTO marcador_fixo VALUES (9, 'ARUCO_009', 5.0, 8.66, 3);

-- PÁTIO 4
INSERT INTO marcador_fixo VALUES (10, 'ARUCO_010', 0.0, 0.0, 4);
INSERT INTO marcador_fixo VALUES (11, 'ARUCO_011', 10.0, 0.0, 4);
INSERT INTO marcador_fixo VALUES (12, 'ARUCO_012', 5.0, 8.66, 4);

-- PÁTIO 5
INSERT INTO marcador_fixo VALUES (13, 'ARUCO_013', 0.0, 0.0, 5);
INSERT INTO marcador_fixo VALUES (14, 'ARUCO_014', 10.0, 0.0, 5);
INSERT INTO marcador_fixo VALUES (15, 'ARUCO_015', 5.0, 8.66, 5);

INSERT INTO marcador_aruco_movel VALUES (1, 'MOVEL_001', '2024-03-01', 1);
INSERT INTO marcador_aruco_movel VALUES (2, 'MOVEL_002', '2024-04-20', 2);
INSERT INTO marcador_aruco_movel VALUES (3, 'MOVEL_003', '2024-03-18', 3);
INSERT INTO marcador_aruco_movel VALUES (4, 'MOVEL_004', '2024-04-25', 4);
INSERT INTO marcador_aruco_movel VALUES (5, 'MOVEL_005', '2024-01-10', 5);

-- POSIÇÕES NO PÁTIO 1 (marcadores 1, 2, 3)
INSERT INTO medicao_posicao VALUES (1, 6.0, 1, 1);
INSERT INTO medicao_posicao VALUES (2, 5.2, 1, 2);
INSERT INTO medicao_posicao VALUES (3, 7.0, 1, 3);

INSERT INTO medicao_posicao VALUES (4, 4.9, 2, 1);
INSERT INTO medicao_posicao VALUES (5, 5.1, 2, 2);
INSERT INTO medicao_posicao VALUES (6, 6.7, 2, 3);

INSERT INTO medicao_posicao VALUES (7, 5.8, 6, 1);
INSERT INTO medicao_posicao VALUES (8, 5.0, 6, 2);
INSERT INTO medicao_posicao VALUES (9, 6.9, 6, 3);

INSERT INTO medicao_posicao VALUES (10, 6.1, 7, 1);
INSERT INTO medicao_posicao VALUES (11, 5.3, 7, 2);
INSERT INTO medicao_posicao VALUES (12, 7.1, 7, 3);

-- POSIÇÕES NO PÁTIO 2 (marcadores 4, 5, 6)
INSERT INTO medicao_posicao VALUES (13, 7.0, 3, 4);
INSERT INTO medicao_posicao VALUES (14, 6.2, 3, 5);
INSERT INTO medicao_posicao VALUES (15, 8.0, 3, 6);

INSERT INTO medicao_posicao VALUES (16, 7.1, 8, 4);
INSERT INTO medicao_posicao VALUES (17, 6.5, 8, 5);
INSERT INTO medicao_posicao VALUES (18, 7.8, 8, 6);

-- POSIÇÃO NO PÁTIO 3 (marcadores 7, 8, 9)
INSERT INTO medicao_posicao VALUES (19, 4.8, 4, 7);
INSERT INTO medicao_posicao VALUES (20, 5.0, 4, 8);
INSERT INTO medicao_posicao VALUES (21, 6.2, 4, 9);

-- POSIÇÃO NO PÁTIO 4 (marcadores 10, 11, 12)
INSERT INTO medicao_posicao VALUES (22, 5.9, 5, 10);
INSERT INTO medicao_posicao VALUES (23, 5.1, 5, 11);
INSERT INTO medicao_posicao VALUES (24, 6.5, 5, 12);
