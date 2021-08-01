package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MakingALargeIsland_827Test {

  private final MakingALargeIsland_827 solution = new MakingALargeIsland_827();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 0}, {0, 1}}, 3),
          arguments(new int[][] {{1, 1}, {1, 0}}, 4),
          arguments(new int[][] {{1, 1}, {1, 1}}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestIsland(int[][] matrix, int expectedResult) {
    int actualResult = solution.largestIsland(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
