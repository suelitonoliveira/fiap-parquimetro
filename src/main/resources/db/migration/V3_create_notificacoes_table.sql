CREATE TABLE notificacoes (
                              id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                              sessao_id BIGINT NOT NULL,
                              tipo VARCHAR(255) NOT NULL,
                              mensagem VARCHAR(1000) NOT NULL,
                              data_envio TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                              FOREIGN KEY (sessao_id) REFERENCES sessao(id)
);