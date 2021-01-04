package com.leetcode.arrays.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TransposeMatrix_867Test {

  private final TransposeMatrix_867 solution = new TransposeMatrix_867();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {4, 5, 6}}, new int[][] {{1, 4}, {2, 5}, {3, 6}}),
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
              new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void transpose(int[][] matrix, int[][] expectedResult) {
    int[][] actualResult = solution.transpose(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
