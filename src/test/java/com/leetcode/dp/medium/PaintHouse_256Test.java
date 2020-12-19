package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PaintHouse_256Test {

  private final PaintHouse_256 solution = new PaintHouse_256();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}, 10),
          arguments(new int[][] {}, 0),
          arguments(new int[][] {{7, 6, 2}}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCost(int[][] costs, int expectedResult) {
    int actualResult = solution.minCost(costs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
