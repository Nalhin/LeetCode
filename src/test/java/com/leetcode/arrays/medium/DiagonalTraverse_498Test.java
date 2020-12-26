package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiagonalTraverse_498Test {
  private final DiagonalTraverse_498 solution = new DiagonalTraverse_498();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
              new int[] {1, 2, 4, 7, 5, 3, 6, 8, 9}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findDiagonalOrder(int[][] matrix, int[] expectedResult) {
    int[] actualResult = solution.findDiagonalOrder(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
