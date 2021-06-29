package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaxConsecutiveOnesIII_1004Test {

  private final MaxConsecutiveOnesIII_1004 solution = new MaxConsecutiveOnesIII_1004();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
          arguments(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestOnes(int[] nums, int k, int expectedResult) {
    int actualResult = solution.longestOnes(nums, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
