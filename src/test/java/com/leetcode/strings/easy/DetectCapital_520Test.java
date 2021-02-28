package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DetectCapital_520Test {
  private final DetectCapital_520 solution = new DetectCapital_520();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("USA", true),
          arguments("leetcode", true),
          arguments("FlaG", false),
          arguments("Google", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void detectCapitalUse(String address, boolean expectedResult) {
    boolean actualResult = solution.detectCapitalUse(address);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
