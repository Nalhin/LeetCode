package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PalindromicSubstrings_647Test {

  private final PalindromicSubstrings_647.Dp solutionDp = new PalindromicSubstrings_647.Dp();
  private final PalindromicSubstrings_647.Expand solutionExpand =
      new PalindromicSubstrings_647.Expand();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abc", 3), arguments("aaa", 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countSubstringsDp(String input, int expectedResult) {
    int actualResult = solutionDp.countSubstrings(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countSubstringsExpand(String input, int expectedResult) {
    int actualResult = solutionExpand.countSubstrings(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
