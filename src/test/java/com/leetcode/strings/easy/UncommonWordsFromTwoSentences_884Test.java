package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UncommonWordsFromTwoSentences_884Test {

  private final UncommonWordsFromTwoSentences_884 solution =
      new UncommonWordsFromTwoSentences_884();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("this apple is sweet", "this apple is sour", new String[] {"sweet", "sour"}),
          arguments("apple apple", "banana", new String[] {"banana"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uncommonFromSentences(String str1, String str2, String[] expected) {
    String[] result = solution.uncommonFromSentences(str1, str2);

    assertThat(result).containsExactlyInAnyOrder(expected);
  }
}
