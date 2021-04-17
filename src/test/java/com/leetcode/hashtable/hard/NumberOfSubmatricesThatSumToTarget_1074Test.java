package com.leetcode.hashtable.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfSubmatricesThatSumToTarget_1074Test {
  private final NumberOfSubmatricesThatSumToTarget_1074 solution =
      new NumberOfSubmatricesThatSumToTarget_1074();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0, 4),
          arguments(new int[][] {{1, -1}, {-1, 1}}, 0, 5),
          arguments(new int[][] {{904}}, 0, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numSubmatrixSumTarget(int[][] matrix, int target, int expectedResult) {
    int actualResult = solution.numSubmatrixSumTarget(matrix, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
