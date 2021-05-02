package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RotateImage_48Test {
  private final RotateImage_48 solution = new RotateImage_48();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
              new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}),
          arguments(
              new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}},
              new int[][] {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}),
          arguments(new int[][] {{1}}, new int[][] {{1}}),
          arguments(new int[][] {{1, 2}, {3, 4}}, new int[][] {{3, 1}, {4, 2}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rotate(int[][] matrix, int[][] expectedResult) {
    solution.rotate(matrix);

    assertThat(matrix).isEqualTo(expectedResult);
  }
}
