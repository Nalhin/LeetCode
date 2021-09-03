package com.leetcode.math.hard;

// You are given an array trees where trees[i] = [xi, yi] represents the
// location of a tree in the garden.
//
// You are asked to fence the entire garden using the minimum length of rope as
// it is expensive. The garden is well fenced only if all the trees are enclosed.
//
// Return the coordinates of trees that are exactly located on the fence
// perimeter.
//
//
// Example 1:
//
//
// Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
// Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
//
//
// Example 2:
//
//
// Input: points = [[1,2],[2,2],[4,2]]
// Output: [[4,2],[2,2],[1,2]]
//
//
//
// Constraints:
//
//
// 1 <= points.length <= 3000
// points[i].length == 2
// 0 <= xi, yi <= 100
// All the given points are unique.
//
// Related Topics Array Math Geometry 👍 368 👎 248
/*
 O(nlog(n)) Runtime: 14 ms, faster than 44.23% of Java online submissions for Erect the Fence.
 O(n) Memory Usage: 52 MB, less than 15.38% of Java online submissions for Erect the Fence.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

// leetcode submit region end(Prohibit modification and deletion)
public class ErectTheFence_587 {


  public int[][] outerTrees(int[][] points) {
    Arrays.sort(points, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);

    List<int[]> hull = new ArrayList<>();
    for (int[] point : points) {
      while (hull.size() >= 2
          && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) > 0) {
        hull.remove(hull.size() - 1);
      }
      hull.add(point);
    }
    hull.remove(hull.size() - 1);

    for (int i = points.length - 1; i >= 0; i--) {
      while (hull.size() >= 2
          && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
        hull.remove(hull.size() - 1);
      }
      hull.add(points[i]);
    }

    HashSet<int[]> result = new HashSet<>(hull);
    return result.toArray(new int[result.size()][]);
  }

  private int orientation(int[] p, int[] q, int[] r) {
    return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
  }
}
