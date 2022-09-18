-- roles
INSERT INTO role(name) VALUES ('ROLE_QUALITY_ENGINEER');
INSERT INTO role(name) VALUES ('ROLE_PROCESS_ENGINEER');
INSERT INTO role(name) VALUES ('ROLE_PRODUCTION_MANAGER');
INSERT INTO role(name) VALUES ('ROLE_EMPLOYEE');


--address
INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Novi Sad', 'Srbija', '11','Bulevar Kralja Petra I');
INSERT INTO address(id, city,country, number,street )
  VALUES (nextval('address_seq_gen'),'Skupljen', 'Srbija', '1','Filipa Visnjica');

INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Obrenovac', 'Srbija', '15','Milutina Milankovica');
INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Nis', 'Srbija', '7','Kralja Milana');
INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Kostolac', 'Srbija', '8','Cara Lazara');
INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Mrdjenovac', 'Srbija', 'bb','bez ulice');

 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Sabac', 'Srbija', '3','Prote Smiljanica');
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Sabac', 'Srbija', '68','Cerska');
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Ub', 'Srbija', '11','Copiceva');
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Debrc', 'Srbija', '16','Marka Kraljevica');
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Banjani', 'Srbija', '9','Isidore Sekulic');
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Vladimirci', 'Srbija', '14','Svetog Save');

--factory
INSERT INTO factory(id, name, pib, address_id, telephone, email, description )
VALUES(1, 'Univerzal', '15487952', 2,'0157529128', 'univerzal@mail.com',
 'Univerzal je firma koja se bavi gumiranjem, peskarenjem i antikorozivnom zastititom. Antikorozivna zastita procesne opreme kao sto su skladisni rezervoari, zeleznicke i autocisterne, filterska postrojenja u HPV-ima, galvanske posude. Izrada i gumiranje cevovoda i cevnih elemenata, gumiranje centrifuga, resetki, ventilatora, kucista pumpi i druge slozene opreme. Proizcodnja opreme je takodje deo procesa kojim se bavimo od samog osnivanja firme');

 --user
 --password nevena
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'PE', 'nevena@gmail.com',1,true, null, 'Nevena', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Atic', '0555215', 1, 2,'2022-06-04 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'marko@gmail.com',0,true, null, 'Marko', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Matic', '06982615412', 3, 4,'1980-08-14 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'darko@gmail.com',0,true, null, 'Darko', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Gajic', '06526505', 4, 4,'1982-04-24 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'jovan@gmail.com',0,true, null, 'Jovan', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovanovic', '06452625', 5, 4,'1975-03-13 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'nikola@gmail.com',0,true, null, 'Nikola', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Nikolic', '06158565485', 6, 4,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'dragana@gmail.com',1,true, null, 'Dragana', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovicic', '06158565485', 7, 4,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'QE', 'lazar@gmail.com',0,true, null, 'Lazar', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Lukic', '06158565485', 8, 1,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'PM', 'marta@gmail.com',1,true, null, 'Marta', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovicic', '06158565485', 8, 3,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'pera@gmail.com',0,true, null, 'Pera', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Peric', '06158565485', 9, 4,'1990-11-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'marija@gmail.com',1,true, null, 'Marija', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Matic', '06158565485', 10, 4,'1978-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'dragan@gmail.com',0,true, null, 'Dragan', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovovic', '06158565485', 11, 4,'1965-03-13 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'EE', 'zoran@gmail.com',0,true, null, 'Zoran', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Arsovic', '06158565485', 12, 4,'1983-08-07 00:00', null,1);

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
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 4, 1, 4);

--material
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'AB152', 200,'Guma',0);
INSERT INTO material(id, label_id, price, name,material_unit_type) VALUES (nextval('material_seq_gen'), 'AB146', 250,'Razredjivac',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'A15152', 300,'Kiselinski razredjivac',1);
INSERT INTO material(id, label_id, price, name, material_unit_type) VALUES (nextval('material_seq_gen'), 'ghu554', 650,'Celik',0);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'uyigtuy1', 650,'Lepak',1);

--step_material
INSERT INTO step_material(material_id, step_id) VALUES (1,4);
INSERT INTO step_material(material_id, step_id) VALUES (4,4);
INSERT INTO step_material(material_id, step_id) VALUES (2,4);

--failure
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nestanak struje', 2, 0.5 );
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nedostatak materijala',1, 0.05);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Los materijal', 1,0.15 );
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Neadekvatan rad',0, 0.2);

--failure in process step
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 1, 1, null);
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 3, 1, null);