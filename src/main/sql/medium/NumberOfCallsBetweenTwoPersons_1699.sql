-- #Table: Calls
--  #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| from_id     | int     |
-- #| to_id       | int     |
-- #| duration    | int     |
-- #+-------------+---------+
-- #This table does not have a primary key, it may contain duplicates.
-- #This table contains the duration of a phone call between from_id and to_id.
-- #from_id != to_id
-- #
-- #
-- #
-- #
-- # Write an SQL query to report the number of calls and the total call duration b
-- #etween each pair of distinct persons (person1, person2) where person1 < person2.
-- #
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Calls table:
--        #+---------+-------+----------+
-- #| from_id | to_id | duration |
-- #+---------+-------+----------+
-- #| 1       | 2     | 59       |
-- #| 2       | 1     | 11       |
-- #| 1       | 3     | 20       |
-- #| 3       | 4     | 100      |
-- #| 3       | 4     | 200      |
-- #| 3       | 4     | 200      |
-- #| 4       | 3     | 499      |
-- #+---------+-------+----------+
-- #
-- #Result table:
--         #+---------+---------+------------+----------------+
-- #| person1 | person2 | call_count | total_duration |
-- #+---------+---------+------------+----------------+
-- #| 1       | 2       | 2          | 70             |
-- #| 1       | 3       | 1          | 20             |
-- #| 3       | 4       | 4          | 999            |
-- #+---------+---------+------------+----------------+
-- #Users 1 and 2 had 2 calls and the total duration is 70 (59 + 11).
-- #Users 1 and 3 had 1 call and the total duration is 20.
-- #Users 3 and 4 had 4 calls and the total duration is 999 (100 + 200 + 200 + 499)
-- #.
-- #
-- # 👍 31 👎 2
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 660 ms, faster than 21.50% of MySQL online submissions for Number of Calls Between Two Persons.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Number of Calls Between Two Persons.

SELECT from_id as person1, to_id as person2, count(*) as call_count, SUM(duration) as total_duration
from (SELECT from_id, to_id, duration
      from calls
      WHERE from_id < to_id
      UNION ALL
      SELECT to_id as from_id, from_id as to_id, duration
      from calls
      WHERE calls.from_id > calls.to_id) as nested
GROUP BY person1, person2;

-- Runtime: 450 ms, faster than 97.46% of MySQL online submissions for Number of Calls Between Two Persons.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Number of Calls Between Two Persons.

SELECT CASE WHEN from_id < to_id THEN from_id ELSE to_id END as person1,
       CASE WHEN from_id > to_id THEN from_id ELSE to_id END as person2,
       COUNT(duration)                                       AS call_count,
       SUM(duration)                                         AS total_duration
FROM calls
GROUP BY person1, person2

-- #leetcode submit region end(Prohibit modification and deletion)
