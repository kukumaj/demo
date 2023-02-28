CREATE TABLE PERSON (
                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                        FIRST_NAME VARCHAR(50),
                        LAST_NAME VARCHAR(50),
                        AGE INTEGER
);

INSERT INTO person (id, first_name, last_name, age) VALUES (1, 'John', 'Doe', 30);
INSERT INTO person (id, first_name, last_name, age) VALUES (2, 'Jane', 'Doe', 28);
INSERT INTO person (id, first_name, last_name, age) VALUES (3, 'Bob', 'Smith', 42);
