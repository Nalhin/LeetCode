package com.leetcode.binarysearch.hard;

import java.util.Arrays;

/*
 O(n * log(n / (k + 1)) Runtime: 5 ms, faster than 62.83% of Java online submissions for Divide Chocolate.
 O(1) Memory Usage: 39.5 MB, less than 34.91% of Java online submissions for Divide Chocolate.
*/
public class DivideChocolate_1231 {
  public int maximizeSweetness(int[] sweetness, int k) {
    if (k == 0) {
      return Arrays.stream(sweetness).sum();
    }

    int left = 0;
    int right = Arrays.stream(sweetness).sum() / (k + 1);

    int result = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (canSplitIntoFragmentsWithAtLeast(sweetness, mid, k + 1)) {
        left = mid + 1;
        result = mid;
      } else {
        right = mid - 1;
      }
    }

    return result;
  }

  private boolean canSplitIntoFragmentsWithAtLeast(int[] sweetness, int target, int fragments) {
    int curr = 0;
    int total = 0;
    for (int score : sweetness) {
      curr += score;
      if (curr >= target) {
        total++;
        curr = 0;
      }
    }

    return total >= fragments;
  }
}
