package com.leetcode.arrays.medium;

// Given a binary array data, return the minimum number of swaps required to grou
// p all 1’s present in the array together in any place in the array.
//
//
// Example 1:
//
//
// Input: data = [1,0,1,0,1]
// Output: 1
// Explanation:
// There are 3 ways to group all 1's together:
// [1,1,1,0,0] using 1 swap.
// [0,1,1,1,0] using 2 swaps.
// [0,0,1,1,1] using 1 swap.
// The minimum is 1.
//
//
// Example 2:
//
//
// Input: data = [0,0,0,1,0]
// Output: 0
// Explanation:
// Since there is only one 1 in the array, no swaps needed.
//
//
// Example 3:
//
//
// Input: data = [1,0,1,0,1,0,0,1,1,0,1]
// Output: 3
// Explanation:
// One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
//
//
// Example 4:
//
//
// Input: data = [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1
// ,1,0,0,1]
// Output: 8
//
//
//
// Constraints:
//
//
// 1 <= data.length <= 105
// data[i] is 0 or 1.
//
// Related Topics Array Sliding Window
// 👍 406 👎 4
/*
 O(n) Runtime: 6 ms, faster than 64.61% of Java online submissions for Minimum Swaps to Group All 1's Together.
 O(1) Memory Usage: 49 MB, less than 88.75% of Java online submissions for Minimum Swaps to Group All 1's Together.
*/
import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class MinimumSwapsToGroupAllOnesTogether_1151 {
  public int minSwaps(int[] data) {
    int totalOnes = Arrays.stream(data).sum();

    int result = totalOnes;

    int onesInWindow = 0;
    for (int i = 0; i < data.length; i++) {
      int end = i - totalOnes;
      if (end >= 0) {
        onesInWindow -= data[end];
      }
      onesInWindow += data[i];
      result = Math.min(totalOnes - onesInWindow, result);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
