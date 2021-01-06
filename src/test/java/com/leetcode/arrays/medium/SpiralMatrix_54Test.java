package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpiralMatrix_54Test {
  private final SpiralMatrix_54 solution = new SpiralMatrix_54();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
          arguments(
              new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
              List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void spiralOrder(int[][] matrix, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.spiralOrder(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
