package com.leetcode.graph.hard;

// Given an array of integers arr, you are initially positioned at the first inde
// x of the array.
//
// In one step you can jump from index i to index:
//
//
// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
//
//
// Return the minimum number of steps to reach the last index of the array.
//
// Notice that you can not jump outside of the array at any time.
//
//
// Example 1:
//
//
// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that in
// dex 9 is the last index of the array.
//
//
// Example 2:
//
//
// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You don't need to jump.
//
//
// Example 3:
//
//
// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index
// of the array.
//
//
// Example 4:
//
//
// Input: arr = [6,1,9]
// Output: 2
//
//
// Example 5:
//
//
// Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
// Output: 3
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 5 * 10^4
// -10^8 <= arr[i] <= 10^8
//
// Related Topics Breadth-first Search
// 👍 380 👎 26

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(n) Runtime: 65 ms, faster than 41.76% of Java online submissions for Jump Game IV.
 O(1) Memory Usage: 61.8 MB, less than 22.61% of Java online submissions for Jump Game IV.
*/
public class JumpGameIV_1345 {
  public int minJumps(int[] arr) {
    boolean[] visited = new boolean[arr.length];
    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      Set<Integer> set = map.getOrDefault(arr[i], new HashSet<>());
      set.add(i);
      map.put(arr[i], set);
    }

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(0);
    visited[0] = true;

    int moves = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        int last = deque.remove();

        if (last == arr.length - 1) {
          return moves;
        }

        if (last - 1 > 0 && !visited[last - 1]) {
          deque.add(last - 1);
          visited[last - 1] = true;
        }
        if (last + 1 < arr.length && !visited[last + 1]) {
          deque.add(last + 1);
          visited[last + 1] = true;
        }

        Set<Integer> set = map.get(arr[last]);
        for (int position : set) {
          if (!visited[position]) {
            visited[position] = true;
            deque.add(position);
          }
        }
        set.clear();
      }
      moves++;
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
