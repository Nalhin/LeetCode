-- #Given a
-- table customer
-- holding customers information and the referee.
-- #
-- #
-- #+------+------+-----------+
-- #| id   | name | referee_id|
-- #+------+------+-----------+
-- #|    1 | Will |      NULL |
-- #|    2 | Jane |      NULL |
-- #|    3 | Alex |         2 |
-- #|    4 | Bill |      NULL |
-- #|    5 | Zack |         1 |
-- #|    6 | Mark |         2 |
-- #+------+------+-----------+
-- #
-- #
-- # Write a query to return the list of customers NOT referred by the person
-- with
--     #id '2'.
--     #
--     # For the sample data above, the result is :
--     #
--     #
--     #+------+
--     #| name |
--     #+------+
--     #| Will |
--     #| Jane |
--     #| Bill |
--     #| Zack |
--     #+------+
--     #
--     # 👍 101 👎 62
/*
  Runtime: 456 ms, faster than 46.14% of MySQL online submissions for Find Customer Referee.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Find Customer Referee.
*/
--  #leetcode submit region begin
-- (Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT name
FROM customer
WHERE referee_id != 2
   OR referee_id IS NULL;
-- #leetcode submit region
-- end(Prohibit modification and deletion)
