package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmallestRectangleEnclosingBlackPixels_302Test {

  private final SmallestRectangleEnclosingBlackPixels_302 solution =
      new SmallestRectangleEnclosingBlackPixels_302();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new char[][] {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}},
              0,
              2,
              6),
          arguments(new char[][] {{'1'}}, 0, 0, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minArea(char[][] image, int x, int y, int expectedResult) {
    int actualResult = solution.minArea(image, x, y);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
