package com.leetcode.dp.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PaintFence_276Test {

  private final PaintFence_276 solution = new PaintFence_276();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, 2, 6), arguments(2, 4, 16), arguments(12, 5, 171320320));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numWays(int n, int k, int expectedResult) {
    int actualResult = solution.numWays(n, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
