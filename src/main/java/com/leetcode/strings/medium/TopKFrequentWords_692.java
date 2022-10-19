package com.leetcode.strings.medium;

//Given an array of strings words and an integer k, return the k most frequent
//strings.
//
// Return the answer sorted by the frequency from highest to lowest. Sort the
//words with the same frequency by their lexicographical order.
//
//
// Example 1:
//
//
//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
//Explanation: "i" and "love" are the two most frequent words.
//Note that "i" comes before "love" due to a lower alphabetical order.
//
//
// Example 2:
//
//
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
// k = 4
//Output: ["the","is","sunny","day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//with the number of occurrence being 4, 3, 2 and 1 respectively.
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 500
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// k is in the range [1, The number of unique words[i]]
//
//
//
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
//
// Related Topics Hash Table String Trie Sorting Heap (Priority Queue) Bucket
//Sort Counting 👍 6229 👎 291

/*
  O(nlog(k)) Runtime: 14 ms, faster than 35.97% of Java online submissions for Top K Frequent Words.
  O(n) Memory Usage: 45.4 MB, less than 32.96% of Java online submissions for Top K Frequent Words.
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class TopKFrequentWords_692 {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> counter = new HashMap<>();

    for(String word : words) {
      counter.merge(word, 1, Integer::sum);
    }

    Queue<WordWrapper> pq = new PriorityQueue<>();

    for(Map.Entry<String, Integer> entry : counter.entrySet()) {
      pq.add(new WordWrapper(entry.getKey(), entry.getValue()));

      if(pq.size() > k){
        pq.poll();
      }
    }

    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll().word);
    }
    Collections.reverse(result);
    return result;
  }


  private static class WordWrapper implements Comparable<WordWrapper> {

    private final int count;
    private final String word;

    public WordWrapper(String word, int count){
      this.count = count;
      this.word = word;
    }


    @Override
    public int compareTo(WordWrapper other) {
      int countCompare = Integer.compare(count, other.count);

      if(countCompare == 0) {
        return other.word.compareTo(word);
      }

      return countCompare;
    }
  }

}
//leetcode submit region end(Prohibit modification and deletion)
