package com.leetcode.hashtable.easy;

// You are given a data structure of employee information, which includes the emp
// loyee's unique id, their importance value and their direct subordinates' id.
//
// For example, employee 1 is the leader of employee 2, and employee 2 is the le
// ader of employee 3. They have importance value 15, 10 and 5, respectively. Then
// employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3
// ]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subor
// dinate of employee 1, the relationship is not direct.
//
// Now given the employee information of a company, and an employee id, you need
// to return the total importance value of this employee and all their subordinate
// s.
//
// Example 1:
//
//
// Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
// Output: 11
// Explanation:
// Employee 1 has importance value 5, and he has two direct subordinates: employe
// e 2 and employee 3. They both have importance value 3. So the total importance v
// alue of employee 1 is 5 + 3 + 3 = 11.
//
//
//
//
// Note:
//
//
// One employee has at most one direct leader and may have several subordinates.
//
// The maximum number of employees won't exceed 2000.
//
// Related Topics Hash Table Depth-first Search Breadth-first Search
// 👍 732 👎 709

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImportance_690 {
  private static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  }

  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e));
    return getImportanceDFS(map, id);
  }

  private int getImportanceDFS(Map<Integer, Employee> employees, int id) {
    Employee emp = employees.get(id);
    return emp.importance
        + emp.subordinates.stream()
            .reduce(0, (s1, s2) -> s1 + getImportanceDFS(employees, s2), Integer::sum);
  }
}

/*
  O(n) Runtime: 19 ms, faster than 5.53% of Java online submissions for Employee Importance.
  O(n) Memory Usage: 40.9 MB, less than 53.64% of Java online submissions for Employee Importance.
*/
// leetcode submit region end(Prohibit modification and deletion)
