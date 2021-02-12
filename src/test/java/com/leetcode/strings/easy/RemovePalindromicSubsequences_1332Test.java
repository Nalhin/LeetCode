package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemovePalindromicSubsequences_1332Test {
  private final RemovePalindromicSubsequences_1332 solution =
      new RemovePalindromicSubsequences_1332();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("ababa", 1), arguments("abb", 2), arguments("", 0), arguments("baabb", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removePalindromeSub(String input, int expectedResult) {
    int actualResult = solution.removePalindromeSub(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
