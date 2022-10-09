select c.name as Customers
from Customers c left join Orders o on c.id = o.customerId
group by c.id
having count(o.id) = 0 or count(o.id) is null