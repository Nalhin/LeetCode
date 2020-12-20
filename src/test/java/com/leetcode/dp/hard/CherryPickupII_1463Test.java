package com.leetcode.dp.hard;

import com.leetcode.dp.medium.CombinationSumIV_377;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CherryPickupII_1463Test {

  private final CherryPickupII_1463 solution = new CherryPickupII_1463();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}, 24),
          arguments(
              new int[][] {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
              },
              28),
          arguments(new int[][] {{1, 1}, {1, 1}}, 4),
          arguments(new int[][] {{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}, 22));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void cherryPickup(int[][] grid, int expectedResult) {
    int actualResult = solution.cherryPickup(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
