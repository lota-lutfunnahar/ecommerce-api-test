INSERT INTO customers (name, email) VALUES
('Sam doe', 'sam.doe@example.com'),
('Jane Smith', 'jane.smith@example.com'),
('Alice Johnson', 'alice.johnson@example.com');

INSERT INTO items (name, price) VALUES
('Item A', 10.00),
('Item B', 20.00),
('Item C', 30.00),
('Item D', 40.00),
('Item E', 50.00);

INSERT INTO wishlists (customer_id, item_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(3, 1),
(3, 4),
(3, 5);

INSERT INTO sales (item_id, quantity, sale_date) VALUES
(1, 5, '2024-07-01'),
(2, 3, '2024-07-01'),
(3, 7, '2024-07-01'),
(4, 2, '2024-07-02'),
(5, 8, '2024-07-02'),
(1, 4, '2024-07-03'),
(2, 6, '2024-07-03');
