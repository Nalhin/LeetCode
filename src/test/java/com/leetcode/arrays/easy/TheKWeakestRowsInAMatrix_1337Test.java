package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TheKWeakestRowsInAMatrix_1337Test {

  private final TheKWeakestRowsInAMatrix_1337 solution = new TheKWeakestRowsInAMatrix_1337();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}
              },
              3,
              new int[] {2, 0, 3}),
          arguments(
              new int[][] {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}},
              2,
              new int[] {0, 2}),
          arguments(
              new int[][] {
                {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}
              },
              3,
              new int[] {1, 2, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kWeakestRows(int[][] matrix, int k, int[] expectedResult) {
    int[] actualResult = solution.kWeakestRows(matrix, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
