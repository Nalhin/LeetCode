package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReachableNodesInSubdividedGraph_882Test {

  private final ReachableNodesInSubdividedGraph_882 solution =
      new ReachableNodesInSubdividedGraph_882();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3, 13),
          arguments(new int[][] {{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}}, 10, 4, 23),
          arguments(new int[][] {{1, 2, 4}, {1, 4, 5}, {1, 3, 1}, {2, 3, 4}, {3, 4, 5}}, 17, 5, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reachableNodes(int[][] edges, int maxMoves, int n, int expectedResult) {
    int actualResult = solution.reachableNodes(edges, maxMoves, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
