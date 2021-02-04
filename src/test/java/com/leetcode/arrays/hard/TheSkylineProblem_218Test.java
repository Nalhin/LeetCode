package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TheSkylineProblem_218Test {

  private final TheSkylineProblem_218 solution = new TheSkylineProblem_218();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}},
              List.of(
                  List.of(2, 10),
                  List.of(3, 15),
                  List.of(7, 12),
                  List.of(12, 0),
                  List.of(15, 10),
                  List.of(20, 8),
                  List.of(24, 0))),
          arguments(new int[][] {{0, 2, 3}, {2, 5, 3}}, List.of(List.of(0, 3), List.of(5, 0))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getSkyline(int[][] buildings, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.getSkyline(buildings);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
