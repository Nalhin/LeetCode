package com.leetcode.greedy.medium;

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

class CampusBikes_1057Test {

  private final CampusBikes_1057 solution = new CampusBikes_1057();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0}, {2, 1}}, new int[][] {{1, 2}, {3, 3}}, new int[] {1, 0}),
          arguments(
              new int[][] {{0, 0}, {1, 1}, {2, 0}},
              new int[][] {{1, 0}, {2, 2}, {2, 1}},
              new int[] {0, 2, 1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void assignBikes(int[][] workers, int[][] bikes, int[] expectedResult) {
    int[] actualResult = solution.assignBikes(workers, bikes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
