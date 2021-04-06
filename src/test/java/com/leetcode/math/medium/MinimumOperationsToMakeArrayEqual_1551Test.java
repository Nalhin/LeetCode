package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumOperationsToMakeArrayEqual_1551Test {

  private final MinimumOperationsToMakeArrayEqual_1551.Math solutionMath =
      new MinimumOperationsToMakeArrayEqual_1551.Math();
  private final MinimumOperationsToMakeArrayEqual_1551.Loop solutionLoop =
      new MinimumOperationsToMakeArrayEqual_1551.Loop();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, 2), arguments(6, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minOperationsMath(int n, int expectedResult) {
    int actualResult = solutionMath.minOperations(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minOperationsLoop(int n, int expectedResult) {
    int actualResult = solutionLoop.minOperations(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
