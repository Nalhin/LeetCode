-- #Table: Weather
-- #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| recordDate    | date    |
-- #| temperature   | int     |
-- #+---------------+---------+
-- #id is the primary key for this table.
-- #This table contains information about the temperature in a certain day.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find all dates' id with higher temperature compared to i
-- #ts previous dates (yesterday).
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Weather
-- #+----+------------+-------------+
-- #| id | recordDate | Temperature |
-- #+----+------------+-------------+
-- #| 1  | 2015-01-01 | 10          |
-- #| 2  | 2015-01-02 | 25          |
-- #| 3  | 2015-01-03 | 20          |
-- #| 4  | 2015-01-04 | 30          |
-- #+----+------------+-------------+
-- #
-- #Result table:
-- #+----+
-- #| id |
-- #+----+
-- #| 2  |
-- #| 4  |
-- #+----+
-- #In 2015-01-02, temperature was higher than the previous day (10 -> 25).
-- #In 2015-01-04, temperature was higher than the previous day (20 -> 30).
-- #
-- # 👍 488 👎 253

-- Runtime: 343 ms, faster than 82.66% of MySQL online submissions for Rising Temperature.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rising Temperature.

SELECT curr.id
from weather curr
         INNER JOIN weather previous on DATE_DIFF(previous.recordDate, curr.recordDate) = 1
WHERE curr.temperature > previous.temperature

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
