package com.leetcode.stack.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidateStackSequences_946Test {
  private final ValidateStackSequences_946 solution = new ValidateStackSequences_946();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}, true),
          arguments(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validateStackSequences(int[] pushed, int[] popped, boolean expectedResult) {
    boolean actualResult = solution.validateStackSequences(pushed, popped);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
