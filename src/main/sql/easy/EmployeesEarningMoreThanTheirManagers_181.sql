-- #The Employee table holds all employees including their managers. Every employee
-- # has an Id, and there is also a column for the manager Id.
-- #
-- #
-- #+----+-------+--------+-----------+
-- #| Id | Name  | Salary | ManagerId |
-- #+----+-------+--------+-----------+
-- #| 1  | Joe   | 70000  | 3         |
-- #| 2  | Henry | 80000  | 4         |
-- #| 3  | Sam   | 60000  | NULL      |
-- #| 4  | Max   | 90000  | NULL      |
-- #+----+-------+--------+-----------+
-- #
-- #
-- # Given the Employee table, write a SQL query that finds out employees who earn
-- #more than their managers. For the above table, Joe is the only employee who earn
-- #s more than his manager.
-- #
-- #
-- #+----------+
-- #| Employee |
-- #+----------+
-- #| Joe      |
-- #+----------+
-- #
-- # 👍 768 👎 92
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 283 ms, faster than 95.47% of MySQL online submissions for Employees Earning More Than Their Managers.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.

SELECT employee.Name as Employee
FROM employee
         INNER JOIN employee managers on managers.Id = employee.ManagerId
WHERE managers.Salary < employee.Salary;
-- #leetcode submit region end(Prohibit modification and deletion)
