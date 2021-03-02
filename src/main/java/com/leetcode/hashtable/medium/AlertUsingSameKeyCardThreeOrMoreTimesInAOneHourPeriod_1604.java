package com.leetcode.hashtable.medium;

// LeetCode company workers use key-cards to unlock office doors. Each time a wor
// ker uses their key-card, the security system saves the worker's name and the tim
// e when it was used. The system emits an alert if any worker uses the key-card th
// ree or more times in a one-hour period.
//
// You are given a list of strings keyName and keyTime where [keyName[i], keyTim
// e[i]] corresponds to a person's name and the time when their key-card was used i
// n a single day.
//
// Access times are given in the 24-hour time format "HH:MM", such as "23:51" an
// d "09:49".
//
// Return a list of unique worker names who received an alert for frequent keyca
// rd use. Sort the names in ascending order alphabetically.
//
// Notice that "10:00" - "11:00" is considered to be within a one-hour period, w
// hile "22:51" - "23:52" is not considered to be within a one-hour period.
//
//
// Example 1:
//
//
// Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], key
// Time = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
// Output: ["daniel"]
// Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","
// 10:40", "11:00").
//
//
// Example 2:
//
//
// Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime =
// ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
// Output: ["bob"]
// Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:
// 20", "21:30").
//
//
// Example 3:
//
//
// Input: keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
// Output: []
//
//
// Example 4:
//
//
// Input: keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"],
// keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
// Output: ["clare","leslie"]
//
//
//
// Constraints:
//
//
// 1 <= keyName.length, keyTime.length <= 105
// keyName.length == keyTime.length
// keyTime[i] is in the format "HH:MM".
// [keyName[i], keyTime[i]] is unique.
// 1 <= keyName[i].length <= 10
// keyName[i] contains only lowercase English letters.
//
// Related Topics String Ordered Map
// 👍 79 👎 143

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;
/*
 O(mlog(m)) Runtime: 87 ms, faster than 51.93% of Java online submissions for Alert Using Same Key-Card Three or More Times in a One Hour Period.
 O(mlog(m)) Memory Usage: 62 MB, less than 47.21% of Java online submissions for Alert Using Same Key-Card Three or More Times in a One Hour Period.
 where:
 m - average num of elements in a group
*/
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod_1604 {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Set<String> result = new HashSet<>();

    HashMap<String, List<Integer>> times = new HashMap<>();

    for (int i = 0; i < keyName.length; i++) {
      List<Integer> items = times.computeIfAbsent(keyName[i], (a) -> new ArrayList<>());
      items.add(parseToTime(keyTime[i]));
      times.put(keyName[i], items);
    }

    for (Map.Entry<String, List<Integer>> entry : times.entrySet()) {
      List<Integer> list = entry.getValue();
      Collections.sort(list);

      Deque<Integer> deque = new ArrayDeque<>();

      for (int num : list) {
        if (!deque.isEmpty() && deque.peekFirst() + 60 < num) {
          deque.removeFirst();
        }

        deque.add(num);

        if (deque.size() >= 3) {
          result.add(entry.getKey());
          break;
        }
      }
    }

    return result.stream().sorted().collect(Collectors.toList());
  }

  private int parseToTime(String date) {
    String[] split = date.split(":");
    int hours = Integer.parseInt(split[0]);
    int minutes = Integer.parseInt(split[1]);
    return hours * 60 + minutes;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
