-- #Table: Sales
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| sale_date     | date    |
-- #| fruit         | enum    |
-- #| sold_num      | int     |
-- #+---------------+---------+
-- #(sale_date,fruit) is the primary key for this table.
-- #This table contains the sales of "apples" and "oranges" sold each day.
-- #
-- #
-- #
-- #
-- # Write an SQL query to report the difference between number of apples and orang
-- #es sold each day.
-- #
-- # Return the result table ordered by sale_date in format ('YYYY-MM-DD').
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Sales table:
--        #+------------+------------+-------------+
-- #| sale_date  | fruit      | sold_num    |
-- #+------------+------------+-------------+
-- #| 2020-05-01 | apples     | 10          |
-- #| 2020-05-01 | oranges    | 8           |
-- #| 2020-05-02 | apples     | 15          |
-- #| 2020-05-02 | oranges    | 15          |
-- #| 2020-05-03 | apples     | 20          |
-- #| 2020-05-03 | oranges    | 0           |
-- #| 2020-05-04 | apples     | 15          |
-- #| 2020-05-04 | oranges    | 16          |
-- #+------------+------------+-------------+
-- #
-- #Result table:
--         #+------------+--------------+
-- #| sale_date  | diff         |
-- #+------------+--------------+
-- #| 2020-05-01 | 2            |
-- #| 2020-05-02 | 0            |
-- #| 2020-05-03 | 20           |
-- #| 2020-05-04 | -1           |
-- #+------------+--------------+
-- #
-- #Day 2020-05-01, 10 apples and 8 oranges were sold (Difference  10 - 8 = 2).
-- #Day 2020-05-02, 15 apples and 15 oranges were sold (Difference 15 - 15 = 0).
-- #Day 2020-05-03, 20 apples and 0 oranges were sold (Difference 20 - 0 = 20).
-- #Day 2020-05-04, 15 apples and 16 oranges were sold (Difference 15 - 16 = -1).
-- #
-- # 👍 63 👎 11
/*
  Runtime: 336 ms, faster than 26.11% of MySQL online submissions for Apples & Oranges.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Apples & Oranges.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT sale_date, SUM(IF(fruit = 'apples', sold_num, -sold_num)) AS diff
FROM sales
GROUP BY sale_date
ORDER BY sale_date;
-- #leetcode submit region end(Prohibit modification and deletion)
