-- #Select all employee's name and bonus whose bonus is < 1000.
-- #
-- # Table:Employee
-- #
-- #
-- #+-------+--------+-----------+--------+
-- #| empId |  name  | supervisor| salary |
-- #+-------+--------+-----------+--------+
-- #|   1   | John   |  3        | 1000   |
-- #|   2   | Dan    |  3        | 2000   |
-- #|   3   | Brad   |  null     | 4000   |
-- #|   4   | Thomas |  3        | 4000   |
-- #+-------+--------+-----------+--------+
-- #empId is the primary key column for this table.
-- #
-- #
-- # Table: Bonus
-- #
-- #
-- #+-------+-------+
-- #| empId | bonus |
-- #+-------+-------+
-- #| 2     | 500   |
-- #| 4     | 2000  |
-- #+-------+-------+
-- #empId is the primary key column for this table.
-- #
-- #
-- # Example ouput:
-- #
-- #
-- #+-------+-------+
-- #| name  | bonus |
-- #+-------+-------+
-- #| John  | null  |
-- #| Dan   | 500   |
-- #| Brad  | null  |
-- #+-------+-------+
-- #
-- # 👍 106 👎 58
/*
    Runtime: 288 ms, faster than 34.91% of MySQL online submissions for Employee Bonus.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employee Bonus.
 */

SELECT name, bonus
FROM employee
         LEFT JOIN bonus USING (empId)
WHERE COALESCE(bonus.bonus, 0) < 1000;

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
