CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    sku VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    active BOOLEAN
);

INSERT INTO products (sku, name, description, price, active) VALUES
('SKU001', 'Product 1', 'Description for Product 1', 10.00, TRUE),
('SKU002', 'Product 2', 'Description for Product 2', 20.00, FALSE),
('SKU003', 'Product 3', 'Description for Product 3', 30.00, TRUE),
('SKU004', 'Product 4', 'Description for Product 4', 40.00, TRUE),
('SKU005', 'Product 5', 'Description for Product 5', 50.00, FALSE),
('SKU006', 'Product 6', 'Description for Product 6', 60.00, TRUE),
('SKU007', 'Product 7', 'Description for Product 7', 70.00, TRUE),
('SKU008', 'Product 8', 'Description for Product 8', 80.00, FALSE),
('SKU009', 'Product 9', 'Description for Product 9', 90.00, TRUE),
('SKU010', 'Product 10', 'Description for Product 10', 100.00, TRUE),
('SKU011', 'Product 11', 'Description for Product 11', 110.00, TRUE),
('SKU100', 'Product 100', 'Description for Product 100', 1000.00, FALSE);