INSERT INTO tb_baseuser (name,email) 
VALUES ('Uchoas','uchoas@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-6857', 1);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Edgar','edgar@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-9794', 2);

INSERT INTO tb_baseuser (name,email) 
VALUES ('João','joao@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-0542', 3);


INSERT INTO tb_baseuser (name,email) 
VALUES ('Nami','nami@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (50.00, 4);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Zed','zed@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (35.00, 5);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Warwick','Warwick@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (0.10, 6);


INSERT INTO tb_place (city, address) VALUES ('São Paulo', 'Jardim dos Gnomos, Rua dos Smurfs nº 23');
INSERT INTO tb_place (city, address) VALUES ('Rio de Janeiro', 'Arizona, Rota 66');
INSERT INTO tb_place (city, address) VALUES ('Recife', 'Jardim das Aves, Rua das Caldeiras nº 12');
INSERT INTO tb_place (city, address) VALUES ('São Paulo', 'Jardim das Cobras, Rua dos Tucanos nº 27');
INSERT INTO tb_place (city, address) VALUES ('Rio de Janeiro', 'Disney, Rota 6');
INSERT INTO tb_place (city, address) VALUES ('Recife', 'Coqueiros, Rua das Escadas nº 65');


INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'cinema', 'Circ of Magic', '12:00:00', '18:00:00', 'joaouchoas@gmail.com',
    0, 10000, 100.00, 3, 1
);

INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'teatro', 'Beauty and the Beast', '19:00:00', '21:30:00', 'theatreboxoffice@example.com',
    0, 200, 150.00, 2, 2
);

INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'show', 'AC/DC', '20:00:00', '23:00:00', 'musicconcerts@example.com',
    100, 900, 200.00, 1, 3
);

INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'cinema', 'Aladdin', '12:00:00', '18:00:00', 'joaouchoas@gmail.com',
    0, 10000, 100.00, 3, 4
);

INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'teatro', 'The Great Music Concert', '19:00:00', '21:30:00', 'theatreboxoffice@example.com',
    0, 200, 150.00, 2, 5
);

INSERT INTO tb_event (
    category, name, start_time, end_time, email_contact,
    amount_vip_tickets, amount_common_tickets, price_ticket, ADMIN_BASEUSER_ID, place_id
) VALUES (
    'show', 'Nirvana in the sky', '20:00:00', '23:00:00', 'music@example.com',
    100, 900, 200.00, 1, 6
);


INSERT INTO tb_seat (rowV, number, is_available, event_id) VALUES
('A', 1, TRUE, 1), ('A', 2, TRUE, 1), ('A', 3, TRUE, 1), ('A', 4, TRUE, 1), ('A', 5, TRUE, 1),
('A', 6, TRUE, 1), ('A', 7, TRUE, 1), ('A', 8, TRUE, 1), ('A', 9, TRUE, 1), ('A', 10, TRUE, 1),
('A', 11, TRUE, 1), ('A', 12, TRUE, 1), ('A', 13, TRUE, 1), ('A', 14, TRUE, 1), ('A', 15, TRUE, 1),
('A', 16, TRUE, 1), ('A', 17, TRUE, 1), ('A', 18, TRUE, 1), ('A', 19, TRUE, 1), ('A', 20, TRUE, 1),
('B', 1, TRUE, 2), ('B', 2, TRUE, 2), ('B', 3, TRUE, 2), ('B', 4, TRUE, 2), ('B', 5, TRUE, 2),
('B', 6, TRUE, 2), ('B', 7, TRUE, 2), ('B', 8, TRUE, 2), ('B', 9, TRUE, 2), ('B', 10, TRUE, 2),
('B', 11, TRUE, 2), ('B', 12, TRUE, 2), ('B', 13, TRUE, 2), ('B', 14, TRUE, 2), ('B', 15, TRUE, 2),
('B', 16, TRUE, 2), ('B', 17, TRUE, 2), ('B', 18, TRUE, 2), ('B', 19, TRUE, 2), ('B', 20, TRUE, 2);




