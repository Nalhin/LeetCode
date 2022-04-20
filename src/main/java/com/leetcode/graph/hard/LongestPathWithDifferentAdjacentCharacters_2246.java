package com.leetcode.graph.hard;

// You are given a tree (i.e. a connected, undirected graph that has no cycles)
// rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is
// represented by a 0-indexed array parent of size n, where parent[i] is the parent of
// node i. Since node 0 is the root, parent[0] == -1.
//
// You are also given a string s of length n, where s[i] is the character
// assigned to node i.
//
// Return the length of the longest path in the tree such that no pair of
// adjacent nodes on the path have the same character assigned to them.
//
//
// Example 1:
//
//
// Input: parent = [-1,0,0,1,1,2], s = "abacbe"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different
// characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3
// is returned.
// It can be proven that there is no longer path that satisfies the conditions.
//
//
// Example 2:
//
//
// Input: parent = [-1,0,0,0], s = "aabc"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different
// characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is
// returned.
//
//
//
// Constraints:
//
//
// n == parent.length == s.length
// 1 <= n <= 10⁵
// 0 <= parent[i] <= n - 1 for all i >= 1
// parent[0] == -1
// parent represents a valid tree.
// s consists of only lowercase English letters.
//
// 👍 207 👎 4
/*
 O(n) Runtime: 330 ms, faster than 9.92% of Java online submissions for Longest Path With Different Adjacent Characters.
 O(n) Memory Usage: 278.4 MB, less than 5.11% of Java online submissions for Longest Path With Different Adjacent Characters.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class LongestPathWithDifferentAdjacentCharacters_2246 {

  private int result = 0;

  public int longestPath(int[] parent, String s) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 1; i < parent.length; i++) {
      graph.computeIfAbsent(parent[i], (ign) -> new ArrayList<>()).add(i);
    }

    return Math.max(getMaxPath(0, s, graph), result);
  }

  private int getMaxPath(int curr, String str, Map<Integer, List<Integer>> graph) {
    Queue<Integer> maxScores = new PriorityQueue<>();

    for (int child : graph.getOrDefault(curr, Collections.emptyList())) {

      if (str.charAt(child) == str.charAt(curr)) {
        result = Math.max(getMaxPath(child, str, graph), result);
      } else {
        int score = getMaxPath(child, str, graph);

        maxScores.add(score);

        if (maxScores.size() > 2) {
          maxScores.poll();
        }
      }
    }

    if (maxScores.size() == 2) {
      result = Math.max(maxScores.poll() + maxScores.peek() + 1, result);
      return maxScores.peek() + 1;
    } else if (maxScores.size() == 1) {
      return maxScores.peek() + 1;
    } else {
      return 1;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
