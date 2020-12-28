package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumProductOfTwoElementsInAnArray_1464Test {

  private final MaximumProductOfTwoElementsInAnArray_1464 solution =
      new MaximumProductOfTwoElementsInAnArray_1464();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 4, 5, 2}, 12),
          arguments(new int[] {1, 5, 4, 5}, 16),
          arguments(new int[] {3, 7}, 12));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProduct(int[] nums, int expected) {
    int result = solution.maxProduct(nums);

    assertThat(result).isEqualTo(expected);
  }
}
