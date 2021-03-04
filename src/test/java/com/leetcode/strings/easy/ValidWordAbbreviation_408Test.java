package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidWordAbbreviation_408Test {
  private final ValidWordAbbreviation_408 solution = new ValidWordAbbreviation_408();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("internationalization", "i12iz4n", true),
          arguments("apple", "a2e", false),
          arguments("a", "2", false),
          arguments("internationalization", "i5a11o1", true),
          arguments("a", "01", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validWordAbbreviation(String word, String abbr, boolean expectedResult) {
    boolean actualResult = solution.validWordAbbreviation(word, abbr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
