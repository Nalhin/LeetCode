package com.leetcode.binarysearch.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MissingNumberInArithmeticProgression_1228Test {

  private final MissingNumberInArithmeticProgression_1228.LinearSearch solutionLinearSearch =
      new MissingNumberInArithmeticProgression_1228.LinearSearch();

  private final MissingNumberInArithmeticProgression_1228.BinarySearch solutionBinarySearch =
      new MissingNumberInArithmeticProgression_1228.BinarySearch();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 7, 11, 13}, 9), arguments(new int[] {15, 13, 12}, 14));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void missingNumberLinearSearch(int[] arr, int expectedResult)  {
    int actualResult = solutionLinearSearch.missingNumber(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void missingNumberBinarySearch(int[] arr, int expectedResult) {
    int actualResult = solutionBinarySearch.missingNumber(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
