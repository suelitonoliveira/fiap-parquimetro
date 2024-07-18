ALTER TABLE parquimetro.tb_usuario
    ADD CONSTRAINT unique_cpf UNIQUE (cpf);

ALTER TABLE parquimetro.tb_usuario
    ADD CONSTRAINT unique_email UNIQUE (email);