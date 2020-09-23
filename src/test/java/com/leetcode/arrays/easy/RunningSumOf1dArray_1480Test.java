package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RunningSumOf1dArray_1480Test {

  private final RunningSumOf1dArray_1480 solution = new RunningSumOf1dArray_1480();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, new int[] {1, 3, 6, 10}),
          arguments(new int[] {1, 1, 1, 1, 1}, new int[] {1, 2, 3, 4, 5}),
          arguments(new int[] {3, 1, 2, 10, 1}, new int[] {3, 4, 6, 16, 17}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void runningSum(int[] input, int[] expectedResult) {

    int[] actualResult = solution.runningSum(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
