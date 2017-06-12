CREATE DATABASE pracownicy;

CREATE TABLE login (
    id_login INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    users VARCHAR(50) NOT NULL,
    passwords VARCHAR(50) NOT NULL,
    access VARCHAR(20) NOT NULL
);

CREATE TABLE employee (
	id_employee INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    firstName_employee VARCHAR(15) NOT NULL,
    lastName_employee VARCHAR(25) NOT NULL,
    gross_earnings VARCHAR(20) NOT NULL,
    net_eartnings VARCHAR(20) NOT NULL
);

INSERT INTO login VALUES (NULL,'admin','admin123','admin');
INSERT INTO login VALUES (NULL,'BartoszK','bartek','pracownik');
INSERT INTO login VALUES (NULL,'KamilN','kamil','pracownik');
INSERT INTO login VALUES (NULL,'MarcelK','marcel','pracownik');
INSERT INTO login VALUES (NULL,'MariaK','maria','pracownik');
INSERT INTO login VALUES (NULL,'WojciechT','wojciech','pracownik');
INSERT INTO login VALUES (NULL,'MichalinaM','michalina','pracownik');
INSERT INTO login VALUES (NULL,'GrzegorzK','grzegorz','pracownik');
INSERT INTO login VALUES (NULL,'ZenonN','zenon','pracownik');
select * from login;


INSERT INTO employee VALUES (NULL, 'admin', 'admin123', '2000','1400');
INSERT INTO employee VALUES (NULL, 'Bartosz', 'Kowalski','3000','2400');
INSERT INTO employee VALUES (NULL, 'Kamil', 'Nowak','4000','2400');
INSERT INTO employee VALUES (NULL, 'Marcel', 'Kaczynski','5000','3400');
INSERT INTO employee VALUES (NULL, 'Maria', 'Kwasniewski','6000','4400');
INSERT INTO employee VALUES (NULL, 'Wojciech', 'Tusk','7000','5400');
INSERT INTO employee VALUES (10, 'Michalina', 'Macierewicz','8000','6400');
INSERT INTO employee VALUES (11, 'Grzegorz', 'Kopacz','9000','7400');
INSERT INTO employee VALUES (12, 'Zenon', 'Nawalka','10000','8400');
SELECT * FROM employee;