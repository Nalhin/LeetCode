package com.leetcode.design.medium;

// Design your implementation of the circular queue. The circular queue is a line
// ar data structure in which the operations are performed based on FIFO (First In
// First Out) principle and the last position is connected front to the first positi
// on to make a circle. It is also called "Ring Buffer".
//
// One of the benefits of the circular queue is that we can make use of the spac
// es in rear of the queue. In a normal queue, once the queue becomes full, we can
// not insert the next element even if there is a space in rear of the queue. But
// using the circular queue, we can use the space to store new values.
//
// Your implementation should support following operations:
//
//
// MyCircularQueue(k): Constructor, set the size of the queue to be k.
// Front: Get the rear item from the queue. If the queue is empty, return -1.
// Rear: Get the last item from the queue. If the queue is empty, return -1.
// enQueue(value): Insert an element into the circular queue. Return true if the
// operation is successful.
// deQueue(): Delete an element from the circular queue. Return true if the oper
// ation is successful.
// isEmpty(): Checks whether the circular queue is empty or not.
// isFull(): Checks whether the circular queue is full or not.
//
//
//
//
// Example:
//
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be
// 3
// circularQueue.enQueue(1);  // return true
// circularQueue.enQueue(2);  // return true
// circularQueue.enQueue(3);  // return true
// circularQueue.enQueue(4);  // return false, the queue is full
// circularQueue.Rear();  // return 3
// circularQueue.isFull();  // return true
// circularQueue.deQueue();  // return true
// circularQueue.enQueue(4);  // return true
// circularQueue.Rear();  // return 4
//
//
//
// Note:
//
//
// All values will be in the range of [0, 1000].
// The number of operations will be in the range of [1, 1000].
// Please do not use the built-in Queue library.
//
// Related Topics Design Queue
// 👍 670 👎 90

// leetcode submit region begin(Prohibit modification and deletion)

public class DesignCircularQueue_622 {

  static class MyCircularQueue {

    public int[] arr;
    public int capacity;
    int rear = -1;
    int front = 0;
    int len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
      this.capacity = k;
      this.arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      rear = next(rear);
      arr[rear] = value;
      len++;
      return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      front = next(front);
      len--;
      return true;
    }

    /** Get the rear item from the queue. */
    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
      if (isEmpty()) {
        return -1;
      }
      return arr[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
      return len == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
      return len == capacity;
    }

    private int next(int n) {
      return (n + 1) % capacity;
    }
  }
}
/*
  O(1) each operation Runtime: 3 ms, faster than 100.00% of Java online submissions for Design Circular Queue.
  O(n) Memory Usage: 39.5 MB, less than 96.16% of Java online submissions for Design Circular Queue.
*/
/*
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new
 * MyCircularQueue(k); boolean param_1 = obj.enQueue(value); boolean param_2 = obj.deQueue(); int
 * param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean param_6
 * = obj.isFull();
 */
// leetcode submit region end(Prohibit modification and deletion)
