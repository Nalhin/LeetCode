package com.leetcode.strings.medium;

// Compare two version numbers version1 and version2.
// If version1 > version2 return 1; if version1 < version2 return -1;otherwise re
// turn 0.
//
// You may assume that the version strings are non-empty and contain only digits
// and the . character.
// The . character does not represent a decimal point and is used to separate nu
// mber sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it
// is the fifth second-level revision of the second first-level revision.
// You may assume the default revision number for each level of a version number
// to be 0. For example, version number 3.4 has a revision number of 3 and 4 for i
// ts first and second level revision number. Its third and fourth level revision n
// umber are both 0.
//
//
//
// Example 1:
//
// Input: version1 = "0.1", version2 = "1.1"
// Output: -1
//
// Example 2:
//
// Input: version1 = "1.0.1", version2 = "1"
// Output: 1
//
// Example 3:
//
// Input: version1 = "7.5.2.4", version2 = "7.5.3"
// Output: -1
//
// Example 4:
//
// Input: version1 = "1.01", version2 = "1.001"
// Output: 0
// Explanation: Ignoring leading zeroes, both “01” and “001" represent the same n
// umber “1”
//
// Example 5:
//
// Input: version1 = "1.0", version2 = "1.0.0"
// Output: 0
// Explanation: The first version number does not have a third level revision num
// ber, which means its third level revision number is default to "0"
//
//
//
// Note:
//
// Version strings are composed of numeric strings separated by dots . and this
// numeric strings may have leading zeroes.
// Version strings do not start or end with dots, and they will not be two conse
// cutive dots.
// Related Topics String
// 👍 566 👎 1498

// leetcode submit region begin(Prohibit modification and deletion)

public class CompareVersionNumbers_165 {
  public int compareVersion(String version1, String version2) {

    String[] nums1 = version1.split("\\.");
    String[] nums2 = version2.split("\\.");

    int i = 0;

    while (i < nums1.length && i < nums2.length) {
      if (Integer.parseInt(nums1[i]) > Integer.parseInt(nums2[i])) {
        return 1;
      } else if (Integer.parseInt(nums1[i]) < Integer.parseInt(nums2[i])) {
        return -1;
      }
      i++;
    }

    for (int j = i; j < nums1.length; j++) {
      if (Integer.parseInt(nums1[j]) > 0) {
        return 1;
      }
    }

    for (int j = i; j < nums2.length; j++) {
      if (Integer.parseInt(nums2[j]) > 0) {
        return -1;
      }
    }

    return 0;
  }
}

/*
  	Runtime:1 ms, faster than 92.98% of Java online submissions.
	Memory Usage:37.3 MB, less than 88.54% of Java online submissions.
*/
// leetcode submit region end(Prohibit modification and deletion)
