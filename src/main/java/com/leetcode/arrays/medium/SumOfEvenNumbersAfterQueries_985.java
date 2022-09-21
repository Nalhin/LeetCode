package com.leetcode.arrays.medium;

//You are given an integer array nums and an array queries where queries[i] = [
//vali, indexi].
//
// For each query i, first, apply nums[indexi] = nums[indexi] + vali, then
//print the sum of the even values of nums.
//
// Return an integer array answer where answer[i] is the answer to the iᵗʰ
//query.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//Output: [8,6,2,4]
//Explanation: At the beginning, the array is [1,2,3,4].
//After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values
//is 2 + 2 + 4 = 8.
//After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even
//values is 2 + 4 = 6.
//After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even
//values is -2 + 4 = 2.
//After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even
//values is -2 + 6 = 4.
//
//
// Example 2:
//
//
//Input: nums = [1], queries = [[4,0]]
//Output: [0]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// 1 <= queries.length <= 10⁴
// -10⁴ <= vali <= 10⁴
// 0 <= indexi < nums.length
//
//
// Related Topics Array Simulation 👍 1768 👎 308
/*
  O(n) Runtime: 11 ms, faster than 19.48% of Java online submissions for Sum of Even Numbers After Queries.
  O(n) Memory Usage: 68.1 MB, less than 83.77% of Java online submissions for Sum of Even Numbers After Queries.
*/
//leetcode submit region begin(Prohibit modification and deletion)
class SumOfEvenNumbersAfterQueries_985 {
  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

    int[] result = new int[nums.length];
    int sum = 0;


    for(int num : nums) {
      if(num % 2 == 0){
        sum += num;
      }
    }

    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int prev = nums[query[1]];
      nums[query[1]] += query[0];
      if (prev % 2 == 0) {
        sum -= prev;
      }
      if (nums[query[1]] % 2 == 0) {
        sum += nums[query[1]];
      }
      result[i] = sum;
    }

    return result;
  }

}
//leetcode submit region end(Prohibit modification and deletion)
