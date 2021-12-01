# Write your MySQL query statement below
SELECT id
FROM Weather w
WHERE (SELECT temperature FROM Weather WHERE recordDate = DATE_SUB(w.recordDate, INTERVAL 1 DAY)) < temperature;