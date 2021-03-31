-- #Table point_2d holds the coordinates (x,y) of some unique points (more than two
-- #) in a plane.
-- #
-- #Write a query to find the shortest distance between these points rounded to 2 d
-- #ecimals.
-- #
-- #
-- #
-- #
-- #| x  | y  |
-- #|----|----|
-- #| -1 | -1 |
-- #| 0  | 0  |
-- #| -1 | -2 |
-- #
-- #
-- #
-- #The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output shoul
-- #d be:
-- #
-- #
-- #
-- #
-- #| shortest |
-- #|----------|
-- #| 1.00     |
-- #
-- #
-- #
-- #Note: The longest distance among all the points are less than 10000.
-- #
-- #
-- # 👍 124 👎 42
/*
  Runtime: 183 ms, faster than 91.55% of MySQL online submissions for Shortest Distance in a Plane.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Shortest Distance in a Plane.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT MIN(ROUND(SQRT(POWER(p1.x - p2.x, 2) + POWER(p1.y - p2.y, 2)), 2)) AS shortest
FROM point_2d p1
         INNER JOIN point_2d p2 ON p1.x != p2.x OR p1.y != p2.y
-- #leetcode submit region end(Prohibit modification and deletion)
