package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SuperPalindromes_906Test {

  private final SuperPalindromes_906 solution = new SuperPalindromes_906();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("4", "1000", 4), arguments("1", "2", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void superpalindromesInRange(String left, String right, int expectedResult) {
    int actualResult = solution.superpalindromesInRange(left, right);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
