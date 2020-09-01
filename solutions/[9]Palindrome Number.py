# Determine whether an integer is a palindrome. An integer is a palindrome when
# it reads the same backward as forward.
#
#  Example 1:
#
#
# Input: 121
# Output: true
#
#
#  Example 2:
#
#
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it becomes
#  121-. Therefore it is not a palindrome.
#
#
#  Example 3:
#
#
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
#
#
#  Follow up:
#
#  Coud you solve it without converting the integer to a string?
#  Related Topics Math
#  👍 2479 👎 1592


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x):
            return False
        reversed_num = 0
        while reversed_num < x:
            reversed_num = reversed_num * 10 + x % 10
            x //= 10
        return x == reversed_num or x == (reversed_num // 10)


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == "__main__":
    print(Solution().isPalindrome(121))
