# Write a function that reverses a string. The input string is given as an array
#  of characters char[].
#
#  Do not allocate extra space for another array, you must do this by modifying
# the input array in-place with O(1) extra memory.
#
#  You may assume all the characters consist of printable ascii characters.
#
#
#
#
#  Example 1:
#
#
# Input: ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]
#
#
#
#  Example 2:
#
#
# Input: ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]
#
#
#
#  Related Topics Two Pointers String
#  👍 1584 👎 710


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        num = len(s) - 1
        curr = 0
        while num >= curr:
            s[num], s[curr] = s[curr], s[num]
            curr += 1
            num -= 1

# leetcode submit region end(Prohibit modification and deletion)
