package com.leetcode.greedy.hard;

// You are given two integers n and k and two integer arrays speed and efficiency
// both of length n. There are n engineers numbered from 1 to n. speed[i] and effi
// ciency[i] represent the speed and efficiency of the ith engineer respectively.
//
// Choose at most k different engineers out of the n engineers to form a team wi
// th the maximum performance.
//
// The performance of a team is the sum of their engineers' speeds multiplied by
// the minimum efficiency among their engineers.
//
// Return the maximum performance of this team. Since the answer can be a huge n
// umber, return it modulo 109 + 7.
//
//
// Example 1:
//
//
// Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
// Output: 60
// Explanation:
// We have the maximum performance of the team by selecting engineer 2 (with spee
// d=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is,
// performance = (10 + 5) * min(4, 7) = 60.
//
//
// Example 2:
//
//
// Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
// Output: 68
// Explanation:
// This is the same example as the first but k = 3. We can select engineer 1, eng
// ineer 2 and engineer 5 to get the maximum performance of the team. That is, perf
// ormance = (2 + 10 + 5) * min(5, 4, 7) = 68.
//
//
// Example 3:
//
//
// Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
// Output: 72
//
//
//
// Constraints:
//
//
// 1 <= <= k <= n <= 105
// speed.length == n
// efficiency.length == n
// 1 <= speed[i] <= 105
// 1 <= efficiency[i] <= 108
//
// Related Topics Greedy Sort
// 👍 749 👎 34

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nlog(n)) Runtime: 52 ms, faster than 25.07% of Java online submissions for Maximum Performance of a Team.
 O(n) Memory Usage: 51.5 MB, less than 46.97% of Java online submissions for Maximum Performance of a Team.
*/
import java.util.*;

public class MaximumPerformanceOfATeam_1383 {
  private static final int MOD = 1_000_000_007;

  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

    List<Member> members = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      members.add(new Member(speed[i], efficiency[i]));
    }

    members.sort(Comparator.comparingInt(m -> -m.efficiency));
    Queue<Member> pq = new PriorityQueue<>(Comparator.comparingInt(m -> m.speed));

    long result = 0;
    long teamSpeed = 0;

    for (Member member : members) {
      teamSpeed += member.speed;
      pq.add(member);
      if (pq.size() > k) {
        teamSpeed -= pq.remove().speed;
      }

      result = Math.max(result, teamSpeed * member.efficiency);
    }

    return (int) (result % MOD);
  }

  private static final class Member {
    private final int speed;
    private final int efficiency;

    private Member(int speed, int efficiency) {
      this.speed = speed;
      this.efficiency = efficiency;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
