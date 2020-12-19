package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestArithmeticSubsequence_1027Test {

  private final LongestArithmeticSubsequence_1027 solution =
      new LongestArithmeticSubsequence_1027();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 6, 9, 12}, 4),
          arguments(new int[] {9, 4, 7, 2, 10}, 3),
          arguments(new int[] {20, 1, 15, 3, 10, 5, 8}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestArithSeqLength(int[] num, int expectedResult) {
    int actualResult = solution.longestArithSeqLength(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
