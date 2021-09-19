package com.leetcode.arrays.hard;

// We are given a list of (axis-aligned) rectangles. Each rectangle[i] = [xi1,
// yi1, xi2, yi2] , where (xi1, yi1) are the coordinates of the bottom-left corner,
// and (xi2, yi2) are the coordinates of the top-right corner of the iᵗʰ rectangle.
//
//
// Find the total area covered by all rectangles in the plane. Since the answer
// may be too large, return it modulo 10⁹ + 7.
//
//
// Example 1:
//
//
// Input: rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
// Output: 6
// Explanation: As illustrated in the picture.
//
//
// Example 2:
//
//
// Input: rectangles = [[0,0,1000000000,1000000000]]
// Output: 49
// Explanation: The answer is 10¹⁸ modulo (10⁹ + 7), which is (10⁹)² = (-7)² = 49
// .
//
//
//
// Constraints:
//
//
// 1 <= rectangles.length <= 200
// rectanges[i].length = 4
// 0 <= rectangles[i][j] <= 10⁹
// The total area covered by all rectangles will never exceed 2⁶³ - 1 and thus
// will fit in a 64-bit signed integer.
//
// Related Topics Array Segment Tree Line Sweep Ordered Set 👍 690 👎 43
/*
 O(n^2log(n)) Runtime: 8 ms, faster than 55.49% of Java online submissions for Rectangle Area II.
 O(n) Memory Usage: 38.4 MB, less than 87.69% of Java online submissions for Rectangle Area II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class RectangleAreaII_850 {
  private static final int MOD = 1_000_000_007;

  public int rectangleArea(int[][] rectangles) {
    List<Event> events = new ArrayList<>();

    for (int[] rectangle : rectangles) {
      events.add(new Event(rectangle[1], Event.Type.OPEN, rectangle[0], rectangle[2]));
      events.add(new Event(rectangle[3], Event.Type.CLOSE, rectangle[0], rectangle[2]));
    }

    events.sort(Comparator.comparingInt(a -> a.y));

    long result = 0;

    List<int[]> active = new ArrayList<>();
    int currY = events.get(0).y;

    for (Event event : events) {

      long query = 0;
      int curr = -1;
      for (int[] acc : active) {
        curr = Math.max(curr, acc[0]);
        query += Math.max(acc[1] - curr, 0);
        curr = Math.max(curr, acc[1]);
      }

      result += query * (event.y - currY);

      if (event.type == Event.Type.OPEN) {
        active.add(new int[] {event.x1, event.x2});
        active.sort(Comparator.comparingInt(a -> a[0]));
      } else {
        for (int i = 0; i < active.size(); ++i)
          if (active.get(i)[0] == event.x1 && active.get(i)[1] == event.x2) {
            active.remove(i);
            break;
          }
      }

      currY = event.y;
    }

    return (int) (result % MOD);
  }

  private static class Event {
    final int y;
    final Type type;
    final int x1;
    final int x2;

    private Event(int y, Type type, int x1, int x2) {
      this.y = y;
      this.type = type;
      this.x1 = x1;
      this.x2 = x2;
    }

    enum Type {
      OPEN,
      CLOSE
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
