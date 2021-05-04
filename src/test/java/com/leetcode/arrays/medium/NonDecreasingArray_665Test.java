package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NonDecreasingArray_665Test {

  private final NonDecreasingArray_665 solution = new NonDecreasingArray_665();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 2, 3}, true),
          arguments(new int[] {4, 2, 1}, false),
          arguments(new int[] {3, 4, 2, 3}, false),
          arguments(new int[] {1, 5, 4, 6, 7, 10, 8, 9}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextPermutation(int[] input, boolean expectedResult) {
    boolean actualResult = solution.checkPossibility(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
