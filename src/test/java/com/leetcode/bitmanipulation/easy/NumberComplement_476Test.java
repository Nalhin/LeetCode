package com.leetcode.bitmanipulation.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberComplement_476Test {

  private final NumberComplement_476.Iterative solutionIterative =
      new NumberComplement_476.Iterative();
  private final NumberComplement_476.BitMask solutionBitMask = new NumberComplement_476.BitMask();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(5, 2), arguments(1, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findComplementIterative(int num, int expectedResult) {
    int actualResult = solutionIterative.findComplement(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findComplementBitMask(int num, int expectedResult) {
    int actualResult = solutionBitMask.findComplement(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
