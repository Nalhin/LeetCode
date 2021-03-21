-- #A pupil Tim gets homework to identify whether three line segments could possibl
-- #y form a triangle.
-- #
-- #However, this assignment is very heavy because there are hundreds of records to
-- # calculate.
-- #
-- #
-- #Could you help Tim by writing a query to judge whether these three sides can fo
-- #rm a triangle, assuming table triangle holds the length of the three sides x, y
-- #and z.
-- #
-- #
-- #
-- #
-- #| x  | y  | z  |
-- #|----|----|----|
-- #| 13 | 15 | 30 |
-- #| 10 | 20 | 15 |
-- #
-- #For the sample data above, your query should return the follow result:
-- #
-- #
-- #| x  | y  | z  | triangle |
-- #|----|----|----|----------|
-- #| 13 | 15 | 30 | No       |
-- #| 10 | 20 | 15 | Yes      |
-- #
-- # 👍 138 👎 27
/*
  Runtime: 261 ms, faster than 39.88% of MySQL online submissions for Triangle Judgement.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Triangle Judgement.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT x, y, z, IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
FROM triangle;
-- #leetcode submit region end(Prohibit modification and deletion)
