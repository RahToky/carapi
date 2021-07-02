CREATE TABLE car
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(250) NOT NULL,
    model VARCHAR(250) NOT NULL,
    img   VARCHAR(250) DEFAULT NULL,
    test INT
);
INSERT INTO car VALUES (1, 'BMW', 'X6', 'base64image',2);
INSERT INTO car VALUES (2, 'AUDI', 'A3', 'base64image',2);
INSERT INTO car VALUES (3, 'CITROEN', 'C4', 'base64image',1);