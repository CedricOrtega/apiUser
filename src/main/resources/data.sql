DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    birthdate DATE NOT NULL,
    country_residence VARCHAR(250) NOT NULL,
    phone_number VARCHAR(250),
    gender VARCHAR(250)
);

INSERT INTO user (user_name, birthdate, country_residence, phone_number, gender) VALUES
    ('Aréola', '1993-02-27', 'France', '0606060606','MALE');
