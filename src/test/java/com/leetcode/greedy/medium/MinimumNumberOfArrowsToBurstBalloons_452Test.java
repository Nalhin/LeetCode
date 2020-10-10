package com.leetcode.greedy.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfArrowsToBurstBalloons_452Test {

  private final MinimumNumberOfArrowsToBurstBalloons_452 solution =
      new MinimumNumberOfArrowsToBurstBalloons_452();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
          arguments(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
          arguments(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2),
          arguments(new int[][] {{1, 2}}, 1),
          arguments(new int[][] {{2, 3}, {2, 3}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMinArrowShots(int[][] intervals, int expectedResult) {

    int actualResult = solution.findMinArrowShots(intervals);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
