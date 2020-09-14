package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquaresOfASortedArray_977Test {

  SquaresOfASortedArray_977 solution = new SquaresOfASortedArray_977();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {-4, -1, 0, 3, 10}, new int[] {0, 1, 9, 16, 100}),
          arguments(new int[] {0, 3, 10}, new int[] {0, 9, 100}),
          arguments(new int[] {0, -3, -10}, new int[] {0, 9, 100}),
          arguments(new int[] {-7, -3, 2, 3, 11}, new int[] {4, 9, 9, 49, 121}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortedSquares(int[] input, int[] expectedResult) {

    int[] actualResult = solution.sortedSquares(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
