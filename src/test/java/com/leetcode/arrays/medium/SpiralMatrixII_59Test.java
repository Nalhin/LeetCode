package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpiralMatrixII_59Test {

  private final SpiralMatrixII_59 solution = new SpiralMatrixII_59();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}),
          arguments(1, new int[][] {{1}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void generateMatrix(int input, int[][] expectedResult) {
    int[][] actualResult = solution.generateMatrix(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
