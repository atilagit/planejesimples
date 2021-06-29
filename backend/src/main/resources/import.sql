insert into tb_user (name, email, password) values ('Átila Izac','atila__7@hotmail.com','321');
insert into tb_user (name, email, password) values ('Mateus Suave','mateus__7@gmail.com','123');
insert into tb_user (name, email, password) values ('Teste de um nome um pouco maior','teste__7@hotmail.com','222');

insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2021-08-13T00:00:00Z',1500.00,1650.00,1);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-08-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2021-09-13T00:00:00Z',1500.00,1650.00,1);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-09-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2021-10-13T00:00:00Z',1500.00,1650.00,2);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-10-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2021-11-13T00:00:00Z',1500.00,1650.00,2);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-11-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2021-12-13T00:00:00Z',1500.00,1650.00,2);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2021-12-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2022-01-13T00:00:00Z',1500.00,1650.00,3);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2022-01-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2022-02-13T00:00:00Z',1500.00,1650.00,3);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2022-02-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2022-03-13T00:00:00Z',1500.00,1650.00,3);
insert into tb_planning (initial_Date, final_Date, expected_Entry, real_Entry, user_id) values (TIMESTAMP WITH TIME ZONE '2022-03-14T00:00:00Z',TIMESTAMP WITH TIME ZONE '2022-04-13T00:00:00Z',1500.00,1650.00,3);

insert into tb_item_name (name, user_Id) values ('Conta de Luz', null);
insert into tb_item_name (name, user_Id) values ('Água', null);
insert into tb_item_name (name, user_Id) values ('Gás', null);
insert into tb_item_name (name, user_Id) values ('Aluguel', null);
insert into tb_item_name (name, user_Id) values ('Carro Financiamento', null);
insert into tb_item_name (name, user_Id) values ('PetShop', null);
insert into tb_item_name (name, user_Id) values ('Curso Manicure', null);
insert into tb_item_name (name, user_Id) values ('Inglês', null);
insert into tb_item_name (name, user_Id) values ('Teste de um nome de item um pouco maior', null);

insert into tb_item_name (name, user_Id) values ('PetShop', 1);
insert into tb_item_name (name, user_Id) values ('Cursinho Vestibular', 2);
insert into tb_item_name (name, user_Id) values ('Energia elétrica da casa do cachorrinho', 2);


insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (1, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 1);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (2, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 1);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (3, null, 120.00, 135.00, 1);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (4, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 1);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (5, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 2);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (6, null, 120.00, 135.00, 2);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (7, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 2);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (8, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 2);
insert into tb_item (item_name_id, due_Date, expectancy, reality, planning_id) values (9, TIMESTAMP WITH TIME ZONE '2021-07-14T00:00:00Z', 120.00, 135.00, 2);