package com.leetcode.greedy.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WiggleSubsequence_376Test {

  private final WiggleSubsequence_376 solution = new WiggleSubsequence_376();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 7, 4, 9, 2, 5}, 6),
          arguments(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7),
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wiggleMaxLength(int[] nums, int expectedResult) {
    int actualResult = solution.wiggleMaxLength(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
