package com.leetcode.linkedlists.medium;

// You are given a doubly linked list which in addition to the next and previous
// pointers, it could have a child pointer, which may or may not point to a separat
// e doubly linked list. These child lists may have one or more children of their o
// wn, and so on, to produce a multilevel data structure, as shown in the example b
// elow.
//
// Flatten the list so that all the nodes appear in a single-level, doubly linke
// d list. You are given the head of the first level of the list.
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
// Explanation:
//
// The multilevel linked list in the input is as follows:
//
//
//
// After flattening the multilevel linked list it becomes:
//
//
//
//
// Example 2:
//
//
// Input: head = [1,2,null,3]
// Output: [1,3,2]
// Explanation:
//
// The input multilevel linked list is as follows:
//
//  1---2---NULL
//  |
//  3---NULL
//
//
// Example 3:
//
//
// Input: head = []
// Output: []
//
//
//
//
// How multilevel linked list is represented in test case:
//
// We use the multilevel linked list from Example 1 above:
//
//
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//
// The serialization of each level is as follows:
//
//
// [1,2,3,4,5,6,null]
// [7,8,9,10,null]
// [11,12,null]
//
//
// To serialize all levels together we will add nulls in each level to signify n
// o node connects to the upper node of the previous level. The serialization becom
// es:
//
//
// [1,2,3,4,5,6,null]
// [null,null,7,8,9,10,null]
// [null,11,12,null]
//
//
// Merging the serialization of each level and removing trailing nulls we obtain
// :
//
//
// [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//
//
// Constraints:
//
//
// Number of Nodes will not exceed 1000.
// 1 <= Node.val <= 10^5
//
// Related Topics Linked List Depth-first Search
// 👍 1688 👎 171

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

public class FlattenAMultilevelDoublyLinkedList_430 {
  private static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  public Node flatten(Node head) {
    if(head == null){
      return null;
    }
    Node first = new Node();
    first.next = head;
    flattenDFS(first, head);
    first.next.prev = null;
    return first.next;
  }

  private Node flattenDFS(Node prev, Node curr){
    if(curr == null){
      return prev;
    }
    curr.prev = prev;
    prev.next = curr;

    Node tempNext = curr.next;

    Node tail = flattenDFS(curr, curr.child);
    curr.child = null;

    return flattenDFS(tail, tempNext);
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100% of Java online submissions for Flatten a Multilevel Doubly Linked List.
  O(n) Memory Usage: 38.9 MB, less than 24.38% of Java online submissions for Flatten a Multilevel Doubly Linked List.
 */

// leetcode submit region end(Prohibit modification and deletion)
