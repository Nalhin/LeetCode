package com.leetcode.arrays.easy;

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

class MissingNumber_268Test {

  private final MissingNumber_268 solution = new MissingNumber_268();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 0, 1}, 2),
          arguments(new int[] {0, 1}, 2),
          arguments(new int[] {0}, 1),
          arguments(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}, 8));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void missingNumber(int[] nums, int expectedResult) {
    int actualResult = solution.missingNumber(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
