CREATE TABLE parquimetro.tb_endereco
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    logradouro        VARCHAR(100)                            NOT NULL,
    numero            INTEGER                                 NOT NULL,
    complemento       VARCHAR(50)                             NOT NULL,
    cidade            VARCHAR(50)                             NOT NULL,
    estado            VARCHAR(2)                              NOT NULL,
    cep               VARCHAR(8)                              NOT NULL,
    CONSTRAINT pk_tb_endereco PRIMARY KEY (cod)
);

CREATE TABLE parquimetro.tb_usuario
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    nome              VARCHAR(255)                            NOT NULL,
    cod_endereco      BIGINT                                  NOT NULL,
    cpf               VARCHAR(255)                            NOT NULL,
    email             VARCHAR(255)                            NOT NULL,
    telefone          VARCHAR(255)                            NOT NULL,
    tipo_usuario      VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_tb_usuario PRIMARY KEY (cod)
);
ALTER TABLE parquimetro.tb_usuario
    ADD CONSTRAINT FK_TB_USUARIO_ON_COD_ENDERECO FOREIGN KEY (cod_endereco) REFERENCES tb_endereco (cod);


CREATE TABLE parquimetro.tb_veiculo
(
    cod         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    placa       VARCHAR(255),
    modelo      VARCHAR(255),
    marca       VARCHAR(255),
    condutor_id BIGINT,
    CONSTRAINT pk_tb_veiculo PRIMARY KEY (cod)
);

ALTER TABLE parquimetro.tb_veiculo
    ADD CONSTRAINT FK_TB_VEICULO_ON_CONDUTOR FOREIGN KEY (condutor_id) REFERENCES parquimetro.tb_usuario (cod);

CREATE TABLE parquimetro.tb_parquimetro
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    numero_serie      VARCHAR(255) NOT NULL UNIQUE,
    modelo            VARCHAR(255)                            NOT NULL,
    usuario_cod       BIGINT,
    CONSTRAINT pk_tb_parquimetro PRIMARY KEY (cod)
);

ALTER TABLE parquimetro.tb_parquimetro
    ADD CONSTRAINT FK_TB_PARQUIMETRO_ON_USUARIO_COD FOREIGN KEY (usuario_cod) REFERENCES parquimetro.tb_usuario (cod);

CREATE TABLE parquimetro.tb_sessao
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    condutor_id       BIGINT                                  NOT NULL,
    parquimetro_id    BIGINT                                  NOT NULL,
    status_pagamento  VARCHAR(255)                            NOT NULL,
    inicio_sessao     TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    fim_sessao        TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_tb_sessao PRIMARY KEY (cod)
);

ALTER TABLE parquimetro.tb_sessao
    ADD CONSTRAINT FK_TB_SECAO_ON_CONDUTOR FOREIGN KEY (condutor_id) REFERENCES parquimetro.tb_usuario (cod);

ALTER TABLE parquimetro.tb_sessao
    ADD CONSTRAINT FK_TB_SECAO_ON_PARQUIMETRO FOREIGN KEY (parquimetro_id) REFERENCES parquimetro.tb_parquimetro (cod);


CREATE TABLE parquimetro.tb_recibo
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    sessao_id         BIGINT                                  NOT NULL,
    tempo_estacionado VARCHAR(255)                            NOT NULL,
    tarifa_aplicada   DECIMAL                                 NOT NULL,
    valor_pago        DECIMAL                                 NOT NULL,
    data_emissao      TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    CONSTRAINT pk_tb_recibo PRIMARY KEY (cod)
);

ALTER TABLE parquimetro.tb_recibo
    ADD CONSTRAINT FK_TB_RECIBO_ON_SESSAO FOREIGN KEY (sessao_id) REFERENCES parquimetro.tb_sessao (cod);


CREATE TABLE parquimetro.tb_pagamento
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    sessao_id         BIGINT                                  NOT NULL,
    valor             DECIMAL                                 NOT NULL,
    data_pagamento    TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    status_pagamento  VARCHAR(255)                            NOT NULL,
    tipo_pagamento  VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_tb_pagamento PRIMARY KEY (cod)
);

ALTER TABLE parquimetro.tb_pagamento
    ADD CONSTRAINT FK_TB_PAGAMENTO_ON_SESSAO FOREIGN KEY (sessao_id) REFERENCES parquimetro.tb_sessao (cod);

CREATE TABLE parquimetro.tb_notificacao
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP WITHOUT TIME ZONE,
    data_de_alteracao TIMESTAMP WITHOUT TIME ZONE,
    secao_id          BIGINT                                  NOT NULL,
    tipo_notificacao  VARCHAR(255)                            NOT NULL,
    mensagem          VARCHAR(255)                            NOT NULL,
    data_envio        TIMESTAMP WITHOUT TIME ZONE             NOT NULL,
    CONSTRAINT pk_tb_notificacao PRIMARY KEY (cod)
);

