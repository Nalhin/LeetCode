package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarPooling_1094Test {

  CarPooling_1094 solution = new CarPooling_1094();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4, false),
          arguments(new int[][] {{2, 1, 5}, {3, 3, 7}}, 5, true),
          arguments(new int[][] {{2, 1, 5}, {3, 5, 7}}, 3, true),
          arguments(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void carPooling(int[][] trips, int capacity, boolean expectedResult) {

    boolean actualResult = solution.carPooling(trips, capacity);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
