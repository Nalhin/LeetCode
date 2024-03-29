-- #Table: Boxes
--  #
-- #
-- #+--------------+------+
-- #| Column Name  | Type |
-- #+--------------+------+
-- #| box_id       | int  |
-- #| chest_id     | int  |
-- #| apple_count  | int  |
-- #| orange_count | int  |
-- #+--------------+------+
-- #box_id is the primary key for this table.
-- #chest_id is a foreign key of the chests table.
-- #This table contains information about the boxes and the number of oranges and a
-- #pples they contain. Each box may contain a chest, which also can contain oranges
-- # and apples.
-- #
-- #
-- #
-- #
-- # Table: Chests
--   #
-- #
-- #+--------------+------+
-- #| Column Name  | Type |
-- #+--------------+------+
-- #| chest_id     | int  |
-- #| apple_count  | int  |
-- #| orange_count | int  |
-- #+--------------+------+
-- #chest_id is the primary key for this table.
-- #This table contains information about the chests we have, and the corresponding
-- # number if oranges and apples they contain.
-- #
-- #
-- #
-- #
-- # Write an SQL query to count the number of apples and oranges in all the boxes.
-- # If a box contains a chest, you should also include the number of apples and ora
-- #nges it has.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Boxes table:
--        #+--------+----------+-------------+--------------+
-- #| box_id | chest_id | apple_count | orange_count |
-- #+--------+----------+-------------+--------------+
-- #| 2      | null     | 6           | 15           |
-- #| 18     | 14       | 4           | 15           |
-- #| 19     | 3        | 8           | 4            |
-- #| 12     | 2        | 19          | 20           |
-- #| 20     | 6        | 12          | 9            |
-- #| 8      | 6        | 9           | 9            |
-- #| 3      | 14       | 16          | 7            |
-- #+--------+----------+-------------+--------------+
-- #
-- #Chests table:
--         #+----------+-------------+--------------+
-- #| chest_id | apple_count | orange_count |
-- #+----------+-------------+--------------+
-- #| 6        | 5           | 6            |
-- #| 14       | 20          | 10           |
-- #| 2        | 8           | 8            |
-- #| 3        | 19          | 4            |
-- #| 16       | 19          | 19           |
-- #+----------+-------------+--------------+
-- #
-- #Result table:
--         #+-------------+--------------+
-- #| apple_count | orange_count |
-- #+-------------+--------------+
-- #| 151         | 123          |
-- #+-------------+--------------+
-- #box 2 has 6 apples and 15 oranges.
-- #box 18 has 4 + 20 (from the chest) = 24 apples and 15 + 10 (from the chest) = 2
-- #5 oranges.
-- #box 19 has 8 + 19 (from the chest) = 27 apples and 4 + 4 (from the chest) = 8 o
-- #ranges.
-- #box 12 has 19 + 8 (from the chest) = 27 apples and 20 + 8 (from the chest) = 28
-- # oranges.
-- #box 20 has 12 + 5 (from the chest) = 17 apples and 9 + 6 (from the chest) = 15
-- #oranges.
-- #box 8 has 9 + 5 (from the chest) = 14 apples and 9 + 6 (from the chest) = 15 or
-- #anges.
-- #box 3 has 16 + 20 (from the chest) = 36 apples and 7 + 10 (from the chest) = 17
-- # oranges.
-- #Total number of apples = 6 + 24 + 27 + 27 + 17 + 14 + 36 = 151
-- #Total number of oranges = 15 + 25 + 8 + 28 + 15 + 15 + 17 = 123
-- #
-- # 👍 28 👎 3
/*
  Runtime: 712 ms, faster than 84.49% of MySQL online submissions for Count Apples and Oranges.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Count Apples and Oranges.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT SUM(boxes.apple_count + COALESCE(chests.apple_count, 0))   AS apple_count,
       SUM(boxes.orange_count + COALESCE(chests.orange_count, 0)) AS orange_count
FROM boxes
         LEFT JOIN chests USING (chest_id);
-- #leetcode submit region end(Prohibit modification and deletion)
