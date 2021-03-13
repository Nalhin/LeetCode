-- //Table: Employee
--   //
-- //
-- //+---------------+---------+
-- //| Column Name   | Type    |
-- //+---------------+---------+
-- //| employee_id   | int     |
-- //| team_id       | int     |
-- //+---------------+---------+
-- //employee_id is the primary key for this table.
-- //Each row of this table contains the ID of each employee and their respective t
-- //eam.
-- //
-- //
-- // Write an SQL query to find the team size of each of the employees.
-- //
-- // Return result table in any order.
-- //
-- // The query result format is in the following example:
-- //
-- //
-- //Employee Table:
--            //+-------------+------------+
-- //| employee_id | team_id    |
-- //+-------------+------------+
-- //|     1       |     8      |
-- //|     2       |     8      |
-- //|     3       |     8      |
-- //|     4       |     7      |
-- //|     5       |     9      |
-- //|     6       |     9      |
-- //+-------------+------------+
-- //Result table:
--          //+-------------+------------+
-- //| employee_id | team_size  |
-- //+-------------+------------+
-- //|     1       |     3      |
-- //|     2       |     3      |
-- //|     3       |     3      |
-- //|     4       |     1      |
-- //|     5       |     2      |
-- //|     6       |     2      |
-- //+-------------+------------+
-- //Employees with Id 1,2,3 are part of a team with team_id = 8.
-- //Employees with Id 4 is part of a team with team_id = 7.
-- //Employees with Id 5,6 are part of a team with team_id = 9.
-- //
-- //
-- // 👍 127 👎 9

/*
  Runtime: 289 ms, faster than 26.26% of MySQL online submissions for Find the Team Size.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Find the Team Size.
*/

SELECT employee_id, team_summary.team_size
FROM employee
         INNER JOIN (SELECT team_id, COUNT(team_id) as team_size FROM employee GROUP BY team_id) team_summary
                    USING (team_id);

-- //There is no code of Java type for this problem
