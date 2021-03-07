-- #Table: Users
--  #
-- #
-- #+----------------+---------+
-- #| Column Name    | Type    |
-- #+----------------+---------+
-- #| user_id        | int     |
-- #| name           | varchar |
-- #+----------------+---------+
-- #user_id is the primary key for this table.
-- #This table contains the ID and the name of the user. The name consists of only
-- #lowercase and uppercase characters.
-- #
-- #
-- #
-- #
-- # Write an SQL query to fix the names so that only the first character is upperc
-- #ase and the rest are lowercase.
-- #
-- # Return the result table ordered by user_id.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Users table:
--        #+---------+-------+
-- #| user_id | name  |
-- #+---------+-------+
-- #| 1       | aLice |
-- #| 2       | bOB   |
-- #+---------+-------+
-- #
-- #Result table:
--         #+---------+-------+
-- #| user_id | name  |
-- #+---------+-------+
-- #| 1       | Alice |
-- #| 2       | Bob   |
-- #+---------+-------+
-- #
-- # 👍 13 👎 17
/*
    Runtime: 646 ms, faster than 29.89% of MySQL online submissions for Fix Names in a Table.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Fix Names in a Table.
 */
SELECT user_id, CONCAT(UPPER(LEFT(name, 1)), LOWER(SUBSTRING(name, 2))) as name
FROM users
ORDER BY user_id;

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
