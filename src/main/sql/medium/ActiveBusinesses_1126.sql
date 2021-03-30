-- #Table: Events
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| business_id   | int     |
-- #| event_type    | varchar |
-- #| occurences    | int     |
-- #+---------------+---------+
-- #(business_id, event_type) is the primary key of this table.
-- #Each row in the table logs the info that an event of some type occured at some
-- #business for a number of times.
-- #
-- #
-- #
-- # Write an SQL query to find all active businesses.
-- #
-- # An active business is a business that has more than one event type with occure
--                                                                                                                                                                       #nces greater than the average occurences of that event type among all businesses
-- #.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Events table:
-- #+-------------+------------+------------+
-- #| business_id | event_type | occurences |
-- #+-------------+------------+------------+
-- #| 1           | reviews    | 7          |
-- #| 3           | reviews    | 3          |
-- #| 1           | ads        | 11         |
-- #| 2           | ads        | 7          |
-- #| 3           | ads        | 6          |
-- #| 1           | page views | 3          |
-- #| 2           | page views | 12         |
-- #+-------------+------------+------------+
-- #
-- #Result table:
-- #+-------------+
-- #| business_id |
-- #+-------------+
-- #| 1           |
-- #+-------------+
-- #Average for 'reviews', 'ads' and 'page views' are (7+3)/2=5, (11+7+6)/3=8, (3+1
-- #2)/2=7.5 respectively.
-- #Business with id 1 has 7 'reviews' events (more than 5) and 11 'ads' events (mo
-- #re than 8) so it is an active business.
-- # 👍 118 👎 13
/*
  Runtime: 749 ms, faster than 57.81% of MySQL online submissions for Active Businesses.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Active Businesses.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT business_id
FROM events
         INNER JOIN (SELECT event_type, AVG(occurences) AS occurences
                     FROM events
                     GROUP BY event_type) events_avg USING (event_type)
GROUP BY business_id
HAVING SUM(events.occurences > events_avg.occurences) >= 2;
-- #leetcode submit region end(Prohibit modification and deletion)
