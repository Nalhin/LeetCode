package com.leetcode.greedy.hard;

// There are n children standing in a line. Each child is assigned a rating value
// given in the integer array ratings.
//
// You are giving candies to these children subjected to the following requireme
// nts:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// Return the minimum number of candies you need to have to distribute the candi
// es to the children.
//
//
// Example 1:
//
//
// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1,
// 2 candies respectively.
//
//
// Example 2:
//
//
// Input: ratings = [1,2,2]
// Output: 4
// Explanation: You can allocate to the first, second and third child with 1, 2,
// 1 candies respectively.
// The third child gets 1 candy because it satisfies the above two conditions.
//
//
//
// Constraints:
//
//
// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104
//
// Related Topics Array Greedy
// 👍 1763 👎 205
/*
 O(n) Runtime: 2 ms, faster than 93.85% of Java online submissions for Candy.
 O(n) Memory Usage: 40.8 MB, less than 25.57% of Java online submissions for Candy.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class Candy_135 {
  public int candy(int[] ratings) {
    int[] candiesLeft = new int[ratings.length];
    int[] candiesRight = new int[ratings.length];

    candiesLeft[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i - 1] < ratings[i]) {
        candiesLeft[i] = candiesLeft[i - 1] + 1;
      } else {
        candiesLeft[i] = 1;
      }
    }

    candiesRight[ratings.length - 1] = 1;
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i + 1] < ratings[i]) {
        candiesRight[i] = candiesRight[i + 1] + 1;
      } else {
        candiesRight[i] = 1;
      }
    }

    int result = 0;
    for (int i = 0; i < ratings.length; i++) {
      result += Math.max(candiesLeft[i], candiesRight[i]);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
