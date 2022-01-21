package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GasStation_134Test {

  private final GasStation_134 solution = new GasStation_134();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}, 3),
          arguments(new int[] {2, 3, 4}, new int[] {3, 4, 3}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canCompleteCircuit(int[] gas, int[] cost, int expectedResult) {
    int actualResult = solution.canCompleteCircuit(gas, cost);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
