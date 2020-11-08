package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumLessThanK_1099Test {
  private final TwoSumLessThanK_1099 solution = new TwoSumLessThanK_1099();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {34, 23, 1, 24, 75, 33, 54, 8}, 60, 58),
          arguments(new int[] {10, 20, 30}, 15, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void twoSumLessThanK(int[] input, int k, int expectedResult) {

    int actualResult = solution.twoSumLessThanK(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
