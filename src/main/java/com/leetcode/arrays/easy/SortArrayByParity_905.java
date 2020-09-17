package com.leetcode.arrays.easy;
//Given an array A of non-negative integers, return an array consisting of all t
//he even elements of A, followed by all the odd elements of A.
//
// You may return any answer array that satisfies this condition.
//
//
//
//
// Example 1:
//
//
//Input: [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
//
// Related Topics Array
// 👍 1275 👎 77


//leetcode submit region begin(Prohibit modification and deletion)
public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int right = A.length - 1;
        int left = 0;
        for (int j : A) {
            if (j % 2 == 0) {
                result[left++] = j;
            } else {
                result[right--] = j;
            }
        }
        return result;
    }
}

/*
    Runtime: 1 ms, faster than 99.59% of Java online submissions for Sort Array By Parity.
    Memory Usage: 40.7 MB, less than 45.26% of Java online submissions for Sort Array By Parity.
 */


//leetcode submit region end(Prohibit modification and deletion)
