
INSERT INTO Category
(active, createdAt, name, priority)
VALUES(true, '2020-03-08 21:40:34', '24h', true);

INSERT INTO Customer
(createdAt, name, showCustomer)
VALUES('2020-03-08 21:40:34', 'Alfa', true);

INSERT INTO CustomerDetails
(createdAt, detail, label, updatedAt, categoryId, customerId)
VALUES('2020-03-08 21:40:34', 'detail', 'label', '2020-03-08 21:40:34', 1, 1);
