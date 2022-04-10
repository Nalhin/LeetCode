package com.leetcode.stack.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballGame_682Test {

  private final BaseballGame_682 solution = new BaseballGame_682();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"5", "2", "C", "D", "+"}, 30),
          arguments(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}, 27),
          arguments(new String[] {"1"}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calPoints(String[] ops, int expectedResult) {
    int actualResult = solution.calPoints(ops);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
