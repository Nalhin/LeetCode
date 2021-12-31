package com.leetcode.design.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignALeaderboard_1244 {
  /*
    add - log(n), remove - log(n) top - log(k)  Runtime: 24 ms, faster than 38.19% of Java online submissions for Design A Leaderboard.
    O(n) Memory Usage: 41.4 MB, less than 14.41% of Java online submissions for Design A Leaderboard.
  */
  static class Leaderboard {
    private final Map<Integer, Integer> scores = new HashMap<>();
    private final TreeMap<Integer, Integer> sortedScores =
        new TreeMap<>(Collections.reverseOrder());

    public void addScore(int playerId, int score) {
      if (scores.containsKey(playerId)) {
        int prevScore = scores.get(playerId);
        int playerCount = sortedScores.get(prevScore);

        if (playerCount == 1) {
          sortedScores.remove(prevScore);
        } else {
          sortedScores.put(prevScore, playerCount - 1);
        }

        int newScore = prevScore + score;
        scores.put(playerId, newScore);
        sortedScores.merge(newScore, 1, Integer::sum);
      } else {
        scores.put(playerId, score);
        sortedScores.merge(score, 1, Integer::sum);
      }
    }

    public int top(int k) {
      int count = 0;
      int sum = 0;

      for (Map.Entry<Integer, Integer> entry : sortedScores.entrySet()) {

        int times = entry.getValue();
        int value = entry.getKey();

        int multiplyBy = Math.min(k - count, times);
        sum += value * multiplyBy;
        count += multiplyBy;
        if (count == k) {
          return sum;
        }
      }

      return sum;
    }

    public void reset(int playerId) {
      int preScore = scores.get(playerId);

      if (sortedScores.merge(preScore, -1, Integer::sum) == 0) {
        sortedScores.remove(preScore);
      }

      scores.remove(playerId);
    }
  }
}
