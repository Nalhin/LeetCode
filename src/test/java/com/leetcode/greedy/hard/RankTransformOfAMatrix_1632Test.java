package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTransformOfAMatrix_1632Test {

  private final RankTransformOfAMatrix_1632 solution = new RankTransformOfAMatrix_1632();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2}, {3, 4}}, new int[][] {{1, 2}, {2, 3}}),
          arguments(new int[][] {{7, 7}, {7, 7}}, new int[][] {{1, 1}, {1, 1}}),
          arguments(
              new int[][] {{20, -21, 14}, {-19, 4, 19}, {22, -47, 24}, {-19, 4, 19}},
              new int[][] {{4, 2, 3}, {1, 3, 4}, {5, 1, 6}, {1, 3, 4}}),
          arguments(
              new int[][] {{7, 3, 6}, {1, 4, 5}, {9, 8, 2}},
              new int[][] {{5, 1, 4}, {1, 2, 3}, {6, 3, 1}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void matrixRankTransform(int[][] matrix, int[][] expectedResult) {
    int[][] actualResult = solution.matrixRankTransform(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
