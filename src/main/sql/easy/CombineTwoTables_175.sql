-- #Table: Person
-- #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| PersonId    | int     |
-- #| FirstName   | varchar |
-- #| LastName    | varchar |
-- #+-------------+---------+
-- #PersonId is the primary key column for this table.
-- #
-- #
-- # Table: Address
-- #
-- #
-- #+-------------+---------+
-- #| Column Name | Type    |
-- #+-------------+---------+
-- #| AddressId   | int     |
-- #| PersonId    | int     |
-- #| City        | varchar |
-- #| State       | varchar |
-- #+-------------+---------+
-- #AddressId is the primary key column for this table.
-- #
-- #
-- #
-- #
-- # Write a SQL query for a report that provides the following information for eac
-- #h person in the Person table, regardless if there is an address for each of thos
-- #e people:
-- #
-- #
-- #FirstName, LastName, City, State
-- #
-- # 👍 1025 👎 147
--
--
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below

-- Runtime: 331 ms, faster than 37.71% of MySQL online submissions for Combine Two Tables.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Combine Two Tables.


SELECT FirstName, LastName, City, State
FROM Person
         LEFT JOIN Address
                   ON Address.PersonId = Person.PersonId;

-- #leetcode submit region end(Prohibit modification and deletion)
