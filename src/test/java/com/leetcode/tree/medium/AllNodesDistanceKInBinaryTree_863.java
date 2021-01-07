package com.leetcode.tree.medium;

//We are given a binary tree (with root node root), a target node, and an intege
//r value K.
//
// Return a list of the values of all nodes that have a distance K from the targ
//et node. The answer can be returned in any order.
//
//
//
//
//
//
//
// Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//Output: [7,4,1]
//
//Explanation:
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//
//
//
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
//
//
//
//
//
// Note:
//
//
// The given tree is non-empty.
// Each node in the tree has unique values 0 <= node.val <= 500.
// The target node is a node in the tree.
// 0 <= K <= 1000.
//
//
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 2979 👎 62


//leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AllNodesDistanceKInBinaryTree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
