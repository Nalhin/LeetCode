package com.leetcode.greedy.medium;

// You have an initial power of P, an initial score of 0, and a bag of tokens whe
// re tokens[i] is the value of the ith token (0-indexed).
//
// Your goal is to maximize your total score by potentially playing each token i
// n one of two ways:
//
//
// If your current power is at least tokens[i], you may play the ith token face
// up, losing tokens[i] power and gaining 1 score.
// If your current score is at least 1, you may play the ith token face down, ga
// ining tokens[i] power and losing 1 score.
//
//
// Each token may be played at most once and in any order. You do not have to pl
// ay all the tokens.
//
// Return the largest possible score you can achieve after playing any number of
// tokens.
//
//
// Example 1:
//
//
// Input: tokens = [100], P = 50
// Output: 0
// Explanation: Playing the only token in the bag is impossible because you eithe
// r have too little power or too little score.
//
//
// Example 2:
//
//
// Input: tokens = [100,200], P = 150
// Output: 1
// Explanation: Play the 0th token (100) face up, your power becomes 50 and score
// becomes 1.
// There is no need to play the 1st token since you cannot play it face up to add
// to your score.
//
//
// Example 3:
//
//
// Input: tokens = [100,200,300,400], P = 200
// Output: 2
// Explanation: Play the tokens in this order to get a score of 2:
// 1. Play the 0th token (100) face up, your power becomes 100 and score becomes
// 1.
// 2. Play the 3rd token (400) face down, your power becomes 500 and score become
// s 0.
// 3. Play the 1st token (200) face up, your power becomes 300 and score becomes
// 1.
// 4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.
//
//
//
//
// Constraints:
//
//
// 0 <= tokens.length <= 1000
// 0 <= tokens[i], P < 104
//
// Related Topics Greedy
// 👍 364 👎 224

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
  O(nlog(n)) Runtime: 3 ms, faster than 89.03% of Java online submissions for Bag of Tokens.
  O(1)       Memory Usage: 38.4 MB, less than 8.73% of Java online submissions for Bag of Tokens.
*/
public class BagOfTokens_948 {
  public int bagOfTokensScore(int[] tokens, int P) {
    Arrays.sort(tokens);
    if (tokens.length == 0 || tokens[0] > P) {
      return 0;
    }
    int power = P;
    int score = 0;
    int left = 0;
    int right = tokens.length - 1;

    while (left <= right) {
      if (power >= tokens[left]) {
        score++;
        power -= tokens[left];
        left++;
      } else {
        if (left + 1 < right) {
          power += tokens[right];
          score--;
          right--;
        } else {
          return score;
        }
      }
    }

    return score;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
