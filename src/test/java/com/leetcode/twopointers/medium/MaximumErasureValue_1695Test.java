package com.leetcode.twopointers.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumErasureValue_1695Test {
  private final MaximumErasureValue_1695 solution = new MaximumErasureValue_1695();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {4, 2, 4, 5, 6}, 17),
          arguments(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}, 8));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumUniqueSubarray(int[] arr, int expectedResult) {
    int actualResult = solution.maximumUniqueSubarray(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
