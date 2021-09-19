package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleAreaII_850Test {

  private final RectangleAreaII_850 solution = new RectangleAreaII_850();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}, 6),
          arguments(new int[][] {{0, 0, 1000000000, 1000000000}}, 49));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rectangleArea(int[][] rectangles, int expectedResult) {
    int actualResult = solution.rectangleArea(rectangles);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
