CREATE TABLE user_table(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    description VARCHAR(300),
    address_name VARCHAR(100),
    city VARCHAR(10),
    zip_code VARCHAR (20),
    user_type VARCHAR(10)
);