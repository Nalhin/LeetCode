package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BackspaceStringCompare_844Test {

  private final BackspaceStringCompare_844 solution = new BackspaceStringCompare_844();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("ab#c", "ad#c", true),
          arguments("ab##", "c#d#", true),
          arguments("a#c", "b", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void backspaceCompare(String s, String t, boolean expectedResult) {
    boolean actualResult = solution.backspaceCompare(s, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
