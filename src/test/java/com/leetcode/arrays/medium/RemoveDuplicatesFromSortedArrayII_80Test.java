package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveDuplicatesFromSortedArrayII_80Test {

  private final RemoveDuplicatesFromSortedArrayII_80 solution =
      new RemoveDuplicatesFromSortedArrayII_80();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 1, 2, 2, 3}, new int[] {1, 1, 2, 2, 3}),
          arguments(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[] {0, 0, 1, 1, 2, 3, 3}),
          arguments(new int[] {}, new int[] {}),
          arguments(new int[] {1, 2}, new int[] {1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeDuplicates(int[] input, int[] expectedResult) {
    solution.removeDuplicates(input);

    assertThat(input).startsWith(expectedResult);
  }
}
