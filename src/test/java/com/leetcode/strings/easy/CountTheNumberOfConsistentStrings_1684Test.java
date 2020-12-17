package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountTheNumberOfConsistentStrings_1684Test {

  private final CountTheNumberOfConsistentStrings_1684 solution =
      new CountTheNumberOfConsistentStrings_1684();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("ab", new String[] {"ad", "bd", "aaab", "baa", "babad"}, 2),
          arguments("abc", new String[] {"a", "b", "c", "ab", "ac", "bc", "abc"}, 7),
          arguments("cad", new String[] {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countConsistentStrings(String allowed, String[] words, int expectedResult) {

    int actualResult = solution.countConsistentStrings(allowed, words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
