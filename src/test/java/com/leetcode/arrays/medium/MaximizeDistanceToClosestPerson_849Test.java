package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximizeDistanceToClosestPerson_849Test {

  private final MaximizeDistanceToClosestPerson_849.Dp solutionDP =
      new MaximizeDistanceToClosestPerson_849.Dp();

  private final MaximizeDistanceToClosestPerson_849.TwoPointer solutionTwoPointers =
      new MaximizeDistanceToClosestPerson_849.TwoPointer();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 0, 0, 0, 1, 0, 1}, 2),
          arguments(new int[] {1, 0, 0, 0}, 3),
          arguments(new int[] {0, 1}, 1),
          arguments(new int[] {1, 0, 0, 0}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDistToClosestDp(int[] input, int expectedResult) {

    int actualResult = solutionDP.maxDistToClosest(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDistToClosestTwoPointer(int[] input, int expectedResult) {

    int actualResult = solutionTwoPointers.maxDistToClosest(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
