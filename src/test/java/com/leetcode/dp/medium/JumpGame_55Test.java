package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JumpGame_55Test {

  private final JumpGame_55.Dp solutionDp = new JumpGame_55.Dp();
  private final JumpGame_55.Greedy solutionGreedy = new JumpGame_55.Greedy();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 1, 1, 4}, true), arguments(new int[] {3, 2, 1, 0, 4}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canJumpDp(int[] array, boolean expectedResult) {
    boolean actualResult = solutionDp.canJump(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canJumpGreedy(int[] array, boolean expectedResult) {
    boolean actualResult = solutionGreedy.canJump(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
