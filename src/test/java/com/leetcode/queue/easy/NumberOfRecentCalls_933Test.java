package com.leetcode.queue.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class NumberOfRecentCalls_933Test {

  @Nested
  class RecentCounterClass {

    @Test
    @DisplayName("Should remove outdated ping")
    void removesOutdated() {
      NumberOfRecentCalls_933.RecentCounter recentCounter = new NumberOfRecentCalls_933.RecentCounter();
      recentCounter.ping(1);

      int actualResult = recentCounter.ping(3002);

      assertThat(actualResult).isEqualTo(1);
    }
  }
}
