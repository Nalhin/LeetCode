package com.leetcode.design.medium;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Given an Iterator class interface with methods: next() and hasNext(), design a
// nd implement a PeekingIterator that support the peek() operation -- it essential
// ly peek() at the element that will be returned by the next call to next().
//
// Example:
//
//
// Assume that the iterator is initialized to the beginning of the list: [1,2,3].
//
//
// Call next() gets you 1, the first element in the list.
// Now you call peek() and it returns 2, the next element. Calling next() after t
// hat still return 2.
// You call next() the final time and it returns 3, the last element.
// Calling hasNext() after that should return false.
//
//
// Follow up: How would you extend your design to be generic and work with all t
// ypes, not just integer?
// Related Topics Design
// 👍 643 👎 462

// leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

/*
 O(n) Runtime: 4 ms, faster than 94.49% of Java online submissions for Peeking Iterator.
 O(n) Memory Usage: 39.1 MB, less than 47.05% of Java online submissions for Peeking Iterator.
*/
public class PeekingIterator_284 {

  static class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
      this.iterator = iterator;
      advanceNext();
    }

    private void advanceNext() {
      if (iterator.hasNext()) {
        this.next = iterator.next();
      } else {
        next = null;
      }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if (next == null) {
        throw new NoSuchElementException();
      }
      return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      Integer result = next;
      advanceNext();
      return result;
    }

    @Override
    public boolean hasNext() {
      return next != null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}
