-- #Write a SQL query to get the second highest salary from the Employee table.
-- #
-- #
-- #+----+--------+
-- #| Id | Salary |
-- #+----+--------+
-- #| 1  | 100    |
-- #| 2  | 200    |
-- #| 3  | 300    |
-- #+----+--------+
-- #
-- #
-- # For example, given the above Employee table, the query should return 200 as th
-- #e second highest salary. If there is no second highest salary, then the query sh
-- #ould return null.
-- #
-- #
-- #+---------------------+
-- #| SecondHighestSalary |
-- #+---------------------+
-- #| 200                 |
-- #+---------------------+
-- #
-- # 👍 1068 👎 528
/*
  Runtime: 170 ms, faster than 85.01% of MySQL online submissions for Second Highest Salary.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Second Highest Salary.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary
FROM employee
WHERE salary < (SELECT MAX(salary) FROM employee);
-- #leetcode submit region end(Prohibit modification and deletion)
