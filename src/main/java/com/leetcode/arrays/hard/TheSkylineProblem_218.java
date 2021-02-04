package com.leetcode.arrays.hard;

// A city's skyline is the outer contour of the silhouette formed by all the buil
// dings in that city when viewed from a distance. Given the locations and heights
// of all the buildings, return the skyline formed by these buildings collectively.
//
//
// The geometric information of each building is given in the array buildings wh
// ere buildings[i] = [lefti, righti, heighti]:
//
//
// lefti is the x coordinate of the left edge of the ith building.
// righti is the x coordinate of the right edge of the ith building.
// heighti is the height of the ith building.
//
//
// You may assume all buildings are perfect rectangles grounded on an absolutely
// flat surface at height 0.
//
// The skyline should be represented as a list of "key points" sorted by their x
// -coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoi
// nt of some horizontal segment in the skyline except the last point in the list,
// which always has a y-coordinate 0 and is used to mark the skyline's termination
// where the rightmost building ends. Any ground between the leftmost and rightmost
// buildings should be part of the skyline's contour.
//
// Note: There must be no consecutive horizontal lines of equal height in the ou
// tput skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acc
// eptable; the three lines of height 5 should be merged into one in the final outp
// ut as such: [...,[2 3],[4 5],[12 7],...]
//
//
// Example 1:
//
//
// Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
// Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
// Explanation:
// Figure A shows the buildings of the input.
// Figure B shows the skyline formed by those buildings. The red points in figure
// B represent the key points in the output list.
//
//
// Example 2:
//
//
// Input: buildings = [[0,2,3],[2,5,3]]
// Output: [[0,3],[5,0]]
//
//
//
// Constraints:
//
//
// 1 <= buildings.length <= 104
// 0 <= lefti < righti <= 231 - 1
// 1 <= heighti <= 231 - 1
// buildings is sorted by lefti in non-decreasing order.
//
// Related Topics Divide and Conquer Heap Binary Indexed Tree Segment Tree Line
// Sweep
// 👍 2664 👎 151

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(n^2) Runtime: 254 ms, faster than 9.76% of Java online submissions for The Skyline Problem.
 O(n^2) Memory Usage: 41.6 MB, less than 97.11% of Java online submissions for The Skyline Problem.
*/
public class TheSkylineProblem_218 {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList<>();

    List<int[]> boundaries = new ArrayList<>();

    for (int[] building : buildings) {
      boundaries.add(new int[] {building[0], -building[2]});
      boundaries.add(new int[] {building[1], building[2]});
    }

    boundaries.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    pq.add(0);

    int prev = 0;
    for (int[] boundary : boundaries) {
      if (boundary[1] < 0) {
        pq.add(-boundary[1]);
      } else {
        pq.remove(boundary[1]);
      }

      int curr = pq.peek();
      if (curr != prev) {
        result.add(List.of(boundary[0], curr));
        prev = curr;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
