package com.leetcode.binarysearch.easy;

// In some array arr, the values were in arithmetic progression: the values arr[i
// + 1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
//
// A value from arr was removed that was not the first or last value in the arra
// y.
//
// Given arr, return the removed value.
//
//
// Example 1:
//
//
// Input: arr = [5,7,11,13]
// Output: 9
// Explanation: The previous array was [5,7,9,11,13].
//
//
// Example 2:
//
//
// Input: arr = [15,13,12]
// Output: 14
// Explanation: The previous array was [15,14,13,12].
//
//
// Constraints:
//
//
// 3 <= arr.length <= 1000
// 0 <= arr[i] <= 105
// The given array is guaranteed to be a valid array.
//
// Related Topics Math
// 👍 168 👎 20

// leetcode submit region begin(Prohibit modification and deletion)

public class MissingNumberInArithmeticProgression_1228 {
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number In Arithmetic Progression.
   O(1) Memory Usage: 38.4 MB, less than 73.41% of Java online submissions for Missing Number In Arithmetic Progression.
  */
  static class LinearSearch {
    public int missingNumber(int[] arr) {
      int first = arr[0];
      int last = arr[arr.length - 1];

      int expectedDiff = (last - first) / (arr.length);
      int prev = first;

      for (int i = 1; i < arr.length; i++) {
        if (arr[i] - prev != expectedDiff) {
          return prev + expectedDiff;
        }
        prev = arr[i];
      }

      return first;
    }
  }
  /*
    O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number In Arithmetic Progression.
    O(1) Memory Usage: 38.6 MB, less than 56.75% of Java online submissions for Missing Number In Arithmetic Progression.
  */
  static class BinarySearch {
    public int missingNumber(int[] arr) {
      int left = 0;
      int right = arr.length - 1;

      int first = arr[left];
      int last = arr[right];
      int numDiff = (last - first) / arr.length;

      while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == first + numDiff * mid) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      return first + right * numDiff;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
