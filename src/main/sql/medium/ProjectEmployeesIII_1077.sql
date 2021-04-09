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
-- # Write an SQL query that reports the most experienced employees in each project
-- #. In case of a tie, report all employees with the maximum number of experience y
-- #ears.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Project table:
-- #+-------------+-------------+
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
-- #+-------------+--------+------------------+
-- #| employee_id | name   | experience_years |
-- #+-------------+--------+------------------+
-- #| 1           | Khaled | 3                |
-- #| 2           | Ali    | 2                |
-- #| 3           | John   | 3                |
-- #| 4           | Doe    | 2                |
-- #+-------------+--------+------------------+
-- #
-- #Result table:
-- #+-------------+---------------+
-- #| project_id  | employee_id   |
-- #+-------------+---------------+
-- #| 1           | 1             |
-- #| 1           | 3             |
-- #| 2           | 1             |
-- #+-------------+---------------+
-- #Both employees with id 1 and 3 have the most experience among the employees of
-- #the first project. For the second project, the employee with id 1 has the most e
-- #xperience.
-- # 👍 114 👎 2
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 421 ms, faster than 97.14% of MySQL online submissions for Project Employees III.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Project Employees III.
-- WINDOW FUNCTIONS
SELECT project_id, employee_id
FROM (SELECT project_id,
             employee_id,
             RANK() OVER (PARTITION BY project_id ORDER BY experience_years DESC) AS experience_rank
      FROM project
               INNER JOIN employee USING (employee_id)) ranked_employees
WHERE experience_rank = 1;

-- Runtime: 562 ms, faster than 36.53% of MySQL online submissions for Project Employees III.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Project Employees III.
-- WHERE IN
SELECT project_id, employee_id
FROM project
         INNER JOIN employee USING (employee_id)
WHERE (project_id, experience_years) IN (
    SELECT project_id, MAX(experience_years)
    FROM project
             INNER JOIN employee USING (employee_id)
    GROUP BY project_id
)
-- #leetcode submit region end(Prohibit modification and deletion)
