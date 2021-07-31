package com.leetcode.graph.hard;

//There is a new alien language that uses the English alphabet. However, the ord
//er among the letters is unknown to you.
//
// You are given a list of strings words from the alien language's dictionary, w
//here the strings in words are sorted lexicographically by the rules of this new
//language.
//
// Return a string of the unique letters in the new alien language sorted in lex
//icographically increasing order by the new language's rules. If there is no solu
//tion, return "". If there are multiple solutions, return any of them.
//
// A string s is lexicographically smaller than a string t if at the first lette
//r where they differ, the letter in s comes before the letter in t in the alien l
//anguage. If the first min(s.length, t.length) letters are the same, then s is sm
//aller if and only if s.length < t.length.
//
//
// Example 1:
//
//
//Input: words = ["wrt","wrf","er","ett","rftt"]
//Output: "wertf"
//
//
// Example 2:
//
//
//Input: words = ["z","x"]
//Output: "zx"
//
//
// Example 3:
//
//
//Input: words = ["z","x","z"]
//Output: ""
//Explanation: The order is invalid, so return "".
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists of only lowercase English letters.
//
// Related Topics Array String Depth-First Search Breadth-First Search Graph Top
//ological Sort
// 👍 2762 👎 538


//leetcode submit region begin(Prohibit modification and deletion)
public class AlienDictionary_269 {
  public String alienOrder(String[] words) {
    return "";
  }
}
//leetcode submit region end(Prohibit modification and deletion)
