package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPalindromeIII_1216Test {

  private final ValidPalindromeIII_1216 solution = new ValidPalindromeIII_1216();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abcdeca", 2, true), arguments("abbababa", 1, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValidPalindrome(String str, int k, boolean expectedResult) {
    boolean actualResult = solution.isValidPalindrome(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
