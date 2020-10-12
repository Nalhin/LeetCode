package com.leetcode.arrays.medium;

// There are N rooms and you start in room 0. Each room has a distinct number in
// 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
//
// Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] i
// s an integer in [0, 1, ..., N-1] where N = rooms.length. A key rooms[i][j] = v o
// pens the room with number v.
//
// Initially, all the rooms start locked (except for room 0).
//
// You can walk back and forth between rooms freely.
//
// Return true if and only if you can enter every room.
//
//
//
//
// Example 1:
//
//
// Input: [[1],[2],[3],[]]
// Output: true
// Explanation:
// We start in room 0, and pick up key 1.
// We then go to room 1, and pick up key 2.
// We then go to room 2, and pick up key 3.
// We then go to room 3.  Since we were able to go to every room, we return true.
//
//
//
// Example 2:
//
//
// Input: [[1,3],[3,0,1],[2],[0]]
// Output: false
// Explanation: We can't enter the room with number 2.
//
//
// Note:
//
//
// 1 <= rooms.length <= 1000
// 0 <= rooms[i].length <= 1000
// The number of keys in all rooms combined is at most 3000.
//
// Related Topics Depth-first Search Graph
// 👍 1190 👎 88

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class KeysAndRooms_841 {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    Deque<Integer> toVisit = new ArrayDeque<>();

    toVisit.add(0);
    visited.add(0);

    while (!toVisit.isEmpty()) {
      int room = toVisit.pop();

      List<Integer> keysInRoom = rooms.get(room);

      for (Integer key : keysInRoom) {
        if (!visited.contains(key)) {
          visited.add(key);
          toVisit.push(key);
        }
      }
    }

    return visited.size() == rooms.size();
  }
}
/*
 O(n + m) Runtime: 2 ms, faster than 51.70% of Java online submissions for Keys and Rooms.
 O(n)   Memory Usage: 38.8 MB, less than 6.20% of Java online submissions for Keys and Rooms.
 where:
 n - number of rooms
 m - number of keys in a room
 */
// leetcode submit region end(Prohibit modification and deletion)
