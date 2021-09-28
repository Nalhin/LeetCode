package com.leetcode.bfs.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestDistanceFromAllBuildings_317Test {

  private final ShortestDistanceFromAllBuildings_317 solution = new ShortestDistanceFromAllBuildings_317();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}, 7),
          arguments(new int[][] {{1, 0}}, 1),
          arguments(new int[][] {{1}}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestDistance(int[][] forest, int expectedResult) {
    int actualResult = solution.shortestDistance(forest);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
