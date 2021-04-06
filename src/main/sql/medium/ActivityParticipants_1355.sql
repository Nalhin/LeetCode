-- #Table: Friends
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| name          | varchar |
-- #| activity      | varchar |
-- #+---------------+---------+
-- #id is the id of the friend and primary key for this table.
-- #name is the name of the friend.
-- #activity is the name of the activity which the friend takes part in.
-- #
-- #
-- # Table: Activities
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| name          | varchar |
-- #+---------------+---------+
-- #id is the primary key for this table.
-- #name is the name of the activity.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find the names of all the activities with neither maximu
-- #m, nor minimum number of participants.
-- #
-- # Return the result table in any order. Each activity in table Activities is per
-- #formed by any person in the table Friends.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Friends table:
-- #+------+--------------+---------------+
-- #| id   | name         | activity      |
-- #+------+--------------+---------------+
-- #| 1    | Jonathan D.  | Eating        |
-- #| 2    | Jade W.      | Singing       |
-- #| 3    | Victor J.    | Singing       |
-- #| 4    | Elvis Q.     | Eating        |
-- #| 5    | Daniel A.    | Eating        |
-- #| 6    | Bob B.       | Horse Riding  |
-- #+------+--------------+---------------+
-- #
-- #Activities table:
-- #+------+--------------+
-- #| id   | name         |
-- #+------+--------------+
-- #| 1    | Eating       |
-- #| 2    | Singing      |
-- #| 3    | Horse Riding |
-- #+------+--------------+
-- #
-- #Result table:
-- #+--------------+
-- #| activity     |
-- #+--------------+
-- #| Singing      |
-- #+--------------+
-- #
-- #Eating activity is performed by 3 friends, maximum number of participants, (Jon
-- #athan D. , Elvis Q. and Daniel A.)
-- #Horse Riding activity is performed by 1 friend, minimum number of participants,
-- # (Bob B.)
-- #Singing is performed by 2 friends (Victor J. and Jade W.)
-- #
-- # 👍 66 👎 23
--
-- Runtime: 570 ms, faster than 52.22% of MySQL online submissions for Activity Participants.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Activity Participants.
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

WITH activity_count_cte AS (
    SELECT activity, COUNT(*) AS friends_count
    FROM friends
             RIGHT JOIN activities ON friends.activity = activities.name
    GROUP BY activity
)

SELECT activity
FROM activity_count_cte
WHERE friends_count != (SELECT MAX(friends_count) FROM activity_count_cte)
  AND friends_count != (SELECT MIN(friends_count) FROM activity_count_cte)
-- #leetcode submit region end(Prohibit modification and deletion)
