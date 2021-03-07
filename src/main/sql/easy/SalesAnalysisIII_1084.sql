-- #Table: Product
--  #
-- #
-- #+--------------+---------+
-- #| Column Name  | Type    |
-- #+--------------+---------+
-- #| product_id   | int     |
-- #| product_name | varchar |
-- #| unit_price   | int     |
-- #+--------------+---------+
-- #product_id is the primary key of this table.
-- #
-- #
-- # Table: Sales
--   #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| seller_id   | int     |
-- #| product_id  | int     |
-- #| buyer_id    | int     |
-- #| sale_date   | date    |
-- #| quantity    | int     |
-- #| price       | int     |
-- #+------ ------+---------+
-- #This table has no primary key, it can have repeated rows.
-- #product_id is a foreign key to Product table.
-- #
-- #
-- #
-- #
-- # Write an SQL query that reports the products that were only sold in spring 201
-- #9. That is, between 2019-01-01 and 2019-03-31 inclusive.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Product table:
--          #+------------+--------------+------------+
-- #| product_id | product_name | unit_price |
-- #+------------+--------------+------------+
-- #| 1          | S8           | 1000       |
-- #| 2          | G4           | 800        |
-- #| 3          | iPhone       | 1400       |
-- #+------------+--------------+------------+
-- #
-- #Sales table:
--        #+-----------+------------+----------+------------+----------+-------+
-- #| seller_id | product_id | buyer_id | sale_date  | quantity | price |
-- #+-----------+------------+----------+------------+----------+-------+
-- #| 1         | 1          | 1        | 2019-01-21 | 2        | 2000  |
-- #| 1         | 2          | 2        | 2019-02-17 | 1        | 800   |
-- #| 2         | 2          | 3        | 2019-06-02 | 1        | 800   |
-- #| 3         | 3          | 4        | 2019-05-13 | 2        | 2800  |
-- #+-----------+------------+----------+------------+----------+-------+
-- #
-- #Result table:
--         #+-------------+--------------+
-- #| product_id  | product_name |
-- #+-------------+--------------+
-- #| 1           | S8           |
-- #+-------------+--------------+
-- #The product with id 1 was only sold in spring 2019 while the other two were sol
-- #d after.
-- # 👍 107 👎 33
/*
    Runtime: 1136 ms, faster than 28.81% of MySQL online submissions for Sales Analysis III.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Sales Analysis III.
 */
SELECT DISTINCT product_id, product_name
FROM sales
         INNER JOIN product USING (product_id)
WHERE product_id IN
      (SELECT product_id
       FROM Sales
       GROUP BY product_id
       HAVING MIN(sale_date) >= '2019-01-01'
          AND MAX(sale_date) <= '2019-03-31'
      )
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
