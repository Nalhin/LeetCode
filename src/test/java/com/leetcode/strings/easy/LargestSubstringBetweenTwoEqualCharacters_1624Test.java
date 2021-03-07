package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestSubstringBetweenTwoEqualCharacters_1624Test {
  private final LargestSubstringBetweenTwoEqualCharacters_1624 solution =
      new LargestSubstringBetweenTwoEqualCharacters_1624();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aa", 0), arguments("abca", 2), arguments("cbzxy", -1), arguments("cabbac", 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxLengthBetweenEqualCharacters(String num, int expectedResult) {
    int actualResult = solution.maxLengthBetweenEqualCharacters(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
