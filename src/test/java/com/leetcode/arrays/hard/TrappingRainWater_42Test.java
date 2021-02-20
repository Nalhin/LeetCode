package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TrappingRainWater_42Test {
  private final TrappingRainWater_42.Stack solutionStack = new TrappingRainWater_42.Stack();
  private final TrappingRainWater_42.Dp solutionDp = new TrappingRainWater_42.Dp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
          arguments(new int[] {4, 2, 0, 3, 2, 5}, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void trapStack(int[] heights, int expectedResult) {
    int actualResult = solutionStack.trap(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void trapDp(int[] heights, int expectedResult) {
    int actualResult = solutionDp.trap(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
