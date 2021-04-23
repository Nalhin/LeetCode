package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestValidParentheses_32Test {
  private final LongestValidParentheses_32.Dp solutionDp = new LongestValidParentheses_32.Dp();
  private final LongestValidParentheses_32.Stack solutionStack =
      new LongestValidParentheses_32.Stack();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("(()", 2), arguments(")()())", 4), arguments("", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestValidParenthesesDp(String str, int expectedResult) {
    int actualResult = solutionDp.longestValidParentheses(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestValidParenthesesStack(String str, int expectedResult) {
    int actualResult = solutionStack.longestValidParentheses(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
