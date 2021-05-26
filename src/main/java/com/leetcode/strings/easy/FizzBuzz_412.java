package com.leetcode.strings.easy;

// Write a program that outputs the string representation of numbers from 1 to n.
//
//
// But for multiples of three it should output “Fizz” instead of the number and
// for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”.
//
// Example:
//
// n = 15,
//
// Return:
// [
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
// ]
//
// 👍 1075 👎 1388

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 9 ms, faster than 5.34% of Java online submissions for Fizz Buzz.
 O(n) Memory Usage: 41 MB, less than 7.16% of Java online submissions for Fizz Buzz.
*/
public class FizzBuzz_412 {
  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      String curr = "";
      if (i % 3 == 0) {
        curr += "Fizz";
      }
      if (i % 5 == 0) {
        curr += "Buzz";
      }
      if (curr.isEmpty()) {
        curr += i;
      }
      result.add(curr);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
