package com.leetcode.bitmanipulation.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ComplementOfBase10Integer_1009Test {

  private final ComplementOfBase10Integer_1009 solution = new ComplementOfBase10Integer_1009();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(5, 2), arguments(7, 0), arguments(10, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void bitwiseComplement(int input, int expectedResult) {

    int actualResult = solution.bitwiseComplement(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
