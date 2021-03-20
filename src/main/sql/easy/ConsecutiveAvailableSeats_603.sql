-- #Several friends at a cinema ticket office would like to reserve consecutive ava
-- #ilable seats.
-- #Can you help to query all the consecutive available seats order by the seat_id
-- #using the following cinema table?
--                             #
-- #| seat_id | free |
-- #|---------|------|
-- #| 1       | 1    |
-- #| 2       | 0    |
-- #| 3       | 1    |
-- #| 4       | 1    |
-- #| 5       | 1    |
-- #
-- #
-- #
-- #Your query should return the following result for the sample case above.
-- #
-- #
-- #
-- #
-- #| seat_id |
-- #|---------|
-- #| 3       |
-- #| 4       |
-- #| 5       |
-- #
-- #Note:
-- #
-- #
-- # The seat_id is an auto increment int, and free is bool ('1' means free, and '0
-- #' means occupied.).
-- # Consecutive available seats are more than 2(inclusive) seats consecutively ava
-- #ilable.
-- #
-- # 👍 303 👎 21
/*
  Runtime: 278 ms, faster than 91.82% of MySQL online submissions for Consecutive Available Seats.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Consecutive Available Seats.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT DISTINCT a.seat_id
FROM cinema a
         INNER JOIN cinema b ON a.seat_id = b.seat_id - 1 OR a.seat_id = b.seat_id + 1
WHERE a.free = 1
  AND b.free = 1;
-- #leetcode submit region end(Prohibit modification and deletion)
