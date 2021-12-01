# Write your MySQL query statement below
SELECT name AS Customers
FROM Customers c
WHERE (SELECT COUNT(customerId) FROM Orders WHERE customerId = c.id) = 0;