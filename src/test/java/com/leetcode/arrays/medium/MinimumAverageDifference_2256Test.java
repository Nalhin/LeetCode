package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumAverageDifference_2256Test {

  private final MinimumAverageDifference_2256 solution = new MinimumAverageDifference_2256();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {2, 5, 3, 9, 5, 3}, 3), arguments(new int[] {0}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumAverageDifference(int[] nums, int expectedResult) {

    int actualResult = solution.minimumAverageDifference(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
