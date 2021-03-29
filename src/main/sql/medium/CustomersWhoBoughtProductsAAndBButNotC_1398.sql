-- #Table: Customers
--  #
-- #
-- #+---------------------+---------+
-- #| Column Name         | Type    |
-- #+---------------------+---------+
-- #| customer_id         | int     |
-- #| customer_name       | varchar |
-- #+---------------------+---------+
-- #customer_id is the primary key for this table.
-- #customer_name is the name of the customer.
-- #
-- #
-- #
-- # Table: Orders
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| order_id      | int     |
-- #| customer_id   | int     |
-- #| product_name  | varchar |
-- #+---------------+---------+
-- #order_id is the primary key for this table.
-- #customer_id is the id of the customer who bought the product "product_name".
-- #
-- #
-- #
-- #
-- # Write an SQL query to report the customer_id and customer_name of customers wh
-- #o bought products "A", "B" but did not buy the product "C" since we want to reco
-- #mmend them buy this product.
-- #
-- # Return the result table ordered by customer_id.
-- #
-- # The query result format is in the following example.
-- #
-- #
-- #
-- #
-- #Customers table:
--            #+-------------+---------------+
-- #| customer_id | customer_name |
-- #+-------------+---------------+
-- #| 1           | Daniel        |
-- #| 2           | Diana         |
-- #| 3           | Elizabeth     |
-- #| 4           | Jhon          |
-- #+-------------+---------------+
-- #
-- #Orders table:
--         #+------------+--------------+---------------+
-- #| order_id   | customer_id  | product_name  |
-- #+------------+--------------+---------------+
-- #| 10         |     1        |     A         |
-- #| 20         |     1        |     B         |
-- #| 30         |     1        |     D         |
-- #| 40         |     1        |     C         |
-- #| 50         |     2        |     A         |
-- #| 60         |     3        |     A         |
-- #| 70         |     3        |     B         |
-- #| 80         |     3        |     D         |
-- #| 90         |     4        |     C         |
-- #+------------+--------------+---------------+
-- #
-- #Result table:
--         #+-------------+---------------+
-- #| customer_id | customer_name |
-- #+-------------+---------------+
-- #| 3           | Elizabeth     |
-- #+-------------+---------------+
-- #Only the customer_id with id 3 bought the product A and B but not the product C
-- #.
-- # 👍 85 👎 4
/*
  Runtime: 511 ms, faster than 49.41% of MySQL online submissions for Customers Who Bought Products A and B but Not C.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Bought Products A and B but Not C.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

SELECT customer_id, customer_name
FROM ORDERS
         INNER JOIN customers USING (customer_id)
GROUP BY customer_id
HAVING SUM(product_name = 'A') > 0
   AND SUM(product_name = 'B') > 0
   AND SUM(product_name = 'C') = 0;

-- #leetcode submit region end(Prohibit modification and deletion)
