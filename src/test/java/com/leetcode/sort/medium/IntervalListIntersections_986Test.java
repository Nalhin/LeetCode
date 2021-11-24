package com.leetcode.sort.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntervalListIntersections_986Test {

  private final IntervalListIntersections_986 solution = new IntervalListIntersections_986();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
              new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}},
              new int[][] {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}),
          arguments(new int[][] {{1, 3}, {5, 9}}, new int[][] {}, new int[][] {}),
          arguments(new int[][] {}, new int[][] {{4, 8}, {10, 12}}, new int[][] {}),
          arguments(new int[][] {{1, 7}}, new int[][] {{3, 10}}, new int[][] {{3, 7}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void intervalIntersection(int[][] firstList, int[][] secondList, int[][] expectedResult) {
    int[][] actualResult = solution.intervalIntersection(firstList, secondList);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
