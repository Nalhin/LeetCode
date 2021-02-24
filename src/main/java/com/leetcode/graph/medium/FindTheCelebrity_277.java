package com.leetcode.graph.medium;

// Suppose you are at a party with n people (labeled from 0 to n - 1), and among
// them, there may exist one celebrity. The definition of a celebrity is that all t
// he other n - 1 people know him/her, but he/she does not know any of them.
//
// Now you want to find out who the celebrity is or verify that there is not one
// . The only thing you are allowed to do is to ask questions like: "Hi, A. Do you
// know B?" to get information about whether A knows B. You need to find out the ce
// lebrity (or verify there is not one) by asking as few questions as possible (in
// the asymptotic sense).
//
// You are given a helper function bool knows(a, b) which tells you whether A kn
// ows B. Implement a function int findCelebrity(n). There will be exactly one cele
// brity if he/she is in the party. Return the celebrity's label if there is a cele
// brity in the party. If there is no celebrity, return -1.
//
//
// Example 1:
//
//
// Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
// Output: 1
// Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1
// means person i knows person j, otherwise graph[i][j] = 0 means person i does not
// know person j. The celebrity is the person labeled as 1 because both 0 and 2 kn
// ow him but 1 does not know anybody.
//
//
// Example 2:
//
//
// Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
// Output: -1
// Explanation: There is no celebrity.
//
//
//
// Constraints:
//
//
// n == graph.length
// n == graph[i].length
// 2 <= n <= 100
// graph[i][j] is 0 or 1.
// graph[i][i] == 1
//
//
//
// Follow up: If the maximum number of allowed calls to the API knows is 3 * n, c
// ould you find a solution without exceeding the maximum number of calls? Related
// Topics Array
// 👍 1465 👎 158

// leetcode submit region begin(Prohibit modification and deletion)
/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */
/*
   O(n) Runtime: 19 ms, faster than 78.41% of Java online submissions for Find the Celebrity.
   O(1) Memory Usage: 39.4 MB, less than 51.80% of Java online submissions for Find the Celebrity.
*/
// leetcode submit region end(Prohibit modification and deletion)
public class FindTheCelebrity_277 {
  public int findCelebrity(int n) {
    int candidate = 0;

    for (int i = 0; i < n; i++) {
      if (knows(candidate, i + 1)) {
        candidate = i + 1;
      }
    }

    return isCelebrity(candidate, n) ? candidate : -1;
  }

  private boolean isCelebrity(int candidate, int numOfPeople) {
    for (int i = 0; i < numOfPeople; i++) {
      if (i != candidate && !knows(candidate, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean knows(int a, int b) {
    return false;
  }
}
