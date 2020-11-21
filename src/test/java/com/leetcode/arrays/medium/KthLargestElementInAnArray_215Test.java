package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthLargestElementInAnArray_215Test {

  private final KthLargestElementInAnArray_215 solution = new KthLargestElementInAnArray_215();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 2, 1, 5, 6, 4}, 2, 5),
          arguments(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestMountain(int[] nums, int k, int expectedResult) {

    int actualResult = solution.findKthLargest(nums, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
