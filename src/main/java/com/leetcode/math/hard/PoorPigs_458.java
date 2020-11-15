package com.leetcode.math.hard;

// There are 1000 buckets, one and only one of them is poisonous, while the rest
// are filled with water. They all look identical. If a pig drinks the poison it wi
// ll die within 15 minutes. What is the minimum amount of pigs you need to figure
// out which bucket is poisonous within one hour?
//
// Answer this question, and write an algorithm for the general case.
//
//
//
// General case:
//
// If there are n buckets and a pig drinking poison will die within m minutes, h
// ow many pigs (x) you need to figure out the poisonous bucket within p minutes? T
// here is exactly one bucket with poison.
//
//
//
// Note:
//
//
// A pig can be allowed to drink simultaneously on as many buckets as one would
// like, and the feeding takes no time.
// After a pig has instantly finished drinking buckets, there has to be a cool d
// own time of m minutes. During this time, only observation is allowed and no feed
// ings at all.
// Any given bucket can be sampled an infinite number of times (by an unlimited
// number of pigs).
// Related Topics Math
// 👍 469 👎 942

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Poor Pigs.
 O(1) Memory Usage: 36 MB, less than 37.35% of Java online submissions for Poor Pigs.
*/
public class PoorPigs_458 {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int pigs = 0;
    while (Math.pow((minutesToTest / minutesToDie + 1), pigs) < buckets) {
      pigs += 1;
    }
    return pigs;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
