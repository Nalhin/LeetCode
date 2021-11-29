package com.leetcode.graph.medium;

// Given a list of accounts where each element accounts[i] is a list of strings,
// where the first element accounts[i][0] is a name, and the rest of the elements
// are emails representing emails of the account.
//
// Now, we would like to merge these accounts. Two accounts definitely belong
// to the same person if there is some common email to both accounts. Note that even
// if two accounts have the same name, they may belong to different people as
// people could have the same name. A person can have any number of accounts initially,
// but all of their accounts definitely have the same name.
//
// After merging the accounts, return the accounts in the following format: the
// first element of each account is the name, and the rest of the elements are
// emails in sorted order. The accounts themselves can be returned in any order.
//
//
// Example 1:
//
//
// Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],[
// "John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John",
// "johnnybravo@mail.com"]]
// Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.
// com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
// Explanation:
// The first and second John's are the same person as they have the common email
// "johnsmith@mail.com".
// The third John and Mary are different people as none of their email addresses
// are used by other accounts.
// We could return these lists in any order, for example the answer [['Mary',
// 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
// ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
// would still be accepted.
//
//
// Example 2:
//
//
// Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
// "Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
// "Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@
// m.co","Fern1@m.co","Fern0@m.co"]]
// Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.
// co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.
// co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co",
// "Fern1@m.co","Fern5@m.co"]]
//
//
//
// Constraints:
//
//
// 1 <= accounts.length <= 1000
// 2 <= accounts[i].length <= 10
// 1 <= accounts[i][j] <= 30
// accounts[i][0] consists of English letters.
// accounts[i][j] (for j > 0) is a valid email.
//
// Related Topics Array String Depth-First Search Breadth-First Search Union
// Find 👍 3471 👎 623
/*
 O(nmlog(nm)) Runtime: 42 ms, faster than 52.81% of Java online submissions for Accounts Merge.
 O(nm) Memory Usage: 43.3 MB, less than 83.81% of Java online submissions for Accounts Merge.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class AccountsMerge_721 {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Dsu dsu = new Dsu();

    for (List<String> userAccounts : accounts) {
      for (int i = 1; i < userAccounts.size() - 1; i++) {
        dsu.union(userAccounts.get(i), userAccounts.get(i + 1));
      }
    }

    Map<String, Set<String>> groups = new HashMap<>();
    for (List<String> userAccounts : accounts) {
      for (int i = 1; i < userAccounts.size(); i++) {
        groups
            .computeIfAbsent(dsu.root(userAccounts.get(i)), (k) -> new TreeSet<>())
            .add(userAccounts.get(i));
      }
    }

    List<List<String>> result = new ArrayList<>();

    for (List<String> userAccounts : accounts) {
      String user = userAccounts.get(0);
      String groupRoot = dsu.root(userAccounts.get(1));
      if (groups.containsKey(groupRoot)) {
        Set<String> currGroup = groups.get(groupRoot);

        List<String> resGroup = new ArrayList<>();
        resGroup.add(user);
        resGroup.addAll(currGroup);
        result.add(resGroup);
        groups.remove(groupRoot);
      }
    }

    return result;
  }

  private static class Dsu {
    private final Map<String, Integer> rank = new HashMap<>();
    private final Map<String, String> root = new HashMap<>();

    private String root(String a) {
      if (root.getOrDefault(a, a).equals(a)) {
        return a;
      }
      root.put(a, root(root.get(a)));
      return root.get(a);
    }

    private void union(String a, String b) {
      String rootA = root(a);
      String rootB = root(b);

      if (rootA.equals(rootB)) {
        return;
      }

      if (rank.getOrDefault(rootA, 0).equals(rank.getOrDefault(rootB, 0))) {
        root.put(rootB, rootA);
        rank.merge(rootA, 1, Integer::sum);
      } else if (rank.getOrDefault(rootA, 0) > rank.getOrDefault(rootB, 0)) {
        root.put(rootB, rootA);
      } else {
        root.put(rootA, rootB);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
