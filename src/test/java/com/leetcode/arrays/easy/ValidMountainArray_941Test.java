package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidMountainArray_941Test {

  private final ValidMountainArray_941 solution = new ValidMountainArray_941();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 1}, false),
          arguments(new int[] {3, 5, 5}, false),
          arguments(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, false),
          arguments(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, false),
          arguments(new int[] {2, 1, 2, 3, 5, 7, 9, 10, 12, 14, 15, 16, 18, 14, 13}, false),
          arguments(new int[] {0, 3, 2, 1}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validMountainArray(int[] input, boolean expectedResult) {

    boolean actualResult = solution.validMountainArray(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
