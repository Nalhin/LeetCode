package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfDiceRollsWithTargetSum_1155Test {
  private final NumberOfDiceRollsWithTargetSum_1155 solution =
      new NumberOfDiceRollsWithTargetSum_1155();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 6, 3, 1),
          arguments(2, 6, 7, 6),
          arguments(2, 5, 10, 1),
          arguments(1, 2, 3, 0),
          arguments(30, 30, 500, 222616187));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numRollsToTarget(int d, int f, int target, int expectedResult) {
    int actualResult = solution.numRollsToTarget(d, f, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
