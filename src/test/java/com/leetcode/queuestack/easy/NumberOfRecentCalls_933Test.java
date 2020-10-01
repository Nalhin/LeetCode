package com.leetcode.queuestack.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.leetcode.queuestack.easy.NumberOfRecentCalls_933.RecentCounter;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class NumberOfRecentCalls_933Test {

  @Nested
  class RecentCounterClass {

    @Test
    @DisplayName("Should remove outdated ping")
    void removesOutdated() {
      RecentCounter recentCounter = new RecentCounter();
      recentCounter.ping(1);

      int actualResult = recentCounter.ping(3002);

      assertThat(actualResult).isEqualTo(1);
    }
  }
}
