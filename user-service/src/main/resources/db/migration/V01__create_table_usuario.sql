CREATE TABLE tb_usuario(
    cd_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nm_usuario VARCHAR(50) NOT NULL,
    nr_idade NUMERIC(3) NOT NULL,
    nr_telefone VARCHAR(11) NOT NULL,
    ds_email VARCHAR(255) NOT NULL,
    ds_senha VARCHAR(20) NOT NULL,
    st_usuario BOOLEAN NOT NULL
);

