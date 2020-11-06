package com.leetcode.binarysearch.easy;

// We are playing the Guess Game. The game is as follows:
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I will tell you whether the number I picked is hi
// gher or lower than your guess.
//
// You call a pre-defined API int guess(int num), which returns 3 possible resul
// ts:
//
//
// -1: The number I picked is lower than your guess (i.e. pick < num).
// 1: The number I picked is higher than your guess (i.e. pick > num).
// 0: The number I picked is equal to your guess (i.e. pick == num).
//
//
// Return the number that I picked.
//
//
// Example 1:
// Input: n = 10, pick = 6
// Output: 6
// Example 2:
// Input: n = 1, pick = 1
// Output: 1
// Example 3:
// Input: n = 2, pick = 1
// Output: 1
// Example 4:
// Input: n = 2, pick = 2
// Output: 2
//
//
// Constraints:
//
//
// 1 <= n <= 231 - 1
// 1 <= pick <= n
//
// Related Topics Binary Search
// 👍 480 👎 1899

// leetcode submit region begin(Prohibit modification and deletion)
/*
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is lower than the guess number 1 if num is higher than the guess number
 *     otherwise return 0 int guess(int num);
 */
/*
 O(log(n))  Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
 O(1)  Memory Usage: 35.5 MB, less than 5.95% of Java online submissions for Guess Number Higher or Lower.
*/
public class GuessNumberHigherOrLower_374 {
  public int guessNumber(int n) {
    int left = 1;
    int right = n;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int val = guess(mid);
      if (val == 0) {
        return mid;
      }
      if (val < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  private int guess(int num) {
    return 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
