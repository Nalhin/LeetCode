package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountPrefixesOfAGivenString_2255Test {

  private final CountPrefixesOfAGivenString_2255 solution = new CountPrefixesOfAGivenString_2255();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new String[] {"a", "b", "c", "ab", "bc", "abc"}, "abc", 3),
          arguments(new String[] {"a", "a"}, "aa", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countPrefixes(String[] words, String str, int expectedResult) {

    int actualResult = solution.countPrefixes(words, str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
