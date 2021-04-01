-- #Table: Delivery
--  #
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
-- # The first order of a customer is the order with the earliest order date that c
-- #ustomer made. It is guaranteed that a customer has exactly one first order.
-- #
-- # Write an SQL query to find the percentage of immediate orders in the first ord
-- #ers of all customers, rounded to 2 decimal places.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Delivery table:
-- #+-------------+-------------+------------+-----------------------------+
-- #| delivery_id | customer_id | order_date | customer_pref_delivery_date |
-- #+-------------+-------------+------------+-----------------------------+
-- #| 1           | 1           | 2019-08-01 | 2019-08-02                  |
-- #| 2           | 2           | 2019-08-02 | 2019-08-02                  |
-- #| 3           | 1           | 2019-08-11 | 2019-08-12                  |
-- #| 4           | 3           | 2019-08-24 | 2019-08-24                  |
-- #| 5           | 3           | 2019-08-21 | 2019-08-22                  |
-- #| 6           | 2           | 2019-08-11 | 2019-08-13                  |
-- #| 7           | 4           | 2019-08-09 | 2019-08-09                  |
-- #+-------------+-------------+------------+-----------------------------+
-- #
-- #Result table:
-- #+----------------------+
-- #| immediate_percentage |
-- #+----------------------+
-- #| 50.00                |
-- #+----------------------+
-- #The customer id 1 has a first order with delivery id 1 and it is scheduled.
-- #The customer id 2 has a first order with delivery id 2 and it is immediate.
-- #The customer id 3 has a first order with delivery id 5 and it is scheduled.
-- #The customer id 4 has a first order with delivery id 7 and it is immediate.
-- #Hence, half the customers have immediate first orders.
-- #
-- # 👍 51 👎 36
/*
  Runtime: 489 ms, faster than 87.27% of MySQL online submissions for Immediate Food Delivery II.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Immediate Food Delivery II.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT ROUND(SUM(order_date = customer_pref_delivery_date) / COUNT(*) * 100, 2) AS immediate_percentage
FROM delivery
WHERE (customer_id, order_date) IN (SELECT customer_id, MIN(order_date)
                                    FROM delivery
                                    GROUP BY customer_id
                                    ORDER BY order_date);
-- #leetcode submit region end(Prohibit modification and deletion)
