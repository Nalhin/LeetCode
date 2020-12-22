package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmallestRangeII_910Test {

  private final SmallestRangeII_910 solution = new SmallestRangeII_910();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1}, 0, 0),
          arguments(new int[] {0, 10}, 2, 6),
          arguments(new int[] {1, 3, 6}, 3, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestRangeII(int[] nums, int k, int expectedResult) {

    int actualResult = solution.smallestRangeII(nums, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
