package com.leetcode.dp.hard;

// Given an array of strings words, return the smallest string that contains each
// string in words as a substring. If there are multiple valid strings of the smal
// lest length, return any of them.
//
// You may assume that no string in words is a substring of another string in wo
// rds.
//
//
// Example 1:
//
//
// Input: words = ["alex","loves","leetcode"]
// Output: "alexlovesleetcode"
// Explanation: All permutations of "alex","loves","leetcode" would also be accep
// ted.
//
//
// Example 2:
//
//
// Input: words = ["catg","ctaagt","gcta","ttca","atgcatc"]
// Output: "gctaagttcatgcatc"
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 12
// 1 <= words[i].length <= 20
// words[i] consists of lowercase English letters.
// All the strings of words are unique.
//
// Related Topics Dynamic Programming
// 👍 579 👎 82
/*
 O(n^2 * 2^n) Runtime: 53 ms, faster than 18.26% of Java online submissions for Find the Shortest Superstring.
 O(n^2) Memory Usage: 52.1 MB, less than 5.19% of Java online submissions for Find the Shortest Superstring.
*/
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// leetcode submit region begin(Prohibit modification and deletion)
public class FindTheShortestSuperstring_943 {
  public String shortestSuperstring(String[] strings) {
    int n = strings.length;
    int[][] graph = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        graph[i][j] = calcWeight(strings[i], strings[j]);
        graph[j][i] = calcWeight(strings[j], strings[i]);
      }
    }
    int[][] dp = new int[1 << n][n];
    int[][] path = new int[1 << n][n];
    int last = -1;
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < (1 << n); i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) > 0) {
          int prev = i - (1 << j);
          if (prev == 0) {
            dp[i][j] = strings[j].length();
          } else {
            for (int k = 0; k < n; k++) {
              if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                dp[i][j] = dp[prev][k] + graph[k][j];
                path[i][j] = k;
              }
            }
          }
        }
        if (i == (1 << n) - 1 && dp[i][j] < min) {
          min = dp[i][j];
          last = j;
        }
      }
    }

    int curr = (1 << n) - 1;
    Deque<Integer> stack = new ArrayDeque<>();
    while (curr > 0) {
      stack.push(last);
      int temp = curr;
      curr -= (1 << last);
      last = path[temp][last];
    }

    int i = stack.pop();
    StringBuilder sb = new StringBuilder();
    sb.append(strings[i]);
    while (!stack.isEmpty()) {
      int j = stack.pop();
      sb.append(strings[j].substring(strings[j].length() - graph[i][j]));
      i = j;
    }
    return sb.toString();
  }

  private int calcWeight(String first, String second) {
    for (int i = 1; i < first.length(); i++) {
      if (second.startsWith(first.substring(i))) {
        return second.length() - first.length() + i;
      }
    }
    return second.length();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
