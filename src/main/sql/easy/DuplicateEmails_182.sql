-- #Write a SQL query to find all duplicate emails in a table named Person.
-- #
-- #
-- #+----+---------+
-- #| Id | Email   |
-- #+----+---------+
-- #| 1  | a@b.com |
-- #| 2  | c@d.com |
-- #| 3  | a@b.com |
-- #+----+---------+
-- #
-- #
-- # For example, your query should return the following for the above table:
--                                                                     #
-- #
-- #+---------+
-- #| Email   |
-- #+---------+
-- #| a@b.com |
-- #+---------+
-- #
-- #
-- # Note: All emails are in lowercase.
-- # 👍 614 👎 31
/*
  Runtime: 276 ms, faster than 88.88% of MySQL online submissions for Duplicate Emails.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT email
FROM person
GROUP BY email
HAVING COUNT(*) > 1;
-- #leetcode submit region end(Prohibit modification and deletion)
