
-- Insertar usuarios de ejemplo
INSERT INTO user (username, email, password) VALUES
('johndoe', 'johndoe@example.com', 'password123'),
('janedoe', 'janedoe@example.com', 'password456'),
('alice', 'alice@example.com', 'password789');

-- Insertar categorías de ejemplo
INSERT INTO category (title, description) VALUES
                                              ('Electronics', 'Gadgets and electronic devices'),
                                              ('Art', 'Paintings, sculptures, and other artworks'),
                                              ('Furniture', 'Home and office furniture');

-- Insertar subastas de ejemplo
INSERT INTO auction (user_id, title, status, description, start_date, end_date) VALUES
                                                                                    (1, 'Electronics Auction', 1, 'Auction for various electronic items', '2025-01-01', '2025-01-10'),
                                                                                    (2, 'Art Auction', 1, 'Auction for various artworks', '2025-02-01', '2025-02-10'),
                                                                                    (3, 'Furniture Auction', 1, 'Auction for various furniture items', '2025-03-01', '2025-03-10');

-- Insertar productos de ejemplo
INSERT INTO product (title, description, img_url, starting_bid, current_bid, closing_bid, category_id, auction_id) VALUES
                                                                                                                       ('Smartphone', 'Brand new smartphone with 128GB storage', 'assets/images/backend/smartphone.jpg', 200.00, 250.00, 0.00, 1, 1),
                                                                                                                       ('Smartwatch', 'Latest model smartwatch with fitness tracking', 'assets/images/backend/smartwatch.jpg', 100.00, 150.00, 0.00, 1, 1),
                                                                                                                       ('Painting', 'Original oil painting by a famous artist', 'assets/images/backend/painting.jpg', 500.00, 750.00, 0.00, 2, 2),
                                                                                                                       ('Sculpture', 'Marble sculpture handcrafted by a local artist', 'assets/images/backend/sculpture.jpg', 300.00, 400.00, 0.00, 2, 2),
                                                                                                                       ('Office Chair', 'Ergonomic office chair with lumbar support', 'assets/images/backend/chair.jpg', 150.00, 200.00, 0.00, 3, 3),
                                                                                                                       ('Desk', 'Large wooden office desk with drawers', 'assets/images/backend/desk.jpg', 250.00, 300.00, 0.00, 3, 3);
data.sql
Mostrando data.sql.