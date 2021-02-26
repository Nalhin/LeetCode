package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumFlipsToMakeAOrBEqualToC_1318Test {
  private final MinimumFlipsToMakeAOrBEqualToC_1318 solution =
      new MinimumFlipsToMakeAOrBEqualToC_1318();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(2, 6, 5, 3), arguments(4, 2, 7, 1), arguments(1, 2, 3, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kthGrammar(int a, int b, int c, int expectedResult) {
    int actualResult = solution.minFlips(a, b, c);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
