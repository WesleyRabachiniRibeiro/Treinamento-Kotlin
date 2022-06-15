CREATE TABLE tb_produto(
    cd_produto BIGINT AUTO_INCREMENT PRIMARY KEY,
    nm_produto VARCHAR(50)           NOT NULL,
    nr_produto NUMERIC(3)            NOT NULL,
    vl_produto NUMERIC(10,5)         NOT NULL,
    ds_produto VARCHAR(255)          NOT NULL,
    st_produto BOOLEAN               NOT NULL
);