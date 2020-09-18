package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThirdMaximumNumber_414Test {

  ThirdMaximumNumber_414 solution = new ThirdMaximumNumber_414();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {3, 2, 1}, 1),
          arguments(new int[] {1, 2}, 2),
          arguments(new int[] {2, 2, 3, 1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void thirdMax(int[] input, int expectedResult) {

    int actualResult = solution.thirdMax(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
