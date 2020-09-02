# Given an array of integers nums and and integer target, return the indices of
# the two numbers such that they add up to target.
#
#  You may assume that each input would have exactly one solution, and you may n
# ot use the same element twice.
#
#  You can return the answer in any order.
#
#
#  Example 1:
#
#
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1]
#
#
#  Example 2:
#
#
# Input: nums = [3,2,4], target = 6
# Output: [1,2]
#
#
#  Example 3:
#
#
# Input: nums = [3,3], target = 6
# Output: [0,1]
#
#
#
#  Constraints:
#
#
#  1 <= nums.length <= 105
#  -109 <= nums[i] <= 109
#  -109 <= target <= 109
#  Only one valid answer exists.
#
#  Related Topics Array Hash Table
#  👍 16567 👎 599


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache = {}
        for pos in range(len(nums)):
            cache[nums[pos]] = pos

        for index in range(len(nums)):
            el = target - nums[index]
            if el in cache and index != cache[el]:
                return [index, cache[el]]

# leetcode submit region end(Prohibit modification and deletion)
