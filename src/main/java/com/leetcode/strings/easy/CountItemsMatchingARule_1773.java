package com.leetcode.strings.easy;

// You are given an array items, where each items[i] = [typei, colori, namei] des
// cribes the type, color, and name of the ith item. You are also given a rule repr
// esented by two strings, ruleKey and ruleValue.
//
// The ith item is said to match the rule if one of the following is true:
//
//
// ruleKey == "type" and ruleValue == typei.
// ruleKey == "color" and ruleValue == colori.
// ruleKey == "name" and ruleValue == namei.
//
//
// Return the number of items that match the given rule.
//
//
// Example 1:
//
//
// Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phon
// e","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
// Output: 1
// Explanation: There is only one item matching the given rule, which is ["comput
// er","silver","lenovo"].
//
//
// Example 2:
//
//
// Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone
// ","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
// Output: 2
// Explanation: There are only two items matching the given rule, which are ["pho
// ne","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer
// ","silver","phone"] does not match.
//
//
// Constraints:
//
//
// 1 <= items.length <= 104
// 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
// ruleKey is equal to either "type", "color", or "name".
// All strings consist only of lowercase letters.
//
// Related Topics Array String
// 👍 80 👎 17

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 O(n*m) Runtime: 3 ms, faster than 100.00% of Java online submissions for Count Items Matching a Rule.
 O(1) Memory Usage: 44.1 MB, less than 16.67% of Java online submissions for Count Items Matching a Rule.
*/
public class CountItemsMatchingARule_1773 {

  private static final Map<String, Integer> keyToIndex = new HashMap<>();

  static {
    keyToIndex.put("type", 0);
    keyToIndex.put("color", 1);
    keyToIndex.put("name", 2);
  }

  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

    int key = keyToIndex.get(ruleKey);
    int result = 0;

    for (List<String> item : items) {
      String value = item.get(key);
      if (value.equals(ruleValue)) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
