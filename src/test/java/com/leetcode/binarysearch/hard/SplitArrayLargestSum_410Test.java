package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SplitArrayLargestSum_410Test {

  private final SplitArrayLargestSum_410 solution = new SplitArrayLargestSum_410();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {7, 2, 5, 10, 8}, 2, 18),
          arguments(new int[] {1, 2, 3, 4, 5}, 2, 9),
          arguments(new int[] {1, 4, 4}, 3, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void splitArray(int[] nums, int m, int expectedResult) {
    int actualResult = solution.splitArray(nums, m);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
