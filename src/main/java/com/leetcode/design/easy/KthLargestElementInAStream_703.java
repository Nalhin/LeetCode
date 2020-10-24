package com.leetcode.design.easy;

// Design a class to find the kth largest element in a stream. Note that it is th
// e kth largest element in the sorted order, not the kth distinct element.
//
// Implement KthLargest class:
//
//
// KthLargest(int k, int[] nums) Initializes the object with the integer k and t
// he stream of integers nums.
// int add(int val) Returns the element representing the kth largest element in
// the stream.
//
//
//
// Example 1:
//
//
// Input
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output
// [null, 4, 5, 5, 8, 8]
//
// Explanation
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3);   // return 4
// kthLargest.add(5);   // return 5
// kthLargest.add(10);  // return 5
// kthLargest.add(9);   // return 8
// kthLargest.add(4);   // return 8
//
//
//
// Constraints:
//
//
// 1 <= k <= 104
// 0 <= nums.length <= 104
// -104 <= nums[i] <= 104
// -104 <= val <= 104
// At most 104 calls will be made to add.
// It is guaranteed that there will be at least k elements in the array when you
// search for the kth element.
//
// Related Topics Heap Design
// 👍 934 👎 497

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream_703 {
  /*
   O(log(n)) Runtime: 16 ms, faster than 71.28% of Java online submissions for Kth Largest Element in a Stream.
   O(n) Memory Usage: 44.4 MB, less than 12.54% of Java online submissions for Kth Largest Element in a Stream.
  */
  static class KthLargest {

    private final int k;
    private final Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.pq = new PriorityQueue<>(k);
      for (int num : nums) {
        add(num);
      }
    }

    public int add(int val) {
      pq.offer(val);
      if (pq.size() > k) {
        pq.poll();
      }
      return pq.peek();
    }
  }
}
/*
 * Your KthLargest object will be instantiated and called as such: KthLargest obj = new
 * KthLargest(k, nums); int param_1 = obj.add(val);
 */
// leetcode submit region end(Prohibit modification and deletion)
