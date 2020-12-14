package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumProductSubarray_152Test {

  private final MaximumProductSubarray_152 solution = new MaximumProductSubarray_152();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, -2, 4}, 6),
          arguments(new int[] {-2, 0, -1}, 0),
          arguments(new int[] {2, -5, -2, -4, 3}, 24),
          arguments(new int[] {2, -5, 0, -4, 3}, 3),
          arguments(new int[] {0, 0}, 0),
          arguments(new int[] {-2}, -2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProduct(int[] num, int expectedResult) {
    int actualResult = solution.maxProduct(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
