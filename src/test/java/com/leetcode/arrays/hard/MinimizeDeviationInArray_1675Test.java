package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimizeDeviationInArray_1675Test {

  private final MinimizeDeviationInArray_1675 solution = new MinimizeDeviationInArray_1675();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, 1),
          arguments(new int[] {4, 1, 5, 20, 3}, 3),
          arguments(new int[] {2, 10, 8}, 3),
          arguments(new int[] {10, 4, 3}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumDeviation(int[] input, int expectedResult) {
    int actualResult = solution.minimumDeviation(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
