package com.leetcode.strings.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MostCommonWord_819Test {

  private final MostCommonWord_819 solution = new MostCommonWord_819();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              "Bob hit a ball, the hit BALL flew far after it was hit.",
              new String[] {"hit"},
              "ball"),
          arguments("a, a, a, a, b,b,b,c, c", new String[] {"a"}, "b"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lengthOfLastWord(String input, String[] blacklist, String expectedResult) {

    String actualResult = solution.mostCommonWord(input, blacklist);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  void mostCommonWord() {}
}
