-- #Table Accounts:
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| name          | varchar |
-- #+---------------+---------+
-- #the id is the primary key for this table.
-- #This table contains the account id and the user name of each account.
-- #
-- #
-- #
-- #
-- # Table Logins:
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| id            | int     |
-- #| login_date    | date    |
-- #+---------------+---------+
-- #There is no primary key for this table, it may contain duplicates.
-- #This table contains the account id of the user who logged in and the login date
-- #. A user may log in multiple times in the day.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find the id and the name of active users.
-- #
-- # Active users are those who logged in to their accounts for 5 or more consecuti
-- #ve days.
-- #
-- # Return the result table ordered by the id.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Accounts table:
--           #+----+----------+
-- #| id | name     |
-- #+----+----------+
-- #| 1  | Winston  |
-- #| 7  | Jonathan |
-- #+----+----------+
-- #
-- #Logins table:
--         #+----+------------+
-- #| id | login_date |
-- #+----+------------+
-- #| 7  | 2020-05-30 |
-- #| 1  | 2020-05-30 |
-- #| 7  | 2020-05-31 |
-- #| 7  | 2020-06-01 |
-- #| 7  | 2020-06-02 |
-- #| 7  | 2020-06-02 |
-- #| 7  | 2020-06-03 |
-- #| 1  | 2020-06-07 |
-- #| 7  | 2020-06-10 |
-- #+----+------------+
-- #
-- #Result table:
--         #+----+----------+
-- #| id | name     |
-- #+----+----------+
-- #| 7  | Jonathan |
-- #+----+----------+
-- #User Winston with id = 1 logged in 2 times only in 2 different days, so, Winsto
-- #n is not an active user.
-- #User Jonathan with id = 7 logged in 7 times in 6 different days, five of them w
-- #ere consecutive days, so, Jonathan is an active user.
-- #
-- #
-- # Follow up question:
-- #Can you write a general solution if the active users are those who logged in to
-- # their accounts for n or more consecutive days?
-- # 👍 162 👎 17
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 1632 ms, faster than 16.86% of MySQL online submissions for Active Users.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Active Users.
-- WINDOW FUNCTION
WITH lead_dates_cte AS (SELECT id,
                               login_date,
                               LEAD(login_date, 4) OVER (PARTITION BY id ORDER BY login_date) AS lead_date
                        FROM (SELECT DISTINCT id, login_date FROM logins) distinct_logins)

SELECT DISTINCT id, name
FROM lead_dates_cte
         INNER JOIN accounts USING (id)
WHERE DATEDIFF(lead_date, login_date) = 4
ORDER BY id;


-- Runtime: 1170 ms, faster than 57.83% of MySQL online submissions for Active Users.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Active Users.
-- SELF JOIN
SELECT DISTINCT accounts.id, accounts.name
FROM accounts
         INNER JOIN logins curr_login USING (id)
         INNER JOIN logins prev_logins ON curr_login.id = prev_logins.id AND
                                          DATEDIFF(prev_logins.login_date, curr_login.login_date) BETWEEN 1 AND 4
GROUP BY id, curr_login.login_date
HAVING COUNT(DISTINCT prev_logins.login_date) >= 4
-- #leetcode submit region end(Prohibit modification and deletion)
