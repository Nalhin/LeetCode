package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CombinationSumII_40Test {

  private final CombinationSumII_40 solution = new CombinationSumII_40();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {10, 1, 2, 7, 6, 1, 5},
              8,
              List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6))),
          arguments(new int[] {2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void combinationSum2(int[] candidates, int target, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.combinationSum2(candidates, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
