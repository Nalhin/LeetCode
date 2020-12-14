package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestArithmeticSubsequenceOfGivenDifference_1218Test {

  private final LongestArithmeticSubsequenceOfGivenDifference_1218 solution =
      new LongestArithmeticSubsequenceOfGivenDifference_1218();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, 1, 4),
          arguments(new int[] {1, 3, 5, 7}, 1, 1),
          arguments(new int[] {1, 5, 7, 8, 5, 3, 4, 2, 1}, -2, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestSubsequence(int[] num, int diff, int expectedResult) {
    int actualResult = solution.longestSubsequence(num, diff);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
