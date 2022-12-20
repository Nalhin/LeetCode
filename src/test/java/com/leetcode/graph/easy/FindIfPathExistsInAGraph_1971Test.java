package com.leetcode.graph.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindIfPathExistsInAGraph_1971Test {
private final FindIfPathExistsInAGraph_1971 solution = new FindIfPathExistsInAGraph_1971();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2, true),
          arguments(6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5, false)
      );
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validPath(int n, int[][] edges, int source, int destination, boolean expectedResult) {
    boolean actualResult = solution.validPath(n, edges, source, destination);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}