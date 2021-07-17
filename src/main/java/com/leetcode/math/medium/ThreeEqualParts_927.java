package com.leetcode.math.medium;

// You are given an array arr which consists of only zeros and ones, divide the a
// rray into three non-empty parts such that all of these parts represent the same
// binary value.
//
// If it is possible, return any [i, j] with i + 1 < j, such that:
//
//
// arr[0], arr[1], ..., arr[i] is the first part,
// arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
// arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
// All three parts have equal binary values.
//
//
// If it is not possible, return [-1, -1].
//
// Note that the entire part is used when considering what binary value it repre
// sents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros
// are allowed, so [0,1,1] and [1,1] represent the same value.
//
//
// Example 1:
// Input: arr = [1,0,1,0,1]
// Output: [0,3]
// Example 2:
// Input: arr = [1,1,0,1,1]
// Output: [-1,-1]
// Example 3:
// Input: arr = [1,1,0,0,1]
// Output: [0,2]
//
//
// Constraints:
//
//
// 3 <= arr.length <= 3 * 104
// arr[i] is 0 or 1
//
// Related Topics Array Math
// 👍 494 👎 83
/*
 O(n) Runtime: 5 ms, faster than 22.55% of Java online submissions for Three Equal Parts.
 O(1) Memory Usage: 45.2 MB, less than 44.12% of Java online submissions for Three Equal Parts.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class ThreeEqualParts_927 {
  private static final int[] NO_RESULT = {-1, -1};

  public int[] threeEqualParts(int[] arr) {
    int numOfOnes = Arrays.stream(arr).sum();

    if (numOfOnes == 0) {
      return new int[] {0, 2};
    }
    if (numOfOnes % 3 != 0) {
      return NO_RESULT;
    }

    int idxThird = findStartingIdxOfEnd(arr, numOfOnes);

    int endFirst = findEndIdx(arr, 0, idxThird);
    if (endFirst < 0) {
      return NO_RESULT;
    }

    int endMid = findEndIdx(arr, endFirst + 1, idxThird);
    if (endMid < 0) {
      return NO_RESULT;
    }

    return new int[] {endFirst, endMid + 1};
  }

  private int findStartingIdxOfEnd(int[] arr, int numOfOnes) {
    int temp = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == 1) {
        temp++;
      }
      if (temp == numOfOnes / 3) {
        return i;
      }
    }
    return -1;
  }

  private int findEndIdx(int[] arr, int left, int right) {
    while (arr[left] == 0) {
      left++;
    }
    while (right < arr.length) {
      if (arr[left] != arr[right]) {
        return -1;
      }
      left++;
      right++;
    }
    return left - 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
