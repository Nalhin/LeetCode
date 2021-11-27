package com.leetcode.design.medium;

/*
 O(k) Runtime: 13 ms, faster than 82.97% of Java online submissions for Iterator for Combination.
 O(k) Memory Usage: 40.5 MB, less than 96.45% of Java online submissions for Iterator for Combination.
*/
public class IteratorForCombination_1286 {
  static class CombinationIterator {
    private final String characters;
    private final int k;
    private final int[] currentCombination;
    private boolean hasNext = true;

    public CombinationIterator(String characters, int combinationLength) {
      this.characters = characters;
      this.k = combinationLength;
      this.currentCombination = new int[k];
      for (int i = 0; i < k; i++) {
        currentCombination[i] = i;
      }
    }

    public String next() {
      StringBuilder result = new StringBuilder();

      for (int num : currentCombination) {
        result.append(characters.charAt(num));
      }

      int right = k - 1;

      while (right >= 0 && currentCombination[right] == characters.length() - k + right) {
        right--;
      }

      if (right >= 0) {
        currentCombination[right]++;
        for (int i = right + 1; i < k; i++) {
          currentCombination[i] = currentCombination[right] + i - right;
        }
      } else {
        hasNext = false;
      }

      return result.toString();
    }

    public boolean hasNext() {
      return hasNext;
    }
  }
}
