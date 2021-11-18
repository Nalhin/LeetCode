package com.leetcode.binarysearch.hard;

// Nearly everyone has used the Multiplication Table. The multiplication table
// of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
//
// Given three integers m, n, and k, return the kᵗʰ smallest element in the m x
// n multiplication table.
//
//
// Example 1:
//
//
// Input: m = 3, n = 3, k = 5
// Output: 3
// Explanation: The 5ᵗʰ smallest number is 3.
//
//
// Example 2:
//
//
// Input: m = 2, n = 3, k = 6
// Output: 6
// Explanation: The 6ᵗʰ smallest number is 6.
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 3 * 10⁴
// 1 <= k <= m * n
//
// Related Topics Binary Search 👍 1431 👎 41

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(m*log(m*n)) Runtime: 17 ms, faster than 10.33% of Java online submissions for Kth Smallest Number in Multiplication Table.
 O(1) Memory Usage: 35.7 MB, less than 79.81% of Java online submissions for Kth Smallest Number in Multiplication Table.
*/
public class KthSmallestNumberInMultiplicationTable_668 {

  public int findKthNumber(int m, int n, int k) {

    int left = 1;
    int right = m * n;

    int result = -1;

    while(left <= right){
      int mid = left + (right - left) / 2;

      if(smallerCount(mid, m, n) >= k){
        right = mid - 1;
        result = mid;
      } else {
        left = mid + 1;
      }
    }

    return result;
  }


  private int smallerCount(int num, int m, int n){
    int result = 0;

    for(int i = 1; i <= n; i++){
      result += Math.min(num / i, m);
    }
    return result;
  }

}
// leetcode submit region end(Prohibit modification and deletion)
