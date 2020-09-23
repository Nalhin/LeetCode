package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortColors_75Test {

  private final SortColors_75 solution = new SortColors_75();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 0, 2, 1, 1, 0}, new int[] {0, 0, 1, 1, 2, 2}),
          arguments(new int[] {1, 0}, new int[] {0, 1}),
          arguments(new int[] {1, 2, 0}, new int[] {0, 1, 2}),
          arguments(new int[] {2, 2, 2, 1, 1, 0}, new int[] {0, 1, 1, 2, 2, 2}),
          arguments(new int[] {2, 0, 2, 1, 1, 0}, new int[] {0, 0, 1, 1, 2, 2}),
          arguments(new int[] {2, 0, 1}, new int[] {0, 1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortColors(int[] input, int[] expectedResult) {
    solution.sortColors(input);

    assertThat(input).isEqualTo(expectedResult);
  }
}
