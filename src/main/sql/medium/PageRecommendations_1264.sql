-- #Table: Friendship
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| user1_id      | int     |
-- #| user2_id      | int     |
-- #+---------------+---------+
-- #(user1_id, user2_id) is the primary key for this table.
-- #Each row of this table indicates that there is a friendship relation between us
-- #er1_id and user2_id.
-- #
-- #
-- #
-- #
-- # Table: Likes
--   #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| user_id     | int     |
-- #| page_id     | int     |
-- #+-------------+---------+
-- #(user_id, page_id) is the primary key for this table.
-- #Each row of this table indicates that user_id likes page_id.
-- #
-- #
-- #
-- #
-- # Write an SQL query to recommend pages to the user with user_id = 1 using the p
-- #ages that your friends liked. It should not recommend pages you already liked.
-- #
-- # Return result table in any order without duplicates.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Friendship table:
-- #+----------+----------+
-- #| user1_id | user2_id |
-- #+----------+----------+
-- #| 1        | 2        |
-- #| 1        | 3        |
-- #| 1        | 4        |
-- #| 2        | 3        |
-- #| 2        | 4        |
-- #| 2        | 5        |
-- #| 6        | 1        |
-- #+----------+----------+
-- #
-- #Likes table:
-- #+---------+---------+
-- #| user_id | page_id |
-- #+---------+---------+
-- #| 1       | 88      |
-- #| 2       | 23      |
-- #| 3       | 24      |
-- #| 4       | 56      |
-- #| 5       | 11      |
-- #| 6       | 33      |
-- #| 2       | 77      |
-- #| 3       | 77      |
-- #| 6       | 88      |
-- #+---------+---------+
-- #
-- #Result table:
-- #+------------------+
-- #| recommended_page |
-- #+------------------+
-- #| 23               |
-- #| 24               |
-- #| 56               |
-- #| 33               |
-- #| 77               |
-- #+------------------+
-- #User one is friend with users 2, 3, 4 and 6.
-- #Suggested pages are 23 from user 2, 24 from user 3, 56 from user 3 and 33 from
-- #user 6.
-- #Page 77 is suggested from both user 2 and user 3.
-- #Page 88 is not suggested because user 1 already likes it.
-- # 👍 78 👎 1
--
-- Runtime: 442 ms, faster than 60.79% of MySQL online submissions for Page Recommendations.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Page Recommendations.
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
WITH friends_cte AS (
    SELECT user1_id AS user_id
    FROM friendship
    WHERE user2_id = 1

    UNION ALL

    SELECT user2_id AS user_id
    FROM friendship
    WHERE user1_id = 1
)

SELECT DISTINCT page_id AS recommended_page
FROM likes
         INNER JOIN friends_cte USING (user_id)
WHERE page_id NOT IN (SELECT DISTINCT page_id FROM likes WHERE user_id = 1)
-- #leetcode submit region end(Prohibit modification and deletion)
