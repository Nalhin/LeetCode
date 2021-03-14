package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConvertANumberToHexadecimal_405Test {
  private final ConvertANumberToHexadecimal_405 solution = new ConvertANumberToHexadecimal_405();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(26, "1a"), arguments(-1, "ffffffff"), arguments(0, "0"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addDigits(int num, String expectedResult) {
    String actualResult = solution.toHex(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
