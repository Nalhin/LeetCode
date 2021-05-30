package com.leetcode.sort.hard;

// Given an integer array nums, return the maximum difference between two success
// ive elements in its sorted form. If the array contains less than two elements, r
// eturn 0.
//
// You must write an algorithm that runs in linear time and uses linear extra sp
// ace.
//
//
// Example 1:
//
//
// Input: nums = [3,6,9,1]
// Output: 3
// Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9)
// has the maximum difference 3.
//
//
// Example 2:
//
//
// Input: nums = [10]
// Output: 0
// Explanation: The array contains less than 2 elements, therefore return 0.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 109
//
// Related Topics Sort
// 👍 1264 👎 226
/*
 O(n) Runtime: 4 ms, faster than 21.76% of Java online submissions for Maximum Gap.
 O(n) Memory Usage: 39.3 MB, less than 33.97% of Java online submissions for Maximum Gap.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class MaximumGap_164 {
  public int maximumGap(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }

    int max = Arrays.stream(nums).max().getAsInt();
    int min = Arrays.stream(nums).min().getAsInt();

    int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
    int numOfBuckets = ((max - min) / bucketSize) + 1;

    int[] bucketsMax = new int[numOfBuckets];
    int[] bucketsMin = new int[numOfBuckets];
    Arrays.fill(bucketsMin, Integer.MAX_VALUE);

    for (int num : nums) {
      int bucket = (num - min) / bucketSize;
      bucketsMax[bucket] = Math.max(num, bucketsMax[bucket]);
      bucketsMin[bucket] = Math.min(num, bucketsMin[bucket]);
    }

    int result = 0;
    int prev = min;
    for (int i = 0; i < numOfBuckets - 1; i++) {
      if (bucketsMin[i] != Integer.MAX_VALUE) {
        result = Math.max(bucketsMin[i] - prev, result);
        prev = bucketsMax[i];
      }
    }
    return Math.max(result, max - prev);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
