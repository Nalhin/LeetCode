-- #Write a SQL query to rank scores. If there is a tie between two scores, both sh
-- #ould have the same ranking. Note that after a tie, the next ranking number shoul
-- #d be the next consecutive integer value. In other words, there should be no "hol
-- #es" between ranks.
-- #
-- #
-- #+----+-------+
-- #| Id | Score |
-- #+----+-------+
-- #| 1  | 3.50  |
-- #| 2  | 3.65  |
-- #| 3  | 4.00  |
-- #| 4  | 3.85  |
-- #| 5  | 4.00  |
-- #| 6  | 3.65  |
-- #+----+-------+
-- #
-- #
-- # For example, given the above Scores table, your query should generate the foll
-- #owing report (order by highest score):
-- #
-- #
-- #+-------+---------+
-- #| score | Rank    |
-- #+-------+---------+
-- #| 4.00  | 1       |
-- #| 4.00  | 1       |
-- #| 3.85  | 2       |
-- #| 3.65  | 3       |
-- #| 3.65  | 3       |
-- #| 3.50  | 4       |
-- #+-------+---------+
-- #
-- #
-- # Important Note: For MySQL solutions, to escape reserved words used as column n
-- #ames, you can use an apostrophe before and after the keyword. For example `Rank`
-- #.
-- # 👍 909 👎 165

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
/*
  Runtime: 674 ms, faster than 12.21% of MySQL online submissions for Rank Scores.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.
*/
-- SELF JOIN
SELECT curr.score, COUNT(DISTINCT lower.score) AS 'rank'
FROM scores curr
         INNER JOIN scores lower ON curr.score <= lower.score
GROUP BY curr.id
ORDER BY curr.score DESC;

/*
  Runtime: 220 ms, faster than 90.13% of MySQL online submissions for Rank Scores.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rank Scores.
*/
-- WINDOW FUNCTIONS
SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
FROM scores

-- #leetcode submit region end(Prohibit modification and deletion)
