package com.leetcode.greedy.medium;

// Given an array arr. You can choose a set of integers and remove all the occurr
// ences of these integers in the array.
//
// Return the minimum size of the set so that at least half of the integers of t
// he array are removed.
//
//
// Example 1:
//
//
// Input: arr = [3,3,3,3,5,5,5,2,2,7]
// Output: 2
// Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size
// 5 (i.e equal to half of the size of the old array).
// Possible sets of size 2 are {3,5},{3,2},{5,2}.
// Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,
// 5] which has size greater than half of the size of the old array.
//
//
// Example 2:
//
//
// Input: arr = [7,7,7,7,7,7]
// Output: 1
// Explanation: The only possible set you can choose is {7}. This will make the n
// ew array empty.
//
//
// Example 3:
//
//
// Input: arr = [1,9]
// Output: 1
//
//
// Example 4:
//
//
// Input: arr = [1000,1000,3,7]
// Output: 1
//
//
// Example 5:
//
//
// Input: arr = [1,2,3,4,5,6,7,8,9,10]
// Output: 5
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 10^5
// arr.length is even.
// 1 <= arr[i] <= 10^5
// Related Topics Array Greedy
// 👍 399 👎 38

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceArraySizeToTheHalf_1338 {

  /*
   O(nlog(n)) Runtime: 81 ms, faster than 17.84% of Java online submissions for Reduce Array Size to The Half.
   O(n) Memory Usage: 105.8 MB, less than 7.59% of Java online submissions for Reduce Array Size to The Half.
  */
  static class Sort {

    public int minSetSize(int[] arr) {
      int size = arr.length;

      Map<Integer, Integer> counter = new HashMap<>();
      for (int num : arr) {
        counter.put(num, counter.getOrDefault(num, 0) + 1);
      }

      List<Integer> sorted =
          counter.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());

      int count = 0;
      while (size > arr.length / 2) {
        size -= sorted.get(count++);
      }

      return count;
    }
  }

  static class Buckets {
    /*
     O(n) Runtime: 27 ms, faster than 87.96% of Java online submissions for Reduce Array Size to The Half.
     O(n) Memory Usage: 48.7 MB, less than 81.94% of Java online submissions for Reduce Array Size to The Half.
    */
    public int minSetSize(int[] arr) {
      Map<Integer, Integer> counter = new HashMap<>();

      for (int num : arr) {
        counter.merge(num, 1, (prev, b) -> prev + 1);
      }

      int[] timesOfOccurrences = new int[arr.length + 1];

      for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
        timesOfOccurrences[entry.getValue()]++;
      }

      int result = 0;

      for (int i = timesOfOccurrences.length - 1, goal = 0; goal < arr.length / 2; i--) {
        while (timesOfOccurrences[i] > 0 && goal < arr.length / 2) {
          goal += i;
          result++;
          timesOfOccurrences[i]--;
        }
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
