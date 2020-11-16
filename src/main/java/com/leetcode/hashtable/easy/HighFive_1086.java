package com.leetcode.hashtable.easy;
// Given a list of the scores of different students, items, where items[i] = [IDi
// , scorei] represents one score from a student with IDi, calculate each student's
// top five average.
//
// Return the answer as an array of pairs result, where result[j] = [IDj, topFiv
// eAveragej] represents the student with IDj and their top five average. Sort resu
// lt by IDj in increasing order.
//
// A student's top five average is calculated by taking the sum of their top fiv
// e scores and dividing it by 5 using integer division.
//
//
// Example 1:
//
//
// Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100
// ],[2,100],[2,76]]
// Output: [[1,87],[2,88]]
// Explanation:
// The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five
// average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
// The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five ave
// rage is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their av
// erage converts to 88.
//
//
// Example 2:
//
//
// Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100
// ],[1,100],[7,100]]
// Output: [[1,100],[7,100]]
//
//
//
// Constraints:
//
//
// 1 <= items.length <= 1000
// items[i].length == 2
// 1 <= IDi <= 1000
// 0 <= scorei <= 100
// For each IDi, there will be at least five scores.
//
// Related Topics Array Hash Table Sort
// 👍 312 👎 63

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(nlog(k)) Runtime: 5 ms, faster than 60.82% of Java online submissions for High Five.
 O(nlog(k)) Memory Usage: 39.3 MB, less than 68.29% of Java online submissions for High Five.
*/
public class HighFive_1086 {
  public int[][] highFive(int[][] items) {
    Map<Integer, Queue<Integer>> map = new HashMap<>();

    for (int[] item : items) {
      if (!map.containsKey(item[0])) {
        map.put(item[0], new PriorityQueue<>());
      }
      Queue<Integer> pq = map.get(item[0]);

      if (pq.size() >= 5) {
        if (pq.peek() < item[1]) {
          pq.poll();
          pq.add(item[1]);
        }
      } else {
        pq.add(item[1]);
      }
    }
    int[][] result = new int[map.size()][2];

    int i = 0;

    for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
      int sum = 0;
      while (!entry.getValue().isEmpty()) {
        sum += entry.getValue().poll();
      }
      result[i][0] = entry.getKey();
      result[i][1] = sum / 5;
      i++;
    }

    Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
