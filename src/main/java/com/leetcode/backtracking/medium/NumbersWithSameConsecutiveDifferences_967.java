package com.leetcode.backtracking.medium;

//Given two integers n and k, return an array of all the integers of length n
//where the difference between every two consecutive digits is k. You may return
//the answer in any order.
//
// Note that the integers should not have leading zeros. Integers as 02 and 043
//are not allowed.
//
//
// Example 1:
//
//
//Input: n = 3, k = 7
//Output: [181,292,707,818,929]
//Explanation: Note that 070 is not a valid number, because it has leading
//zeroes.
//
//
// Example 2:
//
//
//Input: n = 2, k = 1
//Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
//
//
//
// Constraints:
//
//
// 2 <= n <= 9
// 0 <= k <= 9
//
//
// Related Topics Backtracking Breadth-First Search 👍 2513 👎 184
/*
  O(2^n) Runtime: 3 ms, faster than 76.11% of Java online submissions for Numbers With Same Consecutive Differences.
  O(2^n) Memory Usage: 42.6 MB, less than 68.23% of Java online submissions for Numbers With Same Consecutive Differences.
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences_967 {
  public int[] numsSameConsecDiff(int n, int k) {
    List<Integer> result = new ArrayList<>();

    for(int i = 1; i <= 9; i++) {
      backtrack(i, i, n - 1, k, result);
    }

    int[] arrResult = new int[result.size()];

    for(int i = 0 ; i < result.size(); i++) {
      arrResult[i] = result.get(i);
    }

    return arrResult;
  }

  private void backtrack(int currNum, int prevDigit, int length, int k, List<Integer> result) {
    if(length == 0) {
      result.add(currNum);
      return;
    }

    if(prevDigit - k >= 0){
      backtrack(currNum * 10 + prevDigit - k, prevDigit - k, length - 1, k, result);
    }

    if(prevDigit + k <= 9 && k != 0){
      backtrack(currNum * 10 + prevDigit + k, prevDigit + k, length - 1, k, result);
    }
  }


}

//leetcode submit region end(Prohibit modification and deletion)
