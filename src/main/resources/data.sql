DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    birthdate DATE NOT NULL,
    country_residence VARCHAR(250) NOT NULL,
    phone_number VARCHAR(250),
    gender VARCHAR(250)
);
