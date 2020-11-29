package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonSubsequence_1143Test {

  private final LongestCommonSubsequence_1143 solution = new LongestCommonSubsequence_1143();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abcde", "ace", 3), arguments("abc", "abc", 3), arguments("abc", "def", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonSubsequence(String str1, String str2, int expectedResult) {
    int actualResult = solution.longestCommonSubsequence(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
