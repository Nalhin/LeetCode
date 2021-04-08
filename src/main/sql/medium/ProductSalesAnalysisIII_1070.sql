-- #Table: Sales
-- #
-- #
-- #+-------------+-------+
-- #| Column Name | Type  |
-- #+-------------+-------+
-- #| sale_id     | int   |
-- #| product_id  | int   |
-- #| year        | int   |
-- #| quantity    | int   |
-- #| price       | int   |
-- #+-------------+-------+
-- #sale_id is the primary key of this table.
-- #product_id is a foreign key to Product table.
-- #Note that the price is per unit.
-- #
-- #
-- # Table: Product
-- #
-- #
-- #+--------------+---------+
-- #| Column Name  | Type    |
-- #+--------------+---------+
-- #| product_id   | int     |
-- #| product_name | varchar |
-- #+--------------+---------+
-- #product_id is the primary key of this table.
-- #
-- #
-- #
-- #
-- # Write an SQL query that selects the product id, year, quantity, and price for
-- #the first year of every product sold.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Sales table:
-- #+---------+------------+------+----------+-------+
-- #| sale_id | product_id | year | quantity | price |
-- #+---------+------------+------+----------+-------+
-- #| 1       | 100        | 2008 | 10       | 5000  |
-- #| 2       | 100        | 2009 | 12       | 5000  |
-- #| 7       | 200        | 2011 | 15       | 9000  |
-- #+---------+------------+------+----------+-------+
-- #
-- #Product table:
-- #+------------+--------------+
-- #| product_id | product_name |
-- #+------------+--------------+
-- #| 100        | Nokia        |
-- #| 200        | Apple        |
-- #| 300        | Samsung      |
-- #+------------+--------------+
-- #
-- #Result table:
-- #+------------+------------+----------+-------+
-- #| product_id | first_year | quantity | price |
-- #+------------+------------+----------+-------+
-- #| 100        | 2008       | 10       | 5000  |
-- #| 200        | 2011       | 15       | 9000  |
-- #+------------+------------+----------+-------+
-- #
-- # 👍 49 👎 166
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 1117 ms, faster than 37.12% of MySQL online submissions for Product Sales Analysis III.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Product Sales Analysis III.
-- WINDOW FUNCTION
SELECT product_id, year AS first_year, quantity, price
FROM (SELECT *, RANK() OVER (PARTITION BY product_id ORDER BY year) AS year_rank FROM sales) ranked_sales
WHERE year_rank = 1;

-- Runtime: 949 ms, faster than 78.25% of MySQL online submissions for Product Sales Analysis III.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Product Sales Analysis III.
-- WHERE IN
SELECT product_id, year AS first_year, quantity, price
FROM sales
WHERE (product_id, year) IN (
    SELECT product_id, MIN(year) AS year
    FROM sales
    GROUP BY product_id
);
-- #leetcode submit region end(Prohibit modification and deletion)
