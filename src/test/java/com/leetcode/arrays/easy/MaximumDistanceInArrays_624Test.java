package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumDistanceInArrays_624Test {
  private final MaximumDistanceInArrays_624 solution = new MaximumDistanceInArrays_624();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3)), 4),
          arguments(List.of(List.of(1, 4), List.of(0, 5)), 4),
          arguments(List.of(List.of(-1, 1), List.of(-3, 1, 4), List.of(-2, -1, 0, 2)), 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDistance(List<List<Integer>> input, int expectedResult) {

    int actualResult = solution.maxDistance(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
