-- #Write a SQL query to delete all duplicate email entries in a table named Person
--                           #, keeping only unique emails based on its smallest Id.
--                           #
--                           #
--                           #+----+------------------+
--                           #| Id | Email            |
--                           #+----+------------------+
--                           #| 1  | john@example.com |
--                           #| 2  | bob@example.com  |
--                           #| 3  | john@example.com |
--                           #+----+------------------+
--                           #Id is the primary key column for this table.
-- #
-- #
-- # For example, after running your query, the above Person table should have the
-- #following rows:
-- #
-- #
-- #+----+------------------+
-- #| Id | Email            |
-- #+----+------------------+
-- #| 1  | john@example.com |
-- #| 2  | bob@example.com  |
-- #+----+------------------+
-- #
-- #
-- # Note:
-- #
-- # Your output is the whole Person table after executing your sql. Use delete sta
-- #tement.
-- # 👍 550 👎 795
/*
  Runtime: 1505 ms, faster than 81.56% of MySQL online submissions for Delete Duplicate Emails.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Delete Duplicate Emails.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
DELETE
FROM person
WHERE (id, email) NOT IN (SELECT * FROM (SELECT MIN(id), email FROM person GROUP BY email) nested);
-- #leetcode submit region end(Prohibit modification and deletion)
