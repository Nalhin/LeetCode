package com.leetcode.bfs.easy;

// You are given a nested list of integers nestedList. Each element is either an
// integer or a list whose elements may also be integers or other lists.
//
// The depth of an integer is the number of lists that it is inside of. For exam
// ple, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its dep
// th.
//
// Return the sum of each integer in nestedList multiplied by its depth.
//
//
// Example 1:
//
//
// Input: nestedList = [[1,1],2,[1,1]]
// Output: 10
// Explanation: Four 1's at depth 2, one 2 at depth 1. 1*1 + 1*1 + 2*2 + 1*1 + 1*
// 1 = 10.
//
//
// Example 2:
//
//
// Input: nestedList = [1,[4,[6]]]
// Output: 27
// Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4
// *2 + 6*3 = 27.
//
// Example 3:
//
//
// Input: nestedList = [0]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nestedList.length <= 50
// The values of the integers in the nested list is in the range [-100, 100].
// The maximum depth of any integer is less than or equal to 50.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 702 👎 193

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger { // Constructor initializes
 * an empty nested list. public NestedInteger();
 *
 * <p>// Constructor initializes a single integer. public NestedInteger(int value);
 *
 * <p>// @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * <p>// @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * <p>// Set this NestedInteger to hold a single integer. public void setInteger(int value);
 *
 * <p>// Set this NestedInteger to hold a nested list and adds a nested integer to it. public void
 * add(NestedInteger ni);
 *
 * <p>// @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Nested List Weight Sum.
 O(n) Memory Usage: 36.2 MB, less than 87.34% of Java online submissions for Nested List Weight Sum.
*/
public class NestedListWeightSum_339 {
  public int depthSum(List<NestedInteger> nestedList) {
    return sumDfs(nestedList, 1);
  }

  private int sumDfs(List<NestedInteger> nestedList, int depth) {

    int sum = 0;
    for (NestedInteger nested : nestedList) {
      if (nested.isInteger()) {
        sum += nested.getInteger() * depth;
      } else {
        sum += sumDfs(nested.getList(), depth + 1);
      }
    }
    return sum;
  }

  private interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
