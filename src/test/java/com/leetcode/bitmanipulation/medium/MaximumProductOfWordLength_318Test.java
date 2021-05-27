package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumProductOfWordLength_318Test {

  private final MaximumProductOfWordLength_318 solution = new MaximumProductOfWordLength_318();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16),
          arguments(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4),
          arguments(new String[] {"a", "aa", "aaa", "aaaa"}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProduct(String[] words, int expectedResult) {
    int actualResult = solution.maxProduct(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
