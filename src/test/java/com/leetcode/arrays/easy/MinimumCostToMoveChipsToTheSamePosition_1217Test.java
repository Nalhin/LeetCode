package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumCostToMoveChipsToTheSamePosition_1217Test {
  private final MinimumCostToMoveChipsToTheSamePosition_1217 solution =
      new MinimumCostToMoveChipsToTheSamePosition_1217();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3}, 1),
          arguments(new int[] {2, 2, 2, 3, 3}, 2),
          arguments(new int[] {1, 100000000}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostToMoveChips(int[] input, int expectedResult) {
    int actualResult = solution.minCostToMoveChips(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
