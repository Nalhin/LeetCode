package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumNestingDepthOfTheParentheses_1614Test {

  private final MaximumNestingDepthOfTheParentheses_1614 solution =
      new MaximumNestingDepthOfTheParentheses_1614();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("(1+(2*3)+((8)/4))+1", 3),
          arguments("(1)+((2))+(((3)))", 3),
          arguments("1+(2*3)/(2-1)", 1),
          arguments("1", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDepth(String input, int expectedResult) {
    int actualResult = solution.maxDepth(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
