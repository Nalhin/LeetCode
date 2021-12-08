package com.leetcode.stack.medium;

import java.util.List;

/*
 O(N) Runtime: 4 ms, faster than 7.54% of Java online submissions for Nested List Weight Sum II.
 O(N) Memory Usage: 38.8 MB, less than 6.66% of Java online submissions for Nested List Weight Sum II.
*/
public class NestedListWeightSumII_364 {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int max = nestedList.stream().mapToInt(this::maxDepth).max().getAsInt();

    return nestedList.stream().mapToInt(i -> getSize(i, 0, max)).sum();
  }

  private int getSize(NestedInteger integer, int currDepth, int maxDepth) {
    if (integer.isInteger()) {
      return (maxDepth - currDepth + 1) * integer.getInteger();
    }

    int sum = 0;

    for (NestedInteger currInt : integer.getList()) {
      sum += getSize(currInt, currDepth + 1, maxDepth);
    }
    return sum;
  }

  private int maxDepth(NestedInteger nestedInteger) {
    if (nestedInteger.isInteger()) {
      return 0;
    }

    int max = 0;

    for (NestedInteger integer : nestedInteger.getList()) {
      max = Math.max(maxDepth(integer), max);
    }

    return max + 1;
  }

  interface NestedInteger {

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
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
  }
}
