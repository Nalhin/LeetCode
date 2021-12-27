package com.leetcode.strings.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for String Transforms Into Another String.
 O(m) Memory Usage: 39.3 MB, less than 17.96% of Java online submissions for String Transforms Into Another String.
*/
public class StringTransformsIntoAnotherString_1153 {
  public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2)) {
      return true;
    }
    if (str1.length() != str2.length()) {
      return false;
    }
    Map<Character, Character> mapping = new HashMap<>();
    Set<Character> str2Chars = new HashSet<>();

    for (int i = 0; i < str1.length(); i++) {
      char curr1 = str1.charAt(i);
      char curr2 = str2.charAt(i);

      if (mapping.containsKey(curr1)) {
        if (mapping.get(curr1) != curr2) {
          return false;
        }
      } else {
        mapping.put(curr1, curr2);
        str2Chars.add(curr2);
      }
    }

    return str2Chars.size() < 26;
  }
}
