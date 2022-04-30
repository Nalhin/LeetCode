package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountUnguardedCellsInTheGrid_2257Test {

  private final CountUnguardedCellsInTheGrid_2257 solution =
      new CountUnguardedCellsInTheGrid_2257();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              4, 6, new int[][] {{0, 0}, {1, 1}, {2, 3}}, new int[][] {{0, 1}, {2, 2}, {1, 4}}, 7),
          arguments(3, 3, new int[][] {{1, 1}}, new int[][] {{0, 1}, {1, 0}, {2, 1}, {1, 2}}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countUnguarded(int m, int n, int[][] guards, int[][] walls, int expectedResult) {

    int actualResult = solution.countUnguarded(m, n, guards, walls);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
