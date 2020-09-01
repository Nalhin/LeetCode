# Given a fixed length array arr of integers, duplicate each occurrence of zero,
#  shifting the remaining elements to the right.
#
#  Note that elements beyond the length of the original array are not written.
#
#  Do the above modifications to the input array in place, do not return anythin
# g from your function.
#
#
#
#  Example 1:
#
#
# Input: [1,0,2,3,0,4,5,0]
# Output: null
# Explanation: After calling your function, the input array is modified to: [1,0
# ,0,2,3,0,0,4]
#
#
#  Example 2:
#
#
# Input: [1,2,3]
# Output: null
# Explanation: After calling your function, the input array is modified to: [1,2
# ,3]
#
#
#
#
#  Note:
#
#
#  1 <= arr.length <= 10000
#  0 <= arr[i] <= 9
#  Related Topics Array
#  👍 561 👎 220


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        curr = 0
        len_be4 = len(arr)

        while curr < len(arr):
            if arr[curr] == 0:
                arr.insert(curr + 1, 0)
                curr += 2
            else:
                curr += 1

        for _ in range(len_be4, len(arr)):
            arr.pop()
# leetcode submit region end(Prohibit modification and deletion)
