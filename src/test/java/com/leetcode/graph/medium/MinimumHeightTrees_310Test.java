package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumHeightTrees_310Test {

  private final MinimumHeightTrees_310 solution = new MinimumHeightTrees_310();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}, List.of(1)),
          arguments(6, new int[][] {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}, List.of(3, 4)),
          arguments(1, new int[][] {{}}, List.of(0)),
          arguments(2, new int[][] {{0, 1}}, List.of(0, 1)),
          arguments(6, new int[][] {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}, List.of(3)),
          arguments(
              8, new int[][] {{0, 1}, {1, 2}, {2, 3}, {0, 4}, {4, 5}, {4, 6}, {6, 7}}, List.of(0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minPathSum(int n, int[][] edges, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.findMinHeightTrees(n, edges);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
