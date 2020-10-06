package com.leetcode.queue.easy;

import org.assertj.core.util.DoubleComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovingAverageFromDataStream_346Test {

  @Nested
  class MovingAverage {

    @Test
    @DisplayName("Should return moving average")
    void next() {
      MovingAverageFromDataStream_346.MovingAverage movingAverage =
          new MovingAverageFromDataStream_346.MovingAverage(3);

      List<Double> actualResult = new ArrayList<>();
      for (int el : new int[] {1, 10, 3, 5}) {
        actualResult.add(movingAverage.next(el));
      }

      assertThat(actualResult).isEqualTo(List.of(1.0, 5.5, 4.666666666666667, 6.0));
    }
  }
}
