SELECT DISTINCT product_name from orders JOIN customers ON orders.customer_id = customers.id where lower(customers.name) = :name;