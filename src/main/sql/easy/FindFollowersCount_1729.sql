-- #Table: Followers
--  #
-- #
-- #+-------------+------+
-- #| Column Name | Type |
-- #+-------------+------+
-- #| user_id     | int  |
-- #| follower_id | int  |
-- #+-------------+------+
-- #(user_id, follower_id) is the primary key for this table.
-- #This table contains the IDs of a user and a follower in a social media app wher
-- #e the follower follows the user.
-- #
-- # Write an SQL query that will, for each user, return the number of followers.
-- #
-- # Return the result table ordered by user_id.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Followers table:
--            #+---------+-------------+
-- #| user_id | follower_id |
-- #+---------+-------------+
-- #| 0       | 1           |
-- #| 1       | 0           |
-- #| 2       | 0           |
-- #| 2       | 1           |
-- #+---------+-------------+
-- #Result table:
--         #+---------+----------------+
-- #| user_id | followers_count|
-- #+---------+----------------+
-- #| 0       | 1              |
-- #| 1       | 1              |
-- #| 2       | 2              |
-- #+---------+----------------+
-- #The followers of 0 are {1}
-- #The followers of 1 are {0}
-- #The followers of 2 are {0,1}
-- #
-- #
-- #
-- # 👍 18 👎 6
/*
  Runtime: 513 ms, faster than 40.58% of MySQL online submissions for Find Followers Count.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Find Followers Count.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT user_id, COUNT(follower_id) AS followers_count
FROM followers
GROUP BY user_id;
-- #leetcode submit region end(Prohibit modification and deletion)
