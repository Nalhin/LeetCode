-- #Table: Employees
-- #
-- #
-- #+-------------+----------+
-- #| Column Name | Type     |
-- #+-------------+----------+
-- #| employee_id | int      |
-- #| name        | varchar  |
-- #| reports_to  | int      |
-- #| age         | int      |
-- #+-------------+----------+
-- #employee_id is the primary key for this table.
-- #This table contains information about the employees and the id of the manager t
-- #hey report to. Some employees do not report to anyone (reports_to is null).
-- #
-- #
-- #
-- #
-- # For this problem, we will consider a manager an employee who has at least 1 ot
-- #her employee reporting to them.
-- #
-- # Write an SQL query to report the ids and the names of all managers, the number
-- # of employees who report directly to them, and the average age of the reports ro
-- #unded to the nearest integer.
-- #
-- # Return the result table ordered by employee_id.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Employees table:
-- #+-------------+---------+------------+-----+
-- #| employee_id | name    | reports_to | age |
-- #+-------------+---------+------------+-----+
-- #| 9           | Hercy   | null       | 43  |
-- #| 6           | Alice   | 9          | 41  |
-- #| 4           | Bob     | 9          | 36  |
-- #| 2           | Winston | null       | 37  |
-- #+-------------+---------+------------+-----+
-- #
-- #Result table:
-- #+-------------+-------+---------------+-------------+
-- #| employee_id | name  | reports_count | average_age |
-- #+-------------+-------+---------------+-------------+
-- #| 9           | Hercy | 2             | 39          |
-- #+-------------+-------+---------------+-------------+
-- #Hercy has 2 people report directly to him, Alice and Bob. Their average age is
-- #(41+36)/2 = 38.5, which is 39 after rounding it to the nearest integer.
-- #
-- # 👍 18 👎 5

-- Runtime: 681 ms, faster than 20.91% of MySQL online submissions for The Number of Employees Which Report to Each Employee.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for The Number of Employees Which Report to Each Employee.

SELECT e.employee_id, e.name, COUNT(r.reports_to) as reports_count, ROUND(AVG(r.age), 0) as average_age
FROM employees e
         INNER JOIN employees r ON r.reports_to = e.employee_id
GROUP BY e.employee_id, e.name
ORDER BY e.employee_id;

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
--
-- #leetcode submit region end(Prohibit modification and deletion)
