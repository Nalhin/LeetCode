package easy;// Given a sorted array and a target value, return the index if the target is fou
// nd. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Example 1:
//
//
// Input: [1,3,5,6], 5
// Output: 2
//
//
// Example 2:
//
//
// Input: [1,3,5,6], 2
// Output: 1
//
//
// Example 3:
//
//
// Input: [1,3,5,6], 7
// Output: 4
//
//
// Example 4:
//
//
// Input: [1,3,5,6], 0
// Output: 0
//
// Related Topics Array Binary Search
// 👍 2620 👎 265

// leetcode submit region begin(Prohibit modification and deletion)

public class SearchInsertPosition_35 {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (right >= left) {
      int mid = (right + left) >>> 1;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}

/*
  	Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
	Memory Usage:39.6 MB, less than 41.90% of Java online submissions.
 */
// leetcode submit region end(Prohibit modification and deletion)
