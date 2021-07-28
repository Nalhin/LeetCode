package com.leetcode.arrays.medium;

// For some fixed n, an array nums is beautiful if it is a permutation of the int
// egers 1, 2, ..., n, such that:
//
// For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i]
// + nums[j].
//
// Given n, return any beautiful array nums. (It is guaranteed that one exists.)
//
//
//
//
// Example 1:
//
//
// Input: n = 4
// Output: [2,1,4,3]
//
//
//
// Example 2:
//
//
// Input: n = 5
// Output: [3,1,2,5,4]
//
//
//
//
// Note:
//
//
// 1 <= n <= 1000
//
//
//
//
//
// Related Topics Array Math Divide and Conquer
// 👍 616 👎 835
/*
 O(nlogn(n)) Runtime: 7 ms, faster than 6.67% of Java online submissions for Beautiful Array.
 O(n) Memory Usage: 39.9 MB, less than 5.33% of Java online submissions for Beautiful Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray_932 {
  public int[] beautifulArray(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(1);

    while (result.size() < n) {
      List<Integer> temp = new ArrayList<>();
      for (int i : result) {
        if (i * 2 - 1 <= n) {
          temp.add(i * 2 - 1);
        }
      }
      for (int i : result) {
        if (i * 2 <= n) {
          temp.add(i * 2);
        }
      }

      result = temp;
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
