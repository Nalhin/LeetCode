package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AllPathsFromSourceLeadToDestination_1059Test {
  private final AllPathsFromSourceLeadToDestination_1059 solution =
      new AllPathsFromSourceLeadToDestination_1059();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, new int[][] {{0, 1}, {0, 2}}, 0, 2, false),
          arguments(4, new int[][] {{0, 1}, {0, 3}, {1, 2}, {2, 1}}, 0, 3, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void leadsToDestination(
      int n, int[][] edges, int source, int destination, boolean expectedResult) {
    boolean actualResult = solution.leadsToDestination(n, edges, source, destination);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
