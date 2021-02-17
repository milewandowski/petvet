CREATE DATABASE  IF NOT EXISTS petvet;

CREATE USER 'petvet'@'localhost' IDENTIFIED BY 'petvet';
GRANT ALL PRIVILEGES ON petvet.* TO 'petvet'@'localhost' WITH GRANT OPTION;