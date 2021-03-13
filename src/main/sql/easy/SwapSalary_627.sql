-- #Table: Salary
--  #
-- #
-- #+-------------+----------+
-- #| Column Name | Type     |
-- #+-------------+----------+
-- #| id          | int      |
-- #| name        | varchar  |
-- #| sex         | ENUM     |
-- #| salary      | int      |
-- #+-------------+----------+
-- #id is the primary key for this table.
-- #The sex column is ENUM value of type ('m', 'f').
-- #The table contains information about an employee.
-- #
-- #
-- #
-- #
-- # Write an SQL query to swap all 'f' and 'm' values (i.e., change all 'f' values
-- # to 'm' and vice versa) with a single update statement and no intermediate temp
--     #table(s).
-- #
-- # Note that you must write a single update statement, DO NOT write any select st
--     #atement for this problem.
--     #
--     # The query result format is in the following example:
--     #
--     #
--     #
--     #
--     #Salary table:
--             #+----+------+-----+--------+
-- #| id | name | sex | salary |
-- #+----+------+-----+--------+
-- #| 1  | A    | m   | 2500   |
-- #| 2  | B    | f   | 1500   |
-- #| 3  | C    | m   | 5500   |
-- #| 4  | D    | f   | 500    |
-- #+----+------+-----+--------+
-- #
-- #Result table:
--         #+----+------+-----+--------+
-- #| id | name | sex | salary |
-- #+----+------+-----+--------+
-- #| 1  | A    | f   | 2500   |
-- #| 2  | B    | m   | 1500   |
-- #| 3  | C    | f   | 5500   |
-- #| 4  | D    | m   | 500    |
-- #+----+------+-----+--------+
-- #(1, A) and (3, C) were changed from 'm' to 'f'.
-- #(2, B) and (4, D) were changed from 'f' to 'm'.
-- #
-- # 👍 583 👎 309

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
/*
    Runtime: 211 ms, faster than 57.71% of MySQL online submissions for Swap Salary.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Swap Salary.
*/

UPDATE salary
SET sex = IF(sex = 'f', 'm', 'f');

-- #leetcode submit region end(Prohibit modification and deletion)
