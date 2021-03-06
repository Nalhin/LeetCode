package com.leetcode.bfs.medium;

// There are n people, each person has a unique id between 0 and n-1. Given the a
// rrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain t
// he list of watched videos and the list of friends respectively for the person wi
// th id = i.
//
// Level 1 of videos are all watched videos by your friends, level 2 of videos a
// re all watched videos by the friends of your friends and so on. In general, the
// level k of videos are all watched videos by people with the shortest path exactl
// y equal to k with you. Given your id and the level of videos, return the list of
// videos ordered by their frequencies (increasing). For videos with the same freq
// uency order them alphabetically from least to greatest.
//
//
// Example 1:
//
//
//
//
// Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,
// 3],[0,3],[1,2]], id = 0, level = 1
// Output: ["B","C"]
// Explanation:
// You have id = 0 (green color in the figure) and your friends are (yellow color
// in the figure):
// Person with id = 1 -> watchedVideos = ["C"]
// Person with id = 2 -> watchedVideos = ["B","C"]
// The frequencies of watchedVideos by your friends are:
// B -> 1
// C -> 2
//
//
// Example 2:
//
//
//
//
// Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,
// 3],[0,3],[1,2]], id = 0, level = 2
// Output: ["D"]
// Explanation:
// You have id = 0 (green color in the figure) and the only friend of your friend
// s is the person with id = 3 (yellow color in the figure).
//
//
//
// Constraints:
//
//
// n == watchedVideos.length == friends.length
// 2 <= n <= 100
// 1 <= watchedVideos[i].length <= 100
// 1 <= watchedVideos[i][j].length <= 8
// 0 <= friends[i].length < n
// 0 <= friends[i][j] < n
// 0 <= id < n
// 1 <= level < n
// if friends[i] contains j, then friends[j] contains i
//
// Related Topics Hash Table String Breadth-first Search
// 👍 143 👎 219

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * log(m)) Runtime: 27 ms, faster than 70.51% of Java online submissions for Get Watched Videos by Your Friends.
 O(n) Memory Usage: 40.6 MB, less than 90.78% of Java online submissions for Get Watched Videos by Your Friends.
*/
import java.util.*;
import java.util.stream.Collectors;

public class GetWatchedVideosByYourFriends_1311 {
  public List<String> watchedVideosByFriends(
      List<List<String>> watchedVideos, int[][] friends, int id, int level) {
    boolean[] visited = new boolean[friends.length];

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(id);
    visited[id] = true;

    while (!queue.isEmpty() && level > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int prev = queue.poll();

        for (int friend : friends[prev]) {
          if (!visited[friend]) {
            visited[friend] = true;
            queue.add(friend);
          }
        }
      }
      level--;
    }

    HashMap<String, Integer> counter = new HashMap<>();
    for (Integer index : queue) {
      for (String video : watchedVideos.get(index)) {
        counter.put(video, counter.getOrDefault(video, 0) + 1);
      }
    }

    return counter.entrySet().stream()
        .sorted(
            (a, b) ->
                a.getValue().equals(b.getValue())
                    ? a.getKey().compareTo(b.getKey())
                    : a.getValue() - b.getValue())
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
// leetcode submit region end(Prohibit modification and deletion)
