package utils;

public class LinkedList {

  public static ListNode of(int first, int... args) {
    ListNode result = new ListNode(first, new ListNode());
    ListNode next = result.next;
    ListNode prev = null;
    for (int i : args) {
      next.val = i;
      next.next = new ListNode();
      prev = next;
      next = next.next;
    }
    if (prev != null) {
      prev.next = null;
    }
    return result;
  }

  public static ListNode empty() {
    return null;
  }

  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
