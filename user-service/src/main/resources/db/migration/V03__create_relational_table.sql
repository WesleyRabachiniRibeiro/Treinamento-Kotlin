CREATE TABLE tb_usuario_endereco (
    cd_usuario   BIGINT NOT NULL,
    cd_endereco  BIGINT NOT NULL
);
ALTER TABLE tb_usuario_endereco
    ADD CONSTRAINT fk_usuario_endereco_usu FOREIGN KEY ( cd_usuario )
        REFERENCES tb_usuario ( cd_usuario );

ALTER TABLE tb_usuario_endereco
    ADD CONSTRAINT fk_usuario_endereco_end FOREIGN KEY ( cd_endereco )
        REFERENCES tb_endereco ( cd_endereco );