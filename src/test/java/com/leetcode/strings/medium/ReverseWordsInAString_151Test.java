package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseWordsInAString_151Test {
  private final ReverseWordsInAString_151 solution = new ReverseWordsInAString_151();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("the sky is blue", "blue is sky the"),
          arguments("  hello world  ", "world hello"),
          arguments("a good   example", "example good a"),
          arguments("  Bob    Loves  Alice   ", "Alice Loves Bob"),
          arguments("Alice does not even like bob", "bob like even not does Alice"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseWords(String input, String expectedResult) {
    String actualResult = solution.reverseWords(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
