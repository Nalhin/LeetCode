-- #Table: SchoolA
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| student_id    | int     |
-- #| student_name  | varchar |
-- #+---------------+---------+
-- #student_id is the primary key for this table.
-- #Each row of this table contains the name and the id of a student in school A.
-- #All student_name are distinct.
-- #
-- #
-- #
-- #
-- # Table: SchoolB
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| student_id    | int     |
-- #| student_name  | varchar |
-- #+---------------+---------+
-- #student_id is the primary key for this table.
-- #Each row of this table contains the name and the id of a student in school B.
-- #All student_name are distinct.
-- #
-- #
-- #
-- #
-- # Table: SchoolC
--   #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| student_id    | int     |
-- #| student_name  | varchar |
-- #+---------------+---------+
-- #student_id is the primary key for this table.
-- #Each row of this table contains the name and the id of a student in school C.
-- #All student_name are distinct.
-- #
-- #
-- #
-- #
-- # There is a country with three schools, where each student is enrolled in exact
-- #ly one school. The country is joining a competition and wants to select one stud
-- #ent from each school to represent the country such that:
-- #
-- #
-- # member_A is selected from SchoolA,
-- # member_B is selected from SchoolB,
-- # member_C is selected from SchoolC, and
-- # The selected students' names and IDs are pairwise distinct (i.e. no two studen
-- #ts share the same name, and no two students share the same ID).
-- #
-- #
-- # Write an SQL query to find all the possible triplets representing the country
-- #under the given constraints.
-- #
-- # Return the result table in any order.
-- #
-- # The query result format is in the following example.
-- #
-- #
-- #
-- #
-- #SchoolA table:
-- #+------------+--------------+
-- #| student_id | student_name |
-- #+------------+--------------+
-- #| 1          | Alice        |
-- #| 2          | Bob          |
-- #+------------+--------------+
-- #
-- #SchoolB table:
-- #+------------+--------------+
-- #| student_id | student_name |
-- #+------------+--------------+
-- #| 3          | Tom          |
-- #+------------+--------------+
-- #
-- #SchoolC table:
-- #+------------+--------------+
-- #| student_id | student_name |
-- #+------------+--------------+
-- #| 3          | Tom          |
-- #| 2          | Jerry        |
-- #| 10         | Alice        |
-- #+------------+--------------+
-- #
-- #Result table:
-- #+----------+----------+----------+
-- #| member_A | member_B | member_C |
-- #+----------+----------+----------+
-- #| Alice    | Tom      | Jerry    |
-- #| Bob      | Tom      | Alice    |
-- #+----------+----------+----------+
-- #Let us see all the possible triplets.
-- #- (Alice, Tom, Tom) --> Rejected because member_B and member_C have the same na
-- #me and the same ID.
-- #- (Alice, Tom, Jerry) --> Valid triplet.
-- #- (Alice, Tom, Alice) --> Rejected because member_A and member_C have the same
-- #name.
-- #- (Bob, Tom, Tom) --> Rejected because member_B and member_C have the same name
-- # and the same ID.
-- #- (Bob, Tom, Jerry) --> Rejected because member_A and member_C have the same ID
-- #.
-- #- (Bob, Tom, Alice) --> Valid triplet.
-- #
-- # 👍 26 👎 36
/*
 Runtime: 2457 ms, faster than 12.45% of MySQL online submissions for All Valid Triplets That Can Represent a Country.
 Memory Usage: 0B, less than 100.00% of MySQL online submissions for All Valid Triplets That Can Represent a Country.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT SchoolA.student_name AS member_A,
       SchoolB.student_name AS member_B,
       SchoolC.student_name AS member_C
FROM SchoolA,
     SchoolB,
     SchoolC
WHERE (SchoolA.student_name != SchoolB.student_name AND SchoolA.student_id != SchoolB.student_id)
  AND (SchoolB.student_name != SchoolC.student_name AND SchoolB.student_id != SchoolC.student_id)
  AND (SchoolC.student_name != SchoolA.student_name AND SchoolC.student_id != SchoolA.student_id)
-- #leetcode submit region end(Prohibit modification and deletion)
