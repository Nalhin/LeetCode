-- #Table: ActorDirector
--  #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| actor_id    | int     |
-- #| director_id | int     |
-- #| timestamp   | int     |
-- #+-------------+---------+
-- #timestamp is the primary key column for this table.
-- #
-- #
-- #
-- #
-- # Write a SQL query for a report that provides the pairs (actor_id, director_id)
-- # where the actor have cooperated with the director at least 3 times.
-- #
-- # Example:
-- #
-- #
-- #ActorDirector table:
-- #+-------------+-------------+-------------+
-- #| actor_id    | director_id | timestamp   |
-- #+-------------+-------------+-------------+
-- #| 1           | 1           | 0           |
-- #| 1           | 1           | 1           |
-- #| 1           | 1           | 2           |
-- #| 1           | 2           | 3           |
-- #| 1           | 2           | 4           |
-- #| 2           | 1           | 5           |
-- #| 2           | 1           | 6           |
-- #+-------------+-------------+-------------+
-- #
-- #Result table:
-- #+-------------+-------------+
-- #| actor_id    | director_id |
-- #+-------------+-------------+
-- #| 1           | 1           |
-- #+-------------+-------------+
-- #The only pair is (1, 1) where they cooperated exactly 3 times.
-- #
-- # 👍 70 👎 17
/*
  Runtime: 833 ms, faster than 5.02% of MySQL online submissions for Actors and Directors Who Cooperated At Least Three Times.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Actors and Directors Who Cooperated At Least Three Times.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT actor_id, director_id
from actordirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;

-- #leetcode submit region end(Prohibit modification and deletion)
