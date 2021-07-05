package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReshapeTheMatrix_566Test {

  private final ReshapeTheMatrix_566 solution = new ReshapeTheMatrix_566();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2}, {3, 4}}, 1, 4, new int[][] {{1, 2, 3, 4}}),
          arguments(new int[][] {{1, 2}, {3, 4}}, 2, 4, new int[][] {{1, 2}, {3, 4}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void matrixReshape(int[][] mat, int r, int c, int[][] expectedResult) {
    int[][] actualResult = solution.matrixReshape(mat, r, c);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
