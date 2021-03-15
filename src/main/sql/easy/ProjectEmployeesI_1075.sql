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
-- # Write an SQL query that reports the average experience years of all the employ
-- #ees for each project, rounded to 2 digits.
-- #
-- # The query result format is in the following example:
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
--         #+-------------+---------------+
-- #| project_id  | average_years |
-- #+-------------+---------------+
-- #| 1           | 2.00          |
-- #| 2           | 2.50          |
-- #+-------------+---------------+
-- #The average experience years for the first project is (3 + 2 + 1) / 3 = 2.00 an
-- #d for the second project is (3 + 2) / 2 = 2.50
-- #
-- # 👍 38 👎 47
/*
  Runtime: 715 ms, faster than 52.01% of MySQL online submissions for Project Employees I.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Project Employees I.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT project_id, ROUND(AVG(experience_years), 2) as average_years
FROM project
         INNER JOIN employee USING (employee_id)
GROUP BY project_id;

-- #leetcode submit region end(Prohibit modification and deletion)
