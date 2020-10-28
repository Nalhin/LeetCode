package com.leetcode.tree.medium;

// Given two binary trees original and cloned and given a reference to a node tar
// get in the original tree.
//
// The cloned tree is a copy of the original tree.
//
// Return a reference to the same node in the cloned tree.
//
// Note that you are not allowed to change any of the two trees or the target no
// de and the answer must be a reference to a node in the cloned tree.
//
// Follow up: Solve the problem if repeated values on the tree are allowed.
//
//
// Example 1:
//
//
// Input: tree = [7,4,3,null,null,6,19], target = 3
// Output: 3
// Explanation: In all examples the original and cloned trees are shown. The targ
// et node is a green node from the original tree. The answer is the yellow node fr
// om the cloned tree.
//
//
// Example 2:
//
//
// Input: tree = [7], target =  7
// Output: 7
//
//
// Example 3:
//
//
// Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
// Output: 4
//
//
// Example 4:
//
//
// Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
// Output: 5
//
//
// Example 5:
//
//
// Input: tree = [1,2,null,3], target = 2
// Output: 2
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 10^4].
// The values of the nodes of the tree are unique.
// target node is a node from the original tree and is not null.
//
// Related Topics Tree
// 👍 208 👎 309

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree_1379 {
  static class Iterative {
    public final TreeNode getTargetCopy(
        final TreeNode original, final TreeNode cloned, final TreeNode target) {

      HashMap<TreeNode, TreeNode> childParentMap = new HashMap<>();

      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.push(original);

      while (!deque.isEmpty()) {
        TreeNode curr = deque.pop();

        if (curr == target) {
          break;
        }

        if (curr.left != null) {
          childParentMap.put(curr.left, curr);
          deque.push(curr.left);
        }
        if (curr.right != null) {
          childParentMap.put(curr.right, curr);
          deque.push(curr.right);
        }
      }

      Deque<Integer> order = new ArrayDeque<>();
      TreeNode curr = target;
      order.push(curr.val);
      while (childParentMap.containsKey(curr)) {
        curr = childParentMap.get(curr);
        order.push(curr.val);
      }
      curr = cloned;
      order.pop();
      while (!order.isEmpty()) {
        int top = order.pop();
        if (curr.left != null && curr.left.val == top) {
          curr = curr.left;
        } else {
          curr = curr.right;
        }
      }
      return curr;
    }
  }

  static class Recursive {
    public final TreeNode getTargetCopy(
        final TreeNode original, final TreeNode cloned, final TreeNode target) {

      if (original == null) {
        return null;
      }

      if (original == target) {
        return cloned;
      }

      TreeNode left = getTargetCopy(original.left, cloned.left, target);
      TreeNode right = getTargetCopy(original.right, cloned.right, target);

      return left == null ? right : left;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
