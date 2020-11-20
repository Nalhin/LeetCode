package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveInterval_1272Test {

  private final RemoveInterval_1272 solution = new RemoveInterval_1272();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{0, 2}, {3, 4}, {5, 7}},
              new int[] {1, 6},
              List.of(List.of(0, 1), List.of(6, 7))),
          arguments(new int[][] {{0, 5}}, new int[] {2, 3}, List.of(List.of(0, 2), List.of(3, 5))),
          arguments(
              new int[][] {{-5, -4}, {-3, -2}, {1, 2}, {3, 5}, {8, 9}},
              new int[] {-1, 4},
              List.of(List.of(-5, -4), List.of(-3, -2), List.of(4, 5), List.of(8, 9))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void find132pattern(int[][] intervals, int[] toRemove, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.removeInterval(intervals, toRemove);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
