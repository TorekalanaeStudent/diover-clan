SELECT 'CREATE DATABASE gedoria_products'
WHERE NOT EXISTS (
    SELECT FROM pg_database WHERE datname = 'gedoria_products'
)\gexec

\connect gedoria_products

CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    description VARCHAR(500)
);

INSERT INTO products (name, price, quantity, description)
VALUES
    ('Wireless Mouse', 499.00, 12, 'Rechargeable mouse for daily office use'),
    ('Mechanical Keyboard', 1899.00, 6, 'Compact keyboard with tactile switches'),
    ('USB-C Dock', 2499.00, 4, 'Multi-port dock for laptops')
ON CONFLICT DO NOTHING;
