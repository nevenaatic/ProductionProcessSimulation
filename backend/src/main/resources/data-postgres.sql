-- roles
INSERT INTO role(name) VALUES ( 'QUALITY_ENGINEER');
INSERT INTO role(name) VALUES ( 'ROLE_PROCESS_MANAGER');
INSERT INTO role(name) VALUES ('PRODUCTION_MANAGER');
INSERT INTO role(name) VALUES ('EMPLOYEE');


--address
INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Novi Sad', 'Srbija', '11','Bulevar Kralja Petra I');
INSERT INTO address(id, city,country, number,street )
  VALUES (nextval('address_seq_gen'),'Sabac', 'Srbija', '5','Karadjordjeva');

--factory
INSERT INTO factory(id, name, pib, address_id, telephone, email, description )
 VALUES(1, 'Univerzal', '15487952', 2,'2522544122', 'univerzal@mail.com', 'Univerzal je firma koja se bavi gumiranjem, peskarenjem i antikorozivnom zastititom.');

 --user
 --password nevena
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'PE', 'nevena@gmail.com',1,true, null, 'Nevena', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Atic', '0555215', 1, 2,'2022-06-04 00:00', null,1);

--process step kind
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'),  'Priprema proizvoda', 5);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Varenje',5);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'),  'Vuklanizacija',10);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'),  'Gumiranje',5);
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'),  'Peskarenje',5);
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'AKZ',5);

--process step
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Priprema proizvoda je osnovni korak u proizvodnji.', 'Priprema proizvoda', 1);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Varenje delova proizvoda je neophodno da bude bez pukotina, rupa, glatkih ivica.', 'Varenje', 2);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Vulkanizacija delova', 'Vulkanizacija', 3);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Gumiranje unutrasnjosti proizvoda..', 'Gumiranje', 4);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Peskarenje........', 'Peskarenje', 5);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Anti korozivna zastita.', 'AKZ', 6);


--products
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 50000, 'Membrane za sve i svasta','Membrane');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 35000, 'Membrane za sve i svasta','Gumena membrana');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 40000, 'Membrane za sve i svasta','Cisterna za kiselinu');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 60000, 'Membrane za sve i svasta','Valjak');

--production process
INSERT INTO production_process(id, name, description, product_id, engineer_id) VALUES (nextval('production_process_seq_gen'), 'Proizvodnja membrani', 'Membrane za cisterne koje prevoze kiselinu', 1, 1);

--step of production process (table between ProductionProcess and ProcessStep)
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 1, 1, 1);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 2, 1, 2);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 3, 1, 3);