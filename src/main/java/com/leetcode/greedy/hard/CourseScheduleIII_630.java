package com.leetcode.greedy.hard;

// There are n different online courses numbered from 1 to n. You are given an ar
// ray courses where courses[i] = [durationi, lastDayi] indicate that the ith cours
// e should be taken continuously for durationi days and must be finished before or
// on lastDayi.
//
// You will start on the 1st day and you cannot take two or more courses simulta
// neously.
//
// Return the maximum number of courses that you can take.
//
//
// Example 1:
//
//
// Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
// Output: 3
// Explanation:
// There are totally 4 courses, but you can take 3 courses at most:
// First, take the 1st course, it costs 100 days so you will finish it on the 100
// th day, and ready to take the next course on the 101st day.
// Second, take the 3rd course, it costs 1000 days so you will finish it on the 1
// 100th day, and ready to take the next course on the 1101st day.
// Third, take the 2nd course, it costs 200 days so you will finish it on the 130
// 0th day.
// The 4th course cannot be taken now, since you will finish it on the 3300th day
// , which exceeds the closed date.
//
//
// Example 2:
//
//
// Input: courses = [[1,2]]
// Output: 1
//
//
// Example 3:
//
//
// Input: courses = [[3,2],[4,3]]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= courses.length <= 104
// 1 <= durationi, lastDayi <= 104
//
// Related Topics Greedy
// 👍 1091 👎 44
/*
 O(nlog(n) * nlog(m)) Runtime: 40 ms, faster than 19.86% of Java online submissions for Course Schedule III.
 O(m) Memory Usage: 47.3 MB, less than 59.57% of Java online submissions for Course Schedule III.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseScheduleIII_630 {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));

    Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(courseTime -> -courseTime));

    int currentTime = 0;

    for (int[] course : courses) {
      if (currentTime <= course[1] - course[0]) {
        currentTime += course[0];
        pq.add(course[0]);
      } else if (!pq.isEmpty() && course[0] < pq.peek()) {
        currentTime -= pq.poll();
        currentTime += course[0];
        pq.add(course[0]);
      }
    }

    return pq.size();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
