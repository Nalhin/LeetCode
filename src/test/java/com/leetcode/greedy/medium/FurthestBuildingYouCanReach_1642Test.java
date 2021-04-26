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

class FurthestBuildingYouCanReach_1642Test {

  private final FurthestBuildingYouCanReach_1642 solution = new FurthestBuildingYouCanReach_1642();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1, 4),
          arguments(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7),
          arguments(new int[] {14, 3, 19, 3}, 17, 0, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mostCompetitive(int[] heights, int bricks, int ladders, int expectedResult) {
    int actualResult = solution.furthestBuilding(heights, bricks, ladders);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
