CREATE DATABASE  IF NOT EXISTS petvet;
USE petvet;

CREATE TABLE IF NOT EXISTS vet (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(40),
  last_name VARCHAR(40)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS user (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password CHAR(80) NOT NULL,
  first_name VARCHAR(40),
  last_name VARCHAR(40),
  email VARCHAR(80),
  phone_number VARCHAR(13)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS role (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) DEFAULT NULL
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS users_roles (
  user_id INT UNSIGNED NOT NULL,
  role_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (role_id) REFERENCES role(id),
  UNIQUE (user_id, role_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS speciality (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_speciality (
  vet_id INT UNSIGNED NOT NULL,
  speciality_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vet(id),
  FOREIGN KEY (speciality_id) REFERENCES speciality(id),
  UNIQUE (vet_id, speciality_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS species (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pet (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40),
  birth_date DATE,
  species_id INT UNSIGNED NOT NULL,
  user_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (species_id) REFERENCES species(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS appointment (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT UNSIGNED NOT NULL,
  appointment_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pet(id)
) engine=InnoDB;