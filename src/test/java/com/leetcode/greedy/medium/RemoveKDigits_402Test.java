package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveKDigits_402Test {

  private final RemoveKDigits_402 solution = new RemoveKDigits_402();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("1432219", 3, "1219"), arguments("10200", 1, "200"), arguments("10", 2, "0"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeKdigits(String num, int k, String expectedResult) {
    String actualResult = solution.removeKdigits(num, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
