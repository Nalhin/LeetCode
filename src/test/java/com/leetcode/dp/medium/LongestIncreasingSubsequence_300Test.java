package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestIncreasingSubsequence_300Test {

  private final LongestIncreasingSubsequence_300.NaiveDp solutionNaiveDp =
      new LongestIncreasingSubsequence_300.NaiveDp();
  private final LongestIncreasingSubsequence_300.BinarySearchDp solutionBinarySearchDp =
      new LongestIncreasingSubsequence_300.BinarySearchDp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {10, 9, 2, 5, 3, 7, 101, 18}, 4),
          arguments(new int[] {0, 1, 0, 3, 2, 3}, 4),
          arguments(new int[] {7, 7, 7, 7, 7}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lengthOfLISNaiveDp(int[] array, int expectedResult) {
    int actualResult = solutionNaiveDp.lengthOfLIS(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lengthOfLISBinarySearchDp(int[] array, int expectedResult) {
    int actualResult = solutionBinarySearchDp.lengthOfLIS(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
