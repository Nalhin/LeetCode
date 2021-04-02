-- #The Employee table holds all employees. Every employee has an Id, a salary, and
-- # there is also a column for the department Id.
-- #
-- #
-- #+----+-------+--------+--------------+
-- #| Id | Name  | Salary | DepartmentId |
-- #+----+-------+--------+--------------+
-- #| 1  | Joe   | 70000  | 1            |
-- #| 2  | Jim   | 90000  | 1            |
-- #| 3  | Henry | 80000  | 2            |
-- #| 4  | Sam   | 60000  | 2            |
-- #| 5  | Max   | 90000  | 1            |
-- #+----+-------+--------+--------------+
-- #
-- #
-- # The Department table holds all departments of the company.
-- #
-- #
-- #+----+----------+
-- #| Id | Name     |
-- #+----+----------+
-- #| 1  | IT       |
-- #| 2  | Sales    |
-- #+----+----------+
-- #
-- #
-- # Write a SQL query to find employees who have the highest salary in each of the
-- # departments. For the above tables, your SQL query should return the following r
-- #ows (order of rows does not matter).
-- #
-- #
-- #+------------+----------+--------+
-- #| Department | Employee | Salary |
-- #+------------+----------+--------+
-- #| IT         | Max      | 90000  |
-- #| IT         | Jim      | 90000  |
-- #| Sales      | Henry    | 80000  |
-- #+------------+----------+--------+
-- #
-- #
-- # Explanation:
-- #
-- # Max and Jim both have the highest salary in the IT department and Henry has th
-- #e highest salary in the Sales department.
-- # 👍 627 👎 134
/*
  Runtime: 461 ms, faster than 98.16% of MySQL online submissions for Department Highest Salary.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Highest Salary.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
WITH hightest_salary_per_dep AS (
    SELECT MAX(salary) AS salary, DepartmentId
    FROM employee
    GROUP BY DepartmentId)

SELECT department.name as department, employee.name AS employee, employee.salary
FROM employee
         INNER JOIN department ON employee.DepartmentId = department.id
         INNER JOIN hightest_salary_per_dep USING (salary, DepartmentId)

-- #leetcode submit region end(Prohibit modification and deletion)
