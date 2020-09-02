# Given an array of integers A sorted in non-decreasing order, return an array o
# f the squares of each number, also in sorted non-decreasing order.
#
#
#
#
#  Example 1:
#
#
# Input: [-4,-1,0,3,10]
# Output: [0,1,9,16,100]
#
#
#
#  Example 2:
#
#
# Input: [-7,-3,2,3,11]
# Output: [4,9,9,49,121]
#
#
#
#
#  Note:
#
#
#  1 <= A.length <= 10000
#  -10000 <= A[i] <= 10000
#  A is sorted in non-decreasing order.
#
#
#  Related Topics Array Two Pointers
#  👍 1364 👎 91


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        return sorted([item ** 2 for item in A])

# leetcode submit region end(Prohibit modification and deletion)
