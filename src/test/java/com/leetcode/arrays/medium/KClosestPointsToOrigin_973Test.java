package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KClosestPointsToOrigin_973Test {

  private final KClosestPointsToOrigin_973 solution = new KClosestPointsToOrigin_973();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 3}, {-2, 2}}, 1, new int[][] {{-2, 2}}),
          arguments(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][] {{-2, 4}, {3, 3}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kClosest(int[][] input, int k, int[][] expected) {
    int[][] result = solution.kClosest(input, k);

    assertThat(result).isEqualTo(expected);
  }
}
