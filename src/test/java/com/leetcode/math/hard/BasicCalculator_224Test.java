package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BasicCalculator_224Test {

  private final BasicCalculator_224 solution = new BasicCalculator_224();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("1 + 1", 2),
          arguments("2-1 + 2", 3),
          arguments("(1+(4+5+2)-3)+(6+8)", 23),
          arguments("2147483647", 2147483647),
          arguments("- (3 + (4 + 5))", -12));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculate(String str, int expectedResult) {
    int actualResult = solution.calculate(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
