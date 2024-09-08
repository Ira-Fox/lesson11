CREATE SCHEMA IF NOT EXISTS shop DEFAULT CHARACTER SET utf8 ;
USE shop;

CREATE TABLE IF NOT EXISTS user(
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS product(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  price FLOAT NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS bucket (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  product_id INT NOT NULL,
  purchase_date DATETIME NOT NULL,
  PRIMARY KEY (id, user_id, product_id),
  INDEX fk_bucket_product_idx (product_id ASC),
  INDEX fk_bucket_user1_idx (user_id ASC),
  CONSTRAINT fk_bucket_product
    FOREIGN KEY (product_id)
    REFERENCES product(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_bucket_user1
    FOREIGN KEY (user_id)
    REFERENCES user(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM product;
SELECT * FROM bucket;

INSERT INTO user(email, firstName, lastName, role, password) 
VALUES
("sakhatska.iryna@gmail.com", "Ірина", "Сахацька", "ADMINISTRATOR", "87654321");

SELECT * FROM user;
-- DROP DATABASE shop;
