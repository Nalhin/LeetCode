package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumCostToConnectSticks_1167Test {

  private final MinimumCostToConnectSticks_1167 solution = new MinimumCostToConnectSticks_1167();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 4, 3}, 14),
          arguments(new int[] {1, 8, 3, 5}, 30),
          arguments(new int[] {5}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void connectSticks(int[] sticks, int expectedResult) {
    int actualResult = solution.connectSticks(sticks);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
