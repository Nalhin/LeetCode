package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DungeonGame_174Test {

  private final DungeonGame_174 solution = new DungeonGame_174();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, 7),
          arguments(new int[][] {{0}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculateMinimumHP(int[][] dungeon, int expectedResult) {
    int actualResult = solution.calculateMinimumHP(dungeon);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
