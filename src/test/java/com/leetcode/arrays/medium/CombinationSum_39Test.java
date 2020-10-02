package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CombinationSum_39Test {

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2}, 1, Collections.emptyList()),
          arguments(
              new int[] {2, 3, 5},
              8,
              List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
          arguments(new int[] {1}, 1, List.of(List.of(1))),
          arguments(new int[] {2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void combinationSum(int[] candidates, int target, List<List<Integer>> expectedResult) {
    CombinationSum_39 solution = new CombinationSum_39();

    List<List<Integer>> actualResult = solution.combinationSum(candidates, target);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
