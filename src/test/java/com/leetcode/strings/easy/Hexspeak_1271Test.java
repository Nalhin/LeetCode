package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Hexspeak_1271Test {
  private final Hexspeak_1271 solution = new Hexspeak_1271();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("257", "I0I"),
          arguments("3", "ERROR"),
          arguments("747823223228", "AEIDBCDIBC"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void toHexspeak(String num, String expectedResult) {
    String actualResult = solution.toHexspeak(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
