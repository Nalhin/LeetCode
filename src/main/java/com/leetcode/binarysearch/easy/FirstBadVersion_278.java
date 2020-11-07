package com.leetcode.binarysearch.easy;

// You are a product manager and currently leading a team to develop a new produc
// t. Unfortunately, the latest version of your product fails the quality check. Si
// nce each version is developed based on the previous version, all the versions af
// ter a bad version are also bad.
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first
// bad one, which causes all the following ones to be bad.
//
// You are given an API bool isBadVersion(version) which returns whether version
// is bad. Implement a function to find the first bad version. You should minimize
// the number of calls to the API.
//
//
// Example 1:
//
//
// Input: n = 5, bad = 4
// Output: 4
// Explanation:
// call isBadVersion(3) -> false
// call isBadVersion(5) -> true
// call isBadVersion(4) -> true
// Then 4 is the first bad version.
//
//
// Example 2:
//
//
// Input: n = 1, bad = 1
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= bad <= n <= 231 - 1
//
// Related Topics Binary Search
// 👍 1742 👎 741

// leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
/*
 O(n) Runtime: 12 ms, faster than 98.34% of Java online submissions for First Bad Version.
 O(1) Memory Usage: 35.8 MB, less than 8.27% of Java online submissions for First Bad Version.
*/
public class FirstBadVersion_278 {
  public int firstBadVersion(int n) {
    int left = 0;
    int right = n;
    int ans = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      boolean isBad = isBadVersion(mid);

      if (isBad) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  public boolean isBadVersion(int version) {
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
