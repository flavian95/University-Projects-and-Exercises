CREATE TABLE CUSTOMERS (
    CustomerID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name       VARCHAR2(100) NOT NULL,
    Surname    VARCHAR2(100) NOT NULL,
    CNP        VARCHAR2(13) NOT NULL UNIQUE,
    Phone      VARCHAR2(100) NOT NULL UNIQUE,
    Email      VARCHAR2(100) UNIQUE
);

CREATE TABLE RETAILERS (
    RetailerID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name       VARCHAR2(100) NOT NULL UNIQUE
);

CREATE TABLE PRODUCTS (
    ProductID  NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name       VARCHAR2(100) NOT NULL,
    Code       VARCHAR2(100),
    Price      NUMBER(10, 2),
    SoldBy     NUMBER NOT NULL,
    CONSTRAINT fk_soldby FOREIGN KEY (SoldBy) REFERENCES RETAILERS(RetailerID),
    CONSTRAINT uc_code_soldby UNIQUE (Code, SoldBy)
);

CREATE TABLE ORDERS (
    OrderID   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Product   NUMBER NOT NULL,
    Customer  NUMBER NOT NULL,
    OrderDate DATE,
    CONSTRAINT fk_order_product FOREIGN KEY (Product) REFERENCES PRODUCTS(ProductID),
    CONSTRAINT fk_order_customer FOREIGN KEY (Customer) REFERENCES CUSTOMERS(CustomerID)
);

INSERT INTO CUSTOMERS (Name, Surname, CNP, Phone, Email) VALUES
('Andrei', 'Popescu', '1970101123456', '0722123456', 'andrei.popescu@example.com'),
('Maria', 'Ionescu', '2850505987654', '0744987654', 'maria.ionescu@example.com'),
('Paul', 'Georgescu', '1881234567890', '0733123987', 'paul.georgescu@example.com'),
('Elena', 'Dumitru', '2900312456123', '0761456123', 'elena.dumitru@example.com'),
('Alex', 'Stoica', '1930712345678', '0755123789', 'alex.stoica@example.com');

INSERT INTO RETAILERS (Name) VALUES
('TechWorld'),
('GadgetZone'),
('ElectroMarket'),
('CasaElectro'),
('ShopElectro');

INSERT INTO PRODUCTS (Name, Code, Price, SoldBy) VALUES
('Smartphone X100', 'X100-A', 999.99, 1),
('Laptop UltraSlim', 'ULS-500', 1899.50, 2),
('Smart TV 55"', 'TV-55Q', 2499.00, 3),
('Blender ProMix', 'BL-PRO', 299.99, 4),
('Headphones BassBoost', 'HP-BB01', 199.49, 5),
('Gaming Console Z', 'GC-Z9', 2299.90, 1),
('Tablet TabMax', 'TB-MAX', 849.00, 2),
('Coffee Maker JavaBrew', 'CM-JV8', 459.75, 3);

INSERT INTO ORDERS (Product, Customer, OrderDate) VALUES
(1, 1, TO_DATE('2024-12-01', 'YYYY-MM-DD')),
(2, 2, TO_DATE('2025-01-15', 'YYYY-MM-DD')),
(3, 3, TO_DATE('2025-02-20', 'YYYY-MM-DD')),
(4, 4, TO_DATE('2025-03-05', 'YYYY-MM-DD')),
(5, 5, TO_DATE('2025-03-10', 'YYYY-MM-DD')),
(6, 1, TO_DATE('2025-03-15', 'YYYY-MM-DD')),
(7, 2, TO_DATE('2025-03-20', 'YYYY-MM-DD')),
(8, 3, TO_DATE('2025-04-01', 'YYYY-MM-DD'));