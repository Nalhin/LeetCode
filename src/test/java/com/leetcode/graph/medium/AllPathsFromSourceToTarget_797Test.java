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

class AllPathsFromSourceToTarget_797Test {
  private final AllPathsFromSourceToTarget_797 solution = new AllPathsFromSourceToTarget_797();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {1, 2},
                {
                  3,
                },
                {3},
                {}
              },
              List.of(List.of(0, 1, 3), List.of(0, 2, 3))),
          arguments(
              new int[][] {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
              List.of(
                  List.of(0, 4),
                  List.of(0, 3, 4),
                  List.of(0, 1, 3, 4),
                  List.of(0, 1, 2, 3, 4),
                  List.of(0, 1, 4))),
          arguments(new int[][] {{1}, {}}, List.of(List.of(0, 1))),
          arguments(
              new int[][] {{1, 2, 3}, {2}, {3}, {}},
              List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3))),
          arguments(
              new int[][] {{1, 3}, {2}, {3}, {}}, List.of(List.of(0, 1, 2, 3), List.of(0, 3))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void allPathsSourceTarget(int[][] graph, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.allPathsSourceTarget(graph);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
