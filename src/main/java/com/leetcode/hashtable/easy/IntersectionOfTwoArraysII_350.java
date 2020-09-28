package com.leetcode.hashtable.easy;

// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
//
//
// Note:
//
//
// Each element in the result should appear as many times as it shows in both ar
// rays.
// The result can be in any order.
//
//
// Follow up:
//
//
// What if the given array is already sorted? How would you optimize your algori
// thm?
// What if nums1's size is small compared to nums2's size? Which algorithm is be
// tter?
// What if elements of nums2 are stored on disk, and the memory is limited such
// that you cannot load all elements into the memory at once?
//
// Related Topics Hash Table Two Pointers Binary Search Sort
// 👍 1623 👎 439

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysII_350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Long> map =
        Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    List<Integer> result = new ArrayList<>();

    for (int j : nums2) {
      Long val = map.getOrDefault(j, 0L);

      if (val > 0) {
        map.put(j, map.get(j) - 1);
        result.add(j);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
/*
 O(n + m) Runtime: 10 ms, faster than 7.03% of Java online submissions for Intersection of Two Arrays II.
 O(n) Memory Usage: 39.2 MB, less than 97.97% of Java online submissions for Intersection of Two Arrays II.



*/
// leetcode submit region end(Prohibit modification and deletion)
