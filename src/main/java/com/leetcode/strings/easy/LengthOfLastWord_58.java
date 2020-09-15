package com.leetcode.strings.easy;
//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only.
//
// Example:
//
//
//Input: "Hello World"
//Output: 5
//
//
//
// Related Topics String
// 👍 736 👎 2617


//leetcode submit region begin(Prohibit modification and deletion)
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
    Memory Usage: 39.6 MB, less than 8.09% of Java online submissions for Length of Last Word.
 */
//leetcode submit region end(Prohibit modification and deletion)
