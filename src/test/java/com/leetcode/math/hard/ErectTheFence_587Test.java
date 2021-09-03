package com.leetcode.math.hard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ErectTheFence_587Test {

  private final ErectTheFence_587 solution = new ErectTheFence_587();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}},
              new int[][] {{1, 1}, {2, 0}, {3, 3}, {2, 4}, {4, 2}}),
          arguments(new int[][] {{1, 2}, {2, 2}, {4, 2}}, new int[][] {{4, 2}, {2, 2}, {1, 2}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void outerTrees(int[][] trees, int[][] expectedResult) {
    int[][] actualResult = solution.outerTrees(trees);

    assertThat(Arrays.stream(actualResult).collect(Collectors.toList()))
        .containsExactlyInAnyOrderElementsOf(
            Arrays.stream(expectedResult).collect(Collectors.toList()));
  }
}
