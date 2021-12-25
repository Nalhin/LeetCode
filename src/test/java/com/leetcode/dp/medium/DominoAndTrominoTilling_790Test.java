package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DominoAndTrominoTilling_790Test {

  private final DominoAndTrominoTilling_790 solution = new DominoAndTrominoTilling_790();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, 5), arguments(1, 1), arguments(20, 3418626));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numTilings(int n, int expectedResult) {
    int actualResult = solution.numTilings(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
