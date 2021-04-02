-- #Table: Logs
--  #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| id          | int     |
-- #| num         | varchar |
-- #+-------------+---------+
-- #id is the primary key for this table.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find all numbers that appear at least three times consec
-- #utively.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Logs table:
--       #+----+-----+
-- #| Id | Num |
-- #+----+-----+
-- #| 1  | 1   |
-- #| 2  | 1   |
-- #| 3  | 1   |
-- #| 4  | 2   |
-- #| 5  | 1   |
-- #| 6  | 2   |
-- #| 7  | 2   |
-- #+----+-----+
-- #
-- #Result table:
--         #+-----------------+
-- #| ConsecutiveNums |
-- #+-----------------+
-- #| 1               |
-- #+-----------------+
-- #1 is the only number that appears consecutively for at least three times.
-- #
-- # 👍 581 👎 134
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
/*
  Runtime: 488 ms, faster than 31.15% of MySQL online submissions for Consecutive Numbers.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
*/
-- SELF JOIN
SELECT DISTINCT num AS ConsecutiveNums
FROM logs
WHERE id IN (SELECT parent.id
             FROM logs parent
                      INNER JOIN logs children ON (children.id = parent.id - 1 AND children.num = parent.num) OR
                                                  (children.id = parent.id + 1 AND children.num = parent.num)
             GROUP BY parent.id
             HAVING COUNT(*) >= 2);

/*
  Runtime: 431 ms, faster than 54.49% of MySQL online submissions for Consecutive Numbers.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Numbers.
*/
-- WINDOW FUNCTIONS
SELECT distinct num ConsecutiveNums
FROM (SELECT id,
             num,
             LAG(num) OVER (ORDER BY id)  AS num_before,
             LEAD(num) OVER (ORDER BY id) AS num_after
      FROM logs
     ) neightbours
WHERE num = num_before
  and num_before = num_after
-- #leetcode submit region end(Prohibit modification and deletion)
