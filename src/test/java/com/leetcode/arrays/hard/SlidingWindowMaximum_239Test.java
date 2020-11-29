package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SlidingWindowMaximum_239Test {

  private final SlidingWindowMaximum_239 solution = new SlidingWindowMaximum_239();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[] {3, 3, 5, 5, 6, 7}),
          arguments(new int[] {1}, 1, new int[] {1}),
          arguments(new int[] {1, -1}, 1, new int[] {1, -1}),
          arguments(new int[] {9, 11}, 2, new int[] {11}),
          arguments(new int[] {4, -2}, 2, new int[] {4}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxSlidingWindow(int[] input, int k, int[] expectedResult) {

    int[] actualResult = solution.maxSlidingWindow(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
