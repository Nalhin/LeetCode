package com.leetcode.binarysearch.medium;

// Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has
// piles[i] bananas. The guards have gone and will come back in h hours.
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she
// chooses some pile of bananas and eats k bananas from that pile. If the pile has less
// than k bananas, she eats all of them instead and will not eat any more bananas
// during this hour.
//
// Koko likes to eat slowly but still wants to finish eating all the bananas
// before the guards return.
//
// Return the minimum integer k such that she can eat all the bananas within h
// hours.
//
//
// Example 1:
//
//
// Input: piles = [3,6,7,11], h = 8
// Output: 4
//
//
// Example 2:
//
//
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
//
//
// Example 3:
//
//
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
//
//
//
// Constraints:
//
//
// 1 <= piles.length <= 10⁴
// piles.length <= h <= 10⁹
// 1 <= piles[i] <= 10⁹
//
// Related Topics Array Binary Search 👍 3160 👎 149
/*
 O(n*log(m)) Runtime: 45 ms, faster than 16.43% of Java online submissions for Koko Eating Bananas.
 O(1) Memory Usage: 52.5 MB, less than 5.33% of Java online submissions for Koko Eating Bananas.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class KokoEatingBananas_875 {
  public int minEatingSpeed(int[] piles, int h) {
    int left = 0;
    int right = Arrays.stream(piles).max().orElse(0);

    int result = right;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (canEat(piles, h, mid)) {
        right = mid - 1;
        result = mid;
      } else {
        left = mid + 1;
      }
    }

    return result;
  }

  private boolean canEat(int[] piles, int h, int k) {

    for (int pile : piles) {
      h -= Math.ceil((double) pile / k);
      if (h < 0) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
