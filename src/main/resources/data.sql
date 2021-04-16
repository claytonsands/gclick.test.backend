INSERT INTO cliente (id, inscricao, nome, apelido, status) VALUES
  (1, '1', 'Clayton Monteiro', 'csmont', 1),
  (2, '2', 'Stefania Szkruc', 'ste', 1),
  (3, '3', 'Samuel Szkruc', 'sam', 0),
  (4, '4', 'Joao da Silva', 'joao', 2),
  (5, '5', 'Fulano de Souza', 'fulano', 0),
  (6, '6', 'Beltrano Costa', 'beltrano', 2),
  (7, '7', 'Gilberto Gil', 'gil', 1),
  (8, '8', 'Ana Maria Branga', 'ana', 0),
  (9, '9', 'Fabio Assunção', 'fabinho', 2),
  (10, '10', 'Gloria Pires', 'glorinha', 0);
  
  
INSERT INTO email (id, categoria, nome, email, id_cliente) VALUES
  (1, 'Pessoal', 'Clayton Monteiro', 'clayton.sands@gmail.com', 1),
  (2, 'Trabalho', 'Clayton Monteiro', 'clayton.sands@hotmail.com', 1),
  (3, 'Pessoal', 'Stefania Monteiro', 'ste@gmail.com', 2),
  (4, 'Particular', 'Samuel', 'samuel@gmail.com', 3),
  (5, 'Outros', 'Backup', 'backup@gmail.com', 1),
  (6, 'Pessoal', 'Joao da Silva', 'joao@gmail.com', 4),
  (8, 'Comercial', 'Meu email', 'teste@yahoo.com.br', 5),
  (9, 'Outros', 'Filho', 'filho@globo.com', 10),
  (10, 'Pessoal', 'Clayton Monteiro', 'clayton.sands@gmail.com', 8);
  