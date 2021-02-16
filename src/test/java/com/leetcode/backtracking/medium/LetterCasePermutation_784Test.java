package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LetterCasePermutation_784Test {
  private final LetterCasePermutation_784 solution = new LetterCasePermutation_784();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("a1b2", List.of("a1b2", "a1B2", "A1b2", "A1B2")),
          arguments("3z4", List.of("3z4", "3Z4")),
          arguments("12345", List.of("12345")),
          arguments("0", List.of("0")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void letterCasePermutation(String str, List<String> expectedResult) {
    List<String> actualResult = solution.letterCasePermutation(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
