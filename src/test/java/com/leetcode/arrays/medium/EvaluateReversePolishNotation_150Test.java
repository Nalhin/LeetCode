package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EvaluateReversePolishNotation_150Test {

  private final EvaluateReversePolishNotation_150 solution =
      new EvaluateReversePolishNotation_150();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"2", "1", "+", "3", "*"}, 9),
          arguments(new String[] {"4", "13", "5", "/", "+"}, 6),
          arguments(
              new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},
              22));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void evalRPN(String[] input, int expectedResult) {

    int actualResult = solution.evalRPN(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
