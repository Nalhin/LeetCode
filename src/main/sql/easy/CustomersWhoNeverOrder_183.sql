-- #Suppose that a website contains two tables, the Customers table and the Orders
-- #table. Write a SQL query to find all customers who never order anything.
-- #
-- # Table: Customers.
-- #
-- #
-- #+----+-------+
-- #| Id | Name  |
-- #+----+-------+
-- #| 1  | Joe   |
-- #| 2  | Henry |
-- #| 3  | Sam   |
-- #| 4  | Max   |
-- #+----+-------+
-- #
-- #
-- # Table: Orders.
-- #
-- #
-- #+----+------------+
-- #| Id | CustomerId |
-- #+----+------------+
-- #| 1  | 3          |
-- #| 2  | 1          |
-- #+----+------------+
-- #
-- #
-- # Using the above tables as example, return the following:
-- #
-- #
-- #+-----------+
-- #| Customers |
-- #+-----------+
-- #| Henry     |
-- #| Max       |
-- #+-----------+
-- #
-- # 👍 498 👎 56
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 463 ms, faster than 44.85% of MySQL online submissions for Customers Who Never Order.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.

SELECT Name as Customers
FROM Customers
WHERE Id NOT IN (SELECT CustomerId as Id From Orders);

-- #leetcode submit region end(Prohibit modification and deletion)
