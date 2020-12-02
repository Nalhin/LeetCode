package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfStepsToReduceANumberToZero_1342Test {

  private final NumberOfStepsToReduceANumberToZero_1342 solution =
      new NumberOfStepsToReduceANumberToZero_1342();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(14, 6), arguments(8, 4), arguments(123, 12), arguments(0, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numberOfSteps(int n, int expectedResult) {
    int actualResult = solution.numberOfSteps(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
