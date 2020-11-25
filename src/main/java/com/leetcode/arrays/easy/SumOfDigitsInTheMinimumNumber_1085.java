package com.leetcode.arrays.easy;

//Given an array A of positive integers, let S be the sum of the digits of the m
//inimal element of A.
//
// Return 0 if S is odd, otherwise return 1.
//
//
//
// Example 1:
//
//
//Input: [34,23,1,24,75,33,54,8]
//Output: 0
//Explanation:
//The minimal element is 1, and the sum of those digits is S = 1 which is odd, s
//o the answer is 0.
//
//
// Example 2:
//
//
//Input: [99,77,33,66,55]
//Output: 1
//Explanation:
//The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which
//is even, so the answer is 1.
//
//
//
// Constraints:
//
//
// 1 <= A.length <= 100
// 1 <= A[i] <= 100
//
// Related Topics Array
// 👍 46 👎 109


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
/*
  O(max(n, numSize)) Runtime: 1 ms, faster than 19.37% of Java online submissions for Sum of Digits in the Minimum Number.
  O(1) Memory Usage: 37.1 MB, less than 9.01% of Java online submissions for Sum of Digits in the Minimum Number.
 */
public class SumOfDigitsInTheMinimumNumber_1085 {
    public int sumOfDigits(int[] A) {
        int min = Arrays.stream(A).min().orElseThrow();

        int result = 0;

        while(min > 0){
            result += min % 10;
            min /= 10;
        }

        return  1 - result % 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
