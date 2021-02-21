package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BrokenCalculator_991Test {
  private final BrokenCalculator_991 solution = new BrokenCalculator_991();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2, 3, 2), arguments(5, 8, 2), arguments(3, 10, 3), arguments(1024, 1, 1023));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void brokenCalc(int x, int target, int expectedResult) {
    int actualResult = solution.brokenCalc(x, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
