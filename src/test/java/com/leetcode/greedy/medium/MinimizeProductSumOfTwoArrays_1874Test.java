package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimizeProductSumOfTwoArrays_1874Test {

  private final MinimizeProductSumOfTwoArrays_1874 solution =
      new MinimizeProductSumOfTwoArrays_1874();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 3, 4, 2}, new int[] {4, 2, 2, 5}, 40),
          arguments(new int[] {2, 1, 4, 5, 7}, new int[] {3, 2, 4, 8, 6}, 65));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minProductSum(int[] nums1, int[] nums2, int expectedResult) {
    int actualResult = solution.minProductSum(nums1, nums2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
