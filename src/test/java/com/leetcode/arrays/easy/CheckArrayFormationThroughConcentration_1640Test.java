package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckArrayFormationThroughConcentration_1640Test {
  private final CheckArrayFormationThroughConcentration_1640 solution =
      new CheckArrayFormationThroughConcentration_1640();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {85}, new int[][] {{85}}, true),
          arguments(new int[] {15, 88}, new int[][] {{88}, {15}}, true),
          arguments(new int[] {49, 18, 16}, new int[][] {{16, 18, 49}}, false),
          arguments(new int[] {91, 4, 64, 78}, new int[][] {{78}, {4, 64}, {91}}, true),
          arguments(new int[] {1, 3, 5, 7}, new int[][] {{2, 4, 6, 8}}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canFormArray(int[] arr, int[][] pieces, boolean expectedResult) {

    boolean actualResult = solution.canFormArray(arr, pieces);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
