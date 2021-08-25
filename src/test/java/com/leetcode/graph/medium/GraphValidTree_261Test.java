package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GraphValidTree_261Test {

  private final GraphValidTree_261 solution = new GraphValidTree_261();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}, true),
          arguments(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validTree(int n, int[][] edges, boolean expectedResult) {
    boolean actualResult = solution.validTree(n, edges);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
