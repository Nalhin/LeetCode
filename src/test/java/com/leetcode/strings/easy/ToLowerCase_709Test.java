package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ToLowerCase_709Test {

  private final ToLowerCase_709 solution = new ToLowerCase_709();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("Hello", "hello"),
          arguments("here", "here"),
          arguments("LOVELY", "lovely"),
          arguments("Al&phaBET", "al&phabet"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void toLowerCase(String input, String expected) {
    String result = solution.toLowerCase(input);

    assertThat(result).isEqualTo(expected);
  }
}
