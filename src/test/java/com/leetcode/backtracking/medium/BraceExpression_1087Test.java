package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BraceExpression_1087Test {

  private final BraceExpression_1087 solution = new BraceExpression_1087();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("{a,b}c{d,e}f", new String[] {"acdf", "acef", "bcdf", "bcef"}),
          arguments("abcd", new String[] {"abcd"}),
          arguments("{a,b}{z,x,y}", new String[] {"ax","ay","az","bx","by","bz"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void expand(String input, String[] expectedResult) {
    String[] actualResult = solution.expand(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
