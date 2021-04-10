-- #In facebook, there is a follow table with two columns: followee, follower.
-- #
-- # Please write a sql query to get the amount of each follower’s follower if he/s
-- #he has one.
-- #
-- # For example:
-- #
-- #
-- #+-------------+------------+
-- #| followee    | follower   |
-- #+-------------+------------+
-- #|     A       |     B      |
-- #|     B       |     C      |
-- #|     B       |     D      |
-- #|     D       |     E      |
-- #+-------------+------------+
-- #
-- #should output:
-- #
-- #
-- #+-------------+------------+
-- #| follower    | num        |
-- #+-------------+------------+
-- #|     B       |  2         |
-- #|     D       |  1         |
-- #+-------------+------------+
-- #
-- #Explaination:
-- #Both B and D exist in the follower list, when as a followee, B's follower is C
-- #and D, and D's follower is E. A does not exist in follower list.
-- #
-- #
-- #
-- #Note:
-- #Followee would not follow himself/herself in all cases.
-- #Please display the result in follower's alphabet order.
-- #
-- # 👍 87 👎 583
--
-- Runtime: 492 ms, faster than 58.60% of MySQL online submissions for Second Degree Follower.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Second Degree Follower.
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT first_followers.followee AS follower, COUNT(DISTINCT first_followers.follower) AS num
FROM follow curr_user
         INNER JOIN follow first_followers ON curr_user.follower = first_followers.followee
GROUP BY first_followers.followee
ORDER BY first_followers.followee

-- #leetcode submit region end(Prohibit modification and deletion)
