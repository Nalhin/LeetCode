package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfEveryRowAndColumnContainsAllNumbers_2133Test {

  private final CheckIfEveryRowAndColumnContainsAllNumbers_2133 solution =
      new CheckIfEveryRowAndColumnContainsAllNumbers_2133();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}, true),
          arguments(new int[][] {{1, 1, 1}, {1, 2, 3}, {1, 2, 3}}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkValid(int[][] matrix, boolean expectedResult) {
    boolean actualResult = solution.checkValid(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
