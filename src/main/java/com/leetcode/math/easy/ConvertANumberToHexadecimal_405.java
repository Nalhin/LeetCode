package com.leetcode.math.easy;

//
// Given an integer, write an algorithm to convert it to hexadecimal. For negativ
// e integer, two’s complement method is used.
//
//
// Note:
//
// All letters in hexadecimal (a-f) must be in lowercase.
// The hexadecimal string must not contain extra leading 0s. If the number is ze
// ro, it is represented by a single zero character '0'; otherwise, the first chara
// cter in the hexadecimal string will not be the zero character.
// The given number is guaranteed to fit within the range of a 32-bit signed int
// eger.
// You must not use any method provided by the library which converts/formats th
// e number to hex directly.
//
//
//
// Example 1:
//
// Input:
// 26
//
// Output:
// "1a"
//
//
//
// Example 2:
//
// Input:
// -1
//
// Output:
// "ffffffff"
//
// Related Topics Bit Manipulation
// 👍 578 👎 128

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert a Number to Hexadecimal.
 O(1) Memory Usage: 36.5 MB, less than 45.25% of Java online submissions for Convert a Number to Hexadecimal.
*/
import java.util.HashMap;
import java.util.Map;

public class ConvertANumberToHexadecimal_405 {
  private static final Map<Integer, Character> map = new HashMap<>();

  static {
    map.put(0, '0');
    map.put(1, '1');
    map.put(2, '2');
    map.put(3, '3');
    map.put(4, '4');
    map.put(5, '5');
    map.put(6, '6');
    map.put(7, '7');
    map.put(8, '8');
    map.put(9, '9');
    map.put(10, 'a');
    map.put(11, 'b');
    map.put(12, 'c');
    map.put(13, 'd');
    map.put(14, 'e');
    map.put(15, 'f');
  }

  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();

    while (num != 0) {
      sb.append(map.get(num & 15));
      num >>>= 4;
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
