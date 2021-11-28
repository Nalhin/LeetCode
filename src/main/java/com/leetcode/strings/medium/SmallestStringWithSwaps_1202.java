package com.leetcode.strings.medium;

// You are given a string s, and an array of pairs of indices in the string
// pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
//
// You can swap the characters at any pair of indices in the given pairs any
// number of times.
//
// Return the lexicographically smallest string that s can be changed to after
// using the swaps.
//
//
// Example 1:
//
//
// Input: s = "dcab", pairs = [[0,3],[1,2]]
// Output: "bacd"
// Explaination:
// Swap s[0] and s[3], s = "bcad"
// Swap s[1] and s[2], s = "bacd"
//
//
// Example 2:
//
//
// Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
// Output: "abcd"
// Explaination:
// Swap s[0] and s[3], s = "bcad"
// Swap s[0] and s[2], s = "acbd"
// Swap s[1] and s[2], s = "abcd"
//
// Example 3:
//
//
// Input: s = "cba", pairs = [[0,1],[1,2]]
// Output: "abc"
// Explaination:
// Swap s[0] and s[1], s = "bca"
// Swap s[1] and s[2], s = "bac"
// Swap s[0] and s[1], s = "abc"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10^5
// 0 <= pairs.length <= 10^5
// 0 <= pairs[i][0], pairs[i][1] < s.length
// s only contains lower case English letters.
//
// Related Topics Hash Table String Depth-First Search Breadth-First Search
// Union Find 👍 1211 👎 42
/*
 O(nlog(n)) Runtime: 64 ms, faster than 46.19% of Java online submissions for Smallest String With Swaps.
 O(n) Memory Usage: 91.1 MB, less than 33.07% of Java online submissions for Smallest String With Swaps.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class SmallestStringWithSwaps_1202 {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    DisjointSet dsu = new DisjointSet(s.length());

    for (List<Integer> pair : pairs) {
      dsu.union(pair.get(0), pair.get(1));
    }

    List<Queue<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      buckets.add(new PriorityQueue<>(Comparator.comparingInt(s::charAt)));
    }
    for (int i = 0; i < s.length(); i++) {
      buckets.get(dsu.root(i)).add(i);
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      result.append(s.charAt(buckets.get(dsu.root(i)).remove()));
    }

    return result.toString();
  }

  private static class DisjointSet {

    private final int[] root;
    private final int[] rank;

    private DisjointSet(int n) {
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
