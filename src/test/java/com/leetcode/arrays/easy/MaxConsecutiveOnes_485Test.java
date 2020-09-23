package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaxConsecutiveOnes_485Test {

  private final MaxConsecutiveOnes_485 solution = new MaxConsecutiveOnes_485();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 0, 1, 1, 1}, 3),
          arguments(new int[] {0, 0}, 0),
          arguments(new int[] {1, 1}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMaxConsecutiveOnes(int[] input, int expectedResult) {

    int actualResult = solution.findMaxConsecutiveOnes(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
