package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MonotonicArray_896Test {

  private final MonotonicArray_896 solution = new MonotonicArray_896();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 2, 3}, true),
          arguments(new int[] {6, 5, 4, 4}, true),
          arguments(new int[] {1, 3, 2}, false),
          arguments(new int[] {1, 2, 4, 5}, true),
          arguments(new int[] {1, 1, 1}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isMonotonic(int[] nums, boolean expectedResult) {
    boolean actualResult = solution.isMonotonic(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
