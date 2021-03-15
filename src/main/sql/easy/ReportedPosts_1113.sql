-- #Table: Actions
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| user_id       | int     |
-- #| post_id       | int     |
-- #| action_date   | date    |
-- #| action        | enum    |
-- #| extra         | varchar |
-- #+---------------+---------+
-- #There is no primary key for this table, it may have duplicate rows.
-- #The action column is an ENUM type of ('view', 'like', 'reaction', 'comment', 'r
-- #eport', 'share').
-- #The extra column has optional information about the action such as a reason for
-- # report or a type of reaction.
-- #
-- #
-- #
-- # Write an SQL query that reports the number of posts reported yesterday for eac
-- #h report reason. Assume today is 2019-07-05.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Actions table:
--          #+---------+---------+-------------+--------+--------+
-- #| user_id | post_id | action_date | action | extra  |
-- #+---------+---------+-------------+--------+--------+
-- #| 1       | 1       | 2019-07-01  | view   | null   |
-- #| 1       | 1       | 2019-07-01  | like   | null   |
-- #| 1       | 1       | 2019-07-01  | share  | null   |
-- #| 2       | 4       | 2019-07-04  | view   | null   |
-- #| 2       | 4       | 2019-07-04  | report | spam   |
-- #| 3       | 4       | 2019-07-04  | view   | null   |
-- #| 3       | 4       | 2019-07-04  | report | spam   |
-- #| 4       | 3       | 2019-07-02  | view   | null   |
-- #| 4       | 3       | 2019-07-02  | report | spam   |
-- #| 5       | 2       | 2019-07-04  | view   | null   |
-- #| 5       | 2       | 2019-07-04  | report | racism |
-- #| 5       | 5       | 2019-07-04  | view   | null   |
-- #| 5       | 5       | 2019-07-04  | report | racism |
-- #+---------+---------+-------------+--------+--------+
-- #
-- #Result table:
--         #+---------------+--------------+
-- #| report_reason | report_count |
-- #+---------------+--------------+
-- #| spam          | 1            |
-- #| racism        | 2            |
-- #+---------------+--------------+
-- #Note that we only care about report reasons with non zero number of reports.
-- # 👍 39 👎 178
/*
  Runtime: 496 ms, faster than 65.60% of MySQL online submissions for Reported Posts.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Reported Posts.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT extra as report_reason, COUNT(DISTINCT post_id) as report_count
FROM actions
WHERE action_date = '2019-07-04'
  AND action = 'report'
GROUP BY report_reason;

-- #leetcode submit region end(Prohibit modification and deletion)
