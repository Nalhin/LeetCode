package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BeautifulArrangement_526Test {

  private final BeautifulArrangement_526 solution = new BeautifulArrangement_526();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(2, 2), arguments(1, 1), arguments(5, 10));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countArrangement(int input, int expectedResult) {
    int actualResult = solution.countArrangement(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
