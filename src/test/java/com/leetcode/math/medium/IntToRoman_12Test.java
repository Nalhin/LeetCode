package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntToRoman_12Test {
  private final IntToRoman_12 solution = new IntToRoman_12();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, "III"),
          arguments(4, "IV"),
          arguments(9, "IX"),
          arguments(58, "LVIII"),
          arguments(1994, "MCMXCIV"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void intToRoman(int num, String expectedResult) {
    String actualResult = solution.intToRoman(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
