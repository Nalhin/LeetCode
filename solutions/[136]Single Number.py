# Given a non-empty array of integers, every element appears twice except for on
# e. Find that single one. 
# 
#  Note: 
# 
#  Your algorithm should have a linear runtime complexity. Could you implement i
# t without using extra memory? 
# 
#  Example 1: 
# 
#  
# Input: [2,2,1]
# Output: 1
#  
# 
#  Example 2: 
# 
#  
# Input: [4,1,2,1,2]
# Output: 4
#  
#  Related Topics Hash Table Bit Manipulation 
#  👍 4813 👎 166


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counter = 0
        for i in nums:
            counter ^= i
        return counter
# leetcode submit region end(Prohibit modification and deletion)
