package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfDistancesInTree_834Test {

  private final SumOfDistancesInTree_834 solution = new SumOfDistancesInTree_834();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              6,
              new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}},
              new int[] {8, 12, 6, 10, 10, 10}),
          arguments(1, new int[0][0], new int[] {0}),
          arguments(2, new int[][] {{1, 0}}, new int[] {1, 1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sumOfDistancesInTree(int n, int[][] edges, int[] expectedResult) {
    int[] actualResult = solution.sumOfDistancesInTree(n, edges);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
