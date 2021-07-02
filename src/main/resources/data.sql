DROP TABLE IF EXISTS car;

CREATE TABLE car
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(250) NOT NULL,
    model VARCHAR(250) NOT NULL,
    img   TEXT DEFAULT NULL
);
INSERT INTO car (id, brand, model, img) VALUES (1, 'BMW', 'X6', 'base64image');
INSERT INTO car (id, brand, model, img) VALUES (2, 'AUDI', 'A3', 'base64image');
INSERT INTO car (id, brand, model, img) VALUES (3, 'CITROEN', 'C4', 'base64image');