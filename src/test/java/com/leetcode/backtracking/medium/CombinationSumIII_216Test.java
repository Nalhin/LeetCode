package com.leetcode.backtracking.medium;

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

class CombinationSumIII_216Test {

  private final CombinationSumIII_216 solution = new CombinationSumIII_216();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, 7, List.of(List.of(1, 2, 4))),
          arguments(3, 9, List.of(List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 3, 4))),
          arguments(4, 1, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void combinationSum3(int n, int k, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.combinationSum3(n, k);

    for (List<Integer> list : actualResult) {
      Collections.sort(list);
    }

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
