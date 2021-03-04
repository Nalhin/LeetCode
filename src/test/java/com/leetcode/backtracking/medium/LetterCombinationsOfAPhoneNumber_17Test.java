package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LetterCombinationsOfAPhoneNumber_17Test {
  private final LetterCombinationsOfAPhoneNumber_17 solution =
      new LetterCombinationsOfAPhoneNumber_17();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
          arguments("", Collections.emptyList()),
          arguments("2", List.of("a", "b", "c")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void letterCombinations(String str, List<String> expectedResult) {
    List<String> actualResult = solution.letterCombinations(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
