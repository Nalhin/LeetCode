package com.leetcode.strings.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveDuplicateLetters_316Test {

  private final RemoveDuplicateLetters_316 solution = new RemoveDuplicateLetters_316();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("bcabc", "abc"), arguments("cbacdcbc", "acdb"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeDuplicateLetters(String input, String expectedResult) {
    String actualResult = solution.removeDuplicateLetters(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
