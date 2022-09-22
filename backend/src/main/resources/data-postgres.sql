-- roles
INSERT INTO role(name) VALUES ('ROLE_QUALITY_ENGINEER');
INSERT INTO role(name) VALUES ('ROLE_PROCESS_ENGINEER');
INSERT INTO role(name) VALUES ('ROLE_PRODUCTION_MANAGER');
INSERT INTO role(name) VALUES ('ROLE_EMPLOYEE');


--address
INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Novi Sad', 'Srbija', '11','Bulevar Kralja Petra I'); --PE Nevena, adr 1
INSERT INTO address(id, city,country, number,street )
  VALUES (nextval('address_seq_gen'),'Skupljen', 'Srbija', '1','Filipa Visnjica'); --factory  adr 2

INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Obrenovac', 'Srbija', '15','Milutina Milankovica'); --3
INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Nis', 'Srbija', '7','Kralja Milana');--4
INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Kostolac', 'Srbija', '8','Cara Lazara'); --5
INSERT INTO address(id, city,country, number,street )
 VALUES (nextval('address_seq_gen'),'Mrdjenovac', 'Srbija', 'bb','bez ulice');  --6
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Sabac', 'Srbija', '3','Prote Smiljanica'); --7
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Sabac', 'Srbija', '68','Cerska');    --QE  adr8
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Ub', 'Srbija', '11','Copiceva'); --9 PM
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Debrc', 'Srbija', '16','Marka Kraljevica'); --10
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Banjani', 'Srbija', '9','Isidore Sekulic'); --11
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Vladimirci', 'Srbija', '14','Svetog Save'); --12
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Platicevo', 'Srbija', '4','Sremska'); --13
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Jarak', 'Srbija', '17','Nemanjina'); --14
 INSERT INTO address(id, city,country, number,street )
VALUES (nextval('address_seq_gen'),'Platicevo', 'Srbija', '10','Isidore Sekulic'); --15

--factory
INSERT INTO factory(id, name, pib, address_id, telephone, email, description )
VALUES(1, 'Univerzal', '15487952', 2,'0157529128', 'univerzal@mail.com',
 'Univerzal je firma koja se bavi gumiranjem, peskarenjem i antikorozivnom zastititom. Antikorozivna zastita procesne opreme kao sto su skladisni rezervoari, zeleznicke i autocisterne, filterska postrojenja u HPV-ima, galvanske posude. Izrada i gumiranje cevovoda i cevnih elemenata, gumiranje centrifuga, resetki, ventilatora, kucista pumpi i druge slozene opreme. Proizcodnja opreme je takodje deo procesa kojim se bavimo od samog osnivanja firme');

 --user
 --password nevena
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 1,'PE', 'nevena@gmail.com',1,true, null, 'Nevena', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Atic', '0555215', 1, 2,'2022-06-04 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'marko@gmail.com',0,true, null, 'Marko', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Matic', '06982615412', 3, 4,'1980-08-14 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'darko@gmail.com',0,true, null, 'Darko', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Gajic', '06526505', 4, 4,'1982-04-24 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'jovan@gmail.com',0,true, null, 'Jovan', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovanovic', '06452625', 5, 4,'1975-03-13 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'nikola@gmail.com',0,true, null, 'Nikola', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Nikolic', '06158565485', 6, 4,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'dragana@gmail.com',1,true, null, 'Dragana', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovicic', '06158565485', 7, 4,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'pera@gmail.com',0,true, null, 'Pera', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Peric', '06158565485', 10, 4,'1990-11-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'marija@gmail.com',1,true, null, 'Marija', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Matic', '06158565485', 11, 4,'1978-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'dragan@gmail.com',0,true, null, 'Dragan', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovovic', '06158565485', 12, 4,'1965-03-13 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'zoran@gmail.com',0,true, null, 'Zoran', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Arsovic', '06158565485', 13, 4,'1983-08-07 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'danijela@gmail.com',1,true, null, 'Danijela', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Anastasijevic', '06158565485', 14, 4,'1979-08-17 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 3,'EE', 'daca@gmail.com',0,true, null, 'Dalibor', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Petrovic', '06158565485', 15, 4,'1985-11-02 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 0,'QE', 'lazar@gmail.com',0,true, null, 'Lazar', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Lukic', '06158565485', 8, 1,'1990-09-11 00:00', null,1);
INSERT INTO users(id, type,dtype, email, gender, enabled, last_password_reset_date,name,password,  surname, telephone, address_id, role_id, birthday, picture, factory_id )
VALUES (nextval('user_seq_gen'), 2,'PM', 'marta@gmail.com',1,true, null, 'Marta', '$2a$10$S6VHCehpPiJgV3NStRbB7OkqE3U4QjfxdFbVw2dSmTPTUkykY1rjy','Jovicic', '06158565485', 9, 3,'1990-09-11 00:00', null,1);
--process step kind
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Priprema proizvoda', 4);
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Varenje',5);
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Vuklanizacija',2);  --bravar i gumar
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Gumiranje',4);
INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Peskarenje',3);

INSERT INTO process_step_kind(id, name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'AKZ',3);

INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'),  'Priprema materijala', 3);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Varenje i busenje', 3);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Ciscenje, pranje i premazivanje', 2); --otprasivanje i pranje
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Premazivanje', 1);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'AKZ spolja', 3);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'AKZ unutra', 2);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Krojenje i uvlacenje gume u cev', 2);
INSERT INTO process_step_kind(id,  name, number_of_people) VALUES (nextval('process_step_kind_seq_gen'), 'Presovanje', 2);


--process step
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Alati za membrane razlicitih tipova kao i kalupi za njihovo izlivanje.', 'Priprema alata', 1);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Guma se promesa kroz valjke da omeksa, pa tako omeksala stavlja u prethodno pripremljen alat.', 'Priprema gume i kalupiranje', 1);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Alat se uvlaci u presu, pa izvlaci i proverava krajnji rezultat nakon odredjenog broja sati u zavisnosti od vrste materijala.', 'Presovanje', 14);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Peskarenje proizvoda, ciscenje od korozije, prljavstine i drugih nezeljenosti.', 'Peskarenje', 5);

INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Anti-korozivna zastita.', 'AKZ', 6);


INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Priprema materijala se izvodi od strane 3 radnika koji seku, vare i bruse materijal.', 'Priprema materijala', 7);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Varenje i busenje prirubnica u kome se koriste adekvatni aparati koji pruzaju trajnost i jednostavnu upotrebu', 'Varenje i busenje prirubnica', 8);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Obavezan korak za pripremu povrsina pre dalje obrade, nanosenja zastitnih materijala.', 'Peskarenje', 8);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Ciscenje, pranje i premazivanje proizvoda.', 'Otprasivanje i pranje', 9);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Premaz sirovim lepkom koji se pravi od sirove gume bez cadji i trihloretilena.', 'Premazivanje', 10);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Krojenje gume, uvlacenje gume u cev, lepljenje za zidove cevi.', 'Gumiranje cevi', 4);
INSERT INTO process_step(id, description, name, process_step_kind_id) VALUES (nextval('process_step_seq_gen'), 'Pecenje u autoklavu. Pece se na 145C, vazduh od 4Bar.', 'Vulkanizacija', 3);

--products
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 5000, 'Membrane se proizvode u razlicitim dimenzijama u zavisnosti od namene, za membranske ventile ili nepovratne.','Membrane za membranski ventil');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 5000, 'Membrane se proizvode u razlicitim dimenzijama u zavisnosti od namene, za membranske ventile ili nepovratne.','Membrana za nepovratne ventile');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 4000, 'Šavne cevi su uzdužno elektrootporno zavarene cevi, hladno oblikovanog osnovnog materijala okruglog, kvadratnog i pravougaonog preseka','Cev (savna)');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 3000, 'Besavna cev napravljena od jednog komada materijala, bez savova na povrsini.','Cev (besavna)');
INSERT INTO product(id, final_price, usage_description, name) VALUES (nextval('product_seq_gen'), 6500, 'Cev na kojoj je izvrsena antikorozivna zastita.','Cev (akz)');

--production process
INSERT INTO production_process(id, name, description, product_id, engineer_id) VALUES (nextval('production_process_seq_gen'), 'Proizvodnja membrani', 'Membrane se proizvode u razlicitim dimenzijama u zavisnosti od namene, za membranske ventile ili nepovratne', 1, 1);
INSERT INTO production_process(id, name, description, product_id, engineer_id) VALUES (nextval('production_process_seq_gen'), 'Proizvodnja besavnih cevi ', 'Bešavne cevi služe za veća opterećenja, imaju bolja mehanička svojstva i visok stepen sigurnosti. Cevi bez šava dobijaju se toplim valjanjem ili hladnim vučenjem.Bešavne cevi mogu biti: hladno vučene bešavne cevi, OCTG – Casing and Tubing, bešavne konstrukcione cevi, bešavne cevi za naftu i gas (predizolovane cevi), bešavne provodne čelične cevi za povišene temperature, bešavne provodne čelične cevi za normalne temperature.', 4,1);

--step of production process (table between ProductionProcess and ProcessStep)
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 1, 1, 1);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 2, 1, 2);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 3, 1, 3);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 4, 1, 4);

INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 6, 2, 1);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 7, 2, 2);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 8, 2, 3);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 9, 2, 4);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 10, 2, 5);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 11, 2, 6);
INSERT INTO step_of_production_process(id, step_id, process_id, process_step_number) VALUES (nextval('sopp_seq_gen'), 12, 2, 7);


--material
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'AB152', 2600,'Guma',0);
INSERT INTO material(id, label_id, price, name,material_unit_type) VALUES (nextval('material_seq_gen'), 'AB146', 250,'Razredjivac',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'A15152', 300,'Kiselinski razredjivac',1);
INSERT INTO material(id, label_id, price, name, material_unit_type) VALUES (nextval('material_seq_gen'), 'ghu554', 650,'Celik',0);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'uyigtuy1', 650,'Lepak',1);

INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'FG243', 200,'Prirubnica',3);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'MKJ56', 50,'Elektrode',3);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'LJK879', 60,'Kvarcni pesak',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'HYIBY3', 250,'Nafta',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'LLHJ87', 350,'Trihloretilen',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'PO9867', 1800,'Sirova guma bez cadji',0);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'PPOYT5', 850,'Svileno platno',0);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'TTTYT5', 1200,'Toluol',1);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'KIJUB', 120,'Srafovi',3);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'CSDT5', 300,'Opruge',3);
INSERT INTO material(id, label_id, price,name, material_unit_type) VALUES (nextval('material_seq_gen'), 'CPPT5', 700,'Cefer platno',2);
--step_material
--proizvodnja membrani
INSERT INTO step_material(material_id, step_id) VALUES (1,2);
INSERT INTO step_material(material_id, step_id) VALUES (13,2);
INSERT INTO step_material(material_id, step_id) VALUES (14,2);
INSERT INTO step_material(material_id, step_id) VALUES (15,2);
INSERT INTO step_material(material_id, step_id) VALUES (16,2);

--proizvodnja besavnih cevi
INSERT INTO step_material(material_id, step_id) VALUES (4,6);
INSERT INTO step_material(material_id, step_id) VALUES (6,6);
INSERT INTO step_material(material_id, step_id) VALUES (7,7);
INSERT INTO step_material(material_id, step_id) VALUES (8,8);
INSERT INTO step_material(material_id, step_id) VALUES (9,8);
INSERT INTO step_material(material_id, step_id) VALUES (8,9);
INSERT INTO step_material(material_id, step_id) VALUES (10,9);
INSERT INTO step_material(material_id, step_id) VALUES (11,10);
INSERT INTO step_material(material_id, step_id) VALUES (8,10);
INSERT INTO step_material(material_id, step_id) VALUES (11,11);
INSERT INTO step_material(material_id, step_id) VALUES (12,11);
INSERT INTO step_material(material_id, step_id) VALUES (9,12);


--failure
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nestanak struje', 2, 0.5 );
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nedostatak materijala',1, 0.05);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Los materijal (stara guma)', 1,0.15 );
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Neadekvatan rad',0, 0.2);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Lose obradjena guma(risovi)',0, 0.02);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Lose pripremljen alat',0, 0.01);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nedovoljno procenjen pritisak prese',0, 0.01);
INSERT INTO failure(id, name, failure_type, probability ) VALUES (nextval('failure_seq_gen'), 'Nedovoljna tvrdoca gume kao krajnji ishod procesa obrade',0, 0.02);



--failure in process step - for process 1 step 3
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 3, 3, null);
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 5, 3, null);
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 7, 3, null);
INSERT INTO failure_in_process_step(id, failure_id, process_step_id, quality_engineer_id) VALUES (nextval('failureips_seq_gen'), 8, 3, null);


--final production process
INSERT INTO final_production_process(id, process_engineer_id, production_process_id, date_start, label, is_valid) VALUES (nextval('final_production_seq_gen'),1, 1,'2022-09-10 00:00', 'AKNUBU42',true );
--final process step
INSERT INTO final_process_step(id, sofpp_id, failure_inps_id, finalpp_id, date_start, date_end) VALUES (nextval('final_step_seq_gen'), 1,null, 1,'2022-09-11 00:00', '2022-09-13 00:00');
INSERT INTO final_process_step(id, sofpp_id, failure_inps_id, finalpp_id, date_start, date_end) VALUES (nextval('final_step_seq_gen'), 2,null, 1,'2022-09-11 00:00', '2022-09-13 00:00');
INSERT INTO final_process_step(id, sofpp_id, failure_inps_id, finalpp_id, date_start, date_end) VALUES (nextval('final_step_seq_gen'), 3,null, 1,'2022-09-11 00:00', '2022-09-13 00:00');
INSERT INTO final_process_step(id, sofpp_id, failure_inps_id, finalpp_id, date_start, date_end) VALUES (nextval('final_step_seq_gen'), 4,null, 1,'2022-09-11 00:00', '2022-09-13 00:00');


INSERT INTO final_product(id, label, product_id, engineer_id, product_type, checked) VALUES (nextval('final_product_seq_gen'), 'kOK52',1, null,0, false );

--engagement by workers
--production process 1,
 --step 1
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 1, 2, 2.3); --marko, id 2
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 1,3,2 ); -- darko id 3
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 1, 4, 2.1);  -- jovan id 4
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 1, 5, 1.9);  -- nikola id 5
    --step 2
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 2, 2, 3); --marko, id 2
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 2,3,3.1 ); -- darko id 3
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 2, 4, 3.5);  -- jovan id 4
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 2, 5, 2.8);  -- nikola id 5
    --step 3
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 3, 2, 5); --marko, id 2
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 3,3,5.3 ); -- darko id 3
    --step 4
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 4, 2, 3.8); --marko, id 2
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 4,3,3.7 ); -- darko id 3
INSERT INTO employee_with_engagement(id, finalps_id, employee_id, hours) VALUES (nextval('engagement_seq_gen'), 4, 4, 3.5);  -- jovan id 4
