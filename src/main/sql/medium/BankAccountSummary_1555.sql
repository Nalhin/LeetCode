-- #Table: Users
--  #
-- #
-- #+--------------+---------+
-- #| Column Name  | Type    |
-- #+--------------+---------+
-- #| user_id      | int     |
-- #| user_name    | varchar |
-- #| credit       | int     |
-- #+--------------+---------+
-- #user_id is the primary key for this table.
-- #Each row of this table contains the current credit information for each user.
-- #
-- #
-- #
-- #
-- # Table: Transactions
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| trans_id      | int     |
-- #| paid_by       | int     |
-- #| paid_to       | int     |
-- #| amount        | int     |
-- #| transacted_on | date    |
-- #+---------------+---------+
-- #trans_id is the primary key for this table.
-- #Each row of this table contains the information about the transaction in the ba
-- #nk.
-- #User with id (paid_by) transfer money to user with id (paid_to).
-- #
-- #
-- #
-- #
-- # Leetcode Bank (LCB) helps its coders in making virtual payments. Our bank reco
-- #rds all transactions in the table Transaction, we want to find out the current b
-- #alance of all users and check wheter they have breached their credit limit (If t
-- #heir current credit is less than 0).
-- #
-- # Write an SQL query to report.
-- #
-- #
-- # user_id
-- # user_name
-- # credit, current balance after performing transactions.
-- # credit_limit_breached, check credit_limit ("Yes" or "No")
-- #
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example.
-- #
-- #
-- #
-- #
-- #Users table:
-- #+------------+--------------+-------------+
-- #| user_id    | user_name    | credit      |
-- #+------------+--------------+-------------+
-- #| 1          | Moustafa     | 100         |
-- #| 2          | Jonathan     | 200         |
-- #| 3          | Winston      | 10000       |
-- #| 4          | Luis         | 800         |
-- #+------------+--------------+-------------+
-- #
-- #Transactions table:
-- #+------------+------------+------------+----------+---------------+
-- #| trans_id   | paid_by    | paid_to    | amount   | transacted_on |
-- #+------------+------------+------------+----------+---------------+
-- #| 1          | 1          | 3          | 400      | 2020-08-01    |
-- #| 2          | 3          | 2          | 500      | 2020-08-02    |
-- #| 3          | 2          | 1          | 200      | 2020-08-03    |
-- #+------------+------------+------------+----------+---------------+
-- #
-- #Result table:
-- #+------------+------------+------------+-----------------------+
-- #| user_id    | user_name  | credit     | credit_limit_breached |
-- #+------------+------------+------------+-----------------------+
-- #| 1          | Moustafa   | -100       | Yes                   |
-- #| 2          | Jonathan   | 500        | No                    |
-- #| 3          | Winston    | 9900       | No                    |
-- #| 4          | Luis       | 800        | No                    |
-- #+------------+------------+------------+-----------------------+
-- #Moustafa paid $400 on "2020-08-01" and received $200 on "2020-08-03", credit (1
-- #00 -400 +200) = -$100
-- #Jonathan received $500 on "2020-08-02" and paid $200 on "2020-08-08", credit (2
-- #00 +500 -200) = $500
-- #Winston received $400 on "2020-08-01" and paid $500 on "2020-08-03", credit (10
-- #000 +400 -500) = $9990
-- #Luis didn't received any transfer, credit = $800
-- # 👍 57 👎 13
/*
  Runtime: 459 ms, faster than 97.02% of MySQL online submissions for Bank Account Summary.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Bank Account Summary.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

WITH payment_cte AS (
    SELECT paid_by AS user_id, -amount AS amount
    FROM transactions

    UNION ALL

    SELECT paid_to AS user_id, amount
    FROM transactions
)

SELECT user_id,
       user_name,
       credit + COALESCE(SUM(payment_cte.amount), 0)                      AS credit,
       IF(credit + COALESCE(SUM(payment_cte.amount), 0) < 0, 'Yes', 'No') AS credit_limit_breached
FROM users
         LEFT JOIN payment_cte USING (user_id)
GROUP BY user_id;

-- #leetcode submit region end(Prohibit modification and deletion)
