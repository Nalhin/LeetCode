package com.leetcode.tree.medium;

// Given an array of numbers, verify whether it is the correct preorder traversal
// sequence of a binary search tree.
//
// You may assume each number in the sequence is unique.
//
// Consider the following binary search tree:
//
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//
// Example 1:
//
//
// Input: [5,2,6,1,3]
// Output: false
//
// Example 2:
//
//
// Input: [5,2,1,3,6]
// Output: true
//
// Follow up:
// Could you do it using only constant space complexity?
// Related Topics Stack Tree
// 👍 701 👎 60

// leetcode submit region begin(Prohibit modification and deletion)

/*
 O(n) Runtime: 2 ms, faster than 92.61% of Java online submissions for Verify Preorder Sequence in Binary Search Tree.
 O(log(n)) Memory Usage: 40.3 MB, less than 28.40% of Java online submissions for Verify Preorder Sequence in Binary Search Tree.
*/
public class VerifyPreorderSequenceInBinarySearchTree_255 {
  private int position = 0;

  public boolean verifyPreorder(int[] preorder) {
    dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return position == preorder.length;
  }

  private void dfs(int[] preorder, int min, int max) {
    if (position >= preorder.length) {
      return;
    }

    int curr = preorder[position];
    if (curr < min || curr > max) {
      return;
    }
    position++;
    dfs(preorder, min, curr);
    dfs(preorder, curr, max);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
