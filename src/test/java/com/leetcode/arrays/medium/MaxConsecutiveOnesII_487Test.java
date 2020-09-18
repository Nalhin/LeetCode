package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaxConsecutiveOnesII_487Test {

  MaxConsecutiveOnesII_487 solution = new MaxConsecutiveOnesII_487();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {1, 0, 1, 1, 0}, 4),
          arguments(new int[] {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1}, 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMaxConsecutiveOnes(int[] input, int expectedResult) {

    int actualResult = solution.findMaxConsecutiveOnes(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
