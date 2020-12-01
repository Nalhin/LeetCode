package com.leetcode.arrays.medium;

// We have a list of points on the plane. Find the K closest points to the origin
// (0, 0).
//
// (Here, the distance between two points on a plane is the Euclidean distance.)
//
//
// You may return the answer in any order. The answer is guaranteed to be unique
// (except for the order that it is in.)
//
//
//
//
// Example 1:
//
//
// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation:
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [
// [-2,2]].
//
//
//
// Example 2:
//
//
// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
//
//
//
//
// Note:
//
//
// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000
//
//
// Related Topics Divide and Conquer Heap Sort
// 👍 2414 👎 128

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 O(nlog(k)) Runtime: 28 ms, faster than 39.64% of Java online submissions for K Closest Points to Origin.
 O(n) Memory Usage: 47.4 MB, less than 70.01% of Java online submissions for K Closest Points to Origin.
*/
public class KClosestPointsToOrigin_973 {
  public int[][] kClosest(int[][] points, int k) {
    int[] origin = new int[] {0, 0};
    Queue<Item> pq = new PriorityQueue<>(Comparator.comparingDouble(Item::getDistance).reversed());

    for (int[] point : points) {
      pq.add(new Item(point, getDist(point, origin)));

      if (pq.size() > k) {
        pq.remove();
      }
    }

    int[][] result = new int[k][2];

    int size = pq.size();
    for (int i = 0; i < size; i++) {
      result[i] = pq.remove().getPoint();
    }

    return result;
  }

  private double getDist(int[] point1, int[] point2) {
    return Math.sqrt(Math.pow(point1[0] + point2[0], 2) + Math.pow(point1[1] + point2[1], 2));
  }

  private static class Item {

    private final int[] point;
    private final double distance;

    public Item(int[] point, double distance) {
      this.point = point;
      this.distance = distance;
    }

    public double getDistance() {
      return distance;
    }

    public int[] getPoint() {
      return point;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
