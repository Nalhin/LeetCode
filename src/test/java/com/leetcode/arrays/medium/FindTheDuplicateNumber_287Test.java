package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheDuplicateNumber_287Test {

  private final FindTheDuplicateNumber_287 solution = new FindTheDuplicateNumber_287();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 4, 2, 2}, 2),
          arguments(new int[] {3, 1, 3, 4, 2}, 3),
          arguments(new int[] {1, 1}, 1),
          arguments(new int[] {1, 1, 2}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findDuplicate(int[] input, int expected) {

    int result = solution.findDuplicate(input);

    assertThat(result).isEqualTo(expected);
  }
}
