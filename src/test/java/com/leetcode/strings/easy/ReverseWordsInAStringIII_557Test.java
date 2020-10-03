package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseWordsInAStringIII_557Test {
  private final ReverseWordsInAStringIII_557 solution = new ReverseWordsInAStringIII_557();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(arguments("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseWords(String input, String expectedResult) {

    String actualResult = solution.reverseWords(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
