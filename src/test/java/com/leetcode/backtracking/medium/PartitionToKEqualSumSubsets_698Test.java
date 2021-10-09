package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitionToKEqualSumSubsets_698Test {

  private final PartitionToKEqualSumSubsets_698 solution = new PartitionToKEqualSumSubsets_698();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 3, 2, 3, 5, 2, 1}, 4, true),
          arguments(new int[] {1, 2, 3, 4}, 3, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void makesquare(int[] nums, int k, boolean expectedResult) {
    boolean actualResult = solution.backtrack(nums, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
