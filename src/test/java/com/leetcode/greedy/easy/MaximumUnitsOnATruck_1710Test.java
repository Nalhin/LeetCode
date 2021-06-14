package com.leetcode.greedy.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumUnitsOnATruck_1710Test {

  private final MaximumUnitsOnATruck_1710 solution = new MaximumUnitsOnATruck_1710();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 3}, {2, 2}, {3, 1}}, 4, 8),
          arguments(new int[][] {{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10, 91));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumUnits(int[][] boxTypes, int truckSize, int expectedResult) {
    int actualResult = solution.maximumUnits(boxTypes, truckSize);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
