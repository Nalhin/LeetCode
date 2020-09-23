package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfSubstringsWithOnly1s_1513Test {

  private final NumberOfSubstringsWithOnly1s_1513 solution = new NumberOfSubstringsWithOnly1s_1513();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("0110111", 9),
          arguments("101", 2),
          arguments("111111", 21));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numSub(String input, int expectedResult) {
    int actualResult = solution.numSub(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
