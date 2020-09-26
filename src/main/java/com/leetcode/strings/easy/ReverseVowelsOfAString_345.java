package com.leetcode.strings.easy;

//Write a function that takes a string as input and reverse only the vowels of a
// string.
//
// Example 1:
//
//
//Input: "hello"
//Output: "holle"
//
//
//
// Example 2:
//
//
//Input: "leetcode"
//Output: "leotcede"
//
//
// Note:
//The vowels does not include the letter "y".
//
//
// Related Topics Two Pointers String
// 👍 768 👎 1233


import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class ReverseVowelsOfAString_345 {
    private final static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            while(left < right && !vowels.contains(arr[left])){
                left++;
            }

            while(left < right && !vowels.contains(arr[right])){
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(arr);
    }
}
/*
    O(n) Runtime: 4 ms, faster than 65.65% of Java online submissions for Reverse Vowels of a String.
    O(n) Memory Usage: 39.9 MB, less than 49.79% of Java online submissions for Reverse Vowels of a String.


 */
//leetcode submit region end(Prohibit modification and deletion)
