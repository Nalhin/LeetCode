package easy;// Write a function to find the longest common prefix string amongst an array of
// strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
// Related Topics String
// 👍 2876 👎 1941

// leetcode submit region begin(Prohibit modification and deletion)

public class LongestCommonPrefix_14 {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String common = strs[0];
    for (int i = 1; i < strs.length; i++) {
      String str = strs[i];
      while (!str.startsWith(common)) {
        common = common.substring(0, common.length() - 1);
        if (common.isEmpty()) {
          return "";
        }
      }
    }
    return common;
  }
}

/*
Runtime:1 ms, faster than 70.65% of Java online submissions.
Memory Usage:39.4 MB, less than 31.21% of Java online submissions.
*/

// leetcode submit region end(Prohibit modification and deletion)
