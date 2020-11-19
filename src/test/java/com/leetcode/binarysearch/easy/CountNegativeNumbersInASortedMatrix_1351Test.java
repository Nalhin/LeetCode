package com.leetcode.binarysearch.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountNegativeNumbersInASortedMatrix_1351Test {

  private final CountNegativeNumbersInASortedMatrix_1351 solution =
      new CountNegativeNumbersInASortedMatrix_1351();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}, 8),
          arguments(new int[][] {{3, 2}, {1, 0}}, 0),
          arguments(new int[][] {{1, -1}, {-1, -1}}, 3),
          arguments(new int[][] {{-1}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countNegatives(int[][] grid, int expectedResult) {

    int actualResult = solution.countNegatives(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
