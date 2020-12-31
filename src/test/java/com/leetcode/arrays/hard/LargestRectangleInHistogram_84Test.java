package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestRectangleInHistogram_84Test {

  private final LargestRectangleInHistogram_84 solution = new LargestRectangleInHistogram_84();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {2, 1, 5, 6, 2, 3}, 10));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestRectangleArea(int[] input, int expectedResult) {
    int actualResult = solution.largestRectangleArea(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
