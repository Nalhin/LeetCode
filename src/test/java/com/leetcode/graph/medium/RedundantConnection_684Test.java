package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RedundantConnection_684Test {

  private final RedundantConnection_684 solution = new RedundantConnection_684();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2}, {1, 3}, {2, 3}}, new int[] {2, 3}),
          arguments(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}, new int[] {1, 4}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findRedundantConnection(int[][] heights, int[] expectedResult) {
    int[] actualResult = solution.findRedundantConnection(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
