package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumSizeSubarraySum_209Test {

  private final MinimumSizeSubarraySum_209 solution = new MinimumSizeSubarraySum_209();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 1, 2, 4, 3}, 7, 2), arguments(new int[] {321, 8, 1}, 8, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minSubArrayLen(int[] input, int target, int expectedResult) {

    int actualResult = solution.minSubArrayLen(target, input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
