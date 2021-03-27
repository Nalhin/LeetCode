-- #Table my_numbers contains many numbers in column num including duplicated ones.
-- #
-- #Can you write a SQL query to find the biggest number, which only appears once.
-- #
-- #
-- #
-- #+---+
-- #|num|
-- #+---+
-- #| 8 |
-- #| 8 |
-- #| 3 |
-- #| 3 |
-- #| 1 |
-- #| 4 |
-- #| 5 |
-- #| 6 |
-- #
-- #For the sample data above, your query should return the following result:
-- #
-- #
-- #+---+
-- #|num|
-- #+---+
-- #| 6 |
-- #
-- #Note:
-- #If there is no such number, just output null.
-- #
-- #
-- # 👍 87 👎 80
/*
  Runtime: 299 ms, faster than 58.00% of MySQL online submissions for Biggest Single Number.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Biggest Single Number.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT MAX(num) AS num
FROM (SELECT num
      FROM my_numbers
      GROUP BY num
      HAVING COUNT(num) <= 1) nested
-- #leetcode submit region end(Prohibit modification and deletion)
