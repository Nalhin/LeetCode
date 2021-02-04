package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestHarmoniousSubsequence_594Test {

  private final LongestHarmoniousSubsequence_594 solution = new LongestHarmoniousSubsequence_594();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 2, 2, 5, 2, 3, 7}, 5),
          arguments(new int[] {1, 2, 3, 4}, 2),
          arguments(new int[] {1, 1, 1, 1}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLHS(int[] nums, int expectedResult) {
    int actualResult = solution.findLHS(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
