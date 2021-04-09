-- #The Employee table holds all employees including their managers. Every employee
-- # has an Id, and there is also a column for the manager Id.
-- #
-- #
-- #+------+----------+-----------+----------+
-- #|Id    |Name 	  |Department |ManagerId |
-- #+------+----------+-----------+----------+
-- #|101   |John 	  |A 	      |null      |
-- #|102   |Dan 	  |A 	      |101       |
-- #|103   |James 	  |A 	      |101       |
-- #|104   |Amy 	  |A 	      |101       |
-- #|105   |Anne 	  |A 	      |101       |
-- #|106   |Ron 	  |B 	      |101       |
-- #+------+----------+-----------+----------+
-- #
-- #
-- # Given the Employee table, write a SQL query that finds out managers with at le
-- #ast 5 direct report. For the above table, your SQL query should return:
-- #
-- #
-- #+-------+
-- #| Name  |
-- #+-------+
-- #| John  |
-- #+-------+
-- #
-- #
-- # Note:
-- #No one would report to himself.
-- # 👍 145 👎 19
--
-- Runtime: 272 ms, faster than 57.17% of MySQL online submissions for Managers with at Least 5 Direct Reports.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Managers with at Least 5 Direct Reports.
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

SELECT name
FROM employee
WHERE id IN (SELECT ManagerId
             FROM employee
             GROUP BY ManagerId
             HAVING COUNT(*) >= 5)

-- #leetcode submit region end(Prohibit modification and deletion)
