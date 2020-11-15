package com.leetcode.dp.medium;

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

class MaximumPointsYouCanObtainFromCards_1423Test {
  private final MaximumPointsYouCanObtainFromCards_1423 solution =
      new MaximumPointsYouCanObtainFromCards_1423();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5, 6, 1}, 3, 12),
          arguments(
              new int[] {
                2, 2, 2,
              },
              2,
              4),
          arguments(new int[] {9, 7, 7, 9, 7, 7, 9}, 7, 55),
          arguments(new int[] {100, 40, 17, 9, 73, 75}, 3, 248),
          arguments(new int[] {1, 79, 80, 1, 1, 1, 200, 1}, 3, 202));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxScore(int[] points, int k, int expectedResult) {
    int actualResult = solution.maxScore(points, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
