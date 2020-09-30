package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FirstMissingPositive_41Test {
  private final FirstMissingPositive_41 solution = new FirstMissingPositive_41();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 0}, 3),
          arguments(new int[] {3, 4, -1, 1}, 2),
          arguments(new int[] {7, 8, 9, 11, 12}, 1),
          arguments(new int[] {0}, 1),
          arguments(new int[] {-1, -2, -3}, 1),
          arguments(new int[] {1, 2, -1, -2, -3}, 3),
          arguments(new int[] {4, 5, 1, 0, 0, 0}, 2),
          arguments(new int[] {4, 1, 1, 0, 0, 0}, 2),
          arguments(new int[] {}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void firstMissingPositive(int[] input, int expectedResult) {

    int actualResult = solution.firstMissingPositive(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
