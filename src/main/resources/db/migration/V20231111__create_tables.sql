-- Criação das tabelas do banco de dados

CREATE TABLE tb_usuario (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- administrador, avaliador, usuário
    st_ativo BOOLEAN NOT NULL DEFAULT TRUE,
    dt_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    dt_atualizacao TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE tb_avaliacao (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(500) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    st_ordernada BOOLEAN NOT NULL DEFAULT FALSE,
    dt_inicio TIMESTAMP NOT NULL,
    dt_fim TIMESTAMP NOT NULL,
    st_ativo BOOLEAN NOT NULL DEFAULT TRUE,
    dt_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    dt_atualizacao TIMESTAMP NOT NULL DEFAULT NOW(),
    id_usuario UUID NOT NULL,
    CONSTRAINT fk_tb_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_pergunta (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conteudo VARCHAR(1500) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    ordem INTEGER,
    st_ativo BOOLEAN NOT NULL DEFAULT TRUE,
    dt_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    dt_atualizacao TIMESTAMP NOT NULL DEFAULT NOW(),
    id_avaliacao UUID NOT NULL,
    id_usuario UUID NOT NULL,
    CONSTRAINT fk_tb_avaliacao FOREIGN KEY (id_avaliacao) REFERENCES tb_avaliacao(id),
    CONSTRAINT fk_tb_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_alternativa (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conteudo VARCHAR(200) NOT NULL,
    st_correta BOOLEAN NOT NULL DEFAULT FALSE,
    st_ativo BOOLEAN NOT NULL DEFAULT TRUE,
    dt_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    dt_atualizacao TIMESTAMP NOT NULL DEFAULT NOW(),
    id_pergunta UUID NOT NULL,
    id_usuario UUID NOT NULL,
    CONSTRAINT fk_tb_pergunta FOREIGN KEY (id_pergunta) REFERENCES tb_pergunta (id),
    CONSTRAINT fk_tb_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_resposta (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_avaliacao UUID NOT NULL,
    id_pergunta UUID NOT NULL,
    id_alternativa UUID NOT NULL,
    dt_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    dt_atualizacao TIMESTAMP NOT NULL DEFAULT NOW(),
    id_usuario UUID NOT NULL,
    CONSTRAINT fk_tb_avaliacao FOREIGN KEY (id_avaliacao) REFERENCES tb_avaliacao(id),
    CONSTRAINT fk_tb_pergunta FOREIGN KEY (id_pergunta) REFERENCES tb_pergunta(id),
    CONSTRAINT fk_tb_alternativa FOREIGN KEY (id_alternativa) REFERENCES tb_alternativa(id),
    CONSTRAINT fk_tb_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);

-- Dicionário de dados
COMMENT ON TABLE tb_usuario IS 'Tabela que armazena os usuários';
COMMENT ON COLUMN tb_usuario.id IS 'Identificador único do usuário';
COMMENT ON COLUMN tb_usuario.nome IS 'Nome do usuário';
COMMENT ON COLUMN tb_usuario.email IS 'E-mail do usuário';
COMMENT ON COLUMN tb_usuario.senha IS 'Senha do usuário';
COMMENT ON COLUMN tb_usuario.tipo IS 'Tipo do usuário - administrador, avaliador, usuário';
COMMENT ON COLUMN tb_usuario.st_ativo IS 'Status do usuário - true: ativo, false: inativo';
COMMENT ON COLUMN tb_usuario.dt_criacao IS 'Data de criação do usuário';
COMMENT ON COLUMN tb_usuario.dt_atualizacao IS 'Data de atualização do usuário';
COMMENT ON TABLE tb_avaliacao IS 'Tabela que armazena as avaliações';
COMMENT ON COLUMN tb_avaliacao.id IS 'Identificador único da avaliação';
COMMENT ON COLUMN tb_avaliacao.titulo IS 'Título da avaliação';
COMMENT ON COLUMN tb_avaliacao.descricao IS 'Descrição da avaliação';
COMMENT ON COLUMN tb_avaliacao.tipo IS 'Tipo da avaliação - prova, questionário, etc';
COMMENT ON COLUMN tb_avaliacao.dt_inicio IS 'Data de início da avaliação';
COMMENT ON COLUMN tb_avaliacao.dt_fim IS 'Data de finalização da avaliação';
COMMENT ON COLUMN tb_avaliacao.st_ativo IS 'Status da avaliação - true: ativo, false: inativo';
COMMENT ON COLUMN tb_avaliacao.dt_criacao IS 'Data de criação da avaliação';
COMMENT ON COLUMN tb_avaliacao.dt_atualizacao IS 'Data de atualização da avaliação';
COMMENT ON COLUMN tb_avaliacao.st_ordernada IS 'Status da avaliação - true: ordernada, false: aleatória';
COMMENT ON COLUMN tb_avaliacao.id_usuario IS 'Identificador do usuário que criou a avaliação';
COMMENT ON TABLE tb_pergunta IS 'Tabela que armazena as perguntas';
COMMENT ON COLUMN tb_pergunta.id IS 'Identificador único da pergunta';
COMMENT ON COLUMN tb_pergunta.id_avaliacao IS 'Identificador único da avaliação';
COMMENT ON COLUMN tb_pergunta.tipo IS 'Tipo da pergunta - multipla escolha, aberta, etc';
COMMENT ON COLUMN tb_pergunta.ordem IS 'Ordem da pergunta na avaliação';
COMMENT ON COLUMN tb_pergunta.conteudo IS 'Conteúdo da pergunta';
COMMENT ON COLUMN tb_pergunta.tipo IS 'Tipo da pergunta - multipla escolha, aberta, etc';
COMMENT ON COLUMN tb_pergunta.st_ativo IS 'Status da pergunta - true: ativo, false: inativo';
COMMENT ON COLUMN tb_pergunta.dt_criacao IS 'Data de criação da pergunta';
COMMENT ON COLUMN tb_pergunta.dt_atualizacao IS 'Data de atualização da pergunta';
COMMENT ON COLUMN tb_pergunta.id_usuario IS 'Identificador do usuário que criou a pergunta';
COMMENT ON TABLE tb_alternativa IS 'Tabela que armazena as alternativas das perguntas';
COMMENT ON COLUMN tb_alternativa.id IS 'Identificador único da alternativa';
COMMENT ON COLUMN tb_alternativa.id_pergunta IS 'Identificador único da pergunta';
COMMENT ON COLUMN tb_alternativa.conteudo IS 'Conteúdo da alternativa';
COMMENT ON COLUMN tb_alternativa.st_correta IS 'Status da alternativa - true: correta, false: incorreta';
COMMENT ON COLUMN tb_alternativa.st_ativo IS 'Status da alternativa - true: ativo, false: inativo';
COMMENT ON COLUMN tb_alternativa.dt_criacao IS 'Data de criação da alternativa';
COMMENT ON COLUMN tb_alternativa.dt_atualizacao IS 'Data de atualização da alternativa';
COMMENT ON COLUMN tb_alternativa.id_usuario IS 'Identificador do usuário que criou a alternativa';
COMMENT ON TABLE tb_resposta IS 'Tabela que armazena as respostas das avaliações';
COMMENT ON COLUMN tb_resposta.id IS 'Identificador único da resposta';
COMMENT ON COLUMN tb_resposta.id_avaliacao IS 'Identificador único da avaliação';
COMMENT ON COLUMN tb_resposta.id_pergunta IS 'Identificador único da pergunta';
COMMENT ON COLUMN tb_resposta.id_alternativa IS 'Identificador único da alternativa';
COMMENT ON COLUMN tb_resposta.dt_criacao IS 'Data de criação da resposta';
COMMENT ON COLUMN tb_resposta.dt_atualizacao IS 'Data de atualização da resposta';
COMMENT ON COLUMN tb_resposta.id_usuario IS 'Identificador do usuário que respondeu a avaliação';