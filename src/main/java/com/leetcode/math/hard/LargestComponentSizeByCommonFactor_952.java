package com.leetcode.math.hard;

// You are given an integer array of unique positive integers nums. Consider the
// following graph:
//
//
// There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
// There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[
// j] share a common factor greater than 1.
//
//
// Return the size of the largest connected component in the graph.
//
//
// Example 1:
//
//
// Input: nums = [4,6,15,35]
// Output: 4
//
//
// Example 2:
//
//
// Input: nums = [20,50,9,63]
// Output: 2
//
//
// Example 3:
//
//
// Input: nums = [2,3,6,7,4,12,21,39]
// Output: 8
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10⁴
// 1 <= nums[i] <= 10⁵
// All the values of nums are unique.
//
// Related Topics Array Math Union Find 👍 1145 👎 83
/*
  O(n * sqrt(m) * a(m)) Runtime: 287 ms, faster than 62.43% of Java online submissions for Largest Component Size by Common Factor.
  O(m + n) Memory Usage: 42.5 MB, less than 97.37% of Java online submissions for Largest Component Size by Common Factor.
  where:
  m - max(nums[i])
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor_952 {

  public int largestComponentSize(int[] nums) {

    Dsu dsu = new Dsu(Arrays.stream(nums).max().getAsInt() + 1);
    for (int num : nums) {
      for (int factor = 2; factor <= (int) (Math.sqrt(num)); ++factor)
        if (num % factor == 0) {
          dsu.union(num, factor);
          dsu.union(num, num / factor);
        }
    }

    int maxGroupSize = 0;
    Map<Integer, Integer> groupCount = new HashMap<>();
    for (int num : nums) {
      int groupId = dsu.root(num);
      maxGroupSize = Math.max(groupCount.merge(groupId, 1, Integer::sum), maxGroupSize);
    }

    return maxGroupSize;
  }

  private static class Dsu {
    private final int[] root;
    private final int[] rank;

    private Dsu(int n) {
      this.root = new int[n];
      this.rank = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    private int root(int a) {
      if (root[a] == a) {
        return a;
      }
      return root[a] = root(root[a]);
    }

    private void union(int a, int b) {
      int rootA = root(a);
      int rootB = root(b);

      if (rootA == rootB) {
        return;
      }

      if (rank[rootA] == rank[rootB]) {
        root[rootB] = rootA;
        rank[rootA]++;
      } else if (rank[rootA] > rank[rootB]) {
        root[rootB] = rootA;
      } else {
        root[rootA] = rootB;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
