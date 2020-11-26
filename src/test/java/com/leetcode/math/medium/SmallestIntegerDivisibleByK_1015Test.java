package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmallestIntegerDivisibleByK_1015Test {

  private final SmallestIntegerDivisibleByK_1015 solution = new SmallestIntegerDivisibleByK_1015();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 1), arguments(2, -1), arguments(3, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestRepunitDivByK(int k, int expectedResult) {
    int actualResult = solution.smallestRepunitDivByK(k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
