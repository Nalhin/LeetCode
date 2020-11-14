package com.leetcode.binarysearch.easy;

//
// Given a list of sorted characters letters containing only lowercase letters, a
// nd given a target letter target, find the smallest element in the list that is l
// arger than the given target.
//
// Letters also wrap around. For example, if the target is target = 'z' and lette
// rs = ['a', 'b'], the answer is 'a'.
//
//
// Examples:
//
// Input:
// letters = ["c", "f", "j"]
// target = "a"
// Output: "c"
//
// Input:
// letters = ["c", "f", "j"]
// target = "c"
// Output: "f"
//
// Input:
// letters = ["c", "f", "j"]
// target = "d"
// Output: "f"
//
// Input:
// letters = ["c", "f", "j"]
// target = "g"
// Output: "j"
//
// Input:
// letters = ["c", "f", "j"]
// target = "j"
// Output: "c"
//
// Input:
// letters = ["c", "f", "j"]
// target = "k"
// Output: "c"
//
//
//
// Note:
//
// letters has a length in range [2, 10000].
// letters consists of lowercase letters, and contains at least 2 unique letters
// .
// target is a lowercase letter.
//
// Related Topics Binary Search
// 👍 494 👎 595

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
 O(1) Memory Usage: 38.8 MB, less than 99.66% of Java online submissions for Find Smallest Letter Greater Than Target.
*/
public class FindSmallestLetterGreaterThanTarget_744 {
  public char nextGreatestLetter(char[] letters, char target) {
    int left = 0;
    int right = letters.length - 1;

    char ans = letters[0];

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (letters[mid] > target) {
        right = mid - 1;
        ans = letters[mid];
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
