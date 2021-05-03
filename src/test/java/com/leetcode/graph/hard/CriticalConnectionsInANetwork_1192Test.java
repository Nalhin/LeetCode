package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CriticalConnectionsInANetwork_1192Test {
  private final CriticalConnectionsInANetwork_1192 solution =
      new CriticalConnectionsInANetwork_1192();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              4,
              List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3)),
              List.of(List.of(1, 3))),
          arguments(
              6,
              List.of(
                  List.of(0, 1),
                  List.of(1, 2),
                  List.of(2, 0),
                  List.of(1, 3),
                  List.of(3, 4),
                  List.of(4, 5),
                  List.of(5, 3)),
              List.of(List.of(1, 3))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void criticalConnections(int n, List<List<Integer>> edges, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.criticalConnections(n, edges);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
