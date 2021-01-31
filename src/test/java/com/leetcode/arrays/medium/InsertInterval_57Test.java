package com.leetcode.arrays.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InsertInterval_57Test {

  private final InsertInterval_57 solution = new InsertInterval_57();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5}, new int[][] {{1, 5}, {6, 9}}),
          arguments(
              new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
              new int[] {4, 8},
              new int[][] {{1, 2}, {3, 10}, {12, 16}}),
          arguments(new int[][] {}, new int[] {5, 7}, new int[][] {{5, 7}}),
          arguments(new int[][] {{1, 5}}, new int[] {2, 3}, new int[][] {{1, 5}}),
          arguments(new int[][] {{1, 5}}, new int[] {2, 7}, new int[][] {{1, 7}}),
          arguments(new int[][] {{1, 5}}, new int[] {0, 3}, new int[][] {{0, 5}}),
          arguments(
              new int[][] {{3, 5}, {12, 15}},
              new int[] {6, 6},
              new int[][] {{3, 5}, {6, 6}, {12, 15}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void insert(int[][] intervals, int[] newInterval, int[][] expected) {
    int[][] result = solution.insert(intervals, newInterval);

    assertThat(result).isEqualTo(expected);
  }
}
