package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumOperationsToReduceXToZero_1658Test {
  private final MinimumOperationsToReduceXToZero_1658 solution =
      new MinimumOperationsToReduceXToZero_1658();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 4, 2, 3}, 5, 2),
          arguments(new int[] {5, 6, 7, 8, 9}, 4, -1),
          arguments(new int[] {3, 2, 20, 1, 1, 3}, 10, 5),
          arguments(new int[] {1, 1}, 3, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minOperations(int[] nums, int x, int expectedResult) {
    int actualResult = solution.minOperations(nums, x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
