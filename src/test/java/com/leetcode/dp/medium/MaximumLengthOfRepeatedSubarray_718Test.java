package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumLengthOfRepeatedSubarray_718Test {

  private final MaximumLengthOfRepeatedSubarray_718 solution =
      new MaximumLengthOfRepeatedSubarray_718();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 2, 1}, new int[] {3, 2, 1, 4, 7}, 3),
          arguments(new int[] {0, 1, 1, 1, 1}, new int[] {1, 0, 1, 0, 1}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLength(int[] a, int[] b, int expectedResult) {
    int actualResult = solution.findLength(a, b);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
