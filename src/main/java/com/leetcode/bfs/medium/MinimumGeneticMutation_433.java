package com.leetcode.bfs.medium;

// A gene string can be represented by an 8-character long string, with choices f
// rom "A", "C", "G", "T".
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
// d"), where ONE mutation is defined as ONE single character changed in the gene s
// tring.
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
//
// Also, there is a given gene "bank", which records all the valid gene mutation
// s. A gene must be in the bank to make it a valid gene string.
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1.
//
// Note:
//
//
// Starting point is assumed to be valid, so it might not be included in the ban
// k.
// If multiple mutations are needed, all mutations during in the sequence must b
// e valid.
// You may assume start and end string is not the same.
//
//
//
//
// Example 1:
//
//
// start: "AACCGGTT"
// end:   "AACCGGTA"
// bank: ["AACCGGTA"]
//
// return: 1
//
//
//
//
// Example 2:
//
//
// start: "AACCGGTT"
// end:   "AAACGGTA"
// bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
// return: 2
//
//
//
//
// Example 3:
//
//
// start: "AAAAACCC"
// end:   "AACCCCCC"
// bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
// return: 3
//
//
//
// 👍 518 👎 70

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
/*
  O(n*n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Genetic Mutation.
  O(n) Memory Usage: 38.4 MB, less than 16.22% of Java online submissions for Minimum Genetic Mutation.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class MinimumGeneticMutation_433 {
  public int minMutation(String start, String end, String[] bank) {

    Set<String> visited = new HashSet<>();
    Deque<String> deque = new ArrayDeque<>();
    deque.add(start);
    visited.add(start);

    int result = 0;

    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        String curr = deque.pop();

        if (curr.equals(end)) {
          return result;
        }

        for (String next : bank) {
          if (!visited.contains(next) && canMutateTo(curr, next)) {
            deque.add(next);
            visited.add(curr);
          }
        }
      }
      result++;
    }

    return -1;
  }

  private boolean canMutateTo(String curr, String target) {
    int diff = 0;

    for (int i = 0; i < curr.length() && diff <= 1; i++) {
      if (curr.charAt(i) != target.charAt(i)) {
        diff++;
      }
    }

    return diff == 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
