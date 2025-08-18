-- PROFESSORES

INSERT INTO tb_professor (id,nome,email,formacao) VALUES (1, 'Leticia Ribeiro', 'leticia.ribeiro@escola.com', 'Matemática');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (2, 'Pedro Barbosa', 'pedro.barbosa@escola.com', 'Português');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (3, 'Beatriz Lima', 'beatriz.lima@escola.com', 'História');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (4, 'Eduardo Almeida', 'eduardo.almeida@escola.com', 'Geografia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (5, 'Pedro Pereira', 'pedro.pereira@escola.com', 'Física');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (6, 'Matheus Lima', 'matheus.lima@escola.com', 'Química');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (7, 'Ana Moura', 'ana.moura@escola.com', 'Biologia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (8, 'Julia Ferreira', 'julia.ferreira@escola.com', 'Língua Inglesa');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (9, 'Diego Monteiro', 'diego.monteiro@escola.com', 'Língua Espanhola');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (10, 'Sofia Nascimento', 'sofia.nascimento@escola.com', 'Educação Física');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (11, 'Julia Araujo', 'julia.araujo@escola.com', 'Filosofia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (12, 'Ana Silva', 'ana.silva@escola.com', 'Sociologia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (13, 'Leonardo Santos', 'leonardo.santos@escola.com', 'Artes');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (14, 'Julia Mendes', 'julia.mendes@escola.com', 'Literatura');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (15, 'Bruna Martins', 'bruna.martins@escola.com', 'Redação');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (16, 'Daniel Gomes', 'daniel.gomes@escola.com', 'Ciências');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (17, 'Lucas Lima', 'lucas.lima@escola.com', 'Ensino Religioso');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (18, 'Pedro Ferreira', 'pedro.ferreira@escola.com', 'Pedagogia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (19, 'Pedro Souza', 'pedro.souza@escola.com', 'Pedagogia');
INSERT INTO tb_professor (id,nome,email,formacao) VALUES (20, 'Camila Pereira', 'camila.pereira@escola.com', 'Pedagocia');


-- Disciplinas
-- DISCIPLINAS

INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (1, 'Matemática', 80, 1);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (2, 'Português', 80, 2);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (3, 'História', 60, 3);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (4, 'Geografia', 60, 4);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (5, 'Física', 60, 5);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (6, 'Química', 60, 6);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (7, 'Biologia', 60, 7);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (8, 'Língua Inglesa', 40, 8);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (9, 'Língua Espanhola', 40, 9);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (10, 'Educação Física', 40, 10);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (11, 'Filosofia', 40, 11);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (12, 'Sociologia', 40, 12);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (13, 'Artes', 40, 13);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (14, 'Literatura', 40, 14);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (15, 'Redação', 40, 15);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (16, 'Ciências', 60, 16);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (17, 'Ensino Religioso', 30, 17);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (18, 'Pedagogia I', 30, 18);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (19, 'Pedagogia II', 30, 19);
INSERT INTO tb_disciplina (codigo,nome,total_aulas,id_professor) VALUES (20, 'Pedagogia III', 30, 20);

