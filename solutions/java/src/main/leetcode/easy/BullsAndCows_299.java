package easy;

// You are playing the following Bulls and Cows game with your friend: You write
// down a number and ask your friend to guess what the number is. Each time your fr
// iend makes a guess, you provide a hint that indicates how many digits in said gu
// ess match your secret number exactly in both digit and position (called "bulls")
// and how many digits match the secret number but locate in the wrong position (c
// alled "cows"). Your friend will use successive guesses and hints to eventually d
// erive the secret number.
//
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows.
//
// Please note that both secret number and friend's guess may contain duplicate
// digits.
//
// Example 1:
//
//
// Input: secret = "1807", guess = "7810"
//
// Output: "1A3B"
//
// Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
//
// Example 2:
//
//
// Input: secret = "1123", guess = "0111"
//
// Output: "1A1B"
//
// Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
//
//
// Note: You may assume that the secret number and your friend's guess only cont
// ain digits, and their lengths are always equal. Related Topics Hash Table
// 👍 754 👎 914

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows_299 {
  public String getHint(String secret, String guess) {
    Map<Character, Integer> outputCache = new HashMap<>();
    Set<Integer> skipped = new HashSet<>();
    int bulls = 0;
    int cows = 0;

    for (int i = 0; i < guess.length(); i++) {
      char letter = secret.charAt(i);

      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
        skipped.add(i);
      } else {
        if (outputCache.containsKey(letter)) {
          outputCache.put(letter, outputCache.get(letter) + 1);
        } else {
          outputCache.put(letter, 1);
        }
      }
    }

    for (int i = 0; i < guess.length(); i++) {
      char letter = guess.charAt(i);
      if (!skipped.contains(i) && outputCache.containsKey(letter) && outputCache.get(letter) > 0) {
        cows++;
        outputCache.put(letter, outputCache.get(letter) - 1);
      }
    }
    return bulls + "A" + cows + "B";
  }
}

/*
 Runtime: 7 ms, faster than 57.58% of Java online submissions for Bulls and Cows.
 Memory Usage: 39.8 MB, less than 51.71% of Java online submissions for Bulls and Cows.
*/
// leetcode submit region end(Prohibit modification and deletion)
