CREATE TABLE IF NOT EXISTS payment(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    user_id INT NOT NULL,
    store_id INT NOT NULL,
    payment_method VARCHAR(50) NOT NULL, 
    card_brand VARCHAR(50)
);