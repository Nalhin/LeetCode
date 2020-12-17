package com.leetcode.math.medium;

// An integer has sequential digits if and only if each digit in the number is on
// e more than the previous digit.
//
// Return a sorted list of all the integers in the range [low, high] inclusive t
// hat have sequential digits.
//
//
// Example 1:
// Input: low = 100, high = 300
// Output: [123,234]
// Example 2:
// Input: low = 1000, high = 13000
// Output: [1234,2345,3456,4567,5678,6789,12345]
//
//
// Constraints:
//
//
// 10 <= low <= high <= 10^9
//
// Related Topics Backtracking
// 👍 469 👎 47

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Sequential Digits.
 O(n) Memory Usage: 36.3 MB, less than 87.54% of Java online submissions for Sequential Digits.
*/
public class SequentialDigits_1291 {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> result = new ArrayList<>();

    int size = String.valueOf(low).length() - 1;
    int curr = init(size);
    int maxInWindow = 9 - size;
    int increase = calculateIncrease(size);
    int maxNum = Math.min(high, 123456789);
    while (curr <= maxNum) {
      if (maxInWindow == 0) {
        curr = init(++size);
        maxInWindow = 9 - size;
        increase = increase * 10 + 1;
      }
      if (curr >= low && curr <= maxNum) {
        result.add(curr);
      }
      curr += increase;
      maxInWindow--;
    }
    return result;
  }

  private int init(int zeroCount) {
    int i = 1;
    int num = 0;
    while (zeroCount-- >= 0) {
      num = num * 10 + i++;
    }
    return num;
  }

  private int calculateIncrease(int zeroCount) {
    int num = 0;
    while (zeroCount-- >= 0) {
      num = num * 10 + 1;
    }
    return num;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
