-- #Write a SQL query to get the nth highest salary from the Employee table.
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
-- # For example, given the above Employee table, the nth highest salary where n =
-- #2 is 200. If there is no nth highest salary, then the query should return null.
-- #
-- #
-- #
-- #+------------------------+
-- #| getNthHighestSalary(2) |
-- #+------------------------+
-- #| 200                    |
-- #+------------------------+
-- #
-- # 👍 605 👎 451

/*
  Runtime: 272 ms, faster than 87.32% of MySQL online submissions for Nth Highest Salary.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N - 1;
RETURN
(
    SELECT Salary
    FROM Employee
    GROUP BY Salary
    ORDER BY Salary DESC
    LIMIT 1 OFFSET N
);
END


--     #leetcode submit region end(Prohibit modification and deletion)
