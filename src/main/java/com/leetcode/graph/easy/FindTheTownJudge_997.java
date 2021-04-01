package com.leetcode.graph.easy;

// In a town, there are N people labelled from 1 to N. There is a rumor that one
// of these people is secretly the town judge.
//
// If the town judge exists, then:
//
//
// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
//
//
// You are given trust, an array of pairs trust[i] = [a, b] representing that th
// e person labelled a trusts the person labelled b.
//
// If the town judge exists and can be identified, return the label of the town
// judge. Otherwise, return -1.
//
//
// Example 1:
// Input: N = 2, trust = [[1,2]]
// Output: 2
// Example 2:
// Input: N = 3, trust = [[1,3],[2,3]]
// Output: 3
// Example 3:
// Input: N = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1
// Example 4:
// Input: N = 3, trust = [[1,2],[2,3]]
// Output: -1
// Example 5:
// Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
// Output: 3
//
//
// Constraints:
//
//
// 1 <= N <= 1000
// 0 <= trust.length <= 10^4
// trust[i].length == 2
// trust[i] are all different
// trust[i][0] != trust[i][1]
// 1 <= trust[i][0], trust[i][1] <= N
// Related Topics Graph
// 👍 1480 👎 121
/*
  O(n + m) Runtime: 2 ms, faster than 99.69% of Java online submissions for Find the Town Judge.
  O(n) Memory Usage: 47.2 MB, less than 24.19% of Java online submissions for Find the Town Judge.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class FindTheTownJudge_997 {
  public int findJudge(int n, int[][] trust) {
    int[] trustGiven = new int[n + 1];
    int[] trustTaken = new int[n + 1];

    for (int[] trustRelation : trust) {
      trustGiven[trustRelation[0]]++;
      trustTaken[trustRelation[1]]++;
    }

    for (int i = 1; i <= n; i++) {
      if (trustGiven[i] == 0 && trustTaken[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
