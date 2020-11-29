package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WaysToMakeAFairArray_1664Test {

  private final WaysToMakeAFairArray_1664 solution = new WaysToMakeAFairArray_1664();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 1, 6, 4}, 1),
          arguments(new int[] {1, 1, 1}, 3),
          arguments(new int[] {1, 2, 3}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void waysToMakeFair(int[] input, int expectedResult) {
    int actualResult = solution.waysToMakeFair(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
