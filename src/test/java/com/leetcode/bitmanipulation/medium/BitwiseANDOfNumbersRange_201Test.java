package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BitwiseANDOfNumbersRange_201Test {

  private final BitwiseANDOfNumbersRange_201 solution = new BitwiseANDOfNumbersRange_201();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(5, 7, 4), arguments(0, 0, 0), arguments(1, 2147483647, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rangeBitwiseAnd(int n, int m, int expectedResult) {
    int actualResult = solution.rangeBitwiseAnd(n, m);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
