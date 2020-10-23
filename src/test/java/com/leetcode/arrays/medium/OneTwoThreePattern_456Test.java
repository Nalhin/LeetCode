package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OneTwoThreePattern_456Test {

  private final OneTwoThreePattern_456 solution = new OneTwoThreePattern_456();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, false),
          arguments(new int[] {3, 1, 4, 2}, true),
          arguments(new int[] {-1, 3, 2, 0}, true),
          arguments(new int[] {1, 1, 3, 2}, true),
          arguments(new int[] {1, 2, 3, 4, -5, -3, -5, -1}, false),
          arguments(new int[] {1, -4, 2, -1, 3, -3, -4, 0, -3, -1}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void find132pattern(int[] input, boolean expectedResult) {

    boolean actualResult = solution.find132pattern(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
