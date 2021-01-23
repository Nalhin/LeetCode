package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortTheMatrixDiagonally_1329Test {
  private final SortTheMatrixDiagonally_1329 solution = new SortTheMatrixDiagonally_1329();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}},
              new int[][] {{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rotate(int[][] input, int[][] expectedResult) {
    int[][] actualResult = solution.diagonalSort(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
