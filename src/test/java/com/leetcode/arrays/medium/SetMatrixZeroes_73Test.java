package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SetMatrixZeroes_73Test {

  private final SetMatrixZeroes_73.LinearMemory linearMemorySolution =
      new SetMatrixZeroes_73.LinearMemory();
  private final SetMatrixZeroes_73.ConstMemory constMemorySolution =
      new SetMatrixZeroes_73.ConstMemory();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
              new int[][] {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}),
          arguments(
              new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}},
              new int[][] {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}),
          arguments(new int[][] {{1, 0, 3}}, new int[][] {{0, 0, 0}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void setZeroesLinearMemory(int[][] matrix, int[][] expectedResult) {
    linearMemorySolution.setZeroes(matrix);

    assertThat(matrix).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void setZeroesConstMemory(int[][] matrix, int[][] expectedResult) {
    constMemorySolution.setZeroes(matrix);

    assertThat(matrix).isEqualTo(expectedResult);
  }
}
