package com.leetcode.arrays.medium;

import java.util.Arrays;
import java.util.Comparator;
/*
  O(nlog(n)) Runtime: 5 ms, faster than 56.59% of Java online submissions for The Earliest Moment When Everyone Become Friends.
  O(n) Memory Usage: 39.1 MB, less than 85.95% of Java online submissions for The Earliest Moment When Everyone Become Friends.
*/
public class TheEarliestMomentWhenEveryoneBecomeFriends_1101 {
  public int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
    DisjointSet dsu = new DisjointSet(n);

    for (int[] log : logs) {
      dsu.union(log[1], log[2]);

      if (dsu.components == 1) {
        return log[0];
      }
    }

    return -1;
  }

  private static class DisjointSet {
    private final int[] root;
    private final int[] rank;
    private int components;

    private DisjointSet(int n) {
      this.root = new int[n];
      this.rank = new int[n];
      this.components = n;

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
      components--;
    }
  }
}
