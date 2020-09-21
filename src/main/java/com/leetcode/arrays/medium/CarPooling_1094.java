package com.leetcode.arrays.medium;

// You are driving a vehicle that has capacity empty seats initially available fo
// r passengers. The vehicle only drives east (ie. it cannot turn around and drive
// west.)
//
// Given a list of trips, trip[i] = [num_passengers, start_location, end_locatio
// n] contains information about the i-th trip: the number of passengers that must
// be picked up, and the locations to pick them up and drop them off. The locations
// are given as the number of kilometers due east from your vehicle's initial loca
// tion.
//
// Return true if and only if it is possible to pick up and drop off all passeng
// ers for all the given trips.
//
//
//
// Example 1:
//
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 4
// Output: false
//
//
//
// Example 2:
//
//
// Input: trips = [[2,1,5],[3,3,7]], capacity = 5
// Output: true
//
//
//
// Example 3:
//
//
// Input: trips = [[2,1,5],[3,5,7]], capacity = 3
// Output: true
//
//
//
// Example 4:
//
//
// Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
// Output: true
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// Constraints:
//
//
// trips.length <= 1000
// trips[i].length == 3
// 1 <= trips[i][0] <= 100
// 0 <= trips[i][1] < trips[i][2] <= 1000
// 1 <= capacity <= 100000
//
// Related Topics Greedy
// 👍 675 👎 29

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Map;
import java.util.TreeMap;

public class CarPooling_1094 {
  public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer,Integer> map = new TreeMap<>();

    for(int[] trip : trips){
      map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
      map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
    }

    int total = 0;

    for(Integer cost : map.values()){
      total += cost;
      if (total > capacity) {
        return false;
      }
    }

    return true;
  }
}

/*
    O(nlogn) Runtime: 5 ms, faster than 66.40% of Java online submissions for Find All Duplicates in an Array.
    O(n)     Memory Usage: 38.7 MB, less than 98.66% of Java online submissions for Find All Duplicates in an Array.
*/

// leetcode submit region end(Prohibit modification and deletion)
