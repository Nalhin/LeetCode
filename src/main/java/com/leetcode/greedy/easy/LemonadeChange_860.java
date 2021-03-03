package com.leetcode.greedy.easy;

// At a lemonade stand, each lemonade costs $5.
//
// Customers are standing in a queue to buy from you, and order one at a time (i
// n the order specified by bills).
//
// Each customer will only buy one lemonade and pay with either a $5, $10, or $2
// 0 bill. You must provide the correct change to each customer, so that the net tr
// ansaction is that the customer pays $5.
//
// Note that you don't have any change in hand at first.
//
// Return true if and only if you can provide every customer with correct change
// .
//
//
//
//
// Example 1:
//
//
// Input: [5,5,5,10,20]
// Output: true
// Explanation:
// From the first 3 customers, we collect three $5 bills in order.
// From the fourth customer, we collect a $10 bill and give back a $5.
// From the fifth customer, we give a $10 bill and a $5 bill.
// Since all customers got correct change, we output true.
//
//
//
// Example 2:
//
//
// Input: [5,5,10]
// Output: true
//
//
//
// Example 3:
//
//
// Input: [10,10]
// Output: false
//
//
//
// Example 4:
//
//
// Input: [5,5,10,10,20]
// Output: false
// Explanation:
// From the first two customers in order, we collect two $5 bills.
// For the next two customers in order, we collect a $10 bill and give back a $5
// bill.
// For the last customer, we can't give change of $15 back because we only have t
// wo $10 bills.
// Since not every customer received correct change, the answer is false.
//
//
//
//
// Note:
//
//
// 0 <= bills.length <= 10000
// bills[i] will be either 5, 10, or 20.
//
//
//
//
//
// Related Topics Greedy
// 👍 783 👎 93

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 3 ms, faster than 26.55% of Java online submissions for Lemonade Change.
 O(1) Memory Usage: 40.2 MB, less than 42.67% of Java online submissions for Lemonade Change.
*/
public class LemonadeChange_860 {
  private static final int BASE_BILL = 5;

  public boolean lemonadeChange(int[] bills) {
    int[] counter = new int[4];

    for (int bill : bills) {
      int i = counter.length - 1;
      int reduced = bill;

      while (reduced > BASE_BILL) {
        while ((i >= 0 && counter[i] == 0) || reduced - indexToBill(i) < BASE_BILL) {
          i--;
        }

        if (i < 0) {
          return false;
        }

        reduced -= indexToBill(i);
        counter[i]--;
      }
      counter[billToIndex(bill)]++;
    }

    return true;
  }

  private int indexToBill(int index) {
    return (index + 1) * BASE_BILL;
  }

  private int billToIndex(int bill) {
    return bill / BASE_BILL - 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
