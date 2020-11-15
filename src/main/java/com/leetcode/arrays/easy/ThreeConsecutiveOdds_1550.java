package com.leetcode.arrays.easy;

// Given an integer array arr, return true if there are three consecutive odd num
// bers in the array. Otherwise, return false.
//
// Example 1:
//
//
// Input: arr = [2,6,4,1]
// Output: false
// Explanation: There are no three consecutive odds.
//
//
// Example 2:
//
//
// Input: arr = [1,2,34,3,4,5,7,23,12]
// Output: true
// Explanation: [5,7,23] are three consecutive odds.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
//
// Related Topics Array
// 👍 136 👎 21

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Three Consecutive Odds.
 O(1) Memory Usage: 38.8 MB, less than 39.11% of Java online submissions for Three Consecutive Odds.
*/
public class ThreeConsecutiveOdds_1550 {
  public boolean threeConsecutiveOdds(int[] arr) {
    int odds = 0;
    for (int num : arr) {
      if (num % 2 == 1) {
        odds++;
        if (odds == 3) {
          return true;
        }
      } else {
        odds = 0;
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
