-- #Table: Department
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| revenue       | int     |
-- #| month         | varchar |
-- #+---------------+---------+
-- #(id, month) is the primary key of this table.
-- #The table has information about the revenue of each department per month.
-- #The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep",
-- #"Oct","Nov","Dec"].
-- #
-- #
-- #
-- #
-- # Write an SQL query to reformat the table such that there is a department id co
-- #lumn and a revenue column for each month.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Department table:
--             #+------+---------+-------+
-- #| id   | revenue | month |
-- #+------+---------+-------+
-- #| 1    | 8000    | Jan   |
-- #| 2    | 9000    | Jan   |
-- #| 3    | 10000   | Feb   |
-- #| 1    | 7000    | Feb   |
-- #| 1    | 6000    | Mar   |
-- #+------+---------+-------+
-- #
-- #Result table:
--         #+------+-------------+-------------+-------------+-----+-------------+
-- #| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
-- #+------+-------------+-------------+-------------+-----+-------------+
-- #| 1    | 8000        | 7000        | 6000        | ... | null        |
-- #| 2    | 9000        | null        | null        | ... | null        |
-- #| 3    | null        | 10000       | null        | ... | null        |
-- #+------+-------------+-------------+-------------+-----+-------------+
-- #
-- #Note that the result table has 13 columns (1 for the department id + 12 for the
-- # months).
-- #
-- # 👍 253 👎 181
/*
  Runtime: 577 ms, faster than 18.94% of MySQL online submissions for Reformat Department Table.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Reformat Department Table.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT id,
       MAX(IF(month = "Jan", revenue, null)) AS Jan_Revenue,
       MAX(IF(month = "Feb", revenue, null)) AS Feb_Revenue,
       MAX(IF(month = "Mar", revenue, null)) AS Mar_Revenue,
       MAX(IF(month = "Apr", revenue, null)) AS Apr_Revenue,
       MAX(IF(month = "May", revenue, null)) AS May_Revenue,
       MAX(IF(month = "Jun", revenue, null)) AS Jun_Revenue,
       MAX(IF(month = "Jul", revenue, null)) AS Jul_Revenue,
       MAX(IF(month = "Aug", revenue, null)) AS Aug_Revenue,
       MAX(IF(month = "Sep", revenue, null)) AS Sep_Revenue,
       MAX(IF(month = "Oct", revenue, null)) AS Oct_Revenue,
       MAX(IF(month = "Nov", revenue, null)) AS Nov_Revenue,
       MAX(IF(month = "Dec", revenue, null)) AS Dec_Revenue
FROM Department
GROUP BY id
ORDER BY id
-- #leetcode submit region end(Prohibit modification and deletion)
