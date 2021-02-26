package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WalkingRobotSimulation_874Test {

  private final WalkingRobotSimulation_874 solution = new WalkingRobotSimulation_874();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, -1, 3}, new int[][] {}, 25),
          arguments(new int[] {4, -1, 4, -2, 4}, new int[][] {{2, 4}}, 65));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void robotSim(int[] commands, int[][] obstacles, int expectedResult) {
    int actualResult = solution.robotSim(commands, obstacles);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
