package com.leetcode.arrays.medium;

// In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[
// i].
//
// Rearrange the barcodes so that no two adjacent barcodes are equal. You may re
// turn any answer, and it is guaranteed an answer exists.
//
//
// Example 1:
// Input: barcodes = [1,1,1,2,2,2]
// Output: [2,1,2,1,2,1]
// Example 2:
// Input: barcodes = [1,1,1,1,2,2,3,3]
// Output: [1,3,1,3,1,2,1,2]
//
//
// Constraints:
//
//
// 1 <= barcodes.length <= 10000
// 1 <= barcodes[i] <= 10000
//
// Related Topics Heap Sort
// 👍 508 👎 23

import java.util.*;
import java.util.stream.Collectors;
/*
 O(n) Runtime: 27 ms, faster than 72.80% of Java online submissions for Distant Barcodes.
 O(n) Memory Usage: 42.5 MB, less than 35.99% of Java online submissions for Distant Barcodes.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class DistantBarcodes_1054 {
  public int[] rearrangeBarcodes(int[] barcodes) {

    Map<Integer, Integer> counter = new HashMap<>();

    for (int val : barcodes) {
      counter.put(val, counter.getOrDefault(val, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> list =
        counter.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .collect(Collectors.toList());

    int[] result = new int[barcodes.length];
    int pos = 0;
    for (Map.Entry<Integer, Integer> entry : list) {
      int occ = entry.getValue();

      while (occ-- > 0) {
        result[pos] = entry.getKey();
        pos += 2;

        if (pos >= barcodes.length) {
          pos = 1;
        }
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
