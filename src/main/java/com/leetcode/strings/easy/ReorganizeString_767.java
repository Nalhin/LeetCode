package com.leetcode.strings.easy;

// Given a string S, check if the letters can be rearranged so that two character
// s that are adjacent to each other are not the same.
//
// If possible, output any possible result. If not possible, return the empty st
// ring.
//
// Example 1:
//
//
// Input: S = "aab"
// Output: "aba"
//
//
// Example 2:
//
//
// Input: S = "aaab"
// Output: ""
//
//
// Note:
//
//
// S will consist of lowercase letters and have length in range [1, 500].
//
//
//
// Related Topics String Heap Greedy Sort
// 👍 2475 👎 118

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reorganize String.
 O(n) Memory Usage: 39.3 MB, less than 7.24% of Java online submissions for Reorganize String.
*/
public class ReorganizeString_767 {
  public String reorganizeString(String str) {
    int[] counter = new int[26];

    for (int i = 0; i < str.length(); i++) {
      counter[str.charAt(i) - 'a']++;
    }

    int max = 0;
    int maxLetter = 0;
    for (int i = 0; i < counter.length; i++) {
      if (counter[i] > max) {
        max = counter[i];
        maxLetter = i;
      }
    }

    if (max > (str.length() + 1) / 2) {
      return "";
    }

    char[] res = new char[str.length()];

    int currIndex = 0;
    while (counter[maxLetter] > 0) {
      res[currIndex] = (char) (maxLetter + 'a');
      currIndex += 2;
      counter[maxLetter]--;
    }

    for (int i = 0; i < counter.length; i++) {
      while (counter[i] > 0) {
        if (currIndex >= res.length) {
          currIndex = 1;
        }
        res[currIndex] = (char) (i + 'a');
        currIndex += 2;
        counter[i]--;
      }
    }
    return new String(res);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
