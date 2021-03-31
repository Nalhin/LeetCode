package com.leetcode.strings.hard;

// You want to form a target string of lowercase letters.
//
// At the beginning, your sequence is target.length '?' marks. You also have a s
// tamp of lowercase letters.
//
// On each turn, you may place the stamp over the sequence, and replace every le
// tter in the sequence with the corresponding letter from the stamp. You can make
// up to 10 * target.length turns.
//
// For example, if the initial sequence is "?????", and your stamp is "abc", the
// n you may make "abc??", "?abc?", "??abc" in the first turn. (Note that the stamp
// must be fully contained in the boundaries of the sequence in order to stamp.)
//
// If the sequence is possible to stamp, then return an array of the index of th
// e left-most letter being stamped at each turn. If the sequence is not possible t
// o stamp, return an empty array.
//
// For example, if the sequence is "ababc", and the stamp is "abc", then we coul
// d return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ab
// abc".
//
// Also, if the sequence is possible to stamp, it is guaranteed it is possible t
// o stamp within 10 * target.length moves. Any answers specifying more than this n
// umber of moves will not be accepted.
//
//
//
// Example 1:
//
//
// Input: stamp = "abc", target = "ababc"
// Output: [0,2]
// ([1,0,2] would also be accepted as an answer, as well as some other answers.)
//
//
//
// Example 2:
//
//
// Input: stamp = "abca", target = "aabcaca"
// Output: [3,0,1]
//
//
//
//
//
// Note:
//
//
//
//
// 1 <= stamp.length <= target.length <= 1000
// stamp and target only contain lowercase letters.
// Related Topics String Greedy
// 👍 356 👎 85
/*
  O(n * m) Runtime: 7 ms, faster than 48.74% of Java online submissions for Stamping The Sequence.
  O(n + m) Memory Usage: 39.4 MB, less than 60.50% of Java online submissions for Stamping The Sequence.
 */
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StampingTheSequence_936 {
  public int[] movesToStamp(String stamp, String target) {
    char[] stampArr = stamp.toCharArray();
    char[] targetArr = target.toCharArray();
    List<Integer> result = new ArrayList<>();

    boolean[] visited = new boolean[targetArr.length];
    int replacedCount = 0;

    while (replacedCount < targetArr.length) {
      boolean replaced = false;
      for (int i = 0;
          i <= targetArr.length - stampArr.length && replacedCount < targetArr.length;
          i++) {
        if (!visited[i] && canReplace(targetArr, stampArr, i)) {
          replacedCount = replace(targetArr, i, stampArr.length, replacedCount);
          replaced = true;
          visited[i] = true;
          result.add(i);
        }
      }

      if (!replaced) {
        return new int[0];
      }
    }

    Collections.reverse(result);
    return result.stream().mapToInt(i -> i).toArray();
  }

  private boolean canReplace(char[] target, char[] stamp, int position) {
    for (int i = 0; i < stamp.length; i++) {
      if (target[i + position] != '*' && target[i + position] != stamp[i]) {
        return false;
      }
    }
    return true;
  }

  private int replace(char[] target, int position, int stampLength, int replacedCount) {
    for (int i = position; i < stampLength + position; i++) {
      if (target[i] != '*') {
        target[i] = '*';
        replacedCount++;
      }
    }
    return replacedCount;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
