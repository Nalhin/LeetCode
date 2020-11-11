package com.leetcode.binarysearch.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPerfectSquare_367Test {

  private final ValidPerfectSquare_367 solution = new ValidPerfectSquare_367();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, true), arguments(16, true), arguments(9, true), arguments(14, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPerfectSquare(int num, boolean expectedResult) {

    boolean actualResult = solution.isPerfectSquare(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
