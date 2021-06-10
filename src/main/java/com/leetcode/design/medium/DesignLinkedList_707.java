package com.leetcode.design.medium;
// Design your implementation of the linked list. You can choose to use a singly
// or doubly linked list.
// A node in a singly linked list should have two attributes: val and next. val i
// s the value of the current node, and next is a pointer/reference to the next nod
// e.
// If you want to use the doubly linked list, you will need one more attribute pr
// ev to indicate the previous node in the linked list. Assume all nodes in the lin
// ked list are 0-indexed.
//
// Implement the MyLinkedList class:
//
//
// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the indexth node in the linked list. If t
// he index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of t
// he linked list. After the insertion, the new node will be the first node of the
// linked list.
// void addAtTail(int val) Append a node of value val as the last element of the
// linked list.
// void addAtIndex(int index, int val) Add a node of value val before the indext
// h node in the linked list. If index equals the length of the linked list, the no
// de will be appended to the end of the linked list. If index is greater than the
// length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if
// the index is valid.
//
//
//
// Example 1:
//
//
// Input
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex
// ", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output
// [null, null, null, null, 2, null, 3]
//
// Explanation
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3
//
//
//
// Constraints:
//
//
// 0 <= index, val <= 1000
// Please do not use the built-in LinkedList library.
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
// deleteAtIndex.
//
// Related Topics Linked List Design
// 👍 619 👎 742

// leetcode submit region begin(Prohibit modification and deletion)
public class DesignLinkedList_707 {
  private Node head;

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (head == null) {
      return -1;
    }
    Node node = head;
    while (index-- >= 1) {
      node = node.next;
      if (node == null) {
        return -1;
      }
    }

    return node.val;
  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the
   * new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    head = new Node(val, head);
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    if (head == null) {
      head = new Node(val);
      return;
    }

    Node node = head;

    while (node.next != null) {
      node = node.next;
    }

    node.next = new Node(val);
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the
   * length of linked list, the node will be appended to the end of linked list. If index is greater
   * than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index <= 0) {
      addAtHead(val);
      return;
    }

    Node node = head;

    while (index-- > 1 && node.next != null) {
      node = node.next;
    }

    if (index > 0) {
      return;
    }

    Node newNode = new Node(val);

    if (node.next != null) {
      newNode.next = node.next;
    }

    node.next = newNode;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    Node node = head;

    if (index == 0) {
      head = head.next;
      return;
    }

    while (index-- > 1 && node != null) {
      node = node.next;
    }

    if (node != null && node.next != null) {
      node.next = node.next.next;
    }
  }

  private static class Node {

    private Node next;
    private final int val;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

}

/*
    Runtime: 10 ms, faster than 58.70% of Java online submissions for Design Linked List.
    Memory Usage: 40.2 MB, less than 58.10% of Java online submissions for Design Linked List.
 */

/*
 * Your MyLinkedList object will be instantiated and called as such: MyLinkedList obj = new
 * MyLinkedList(); int param_1 = obj.get(index); obj.addAtHead(val); obj.addAtTail(val);
 * obj.addAtIndex(index,val); obj.deleteAtIndex(index);
 */
// leetcode submit region end(Prohibit modification and deletion)
