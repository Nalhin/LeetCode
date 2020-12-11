package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaxNumberOfKSumPairs_1679Test {
  private final MaxNumberOfKSumPairs_1679 solution = new MaxNumberOfKSumPairs_1679();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, 5, 2), arguments(new int[] {3, 1, 3, 4, 3}, 6, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxOperations(int[] input, int k, int expectedResult) {
    int actualResult = solution.maxOperations(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
