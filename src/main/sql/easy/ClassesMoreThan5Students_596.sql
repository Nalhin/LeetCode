-- #There is a table courses with columns: student and class
-- #
-- # Please list out all classes which have more than or equal to 5 students.
-- #
-- # For example, the table:
--                    #
-- #
-- #+---------+------------+
-- #| student | class      |
-- #+---------+------------+
-- #| A       | Math       |
-- #| B       | English    |
-- #| C       | Math       |
-- #| D       | Biology    |
-- #| E       | Math       |
-- #| F       | Computer   |
-- #| G       | Math       |
-- #| H       | Math       |
-- #| I       | Math       |
-- #+---------+------------+
-- #
-- #
-- # Should output:
-- #
-- #
-- #+---------+
-- #| class   |
-- #+---------+
-- #| Math    |
-- #+---------+
-- #
-- #
-- #
-- #
-- # Note:
-- #The students should not be counted duplicate in each course.
-- # 👍 281 👎 750
/*
  Runtime: 251 ms, faster than 69.57% of MySQL online submissions for Classes More Than 5 Students.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Classes More Than 5 Students.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
-- #leetcode submit region end(Prohibit modification and deletion)
