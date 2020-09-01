# Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements ap
# pear twice and others appear once.
#
#  Find all the elements that appear twice in this array.
#
#  Could you do it without extra space and in O(n) runtime?
#
#  Example:
#
# Input:
# [4,3,2,7,8,2,3,1]
#
# Output:
# [2,3]
#  Related Topics Array
#  👍 2688 👎 161


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        cache = {}
        duplicates = []
        for num in nums:
            if num in cache:
                duplicates.append(num)
            else:
                cache[num] = True
        return duplicates

# leetcode submit region end(Prohibit modification and deletion)
