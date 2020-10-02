package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlusOne_66Test {

  private final PlusOne_66 solution = new PlusOne_66();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3}, new int[] {1, 2, 4}),
          arguments(new int[] {4, 3, 2, 1}, new int[] {4, 3, 2, 2}),
          arguments(new int[] {0}, new int[] {1}),
          arguments(new int[] {9}, new int[] {1, 0}),
          arguments(new int[] {9, 9}, new int[] {1, 0, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void plusOne(int[] input, int[] expectedResult) {
    int[] actualResult = solution.plusOne(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
