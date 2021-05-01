package com.leetcode.math.medium;

// Given three integers x, y, and bound, return a list of all the powerful intege
// rs that have a value less than or equal to bound.
//
// An integer is powerful if it can be represented as xi + yj for some integers
// i >= 0 and j >= 0.
//
// You may return the answer in any order. In your answer, each value should occ
// ur at most once.
//
//
// Example 1:
//
//
// Input: x = 2, y = 3, bound = 10
// Output: [2,3,4,5,7,9,10]
// Explanation:
// 2 = 20 + 30
// 3 = 21 + 30
// 4 = 20 + 31
// 5 = 21 + 31
// 7 = 22 + 31
// 9 = 23 + 30
// 10 = 20 + 32
//
//
// Example 2:
//
//
// Input: x = 3, y = 5, bound = 15
// Output: [2,4,6,8,10,14]
//
//
//
// Constraints:
//
//
// 1 <= x, y <= 100
// 0 <= bound <= 106
//
// Related Topics Hash Table Math
// 👍 139 👎 55
/*
 O(log(n)^2) Runtime: 1 ms, faster than 98.44% of Java online submissions for Powerful Integers.
 O(log(n)^2) Memory Usage: 37.1 MB, less than 28.12% of Java online submissions for Powerful Integers.
*/
// leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers_970 {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    Set<Integer> result = new HashSet<>();

    for (int first = 1; first <= bound; first *= x) {
      for (int second = 1; first + second <= bound; second *= y) {
        result.add(first + second);
        if (y == 1) {
          break;
        }
      }
      if (x == 1) {
        break;
      }
    }

    return new ArrayList<>(result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
