package com.leetcode.arrays.easy;

// Given an array of unique integers salary where salary[i] is the salary of the
// employee i.
//
// Return the average salary of employees excluding the minimum and maximum sala
// ry.
//
//
// Example 1:
//
//
// Input: salary = [4000,3000,1000,2000]
// Output: 2500.00000
// Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
//
// Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
//
//
// Example 2:
//
//
// Input: salary = [1000,2000,3000]
// Output: 2000.00000
// Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
//
// Average salary excluding minimum and maximum salary is (2000)/1= 2000
//
//
// Example 3:
//
//
// Input: salary = [6000,5000,4000,3000,2000,1000]
// Output: 3500.00000
//
//
// Example 4:
//
//
// Input: salary = [8000,9000,2000,3000,6000,1000]
// Output: 4750.00000
//
//
//
// Constraints:
//
//
// 3 <= salary.length <= 100
// 10^3 <= salary[i] <= 10^6
// salary[i] is unique.
// Answers within 10^-5 of the actual value will be accepted as correct.
// Related Topics Array Sort
// 👍 140 👎 31

// leetcode submit region begin(Prohibit modification and deletion)

public class AverageSalaryExcludingTheMinimumAndMaximum_1491 {
  public double average(int[] salary) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    double sum = 0d;

    for (int val : salary) {
      if (val > max) {
        max = val;
      }

      if (val < min) {
        min = val;
      }

      sum += val;
    }

    return (sum - min - max) / (salary.length - 2);
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
  O(1) Memory Usage: 37.1 MB, less than 66.12% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
 */

// leetcode submit region end(Prohibit modification and deletion)
