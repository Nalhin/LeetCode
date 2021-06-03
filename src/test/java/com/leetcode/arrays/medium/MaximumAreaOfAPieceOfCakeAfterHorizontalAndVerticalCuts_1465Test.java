package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465Test {

  private final MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465 solution =
      new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts_1465();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, 4, new int[] {1, 2, 4}, new int[] {1, 3}, 4),
          arguments(5, 4, new int[] {3, 1}, new int[] {1}, 6),
          arguments(5, 4, new int[] {3}, new int[] {3}, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts, int expectedResult) {
    int actualResult = solution.maxArea(h, w, horizontalCuts, verticalCuts);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
