-- #Table: Ads
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| ad_id         | int     |
-- #| user_id       | int     |
-- #| action        | enum    |
-- #+---------------+---------+
-- #(ad_id, user_id) is the primary key for this table.
-- #Each row of this table contains the ID of an Ad, the ID of a user and the actio
-- #n taken by this user regarding this Ad.
-- #The action column is an ENUM type of ('Clicked', 'Viewed', 'Ignored').
-- #
-- #
-- #
-- #
-- # A company is running Ads and wants to calculate the performance of each Ad.
-- #
-- # Performance of the Ad is measured using Click-Through Rate (CTR) where:
-- #
-- #
-- #
-- # Write an SQL query to find the ctr of each Ad.
-- #
-- # Round ctr to 2 decimal points. Order the result table by ctr in descending ord
-- #er and by ad_id in ascending order in case of a tie.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Ads table:
--      #+-------+---------+---------+
-- #| ad_id | user_id | action  |
-- #+-------+---------+---------+
-- #| 1     | 1       | Clicked |
-- #| 2     | 2       | Clicked |
-- #| 3     | 3       | Viewed  |
-- #| 5     | 5       | Ignored |
-- #| 1     | 7       | Ignored |
-- #| 2     | 7       | Viewed  |
-- #| 3     | 5       | Clicked |
-- #| 1     | 4       | Viewed  |
-- #| 2     | 11      | Viewed  |
-- #| 1     | 2       | Clicked |
-- #+-------+---------+---------+
-- #Result table:
--         #+-------+-------+
-- #| ad_id | ctr   |
-- #+-------+-------+
-- #| 1     | 66.67 |
-- #| 3     | 50.00 |
-- #| 2     | 33.33 |
-- #| 5     | 0.00  |
-- #+-------+-------+
-- #for ad_id = 1, ctr = (2/(2+1)) * 100 = 66.67
-- #for ad_id = 2, ctr = (1/(1+2)) * 100 = 33.33
-- #for ad_id = 3, ctr = (1/(1+1)) * 100 = 50.00
-- #for ad_id = 5, ctr = 0.00, Note that ad_id = 5 has no clicks or views.
-- #Note that we don't care about Ignored Ads.
-- #Result table is ordered by the ctr. in case of a tie we order them by ad_id
-- #
-- # 👍 113 👎 28
/*
  Runtime: 336 ms, faster than 99.26% of MySQL online submissions for Ads Performance.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Ads Performance.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT ad_id,
       COALESCE(ROUND(SUM(IF(action = 'Clicked', 1, 0)) / SUM(IF(action = 'Clicked' OR action = 'Viewed', 1, 0)) * 100,
                      2), 0) AS ctr
FROM ads
GROUP BY ad_id
ORDER BY ctr DESC, ad_id;
-- #leetcode submit region end(Prohibit modification and deletion)
