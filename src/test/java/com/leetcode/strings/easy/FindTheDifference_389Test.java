package com.leetcode.strings.easy;

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

class FindTheDifference_389Test {

  private final FindTheDifference_389 solution = new FindTheDifference_389();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abcd", "abcde", 'e'),arguments("aa", "a", 'a'));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findTheDifference(String first, String second, char expectedResult) {

    char actualResult = solution.findTheDifference(first, second);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
