-- #Table: Orders
--  #
-- #
-- #+-----------------+----------+
-- #| Column Name     | Type     |
-- #+-----------------+----------+
-- #| order_number    | int      |
-- #| customer_number | int      |
-- #+-----------------+----------+
-- #order_number is the primary key for this table.
-- #This table contains information about the order ID and the customer ID.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find the customer_number for the customer who has placed
-- # the largest number of orders.
-- #
-- # It is guaranteed that exactly one customer will have placed more orders than a
-- #ny other customer.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Orders table:
--         #+--------------+-----------------+
-- #| order_number | customer_number |
-- #+--------------+-----------------+
-- #| 1            | 1               |
-- #| 2            | 2               |
-- #| 3            | 3               |
-- #| 4            | 3               |
-- #+--------------+-----------------+
-- #
-- #Result table:
--         #+-----------------+
-- #| customer_number |
-- #+-----------------+
-- #| 3               |
-- #+-----------------+
-- #The customer with number 3 has two orders, which is greater than either custome
-- #r 1 or 2 because each of them only has one order.
-- #So the result is customer_number 3.
-- #
-- #
-- #
-- #Follow up: What if more than one customer have the largest number of orders, ca
-- #n you find all the customer_number in this case? 👍 135 👎 14
/*
  Runtime: 857 ms, faster than 5.02% of MySQL online submissions for Customer Placing the Largest Number of Orders.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customer Placing the Largest Number of Orders.
*/

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

SELECT customer_number
FROM orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;

-- #leetcode submit region end(Prohibit modification and deletion)
