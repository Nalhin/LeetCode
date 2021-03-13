package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReduceArraySizeToTheHalf_1338Test {
  private final ReduceArraySizeToTheHalf_1338 solution = new ReduceArraySizeToTheHalf_1338();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, 2),
          arguments(new int[] {7, 7, 7, 7, 7, 7}, 1),
          arguments(new int[] {1, 9}, 1),
          arguments(new int[] {1000, 1000, 3, 7}, 1),
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minSetSize(int[] arr, int expectedResult) {
    int actualResult = solution.minSetSize(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
