-- #Table: Candidate
--  #
-- #
-- #+-----+---------+
-- #| id  | Name    |
-- #+-----+---------+
-- #| 1   | A       |
-- #| 2   | B       |
-- #| 3   | C       |
-- #| 4   | D       |
-- #| 5   | E       |
-- #+-----+---------+
-- #
-- #
-- # Table: Vote
--   #
-- #
-- #+-----+--------------+
-- #| id  | CandidateId  |
-- #+-----+--------------+
-- #| 1   |     2        |
-- #| 2   |     4        |
-- #| 3   |     3        |
-- #| 4   |     2        |
-- #| 5   |     5        |
-- #+-----+--------------+
-- #id is the auto-increment primary key,
-- #CandidateId is the id appeared in Candidate table.
-- #
-- #
-- # Write a sql to find the name of the winning candidate, the above example will
-- #return the winner B.
-- #
-- #
-- #+------+
-- #| Name |
-- #+------+
-- #| B    |
-- #+------+
-- #
-- #
-- # Notes:
-- #
-- #
-- # You may assume there is no tie, in other words there will be only one winning
-- #candidate.
-- #
-- #
-- #
-- # 👍 85 👎 327
/*
  Runtime: 424 ms, faster than 37.04% of MySQL online submissions for Winning Candidate.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Winning Candidate.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT name FROM candidate
WHERE id =
      (SELECT CandidateId
       FROM vote
       GROUP BY CandidateId
       ORDER BY COUNT(*) DESC
       LIMIT 1
      )
-- #leetcode submit region end(Prohibit modification and deletion)
