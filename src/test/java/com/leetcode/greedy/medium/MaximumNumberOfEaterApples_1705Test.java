package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumNumberOfEaterApples_1705Test {

  private final MaximumNumberOfEaterApples_1705 solution = new MaximumNumberOfEaterApples_1705();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 5, 2}, new int[] {3, 2, 1, 4, 2}, 7),
          arguments(new int[] {3, 0, 0, 0, 0, 2}, new int[] {3, 0, 0, 0, 0, 2}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void eatenApples(int[] apples, int[] days, int expectedResult) {
    int actualResult = solution.eatenApples(apples, days);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
