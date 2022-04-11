package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Shift2DGrid_1260Test {

  private final Shift2DGrid_1260 solution = new Shift2DGrid_1260();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
              1,
              List.of(List.of(9, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8))),
          arguments(
              new int[][] {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}},
              4,
              List.of(
                  List.of(12, 0, 21, 13),
                  List.of(3, 8, 1, 9),
                  List.of(19, 7, 2, 5),
                  List.of(4, 6, 11, 10))),
          arguments(
              new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
              9,
              List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shiftGrid(int[][] grid, int k, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.shiftGrid(grid, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
