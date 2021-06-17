package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfSubarraysWithBoundedMaximum_795Test {

  private final NumberOfSubarraysWithBoundedMaximum_795 solution =
      new NumberOfSubarraysWithBoundedMaximum_795();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {2, 1, 4, 3}, 2, 3, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numSubarrayBoundedMax(int[] nums, int left, int right, int expectedResult) {
    int actualResult = solution.numSubarrayBoundedMax(nums, left, right);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
