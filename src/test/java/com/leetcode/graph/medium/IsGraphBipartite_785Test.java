package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsGraphBipartite_785Test {
  private final IsGraphBipartite_785 solution = new IsGraphBipartite_785();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}, false),
          arguments(new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isBipartite(int[][] graph, boolean expectedResult) {
    boolean actualResult = solution.isBipartite(graph);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
