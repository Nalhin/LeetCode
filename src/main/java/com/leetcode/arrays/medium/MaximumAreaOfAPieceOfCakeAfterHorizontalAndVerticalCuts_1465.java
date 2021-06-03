package com.leetcode.arrays.medium;

// Given a rectangular cake with height h and width w, and two arrays of integers
// horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from th
// e top of the rectangular cake to the ith horizontal cut and similarly, verticalC
// uts[j] is the distance from the left of the rectangular cake to the jth vertical
// cut.
//
// Return the maximum area of a piece of cake after you cut at each horizontal a
// nd vertical position provided in the arrays horizontalCuts and verticalCuts. Sin
// ce the answer can be a huge number, return this modulo 10^9 + 7.
//
//
// Example 1:
//
//
//
//
// Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
// Output: 4
// Explanation: The figure above represents the given rectangular cake. Red lines
// are the horizontal and vertical cuts. After you cut the cake, the green piece o
// f cake has the maximum area.
//
//
// Example 2:
//
//
//
//
// Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
// Output: 6
// Explanation: The figure above represents the given rectangular cake. Red lines
// are the horizontal and vertical cuts. After you cut the cake, the green and yel
// low pieces of cake have the maximum area.
//
//
// Example 3:
//
//
// Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
// Output: 9
//
//
//
// Constraints:
//
//
// 2 <= h, w <= 10^9
// 1 <= horizontalCuts.length < min(h, 10^5)
// 1 <= verticalCuts.length < min(w, 10^5)
// 1 <= horizontalCuts[i] < h
// 1 <= verticalCuts[i] < w
// It is guaranteed that all elements in horizontalCuts are distinct.
// It is guaranteed that all elements in verticalCuts are distinct.
//
// Related Topics Array
// 👍 583 👎 160
/*

 O(nlog(n) + mlog(m)) Runtime: 17 ms, faster than 14.84% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
 O(sort(n) + sort(m)) Memory Usage: 49.4 MB, less than 19.69% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465 {
  private static final int MOD = 1_000_000_007;

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    int maxVertical = maxInLine(w, verticalCuts);
    int maxHorizontal = maxInLine(h, horizontalCuts);

    return (maxHorizontal % MOD) * (maxVertical % MOD) % MOD;
  }

  private int maxInLine(int endValue, int[] cuts) {
    int prev = 0;
    int max = 0;
    for (int cur : cuts) {
      max = Math.max(cur - prev, max);
      prev = cur;
    }
    return Math.max(endValue - prev, max);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
