-- #Table: Players
--  #
-- #
-- #+----------------+---------+
-- #| Column Name    | Type    |
-- #+----------------+---------+
-- #| player_id      | int     |
-- #| player_name    | varchar |
-- #+----------------+---------+
-- #player_id is the primary key for this table.
-- #Each row in this table contains the name and the ID of a tennis player.
-- #
-- #
-- #
-- #
-- # Table: Championships
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| year          | int     |
-- #| Wimbledon     | int     |
-- #| Fr_open       | int     |
-- #| US_open       | int     |
-- #| Au_open       | int     |
-- #+---------------+---------+
-- #year is the primary key for this table.
-- #Each row of this table containts the IDs of the players who won one each tennis
-- # tournament of the grand slam.
-- #
-- #
-- #
-- #
-- # Write an SQL query to report the number of grand slam tournaments won by each
-- #player. Do not include the players who did not win any tournament.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Players table:
--          #+-----------+-------------+
-- #| player_id | player_name |
-- #+-----------+-------------+
-- #| 1         | Nadal       |
-- #| 2         | Federer     |
-- #| 3         | Novak       |
-- #+-----------+-------------+
-- #
-- #Championships table:
--                #+------+-----------+---------+---------+---------+
-- #| year | Wimbledon | Fr_open | US_open | Au_open |
-- #+------+-----------+---------+---------+---------+
-- #| 2018 | 1         | 1       | 1       | 1       |
-- #| 2019 | 1         | 1       | 2       | 2       |
-- #| 2020 | 2         | 1       | 2       | 2       |
-- #+------+-----------+---------+---------+---------+
-- #
-- #Result table:
--         #+-----------+-------------+-------------------+
-- #| player_id | player_name | grand_slams_count |
-- #+-----------+-------------+-------------------+
-- #| 2         | Federer     | 5                 |
-- #| 1         | Nadal       | 7                 |
-- #+-----------+-------------+-------------------+
-- #
-- #Player 1 (Nadal) won 7 titles: Wimbledon (2018, 2019), Fr_open (2018, 2019, 202
-- #0), US_open (2018), and Au_open (2018).
-- #Player 2 (Federer) won 5 titles: Wimbledon (2020), US_open (2019, 2020), and Au
-- #_open (2019, 2020).
-- #Player 3 (Novak) did not win anything, we did not include them in the result ta
-- #ble.
-- # 👍 25 👎 0
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 1166 ms, faster than 46.85% of MySQL online submissions for Grand Slam Titles.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Grand Slam Titles.
-- CTE WITH UNION
WITH winners_cte AS (
    SELECT wimbledon AS winner_id
    FROM championships
    UNION ALL
    SELECT fr_open AS winner_id
    FROM championships
    UNION ALL
    SELECT us_open AS winner_id
    FROM championships
    UNION ALL
    SELECT au_open AS winner_id
    FROM championships
)
SELECT player_id, player_name, COUNT(winner_id) AS grand_slams_count
FROM players
         INNER JOIN winners_cte ON winner_id = player_id
GROUP BY player_id;



-- Runtime: 989 ms, faster than 91.04% of MySQL online submissions for Grand Slam Titles.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Grand Slam Titles.
-- SUM + JOIN
SELECT player_id,
       player_name,
       SUM(player_id = wimbledon) + SUM(player_id = fr_open) + SUM(player_id = us_open) +
       SUM(player_id = au_open) AS grand_slams_count
FROM players
         INNER JOIN championships
                    ON player_id = wimbledon OR player_id = Fr_open OR player_id = US_open OR player_id = Au_open
GROUP BY player_id;
-- #leetcode submit region end(Prohibit modification and deletion)
