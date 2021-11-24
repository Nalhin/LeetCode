package com.leetcode.sort.medium;

// You are given two lists of closed intervals, firstList and secondList, where
// firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of
// intervals is pairwise disjoint and in sorted order.
//
// Return the intersection of these two interval lists.
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x
// with a <= x <= b.
//
// The intersection of two closed intervals is a set of real numbers that are
// either empty or represented as a closed interval. For example, the intersection
// of [1, 3] and [2, 4] is [2, 3].
//
//
// Example 1:
//
//
// Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],
// [15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
//
// Example 2:
//
//
// Input: firstList = [[1,3],[5,9]], secondList = []
// Output: []
//
//
// Example 3:
//
//
// Input: firstList = [], secondList = [[4,8],[10,12]]
// Output: []
//
//
// Example 4:
//
//
// Input: firstList = [[1,7]], secondList = [[3,10]]
// Output: [[3,7]]
//
//
//
// Constraints:
//
//
// 0 <= firstList.length, secondList.length <= 1000
// firstList.length + secondList.length >= 1
// 0 <= starti < endi <= 10⁹
// endi < starti+1
// 0 <= startj < endj <= 10⁹
// endj < startj+1
//
// Related Topics Array Two Pointers 👍 3495 👎 76
/*
 O(n) Runtime: 6 ms, faster than 20.91% of Java online submissions for Interval List Intersections.
 O(n) Memory Usage: 52.4 MB, less than 9.48% of Java online submissions for Interval List Intersections.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> result = new ArrayList<>();

    int currFirst = 0;
    int currSecond = 0;

    while (currFirst < firstList.length && currSecond < secondList.length) {

      if (firstList[currFirst][1] < secondList[currSecond][0]) {
        currFirst++;
      } else if (secondList[currSecond][1] < firstList[currFirst][0]) {
        currSecond++;
      } else {
        int maxStart = Math.max(firstList[currFirst][0], secondList[currSecond][0]);
        int minEnd = Math.min(firstList[currFirst][1], secondList[currSecond][1]);

        if (minEnd - maxStart >= 0) {
          result.add(new int[] {maxStart, minEnd});
        }

        if (firstList[currFirst][1] < secondList[currSecond][1]) {
          currFirst++;
        } else {
          currSecond++;
        }
      }
    }

    return result.toArray(int[][]::new);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
