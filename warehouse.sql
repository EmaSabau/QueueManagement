DROP DATABASE Warehouse;
CREATE DATABASE IF NOT EXISTS Warehouse;

USE Warehouse; 

-- Create Client table
CREATE TABLE WarehouseClient (
    ClientID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Address VARCHAR(255),
    Phone VARCHAR(20)
);

-- Create Product table
CREATE TABLE Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Description VARCHAR(255),
    Price DECIMAL(10, 2),
    StockQuantity INT
);

-- Create Order table
CREATE TABLE WarehouseOrder (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    ClientID INT,
    ProductID INT,
    Quantity INT,
    TotalPrice DECIMAL(10, 2),
    FOREIGN KEY (ClientID) REFERENCES WarehouseClient(ClientID)
    -- FOREIGN KEY (ProductID) REFERENCES Product(ProductID) -- Eliminarea ON DELETE CASCADE
);


-- Insert sample values into Client table
INSERT INTO WarehouseClient (ClientID, Name, Email, Address, Phone) 
VALUES 
    (1, 'John Doe', 'john.doe@example.com', '123 Main St, Anytown, USA', '123-456-7890'),
    (2, 'Jane Smith', 'jane.smith@example.com', '456 Oak St, Anytown, USA', '456-789-0123');

-- Insert sample values into Product table
INSERT INTO Product (ProductID, Name, Description, Price, StockQuantity) 
VALUES 
    (1, 'T-Shirt', 'Cotton T-Shirt', 15.99, 100),
    (2, 'Jeans', 'Denim Jeans', 29.99, 50),
    (3, 'Sneakers', 'Casual Sneakers', 49.99, 30);

-- Insert sample values into Order table
INSERT INTO WarehouseOrder (OrderID, ClientID, ProductID, Quantity, TotalPrice) 
VALUES 
    (1, 1, 1, 2, 31.98),
    (2, 2, 2, 1, 29.99),
    (3, 1, 3, 1, 49.99);

ALTER TABLE WarehouseOrder 
    ADD CONSTRAINT fk_order_client 
    FOREIGN KEY (ClientID) 
    REFERENCES WarehouseClient(ClientID) ;
    -- ON DELETE CASCADE;

ALTER TABLE WarehouseOrder 
    ADD CONSTRAINT fk_order_product 
    FOREIGN KEY (ProductID) 
    REFERENCES Product(ProductID) 
   -- ON DELETE CASCADE;



