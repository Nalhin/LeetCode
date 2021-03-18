package com.leetcode.math.medium;

// Given the radius and x-y positions of the center of a circle, write a function
// randPoint which generates a uniform random point in the circle.
//
// Note:
//
//
// input and output values are in floating-point.
// radius and x-y position of the center of the circle is passed into the class
// constructor.
// a point on the circumference of the circle is considered to be in the circle.
//
// randPoint returns a size 2 array containing x-position and y-position of the
// random point, in that order.
//
//
//
// Example 1:
//
//
// Input:
// ["Solution","randPoint","randPoint","randPoint"]
// [[1,0,0],[],[],[]]
// Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
//
//
//
// Example 2:
//
//
// Input:
// ["Solution","randPoint","randPoint","randPoint"]
// [[10,5,-7.5],[],[],[]]
// Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
//
//
// Explanation of Input Syntax:
//
// The input is two lists: the subroutines called and their arguments. Solution'
// s constructor has three arguments, the radius, x-position of the center, and y-p
// osition of the center of the circle. randPoint has no arguments. Arguments are a
// lways wrapped with a list, even if there aren't any.
//
// Related Topics Math Random Rejection Sampling
// 👍 267 👎 503
/*
 O(1) Runtime: 202 ms, faster than 72.56% of Java online submissions for Generate Random Point in a Circle.
 O(1) Memory Usage: 49.5 MB, less than 57.32% of Java online submissions for Generate Random Point in a Circle.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Random;

public class GenerateRandomPointInACircle_478 {
  static class Solution {
    private final Random random = new Random();

    private final double radius;
    private final double xCenter;
    private final double yCenter;

    public Solution(double radius, double xCenter, double y_center) {
      this.radius = radius;
      this.xCenter = xCenter;
      this.yCenter = y_center;
    }

    public double[] randPoint() {
      double len = Math.sqrt(random.nextDouble()) * radius;
      double deg = random.nextDouble() * 2 * Math.PI;
      double x = xCenter + len * Math.cos(deg);
      double y = yCenter + len * Math.sin(deg);
      return new double[] {x, y};
    }
  }
}

/*
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(radius,
 * x_center, y_center); double[] param_1 = obj.randPoint();
 */
// leetcode submit region end(Prohibit modification and deletion)
