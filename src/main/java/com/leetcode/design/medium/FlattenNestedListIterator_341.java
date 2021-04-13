package com.leetcode.design.medium;

// You are given a nested list of integers nestedList. Each element is either an
// integer or a list whose elements may also be integers or other lists. Implement
// an iterator to flatten it.
//
// Implement the NestedIterator class:
//
//
// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with
// the nested list nestedList.
// int next() Returns the next integer in the nested list.
// boolean hasNext() Returns true if there are still some integers in the nested
// list and false otherwise.
//
//
//
// Example 1:
//
//
// Input: nestedList = [[1,1],2,[1,1]]
// Output: [1,1,2,1,1]
// Explanation: By calling next repeatedly until hasNext returns false, the order
// of elements returned by next should be: [1,1,2,1,1].
//
//
// Example 2:
//
//
// Input: nestedList = [1,[4,[6]]]
// Output: [1,4,6]
// Explanation: By calling next repeatedly until hasNext returns false, the order
// of elements returned by next should be: [1,4,6].
//
//
//
// Constraints:
//
//
// 1 <= nestedList.length <= 500
// The values of the integers in the nested list is in the range [-106, 106].
//
// Related Topics Stack Design
// 👍 2131 👎 808

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger {
 *
 * <p>// @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * <p>// @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * <p>// @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * empty list if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
public class FlattenNestedListIterator_341 {

  public static class NestedIterator implements Iterator<Integer> {

    private final Deque<Iterator<NestedInteger>> deque = new ArrayDeque<>();
    private Integer currInteger = null;

    public NestedIterator(List<NestedInteger> nestedList) {
      deque.push(nestedList.iterator());
    }

    private void moveToNextNum() {
      while (!deque.isEmpty()) {
        Iterator<NestedInteger> it = deque.pop();

        if (it.hasNext()) {
          NestedInteger curr = it.next();

          if (curr.isInteger()) {
            currInteger = curr.getInteger();
            deque.push(it);
            return;
          } else {
            deque.push(it);
            deque.push(curr.getList().iterator());
          }
        }
      }
    }

    @Override
    public Integer next() {
      moveToNextNum();
      Integer result = currInteger;
      currInteger = null;
      return result;
    }

    @Override
    public boolean hasNext() {
      moveToNextNum();
      return currInteger != null;
    }
  }

  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }
}
/*
 * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
 * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
 */
// leetcode submit region end(Prohibit modification and deletion)
