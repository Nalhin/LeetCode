package com.leetcode.arrays.easy;

// You have some apples, where arr[i] is the weight of the i-th apple. You also h
// ave a basket that can carry up to 5000 units of weight.
//
// Return the maximum number of apples you can put in the basket.
//
//
// Example 1:
//
//
// Input: arr = [100,200,150,1000]
// Output: 4
// Explanation: All 4 apples can be carried by the basket since their sum of weig
// hts is 1450.
//
//
// Example 2:
//
//
// Input: arr = [900,950,800,1000,700,800]
// Output: 5
// Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any
// 5 of them.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 10^3
// 1 <= arr[i] <= 10^3
//
// Related Topics Greedy
// 👍 76 👎 11

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
  O(nlog(n)) Runtime: 1 ms, faster than 97.70% of Java online submissions for How Many Apples Can You Put into the Basket.
  O(1) Memory Usage: 38.9 MB, less than 14.37% of Java online submissions for How Many Apples Can You Put into the Basket.
*/
public class HowManyApplesCanYouPutIntoTheBasket_1196 {
  private final int MAX_CAPACITY = 5000;

  public int maxNumberOfApples(int[] arr) {
    Arrays.sort(arr);
    int result = 0;
    int sum = 0;

    for (int item : arr) {
      if (sum + item > MAX_CAPACITY) {
        return result;
      }
      sum += item;
      result++;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
