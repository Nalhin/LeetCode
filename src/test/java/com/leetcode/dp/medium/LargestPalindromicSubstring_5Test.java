package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestPalindromicSubstring_5Test {

  private final LargestPalindromicSubstring_5.Dp solutionDp =
      new LargestPalindromicSubstring_5.Dp();
  private final LargestPalindromicSubstring_5.CenterExpansion solutionExpansion =
      new LargestPalindromicSubstring_5.CenterExpansion();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("babad", "bab"),
          arguments("cbbd", "bb"),
          arguments("a", "a"),
          arguments("ac", "a"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestPalindromeDp(String str, String expectedResult) {
    String actualResult = solutionDp.longestPalindrome(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestPalindromeExpansion(String str, String expectedResult) {
    String actualResult = solutionExpansion.longestPalindrome(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
