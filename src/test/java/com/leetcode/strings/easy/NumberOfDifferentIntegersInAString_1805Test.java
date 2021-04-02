package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfDifferentIntegersInAString_1805Test {
  private final NumberOfDifferentIntegersInAString_1805 solution =
      new NumberOfDifferentIntegersInAString_1805();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("a123bc34d8ef34", 3),
          arguments("leet1234code234", 2),
          arguments("a1b01c001", 1),
          arguments("167278959591294", 1),
          arguments("u", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numDifferentIntegers(String str, int expectedResult) {
    int actualResult = solution.numDifferentIntegers(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
