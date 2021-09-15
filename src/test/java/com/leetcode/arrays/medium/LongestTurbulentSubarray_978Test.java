package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestTurbulentSubarray_978Test {
  private final LongestTurbulentSubarray_978 solution = new LongestTurbulentSubarray_978();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9}, 5),
          arguments(new int[] {4, 8, 12, 15}, 2),
          arguments(new int[] {100}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxTurbulenceSize(int[] arr, int expectedResult) {
    int actualResult = solution.maxTurbulenceSize(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
