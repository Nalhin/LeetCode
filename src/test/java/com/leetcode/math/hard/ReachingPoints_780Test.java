package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReachingPoints_780Test {
  private final ReachingPoints_780 solution = new ReachingPoints_780();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 1, 3, 5, true),
          arguments(1, 1, 2, 2, false),
          arguments(1, 1, 1, 1, true),
          arguments(1, 1, 1000000000, 1, true),
          arguments(3, 3, 12, 9, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void poorPigs(int sx, int sy, int tx, int ty, boolean expectedResult) {
    boolean actualResult = solution.reachingPoints(sx, sy, tx, ty);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
