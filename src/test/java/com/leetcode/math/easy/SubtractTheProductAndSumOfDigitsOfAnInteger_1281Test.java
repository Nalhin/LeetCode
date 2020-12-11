package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubtractTheProductAndSumOfDigitsOfAnInteger_1281Test {

  private final SubtractTheProductAndSumOfDigitsOfAnInteger_1281 solution =
      new SubtractTheProductAndSumOfDigitsOfAnInteger_1281();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(423, 15), arguments(4421, 21));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subtractProductAndSum(int x, int expectedResult) {
    int actualResult = solution.subtractProductAndSum(x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
