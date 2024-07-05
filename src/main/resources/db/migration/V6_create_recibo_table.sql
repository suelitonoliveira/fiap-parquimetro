CREATE TABLE parquimetro.recibo (
                        id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        sessao_id BIGINT NOT NULL,
                        tempo_estacionado VARCHAR(50) NOT NULL,
                        tarifa_aplicada NUMERIC(10, 2) NOT NULL,
                        valor_pago NUMERIC(10, 2) NOT NULL,
                        data_emissao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                        FOREIGN KEY (sessao_id) REFERENCES sessao(id)
);