package com.leetcode.dp.medium;
/*
 O(m*2^m) Runtime: 10 ms, faster than 64.61% of Java online submissions for Campus Bikes II.
 O(2^m) Memory Usage: 41.5 MB, less than 22.59% of Java online submissions for Campus Bikes II.
*/
import java.util.HashMap;
import java.util.Map;

public class CampusBikesII_1066 {
  public int assignBikes(int[][] workers, int[][] bikes) {
    return memo(0, 0, workers, bikes, new HashMap<>());
  }

  private int memo(
      int currWorker, int bikesTaken, int[][] workers, int[][] bikes, Map<Integer, Integer> memo) {
    if (currWorker >= workers.length) {
      return 0;
    }
    if (memo.containsKey(bikesTaken)) {
      return memo.get(bikesTaken);
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < bikes.length; i++) {
      int bit = 1 << i;
      if ((bikesTaken & bit) == 0) {
        result =
            Math.min(
                result,
                memo(currWorker + 1, bikesTaken | bit, workers, bikes, memo)
                    + distance(workers[currWorker], bikes[i]));
      }
    }

    memo.put(bikesTaken, result);

    return result;
  }

  private int distance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}
