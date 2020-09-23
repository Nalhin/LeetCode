package com.leetcode.arrays.easy;
// Suppose you have a long flowerbed in which some of the plots are planted and s
// ome are not. However, flowers cannot be planted in adjacent plots - they would c
// ompete for water and both would die.
//
// Given a flowerbed (represented as an array containing 0 and 1, where 0 means
// empty and 1 means not empty), and a number n, return if n new flowers can be pla
// nted in it without violating the no-adjacent-flowers rule.
//
// Example 1:
//
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: True
//
//
//
// Example 2:
//
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False
//
//
//
// Note:
//
// The input array won't violate no-adjacent-flowers rule.
// The input array size is in the range of [1, 20000].
// n is a non-negative integer which won't exceed the input array size.
//
// Related Topics Array
// 👍 921 👎 377

// leetcode submit region begin(Prohibit modification and deletion)
public class CanPlaceFlowers_605 {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed.length == 1) {
      return flowerbed[0] == 0 || n == 0;
    }

    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      n--;
    }

    if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
      flowerbed[flowerbed.length - 1] = 1;
      n--;
    }

    for (int i = 1; i < flowerbed.length - 1 && n > 0; i++) {
      if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        n--;
      }
    }

    return n <= 0;
  }
}

/*
  O(n) Runtime: 1 ms, faster than 95.74% of Java online submissions for Can Place Flowers.
  O(1) Memory Usage: 50 MB, less than 5.03% of Java online submissions for Can Place Flowers.
*/
// leetcode submit region end(Prohibit modification and deletion)
