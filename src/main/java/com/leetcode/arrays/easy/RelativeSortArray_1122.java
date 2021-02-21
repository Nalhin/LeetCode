package com.leetcode.arrays.easy;

// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all ele
// ments in arr2 are also in arr1.
//
// Sort the elements of arr1 such that the relative ordering of items in arr1 ar
// e the same as in arr2. Elements that don't appear in arr2 should be placed at th
// e end of arr1 in ascending order.
//
//
// Example 1:
// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//
// Constraints:
//
//
// 1 <= arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// All the elements of arr2 are distinct.
// Each arr2[i] is in arr1.
//
// Related Topics Array Sort
// 👍 970 👎 66

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
   O(nlog(n)) Runtime: 6 ms, faster than 14.39% of Java online submissions for Relative Sort Array.
   O(n) Memory Usage: 39.3 MB, less than 42.02% of Java online submissions for Relative Sort Array.
*/
public class RelativeSortArray_1122 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> sortValues = new HashMap<>();

    for (int i = 0; i < arr2.length; i++) {
      sortValues.put(arr2[i], i);
    }

    return Arrays.stream(arr1)
        .boxed()
        .sorted(
            (a, b) -> {
              if (sortValues.containsKey(a) && !sortValues.containsKey(b)) {
                return -1;
              }
              if (sortValues.containsKey(b) && !sortValues.containsKey(a)) {
                return 1;
              }

              if (sortValues.containsKey(a) && sortValues.containsKey(b)) {
                return sortValues.get(a) - sortValues.get(b);
              }

              return a - b;
            })
        .mapToInt(i -> i)
        .toArray();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
