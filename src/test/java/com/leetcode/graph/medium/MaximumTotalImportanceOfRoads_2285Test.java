package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumTotalImportanceOfRoads_2285Test {
  private final MaximumTotalImportanceOfRoads_2285 solution =
      new MaximumTotalImportanceOfRoads_2285();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}, 43),
          arguments(5, new int[][] {{0, 3}, {2, 4}, {1, 3}}, 20));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumImportance(int n, int[][] roads, long expectedResult) {
    long actualResult = solution.maximumImportance(n, roads);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
