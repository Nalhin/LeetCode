package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveCoveredIntervals_1288Test {

  private final RemoveCoveredIntervals_1288 solution = new RemoveCoveredIntervals_1288();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 4}, {3, 6}, {2, 8}}, 2),
          arguments(new int[][] {{1, 4}, {2, 3}}, 1),
          arguments(new int[][] {{0, 10}, {5, 12}}, 2),
          arguments(new int[][] {{3, 10}, {4, 10}, {5, 11}}, 2),
          arguments(new int[][] {{1, 2}, {1, 4}, {3, 4}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeCoveredIntervals(int[][] intervals, int expectedResult) {

    int actualResult = solution.removeCoveredIntervals(intervals);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
