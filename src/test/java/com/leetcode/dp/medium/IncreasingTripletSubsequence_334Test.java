package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IncreasingTripletSubsequence_334Test {

  private final IncreasingTripletSubsequence_334.Dp solutionDp =
      new IncreasingTripletSubsequence_334.Dp();
  private final IncreasingTripletSubsequence_334.LinearScan solutionGreedy =
      new IncreasingTripletSubsequence_334.LinearScan();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5}, true),
          arguments(new int[] {5, 4, 3, 2, 1}, false),
          arguments(new int[] {2, 1, 5, 0, 4, 6}, true),
          arguments(new int[] {1, 2, 3, 1, 2, 1}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canJumpDp(int[] array, boolean expectedResult) {
    boolean actualResult = solutionDp.increasingTriplet(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canJumpGreedy(int[] array, boolean expectedResult) {
    boolean actualResult = solutionGreedy.increasingTriplet(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
