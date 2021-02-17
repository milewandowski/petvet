CREATE USER 'petvet'@'localhost' IDENTIFIED BY 'petvet';
GRANT ALL PRIVILEGES ON petvet.* TO 'petvet'@'localhost' WITH GRANT OPTION;