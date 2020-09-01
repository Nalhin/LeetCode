# Given a binary array, find the maximum number of consecutive 1s in this array.
#
#
#  Example 1:
#
# Input: [1,1,0,1,1,1]
# Output: 3
# Explanation: The first two digits or the last three digits are consecutive 1s.
#
#     The maximum number of consecutive 1s is 3.
#
#
#
#  Note:
#
#  The input array will only contain 0 and 1.
#  The length of input array is a positive integer and will not exceed 10,000
#
#  Related Topics Array
#  👍 780 👎 371


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        cache = []
        current = 0
        for num in nums:
            if not num:
                cache.append(current)
                current = 0
            else:
                current += 1
        cache.append(current)
        return max(cache)

    # leetcode submit region end(Prohibit modification and deletion)
