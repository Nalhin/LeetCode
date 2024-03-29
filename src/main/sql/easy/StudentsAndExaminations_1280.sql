-- #Table: Students
--  #
-- #
-- #+---------------+---------+
-- #| Column Name   | Type    |
-- #+---------------+---------+
-- #| student_id    | int     |
-- #| student_name  | varchar |
-- #+---------------+---------+
-- #student_id is the primary key for this table.
-- #Each row of this table contains the ID and the name of one student in the schoo
-- #l.
-- #
-- #
-- #
-- #
-- # Table: Subjects
--   #
-- #
-- #+--------------+---------+
-- #| Column Name  | Type    |
-- #+--------------+---------+
-- #| subject_name | varchar |
-- #+--------------+---------+
-- #subject_name is the primary key for this table.
-- #Each row of this table contains the name of one subject in the school.
-- #
-- #
-- #
-- #
-- # Table: Examinations
--   #
-- #
-- #+--------------+---------+
-- #| Column Name  | Type    |
-- #+--------------+---------+
-- #| student_id   | int     |
-- #| subject_name | varchar |
-- #+--------------+---------+
-- #There is no primary key for this table. It may contain duplicates.
-- #Each student from the Students table takes every course from Subjects table.
-- #Each row of this table indicates that a student with ID student_id attended the
-- # exam of subject_name.
-- #
-- #
-- #
-- #
-- # Write an SQL query to find the number of times each student attended each exam
-- #.
-- #
-- # Order the result table by student_id and subject_name.
-- #
-- # The query result format is in the following example:
-- #
-- #
-- #Students table:
--           #+------------+--------------+
-- #| student_id | student_name |
-- #+------------+--------------+
-- #| 1          | Alice        |
-- #| 2          | Bob          |
-- #| 13         | John         |
-- #| 6          | Alex         |
-- #+------------+--------------+
-- #Subjects table:
--           #+--------------+
-- #| subject_name |
-- #+--------------+
-- #| Math         |
-- #| Physics      |
-- #| Programming  |
-- #+--------------+
-- #Examinations table:
--               #+------------+--------------+
-- #| student_id | subject_name |
-- #+------------+--------------+
-- #| 1          | Math         |
-- #| 1          | Physics      |
-- #| 1          | Programming  |
-- #| 2          | Programming  |
-- #| 1          | Physics      |
-- #| 1          | Math         |
-- #| 13         | Math         |
-- #| 13         | Programming  |
-- #| 13         | Physics      |
-- #| 2          | Math         |
-- #| 1          | Math         |
-- #+------------+--------------+
-- #Result table:
--         #+------------+--------------+--------------+----------------+
-- #| student_id | student_name | subject_name | attended_exams |
-- #+------------+--------------+--------------+----------------+
-- #| 1          | Alice        | Math         | 3              |
-- #| 1          | Alice        | Physics      | 2              |
-- #| 1          | Alice        | Programming  | 1              |
-- #| 2          | Bob          | Math         | 1              |
-- #| 2          | Bob          | Physics      | 0              |
-- #| 2          | Bob          | Programming  | 1              |
-- #| 6          | Alex         | Math         | 0              |
-- #| 6          | Alex         | Physics      | 0              |
-- #| 6          | Alex         | Programming  | 0              |
-- #| 13         | John         | Math         | 1              |
-- #| 13         | John         | Physics      | 1              |
-- #| 13         | John         | Programming  | 1              |
-- #+------------+--------------+--------------+----------------+
-- #The result table should contain all students and all subjects.
-- #Alice attended Math exam 3 times, Physics exam 2 times and Programming exam 1 t
-- #ime.
-- #Bob attended Math exam 1 time, Programming exam 1 time and didn't attend the Ph
-- #ysics exam.
-- #Alex didn't attend any exam.
-- #John attended Math exam 1 time, Physics exam 1 time and Programming exam 1 time
-- #.
-- #
-- # 👍 153 👎 21
/*
  Runtime: 719 ms, faster than 40.74% of MySQL online submissions for Students and Examinations.
  Memory Usage: 0B, less than 100.00% of MySQL online submissions for Students and Examinations.
*/
-- #leetcode submit region begin(Prohibit modification and deletion)
-- # Write your MySQL query statement below
SELECT students.student_id,
       students.student_name,
       subjects.subject_name,
       COUNT(examinations.student_id) AS attended_exams
FROM students
         INNER JOIN subjects
         LEFT JOIN examinations USING (student_id, subject_name)
GROUP BY student_id, subject_name
ORDER BY student_id, subject_name;

-- #leetcode submit region end(Prohibit modification and deletion)
