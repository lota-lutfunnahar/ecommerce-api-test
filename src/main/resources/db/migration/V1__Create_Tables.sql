REATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE wishlist (
    customer_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    PRIMARY KEY (customer_id, item_id),
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE sale (
    id SERIAL PRIMARY KEY,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    sale_date DATE NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item (id)
);