package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ZeroOneMatrix_542Test {

  private final ZeroOneMatrix_542 solution = new ZeroOneMatrix_542();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
              },
              new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
              }),
          arguments(
              new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
              new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void updateMatrix(int[][] input, int[][] expectedResult) {

    int[][] actualResult = solution.updateMatrix(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
