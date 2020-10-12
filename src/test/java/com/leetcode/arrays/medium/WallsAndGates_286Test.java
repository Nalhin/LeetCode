package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WallsAndGates_286Test {

  private final WallsAndGates_286 solution = new WallsAndGates_286();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
              },
              new int[][] {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
              }),
          arguments(
              new int[][] {
                {
                  Integer.MAX_VALUE,
                  0,
                  Integer.MAX_VALUE,
                  Integer.MAX_VALUE,
                  0,
                  Integer.MAX_VALUE,
                  -1,
                  Integer.MAX_VALUE
                }
              },
              new int[][] {{1, 0, 1, 1, 0, 1, -1, Integer.MAX_VALUE}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wallsAndGates(int[][] input, int[][] expectedResult) {

    solution.wallsAndGates(input);

    assertThat(input).isEqualTo(expectedResult);
  }
}
