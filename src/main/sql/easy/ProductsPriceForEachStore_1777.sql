-- #Table: Products
--  #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| product_id  | int     |
-- #| store       | enum    |
-- #| price       | int     |
-- #+-------------+---------+
-- #(product_id,store) is the primary key for this table.
-- #store is an ENUM of type ('store1', 'store2', 'store3') where each represents t
-- #he store this product is available at.
-- #price is the price of the product at this store.
-- #
-- #
-- #
-- # Write an SQL query to find the price of each product in each store.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #
-- #
-- #Products table:
--           #+-------------+--------+-------+
-- #| product_id  | store  | price |
-- #+-------------+--------+-------+
-- #| 0           | store1 | 95    |
-- #| 0           | store3 | 105   |
-- #| 0           | store2 | 100   |
-- #| 1           | store1 | 70    |
-- #| 1           | store3 | 80    |
-- #+-------------+--------+-------+
-- #Result table:
--         #+-------------+--------+--------+--------+
-- #| product_id  | store1 | store2 | store3 |
-- #+-------------+--------+--------+--------+
-- #| 0           | 95     | 100    | 105    |
-- #| 1           | 70     | null   | 80     |
-- #+-------------+--------+--------+--------+
-- #Product 0 price's are 95 for store1, 100 for store2 and, 105 for store3.
-- #Product 1 price's are 70 for store1, 80 for store3 and, it's not sold in store2
-- #.
-- # 👍 16 👎 3

/*
    Runtime: 463 ms, faster than 100.00% of MySQL online submissions for Product's Price for Each Store.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Product's Price for Each Store.
*/

-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

SELECT product_id,
       MAX(IF(store = 'store1', price, null)) as store1,
       MAX(IF(store = 'store2', price, null)) as store2,
       MAX(IF(store = 'store3', price, null)) as store3
FROM products
GROUP BY product_id;

-- #leetcode submit region end(Prohibit modification and deletion)
