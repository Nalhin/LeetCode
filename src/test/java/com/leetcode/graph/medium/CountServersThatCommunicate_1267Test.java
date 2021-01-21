package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountServersThatCommunicate_1267Test {

  private final CountServersThatCommunicate_1267 solution = new CountServersThatCommunicate_1267();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 0}, {0, 1}}, 0),
          arguments(new int[][] {{1, 0}, {1, 1}}, 3),
          arguments(new int[][] {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countServers(int[][] grid, int expectedResult) {
    int actualResult = solution.countServers(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
