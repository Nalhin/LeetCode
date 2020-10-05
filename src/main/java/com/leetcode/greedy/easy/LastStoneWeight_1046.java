package com.leetcode.greedy.easy;

// We have a collection of stones, each stone has a positive integer weight.
//
// Each turn, we choose the two heaviest stones and smash them together. Suppose
// the stones have weights x and y with x <= y. The result of this smash is:
//
//
// If x == y, both stones are totally destroyed;
// If x != y, the stone of weight x is totally destroyed, and the stone of weigh
// t y has new weight y-x.
//
//
// At the end, there is at most 1 stone left. Return the weight of this stone (o
// r 0 if there are no stones left.)
//
//
//
// Example 1:
//
//
// Input: [2,7,4,1,8,1]
// Output: 1
// Explanation:
// We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
// we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
// we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
// we combine 1 and 1 to get 0 so the array converts to [1] then that's the value
// of last stone.
//
//
//
// Note:
//
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 1000
//
// Related Topics Heap Greedy
// 👍 970 👎 33

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight_1046 {
  public int lastStoneWeight(int[] stones) {
    Queue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
    for (int stone : stones) {
      pq.add(stone);
    }

    while (pq.size() > 1) {

      int y = pq.remove();
      int x = pq.remove();

      if (x != y) {
        pq.add(y - x);
      }
    }

    return pq.isEmpty() ? 0 : pq.element();
  }
}
/*
O(nlog(n)) Runtime: 1 ms, faster than 91.97% of Java online submissions for Last Stone Weight.
O(n)       Memory Usage: 36.1 MB, less than 99.13% of Java online submissions for Last Stone Weight.
*/
// leetcode submit region end(Prohibit modification and deletion)
