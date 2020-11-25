package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BasicCalculatorII_227Test {

  private final BasicCalculatorII_227 solution = new BasicCalculatorII_227();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("3+2*2", 7),
          arguments(" 3/2 ", 1),
          arguments(" 3+5 / 2", 5),
          arguments(" 3+5 / 2 * 4", 11),
          arguments("1-1+1", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculate(String input, int expectedResult) {
    int actualResult = solution.calculate(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
