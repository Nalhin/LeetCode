package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NetworkDelayTime_743Test {

  private final NetworkDelayTime_743 solution = new NetworkDelayTime_743();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2),
          arguments(new int[][] {{1, 2, 1}}, 2, 1, 1),
          arguments(new int[][] {{1, 2, 1}}, 2, 2, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void networkDelayTime(int[][] times, int n, int k, int expectedResult) {
    int actualResult = solution.networkDelayTime(times, n, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
