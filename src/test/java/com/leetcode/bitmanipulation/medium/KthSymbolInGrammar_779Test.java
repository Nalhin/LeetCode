package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthSymbolInGrammar_779Test {
  private final KthSymbolInGrammar_779 solution = new KthSymbolInGrammar_779();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 1, 0),
          arguments(2, 1, 0),
          arguments(2, 2, 1),
          arguments(4, 5, 1),
          arguments(3, 1, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kthGrammar(int n, int k, int expectedResult) {
    int actualResult = solution.kthGrammar(n, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
