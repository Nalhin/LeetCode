package com.leetcode.hashtable.easy;

// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
//
//
// Note:
//
//
// Each element in the result must be unique.
// The result can be in any order.
//
//
//
// Related Topics Hash Table Two Pointers Binary Search Sort
// 👍 980 👎 1303

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays_349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

    return set1.stream().filter(set2::contains).mapToInt(Integer::intValue).toArray();
  }
}

/*
 O(n + m) Runtime: 7 ms, faster than 13.06% of Java online submissions for Intersection of Two Arrays.
 O(n + m) Memory Usage: 39.2 MB, less than 99.07% of Java online submissions for Intersection of Two Arrays.
*/

// leetcode submit region end(Prohibit modification and deletion)
