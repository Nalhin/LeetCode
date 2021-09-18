package com.leetcode.binarysearch.hard;

/*
 O(nlog(W)) Runtime: 16 ms, faster than 69.71% of Java online submissions for Minimize Max Distance to Gas Station.
 O(n) Memory Usage: 46 MB, less than 26.23% of Java online submissions for Minimize Max Distance to Gas Station.
*/
public class MinimizeDistanceToGasStation_774 {

  public double minmaxGasDist(int[] stations, int k) {
    double min = 0;
    double max = stations[stations.length - 1] - stations[0];

    while (max - min > 1e-6) {

      double mid = (min + max) / 2;

      if (possible(mid, stations, k)) {
        max = mid;
      } else {
        min = mid;
      }
    }

    return min;
  }

  private boolean possible(double mid, int[] stations, int k) {

    for (int i = 0; i < stations.length - 1; i++) {
      double dist = stations[i + 1] - stations[i];
      k -=  (int) Math.ceil(dist / mid) - 1;
    }

    return k >= 0;
  }
}
