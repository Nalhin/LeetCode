package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfCornerRectangles_750Test {

  private final NumberOfCornerRectangles_750 solution = new NumberOfCornerRectangles_750();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}}, 1),
          arguments(new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 9),
          arguments(new int[][] {{1, 1, 1, 1}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countCornerRectangles(int[][] grid, int expectedResult) {
    int actualResult = solution.countCornerRectangles(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
