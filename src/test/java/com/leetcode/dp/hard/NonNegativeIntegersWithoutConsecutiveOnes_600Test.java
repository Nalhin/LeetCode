package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NonNegativeIntegersWithoutConsecutiveOnes_600Test {
  private final NonNegativeIntegersWithoutConsecutiveOnes_600 solution =
      new NonNegativeIntegersWithoutConsecutiveOnes_600();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(5, 5), arguments(1, 2), arguments(2, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findIntegers(int input, int expectedResult) {
    int actualResult = solution.findIntegers(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
