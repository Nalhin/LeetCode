package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DuplicateZeros_1089Test {

  private final DuplicateZeros_1089 solution = new DuplicateZeros_1089();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 0, 2, 3, 0, 4, 5, 0}, new int[] {1, 0, 0, 2, 3, 0, 0, 4}),
          arguments(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void duplicateZeros(int[] input, int[] expectedResult) {

    solution.duplicateZeros(input);

    assertThat(input).isEqualTo(expectedResult);
  }
}
