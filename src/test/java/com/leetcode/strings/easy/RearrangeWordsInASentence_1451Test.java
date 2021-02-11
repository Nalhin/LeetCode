package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RearrangeWordsInASentence_1451Test {
  private final RearrangeWordsInASentence_1451 solution = new RearrangeWordsInASentence_1451();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("Leetcode is cool", "Is cool leetcode"),
          arguments("Keep calm and code on", "On and keep calm code"),
          arguments("To be or not to be", "To be or to be not"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void arrangeWords(String str, String expectedResult) {
    String actualResult = solution.arrangeWords(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
