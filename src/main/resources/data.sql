INSERT INTO usuario (id, nome, token, senha, email) values (1111, 'usuario teste 1', 'token de teste', '$2y$12$YZU2Hl/./XF88tSC0Q4Hxu/M2UAhPdXZ3rSt9rLz6EdzI16pdKByW', 'teste1@squad6.com.br');

INSERT INTO usuario (id, nome, token, senha, email) values (2222, 'usuario teste 2', 'token de teste', '$2y$12$YZU2Hl/./XF88tSC0Q4Hxu/M2UAhPdXZ3rSt9rLz6EdzI16pdKByW', 'teste2@squad6.com.br');

INSERT INTO usuario (id, nome, token, senha, email) values (3333, 'usuario teste 3', 'token de teste', '$2y$12$YZU2Hl/./XF88tSC0Q4Hxu/M2UAhPdXZ3rSt9rLz6EdzI16pdKByW', 'teste3@squad6.com.br');

INSERT INTO usuario (id, nome, token, senha, email) values (4444, 'usuario teste 4', 'token de teste', 'teste', 'teste4@squad6.com.br');

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0101, now(), 'erro 1', 'detalhes do erro 1', 1111, 2, 0, '192.168.0.0', now(), 1);

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0202, now(), 'erro 2', 'detalhes do erro 2', 2222, 1, 1, '192.1.0.0', now(), 1);

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0303, now(), 'erro 3', 'detalhes do erro 3', 2222, 1, 0, '10.0.0.1', now(), 1);

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0404, now(), 'erro 4', 'detalhes do erro 4', 3333, 2, 1, '192.168.0.0', now(), 1);

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0505, now(), 'erro 5', 'detalhes do erro 5', 1111, 3, 1, '1.1.0.0', now(), 1);

INSERT INTO erro (id, create_at, titulo, detalhes, usuario_id, level, ambiente, endereco, data, status) values (0606, now(), 'erro 6', 'detalhes do erro 6', 3333, 2, 2, '10.0.0.1', now(), 1);
