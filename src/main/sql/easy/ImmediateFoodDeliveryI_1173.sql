-- #Table: Delivery
-- #
-- #
-- #+-----------------------------+---------+
-- #| Column Name                 | Type    |
-- #+-----------------------------+---------+
-- #| delivery_id                 | int     |
-- #| customer_id                 | int     |
-- #| order_date                  | date    |
-- #| customer_pref_delivery_date | date    |
-- #+-----------------------------+---------+
-- #delivery_id is the primary key of this table.
-- #The table holds information about food delivery to customers that make orders a
-- #t some date and specify a preferred delivery date (on the same order date or aft
-- #er it).
-- #
-- #
-- #
-- #
-- # If the preferred delivery date of the customer is the same as the order date t
-- #hen the order is called immediate otherwise it's called scheduled.
-- #
-- # Write an SQL query to find the percentage of immediate orders in the table, ro
-- #unded to 2 decimal places.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Delivery table:
-- #+-------------+-------------+------------+-----------------------------+
-- #| delivery_id | customer_id | order_date | customer_pref_delivery_date |
-- #+-------------+-------------+------------+-----------------------------+
-- #| 1           | 1           | 2019-08-01 | 2019-08-02                  |
-- #| 2           | 5           | 2019-08-02 | 2019-08-02                  |
-- #| 3           | 1           | 2019-08-11 | 2019-08-11                  |
-- #| 4           | 3           | 2019-08-24 | 2019-08-26                  |
-- #| 5           | 4           | 2019-08-21 | 2019-08-22                  |
-- #| 6           | 2           | 2019-08-11 | 2019-08-13                  |
-- #+-------------+-------------+------------+-----------------------------+
-- #
-- #Result table:
-- #+----------------------+
-- #| immediate_percentage |
-- #+----------------------+
-- #| 33.33                |
-- #+----------------------+
-- #The orders with delivery id 2 and 3 are immediate while the others are schedule
-- #d.
-- #
-- # 👍 77 👎 3

/*
    Runtime: 384 ms, faster than 66.25% of MySQL online submissions for Immediate Food Delivery I.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Immediate Food Delivery I.
 */
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT ROUND((SELECT COUNT(*)
              from delivery
              WHERE delivery.order_date = delivery.customer_pref_delivery_date) / COUNT(*) * 100,
             2) as immediate_percentage
FROM delivery
-- #leetcode submit region end(Prohibit modification and deletion)
