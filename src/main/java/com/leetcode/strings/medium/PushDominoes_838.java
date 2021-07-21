package com.leetcode.strings.medium;

// There are n dominoes in a line, and we place each domino vertically upright. I
// n the beginning, we simultaneously push some of the dominoes either to the left
// or to the right.
//
// After each second, each domino that is falling to the left pushes the adjacen
// t domino on the left. Similarly, the dominoes falling to the right push their ad
// jacent dominoes standing on the right.
//
// When a vertical domino has dominoes falling on it from both sides, it stays s
// till due to the balance of the forces.
//
// For the purposes of this question, we will consider that a falling domino exp
// ends no additional force to a falling or already fallen domino.
//
// You are given a string dominoes representing the initial state where:
//
//
// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
//
//
// Return a string representing the final state.
//
//
// Example 1:
//
//
// Input: dominoes = "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino
// .
//
//
// Example 2:
//
//
// Input: dominoes = ".L.R...LR..L.."
// Output: "LL.RR.LLRRLL.."
//
//
//
// Constraints:
//
//
// n == dominoes.length
// 1 <= n <= 105
// dominoes[i] is either 'L', 'R', or '.'.
//
// Related Topics Two Pointers String Dynamic Programming
// 👍 1136 👎 86
/*
  O(n) Runtime: 11 ms, faster than 49.48% of Java online submissions for Push Dominoes.
  O(n) Memory Usage: 40.2 MB, less than 68.65% of Java online submissions for Push Dominoes.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class PushDominoes_838 {

  private static final char LEFT = 'L';
  private static final char RIGHT = 'R';
  private static final char DOT = '.';

  public String pushDominoes(String dominoes) {
    char[] result = new char[dominoes.length() + 2];
    result[0] = LEFT;
    result[result.length - 1] = RIGHT;

    for (int i = 1; i < result.length - 1; i++) {
      result[i] = dominoes.charAt(i - 1);
    }

    int left = 0;

    for (int right = 1; right < result.length; right++) {
      if (result[right] == DOT) {
        continue;
      }

      if (result[left] == LEFT && result[right] == LEFT) {
        fillBetweenWith(result, left, right, LEFT);
      } else if (result[left] == RIGHT && result[right] == RIGHT) {
        fillBetweenWith(result, left, right, RIGHT);
      } else if (result[left] == RIGHT && result[right] == LEFT) {
        meetInMiddle(result, left, right);
      }
      left = right;
    }

    return new String(result, 1, result.length - 2);
  }

  private void fillBetweenWith(char[] array, int leftIndex, int rightIndex, char value) {
    for (int i = leftIndex; i <= rightIndex; i++) {
      array[i] = value;
    }
  }

  private void meetInMiddle(char[] array, int leftIndex, int rightIndex) {
    int left = leftIndex + 1;
    int right = rightIndex - 1;
    while (left < right) {
      array[left] = RIGHT;
      array[right] = LEFT;
      left++;
      right--;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
