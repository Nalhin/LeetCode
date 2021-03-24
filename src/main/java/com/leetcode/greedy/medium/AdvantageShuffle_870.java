package com.leetcode.greedy.medium;

// Given two arrays A and B of equal size, the advantage of A with respect to B i
// s the number of indices i for which A[i] > B[i].
//
// Return any permutation of A that maximizes its advantage with respect to B.
//
//
//
//
// Example 1:
//
//
// Input: A = [2,7,11,15], B = [1,10,4,11]
// Output: [2,11,7,15]
//
//
//
// Example 2:
//
//
// Input: A = [12,24,8,32], B = [13,25,32,11]
// Output: [24,32,8,12]
//
//
//
//
// Note:
//
//
// 1 <= A.length = B.length <= 10000
// 0 <= A[i] <= 10^9
// 0 <= B[i] <= 10^9
//
//
//
// Related Topics Array Greedy
// 👍 775 👎 48
/*
 O(nlog(n)) Runtime: 75 ms, faster than 29.03% of Java online submissions for Advantage Shuffle.
 O(n) Memory Usage: 41.4 MB, less than 79.72% of Java online submissions for Advantage Shuffle.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.TreeMap;

public class AdvantageShuffle_870 {
  public int[] advantageCount(int[] A, int[] B) {
    TreeMap<Integer, Integer> set = new TreeMap<>();

    for (int num : A) {
      set.put(num, set.getOrDefault(num, 0) + 1);
    }

    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      Integer higher = set.ceilingKey(B[i] + 1);

      Integer key = higher == null ? set.firstKey() : higher;
      result[i] = key;
      Integer value = set.get(key);
      if (value == 1) {
        set.remove(key);
      } else {
        set.replace(key, value - 1);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
