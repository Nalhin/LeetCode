package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayNesting_565Test {
  private final ArrayNesting_565 solution = new ArrayNesting_565();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 4, 0, 3, 1, 6, 2}, 4), arguments(new int[] {0, 1, 2}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void arrayNesting(int[] nums, int expectedResult) {
    int actualResult = solution.arrayNesting(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
