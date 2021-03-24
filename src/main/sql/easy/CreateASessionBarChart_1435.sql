-- #Table: Sessions
--  #
-- #
-- #+---------------------+---------+
-- #| Column Name         | Type    |
-- #+---------------------+---------+
-- #| session_id          | int     |
-- #| duration            | int     |
-- #+---------------------+---------+
-- #session_id is the primary key for this table.
-- #duration is the time in seconds that a user has visited the application.
-- #
-- #
-- #
-- #
-- # You want to know how long a user visits your application. You decided to creat
-- #e bins of "[0-5>", "[5-10>", "[10-15>" and "15 minutes or more" and count the nu
-- #mber of sessions on it.
-- #
-- # Write an SQL query to report the (bin, total) in any order.
-- #
-- # The query result format is in the following example.
-- #
-- #
-- #Sessions table:
--           #+-------------+---------------+
-- #| session_id  | duration      |
-- #+-------------+---------------+
-- #| 1           | 30            |
-- #| 2           | 199           |
-- #| 3           | 299           |
-- #| 4           | 580           |
-- #| 5           | 1000          |
-- #+-------------+---------------+
-- #
-- #Result table:
--         #+--------------+--------------+
-- #| bin          | total        |
-- #+--------------+--------------+
-- #| [0-5>        | 3            |
-- #| [5-10>       | 1            |
-- #| [10-15>      | 0            |
-- #| 15 or more   | 1            |
-- #+--------------+--------------+
-- #
-- #For session_id 1, 2 and 3 have a duration greater or equal than 0 minutes and l
-- #ess than 5 minutes.
-- #For session_id 4 has a duration greater or equal than 5 minutes and less than 1
-- #0 minutes.
-- #There are no session with a duration greater or equial than 10 minutes and less
-- # than 15 minutes.
-- #For session_id 5 has a duration greater or equal than 15 minutes.
-- #
-- # 👍 59 👎 115
/*
  Runtime: 379 ms, faster than 44.72% of MySQL online submissions for Create a Session Bar Chart.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Create a Session Bar Chart.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
WITH cte_chart AS (
    SELECT '[0-5>' AS bin, 0 AS min_duration, 5 * 60 AS max_duration
    UNION ALL
    SELECT '[5-10>' AS bin, 5 * 60 AS min_duration, 10 * 60 AS max_duration
    UNION ALL
    SELECT '[10-15>' AS bin, 10 * 60 AS min_duration, 15 * 60 AS max_duration
    UNION ALL
    SELECT '15 or more' AS bin, 15 * 60 as min_duration, 2147483647 AS max_duration
)

SELECT bin, COUNT(session_id) AS total
FROM sessions
         RIGHT JOIN cte_chart
                    ON duration >= min_duration
                        AND duration < max_duration
GROUP BY bin;
-- #leetcode submit region end(Prohibit modification and deletion)
