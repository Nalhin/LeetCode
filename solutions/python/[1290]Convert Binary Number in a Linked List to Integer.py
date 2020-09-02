# Given head which is a reference node to a singly-linked list. The value of eac
# h node in the linked list is either 0 or 1. The linked list holds the binary rep
# resentation of a number.
#
#  Return the decimal value of the number in the linked list.
#
#
#  Example 1:
#
#
# Input: head = [1,0,1]
# Output: 5
# Explanation: (101) in base 2 = (5) in base 10
#
#
#  Example 2:
#
#
# Input: head = [0]
# Output: 0
#
#
#  Example 3:
#
#
# Input: head = [1]
# Output: 1
#
#
#  Example 4:
#
#
# Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
# Output: 18880
#
#
#  Example 5:
#
#
# Input: head = [0,0]
# Output: 0
#
#
#
#  Constraints:
#
#
#  The Linked List is not empty.
#  Number of nodes will not exceed 30.
#  Each node's value is either 0 or 1.
#  Related Topics Linked List Bit Manipulation
#  👍 544 👎 46


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        values = ""
        node = head
        while node:
            values += str(node.val)
            node = node.next

        return int(values, 2)

# leetcode submit region end(Prohibit modification and deletion)
