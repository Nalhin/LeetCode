package com.leetcode.binarysearch.medium;

import java.util.Arrays;
/*
 O(nlog(max(nums))) Runtime: 8 ms, faster than 74.12% of Java online submissions for Find the Smallest Divisor Given a Threshold.
 O(1) Memory Usage: 41.3 MB, less than 6.71% of Java online submissions for Find the Smallest Divisor Given a Threshold.
*/
public class FindTheSmallestDivisorGivenAThreshold_1283 {
  public int smallestDivisor(int[] nums, int threshold) {
    int left = 1;
    int right = Arrays.stream(nums).max().getAsInt();
    while (left < right) {
      int mid = left + (right - left) / 2;
      int sum = sumDividedBy(nums, mid);

      if (sum > threshold) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  int sumDividedBy(int[] nums, int divider) {
    int sum = 0;
    for (int num : nums) {
      sum += (num - 1) / divider + 1;
    }
    return sum;
  }
}
