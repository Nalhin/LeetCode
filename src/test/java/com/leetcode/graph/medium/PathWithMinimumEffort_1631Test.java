package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathWithMinimumEffort_1631Test {

  private final PathWithMinimumEffort_1631 solution = new PathWithMinimumEffort_1631();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}, 2),
          arguments(new int[][] {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}, 1),
          arguments(
              new int[][] {
                {1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
              },
              0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumEffortPath(int[][] heights, int expectedResult) {
    int actualResult = solution.minimumEffortPath(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
