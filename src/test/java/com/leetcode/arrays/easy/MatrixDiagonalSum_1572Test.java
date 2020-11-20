package com.leetcode.arrays.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MatrixDiagonalSum_1572Test {

  private final MatrixDiagonalSum_1572 solution = new MatrixDiagonalSum_1572();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 25),
          arguments(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}, 8),
          arguments(new int[][] {{5}}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void diagonalSum(int[][] mat, int expectedResult) {

    int actualResult = solution.diagonalSum(mat);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
