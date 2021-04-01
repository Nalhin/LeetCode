package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestUniqueNumber_1133Test {
  private final LargestUniqueNumber_1133 solution = new LargestUniqueNumber_1133();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 7, 3, 9, 4, 9, 8, 3, 1}, 8),
          arguments(new int[] {9, 9, 8, 8}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestUniqueNumber(int[] nums, int expectedResult) {
    int actualResult = solution.largestUniqueNumber(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
