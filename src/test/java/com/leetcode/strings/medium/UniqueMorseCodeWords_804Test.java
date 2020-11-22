package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniqueMorseCodeWords_804Test {

  private final UniqueMorseCodeWords_804 solution = new UniqueMorseCodeWords_804();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new String[] {"gin", "zen", "gig", "msg"}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uniqueMorseRepresentations(String[] words, int expectedResult) {
    int actualResult = solution.uniqueMorseRepresentations(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
