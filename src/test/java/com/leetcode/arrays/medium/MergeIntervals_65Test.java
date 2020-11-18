package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeIntervals_65Test {

  private final MergeIntervals_65 solution = new MergeIntervals_65();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
              new int[][] {{1, 6}, {8, 10}, {15, 18}}),
          arguments(new int[][] {{1, 4}, {4, 5}}, new int[][] {{1, 5}}),
          arguments(new int[][] {{1, 8}, {2, 6}, {8, 11}, {11, 15}}, new int[][] {{1, 15}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void merge(int[][] input, int[][] expectedResult) {

    int[][] actualResult = solution.merge(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
