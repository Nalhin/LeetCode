package com.leetcode.hashtable.easy;

import java.util.HashMap;

public class LoggerRateLimiter_359 {
  public static class Logger {
    private HashMap<String, Integer> map = new HashMap<>();
    private final int GRACE_PERIOD = 10;
    /** Initialize your data structure here. */
    public Logger() {}

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns
     * false. If this method returns false, the message will not be printed. The timestamp is in
     * seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
      if (map.containsKey(message) && timestamp - map.get(message) < GRACE_PERIOD) {
        return false;
      }
      map.put(message, timestamp);
      return true;
    }
  }
}
/*
 O(1) Runtime: 26 ms, faster than 99.81% of Java online submissions for Logger Rate Limiter.
 O(n) Memory Usage: 46.9 MB, less than 99.85% of Java online submissions for Logger Rate Limiter.
*/
