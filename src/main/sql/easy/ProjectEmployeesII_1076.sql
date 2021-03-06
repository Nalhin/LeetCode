-- #Table: Project
--  #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| project_id  | int     |
-- #| employee_id | int     |
-- #+-------------+---------+
-- #(project_id, employee_id) is the primary key of this table.
-- #employee_id is a foreign key to Employee table.
-- #
-- #
-- #
-- #
-- # Table: Employee
--   #
-- #
-- #+------------------+---------+
-- #| Column Name      | Type    |
-- #+------------------+---------+
-- #| employee_id      | int     |
-- #| name             | varchar |
-- #| experience_years | int     |
-- #+------------------+---------+
-- #employee_id is the primary key of this table.
-- #
-- #
-- #
-- #
-- # Write an SQL query that reports all the projects that have the most employees.
-- #
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Project table:
--          #+-------------+-------------+
-- #| project_id  | employee_id |
-- #+-------------+-------------+
-- #| 1           | 1           |
-- #| 1           | 2           |
-- #| 1           | 3           |
-- #| 2           | 1           |
-- #| 2           | 4           |
-- #+-------------+-------------+
-- #
-- #Employee table:
--           #+-------------+--------+------------------+
-- #| employee_id | name   | experience_years |
-- #+-------------+--------+------------------+
-- #| 1           | Khaled | 3                |
-- #| 2           | Ali    | 2                |
-- #| 3           | John   | 1                |
-- #| 4           | Doe    | 2                |
-- #+-------------+--------+------------------+
-- #
-- #Result table:
--         #+-------------+
-- #| project_id  |
-- #+-------------+
-- #| 1           |
-- #+-------------+
-- #The first project has 3 employees while the second one has 2.
-- # 👍 75 👎 23

-- Runtime: 644 ms, faster than 78.21% of MySQL online submissions for Project Employees II.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Project Employees II.

SELECT project_id
FROM project
GROUP BY project_id
HAVING COUNT(project.employee_id) = (SELECT COUNT(employee_id)
                                     FROM project
                                     GROUP BY project_id
                                     ORDER BY COUNT(employee_id) DESC
                                     LIMIT 1);

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
