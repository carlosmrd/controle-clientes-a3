USE controle_clientes_a3;

INSERT INTO Cliente (nome, telefone, uf, cep, complemento, cpf, numero_processo, status_cliente) VALUES
('João Silva', '11999998888', 'SP', '01001000', 'número 123', '12345678901', '2024X0001', 1),
('Ana Lima', '21912345678', 'RJ', '22041001', 'número 456', '98765432100', '2024X0002', 2),
('Carlos Mendes', '31987654321', 'MG', '30130003', 'número 789', '45678912300', '2024X0003', 3),
('Mariana Souza', '41911223344', 'PR', '80020010', 'número 321', '32165498700', '2024X0004', 4),
('Beatriz Rocha', '51999887766', 'RS', '90160000', 'número 654', '65498732100', '2024X0005', 5),
('Fernando Castro', '61988776655', 'GO', '74210020', 'número 15', '14725836900', '2024X0006', 2),
('Camila Duarte', '71933445566', 'BA', '40140071', 'número 789', '96385274100', '2024X0007', 1),
('Rafael Torres', '83922334455', 'PB', '58013080', 'número 555', '85274196300', '2024X0008', 3),
('Luciana Ramos', '85999887766', 'CE', '60165012', 'número 2000', '74185296300', '2024X0009', 4),
('Eduardo Nogueira', '62988776655', 'GO', '75020010', 'número 101', '15935725800', '2024X0010', 5),
('Juliana Ferreira', '11911223344', 'SP', '01304000', 'número 900', '25896314700', '2024X0011', 1),
('Marcos Andrade', '21988776655', 'RJ', '22220000', 'número 77', '75315985200', '2024X0012', 3),
('Vanessa Martins', '31922334455', 'MG', '32310010', 'número 3500', '95175385200', '2024X0013', 2);

INSERT INTO Anotacao (id_cliente, descricao_anotacao, data_hora) VALUES
(1, 'Cliente trouxe documentos incompletos.', '2024-05-01 10:30:00'),
(1, 'Cliente entregou parte dos documentos faltantes.', '2024-05-03 09:40:00'),
(2, 'Aguardando retorno para confirmação de reunião.', '2024-05-02 14:00:00'),
(3, 'Explicado o andamento do processo em detalhes.', '2024-05-03 09:15:00'),
(4, 'Cliente pediu simulação de honorários.', '2024-05-04 11:45:00'),
(5, 'Caso em análise. Retornar ligação em 2 dias.', '2024-05-05 16:20:00'),
(6, 'Nova documentação enviada por e-mail.', '2024-05-06 13:00:00'),
(7, 'Cliente solicitou reenvio de documentos.', '2024-05-07 10:30:00'),
(8, 'Foi marcada nova reunião com advogado.', '2024-05-08 09:20:00'),
(9, 'Cliente relatou dificuldades com prazos.', '2024-05-09 14:45:00'),
(10, 'Documentação completa recebida.', '2024-05-10 11:10:00'),
(11, 'Aguardando parecer jurídico.', '2024-05-11 13:50:00'),
(12, 'Cliente pediu revisão da proposta.', '2024-05-12 15:00:00'),
(13, 'Cliente solicitou reenvio de documentos.', '2024-05-07 10:30:00');

INSERT INTO Lembrete (id_cliente, data_hora, descricao_lembrete) VALUES
(1, '2025-07-01 09:00:00', 'Reunião para verificar pendências.'),
(2, '2025-07-02 15:30:00', 'Apresentação de proposta de honorários.'),
(3, '2025-07-03 10:00:00', 'Assinatura de contrato.'),
(4, '2025-07-04 11:00:00', 'Reunião de atualização do processo.'),
(5, '2025-07-05 14:30:00', 'Entrega de documentos finais.'),
(6, '2025-07-06 16:00:00', 'Ligar para confirmar presença na reunião.'),
(7, '2025-07-07 09:00:00', 'Reunião com advogado responsável.'),
(8, '2025-07-08 14:30:00', 'Envio de documentos pendentes.'),
(9, '2025-07-09 11:15:00', 'Consulta sobre próximos passos do processo.'),
(10, '2025-07-10 16:00:00', 'Entregar documentação assinada.'),
(11, '2025-07-11 13:00:00', 'Ligar para agendar reunião de fechamento.'),
(12, '2025-07-12 15:30:00', 'Apresentar orçamento atualizado.'),
(13, '2025-07-07 09:00:00', 'Reunião com advogado responsável.');