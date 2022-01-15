# Write your MySQL query statement below

SELECT id 
FROM Weather w
WHERE temperature > (SELECT temperature FROM Weather WHERE DATEDIFF(w.recordDate, recordDate) = 1);