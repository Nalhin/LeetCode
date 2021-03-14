-- #Table: Employee
--  #
-- #
-- #+--------------+---------+
-- #| Column Name  |  Type   |
-- #+--------------+---------+
-- #| employee_id  | int     |
-- #| deprtment_id | int     |
-- #| primary_flag | varchar |
-- #+--------------+---------+
-- #(employee_id, department_id) is the primary key for this table.
-- #employee_id is the id of the employee.
-- #department_id is the id of the department to which the employee belongs.
-- #primary_flag is an ENUM of type ('Y', 'N'). If the flag is 'Y', the department
-- #is the primary department for the employee. If the flag is 'N', the department i
-- #s not the primary.
-- #
-- #
-- #
-- #
-- # Employees can belong to multiple departments. When the employee joins other de
-- #partments, they need to decide which department is their primary department. Not
-- #e that when an employee belongs to only one department, their primary column is
-- #'N'.
-- #
-- # Write an SQL query to report all the employees with their primary department.
-- #For employees who belong to one department, report their only department.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example.
-- #
-- #
-- #
-- #
-- #Employee table:
-- #+-------------+---------------+--------------+
-- #| employee_id | department_id | primary_flag |
-- #+-------------+---------------+--------------+
-- #| 1           | 1             | N            |
-- #| 2           | 1             | Y            |
-- #| 2           | 2             | N            |
-- #| 3           | 3             | N            |
-- #| 4           | 2             | N            |
-- #| 4           | 3             | Y            |
-- #| 4           | 4             | N            |
-- #+-------------+---------------+--------------+
-- #
-- #Result table:
-- #+-------------+---------------+
-- #| employee_id | department_id |
-- #+-------------+---------------+
-- #| 1           | 1             |
-- #| 2           | 1             |
-- #| 3           | 3             |
-- #| 4           | 3             |
-- #+-------------+---------------+
-- #- The Primary department for employee 1 is 1.
-- #- The Primary department for employee 2 is 1.
-- #- The Primary department for employee 3 is 3.
-- #- The Primary department for employee 4 is 3.
-- #
-- # 👍 3 👎 2

/*
  Runtime: 433 ms, faster than 100.00% of MySQL online submissions for Primary Department for Each Employee.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Primary Department for Each Employee.
*/

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

SELECT DISTINCT employee_id,
                (SELECT department_id
                 FROM employee emp_by_department
                 WHERE emp_by_department.employee_id = employee.employee_id
                 ORDER BY primary_flag
                 LIMIT 1) AS department_id
FROM employee;

-- #leetcode submit region end(Prohibit modification and deletion)
