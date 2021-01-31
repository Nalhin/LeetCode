package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NextPermutation_31Test {

  private final NextPermutation_31 solution = new NextPermutation_31();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3}, new int[] {1, 3, 2}),
          arguments(new int[] {3, 2, 1}, new int[] {1, 2, 3}),
          arguments(new int[] {1, 1, 5}, new int[] {1, 5, 1}),
          arguments(new int[] {1}, new int[] {1}),
          arguments(new int[] {1, 3, 2}, new int[] {2, 1, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextPermutation(int[] input, int[] expectedResult) {
    solution.nextPermutation(input);

    assertThat(input).isEqualTo(expectedResult);
  }
}
