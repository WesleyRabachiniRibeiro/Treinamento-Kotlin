CREATE TABLE tb_endereco(
    cd_endereco BIGINT AUTO_INCREMENT PRIMARY KEY,
    ds_endereco VARCHAR(255) NOT NULL,
    nr_endereco NUMERIC(4)   NOT NULL,
    ds_cidade   VARCHAR(50)  NOT NULL,
    ds_estado   VARCHAR(50)  NOT NULL
);