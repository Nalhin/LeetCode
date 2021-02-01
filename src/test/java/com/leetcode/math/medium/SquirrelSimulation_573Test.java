package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquirrelSimulation_573Test {

  private final SquirrelSimulation_573 solution = new SquirrelSimulation_573();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(6, 7, new int[] {2, 2}, new int[] {4, 4}, new int[][] {{3, 0}, {2, 5}}, 12),
          arguments(
              5,
              5,
              new int[] {3, 2},
              new int[] {0, 1},
              new int[][] {
                {2, 0}, {4, 1}, {0, 4}, {1, 3}, {1, 0}, {3, 4}, {3, 0}, {2, 3}, {0, 2}, {0, 0},
                {2, 2}, {4, 2}, {3, 3}, {4, 4}, {4, 0}, {4, 3}, {3, 1}, {2, 1}, {1, 4}, {2, 4}
              },
              100),
          arguments(
              7,
              6,
              new int[] {5, 4},
              new int[] {3, 4},
              new int[][] {
                {1, 4}, {3, 0}, {5, 0}, {6, 1}, {1, 3}, {1, 1}, {0, 3}, {2, 2}, {6, 3}, {4, 1},
                {2, 4}, {2, 1}, {1, 0}, {3, 2}, {4, 2}, {2, 5}, {0, 2}, {1, 2}, {3, 3}, {6, 2},
                {2, 0}, {5, 1}, {4, 5}, {5, 2}, {0, 1}, {4, 0}, {5, 3}, {3, 5}, {0, 5}, {6, 4},
                {5, 5}, {2, 3}, {3, 1}, {4, 4}, {4, 3}
              },
              288),
          arguments(
              9,
              9,
              new int[] {7, 2},
              new int[] {7, 1},
              new int[][] {{3, 0}, {7, 7}, {8, 8}, {0, 8}, {2, 4}, {4, 5}, {3, 5}, {4, 2}, {1, 8}},
              131));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDistance(
      int height, int width, int[] tree, int[] squirrel, int[][] nuts, int expectedResult) {
    int actualResult = solution.minDistance(height, width, tree, squirrel, nuts);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
