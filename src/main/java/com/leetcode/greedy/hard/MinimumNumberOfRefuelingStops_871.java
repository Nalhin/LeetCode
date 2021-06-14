package com.leetcode.greedy.hard;

// A car travels from a starting position to a destination which is target miles
// east of the starting position.
//
// Along the way, there are gas stations. Each station[i] represents a gas stati
// on that is station[i][0] miles east of the starting position, and has station[i]
// [1] liters of gas.
//
// The car starts with an infinite tank of gas, which initially has startFuel li
// ters of fuel in it. It uses 1 liter of gas per 1 mile that it drives.
//
// When the car reaches a gas station, it may stop and refuel, transferring all
// the gas from the station into the car.
//
// What is the least number of refueling stops the car must make in order to rea
// ch its destination? If it cannot reach the destination, return -1.
//
// Note that if the car reaches a gas station with 0 fuel left, the car can stil
// l refuel there. If the car reaches the destination with 0 fuel left, it is still
// considered to have arrived.
//
//
//
//
// Example 1:
//
//
// Input: target = 1, startFuel = 1, stations = []
// Output: 0
// Explanation: We can reach the target without refueling.
//
//
//
// Example 2:
//
//
// Input: target = 100, startFuel = 1, stations = [[10,100]]
// Output: -1
// Explanation: We can't reach the target (or even the first gas station).
//
//
//
// Example 3:
//
//
// Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,4
// 0]]
// Output: 2
// Explanation:
// We start with 10 liters of fuel.
// We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters
// to 60 liters of gas.
// Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
// and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the
// target.
// We made 2 refueling stops along the way, so we return 2.
//
//
//
//
// Note:
//
//
// 1 <= target, startFuel, stations[i][1] <= 10^9
// 0 <= stations.length <= 500
// 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] <
// target
//
//
//
//
// Related Topics Dynamic Programming Heap
// 👍 1632 👎 35
/*
 O(nlog(n)) Runtime: 4 ms, faster than 55.52% of Java online submissions for Minimum Number of Refueling Stops.
 O(n) Memory Usage: 38.8 MB, less than 88.61% of Java online submissions for Minimum Number of Refueling Stops.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops_871 {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    Queue<Integer> visitedStations = new PriorityQueue<>(Comparator.comparingInt(val -> -val));
    int result = 0;

    int currFuel = startFuel;
    int currDist = 0;

    for (int[] station : stations) {
      int nextStop = Math.min(station[0], target);
      currFuel -= nextStop - currDist;

      while (currFuel < 0) {
        if (visitedStations.isEmpty()) {
          return -1;
        }
        currFuel += visitedStations.poll();
        result++;
      }

      currDist = nextStop;
      visitedStations.add(station[1]);

      if (currDist >= target) {
        return result;
      }
    }

    while (currDist < target) {
      if (currFuel == 0) {
        if (visitedStations.isEmpty()) {
          return -1;
        }
        currFuel += visitedStations.poll();
        result++;
      }

      currDist += currFuel;
      currFuel = 0;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
