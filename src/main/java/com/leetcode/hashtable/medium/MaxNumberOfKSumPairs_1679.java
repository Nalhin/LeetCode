package com.leetcode.hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/*
 O(n) Runtime: 30 ms, faster than 68.21% of Java online submissions for Max Number of K-Sum Pairs.
 O(n) Memory Usage: 53.4 MB, less than 65.61% of Java online submissions for Max Number of K-Sum Pairs.
*/
public class MaxNumberOfKSumPairs_1679 {
  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int curr : nums) {
      if (map.containsKey(k - curr)) {
        if (map.get(k - curr) == 1) {
          map.remove(k - curr);
        } else {
          map.put(k - curr, map.get(k - curr) - 1);
        }
        result++;
      } else {
        map.put(curr, map.getOrDefault(curr, 0) + 1);
      }
    }
    return result;
  }
}
