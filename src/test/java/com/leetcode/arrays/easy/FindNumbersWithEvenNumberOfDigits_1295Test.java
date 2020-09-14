package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindNumbersWithEvenNumberOfDigits_1295Test {

  FindNumbersWithEvenNumberOfDigits_1295 solution = new FindNumbersWithEvenNumberOfDigits_1295();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {12, 345, 2, 6, 7896}, 2),
          arguments(new int[] {0}, 0),
          arguments(new int[] {555, 901, 482, 1771}, 1),
          arguments(new int[] {20, 1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findNumbers(int[] input, int expectedResult) {

    int actualResult = solution.findNumbers(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
