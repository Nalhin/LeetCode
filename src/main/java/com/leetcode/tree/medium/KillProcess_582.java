package com.leetcode.tree.medium;

// Given n processes, each process has a unique PID (process id) and its PPID (pa
// rent process id).
//
// Each process only has one parent process, but may have one or more children p
// rocesses. This is just like a tree structure. Only one process has PPID that is
// 0, which means this process has no parent process. All the PIDs will be distinct
// positive integers.
//
// We use two list of integers to represent a list of processes, where the first
// list contains PID for each process and the second list contains the correspondi
// ng PPID.
//
// Now given the two lists, and a PID representing a process you want to kill, r
// eturn a list of PIDs of processes that will be killed in the end. You should ass
// ume that when a process is killed, all its children processes will be killed. No
// order is required for the final answer.
//
// Example 1:
//
// Input:
// pid =  [1, 3, 10, 5]
// ppid = [3, 0, 5, 3]
// kill = 5
// Output: [5,10]
// Explanation:
//           3
//         /   \
//        1     5
//             /
//            10
// Kill 5 will also kill 10.
//
//
//
// Note:
//
// The given kill id is guaranteed to be one of the given PIDs.
// n >= 1.
//
// Related Topics Tree Queue
// 👍 599 👎 14

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(n) Runtime: 21 ms, faster than 78.84% of Java online submissions for Kill Process.
 O(n) Memory Usage: 47.2 MB, less than 91.88% of Java online submissions for Kill Process.
*/
public class KillProcess_582 {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, List<Integer>> childParent = new HashMap<>();

    for (int i = 0; i < pid.size(); i++) {
      List<Integer> children = childParent.getOrDefault(ppid.get(i), new ArrayList<>());
      children.add(pid.get(i));
      childParent.put(ppid.get(i), children);
    }

    Deque<Integer> queue = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();

    queue.add(kill);

    while (!queue.isEmpty()) {
      int curr = queue.pop();
      result.add(curr);

      if (childParent.containsKey(curr)) {
        queue.addAll(childParent.get(curr));
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
