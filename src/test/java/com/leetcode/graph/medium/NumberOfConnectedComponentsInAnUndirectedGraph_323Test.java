package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfConnectedComponentsInAnUndirectedGraph_323Test {

  private final NumberOfConnectedComponentsInAnUndirectedGraph_323 solution =
      new NumberOfConnectedComponentsInAnUndirectedGraph_323();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}, 2),
          arguments(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countComponents(int n, int[][] edges, int expectedResult) {
    int actualResult = solution.countComponents(n, edges);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
