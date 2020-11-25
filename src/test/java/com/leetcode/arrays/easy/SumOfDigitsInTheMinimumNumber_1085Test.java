package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfDigitsInTheMinimumNumber_1085Test {
  private final SumOfDigitsInTheMinimumNumber_1085 solution =
      new SumOfDigitsInTheMinimumNumber_1085();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {34, 23, 1, 24, 75, 33, 54, 8}, 0),
          arguments(new int[] {99, 77, 33, 66, 55}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sumOfDigits(int[] input, int expectedResult) {
    int actualResult = solution.sumOfDigits(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
