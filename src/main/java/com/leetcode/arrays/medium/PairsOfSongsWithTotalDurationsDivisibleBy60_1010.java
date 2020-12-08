package com.leetcode.arrays.medium;
/*
  O(n) Runtime: 3 ms, faster than 84.92% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
  O(1) Memory Usage: 44.6 MB, less than 49.29% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
*/
public class PairsOfSongsWithTotalDurationsDivisibleBy60_1010 {
  public int numPairsDivisibleBy60(int[] time) {
    int[] count = new int[60];
    int result = 0;

    for (int t : time) {
      result += count[(60 - (t % 60)) % 60];
      count[t % 60]++;
    }

    return result;
  }
}
