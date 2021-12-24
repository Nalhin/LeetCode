package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NthMagicNumber_878Test {

  private final NthMagicNumber_878 solution = new NthMagicNumber_878();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 2, 3, 2), arguments(4, 2, 3, 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nthMagicalNumber(int n, int a, int b, int expectedResult) {
    int actualResult = solution.nthMagicalNumber(n, a, b);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
