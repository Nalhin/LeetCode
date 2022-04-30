package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinCostToConnectAllPoints_1584Test {

  private final MinCostToConnectAllPoints_1584 solution = new MinCostToConnectAllPoints_1584();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}, 20),
          arguments(new int[][] {{3, 12}, {-2, 5}, {-4, 1}}, 18));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostConnectPoints(int[][] points, int expectedResult) {
    int actualResult = solution.minCostConnectPoints(points);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
