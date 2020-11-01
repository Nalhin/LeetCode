package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountSquareSubmatricesWithAllOnes_1277Test {

  private final CountSquareSubmatricesWithAllOnes_1277 solution =
      new CountSquareSubmatricesWithAllOnes_1277();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}, 15),
          arguments(new int[][] {{1}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countSquares(int[][] matrix, int expectedResult) {
    int actualResult = solution.countSquares(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
