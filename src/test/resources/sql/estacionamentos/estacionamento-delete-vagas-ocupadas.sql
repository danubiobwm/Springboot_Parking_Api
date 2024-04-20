DELETE FROM CLIENTES_TEM_VAGAS;
DELETE FROM CLIENTES;
DELETE FROM VAGAS;
DELETE FROM USUARIOS;

insert into clientes_tem_vagas (numero_recibo, placa, marca, modelo, cor, data_entrada, id_cliente, id_vaga) values ('20230315-101500', 'FIT-1020', 'FIAT', 'PALIO', 'VERDE', '2023-03-14 10:15:00', 22, 300);
