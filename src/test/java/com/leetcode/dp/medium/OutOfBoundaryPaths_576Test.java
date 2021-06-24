package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OutOfBoundaryPaths_576Test {

  private final OutOfBoundaryPaths_576.DpTopDown solutionTopDown =
      new OutOfBoundaryPaths_576.DpTopDown();
  private final OutOfBoundaryPaths_576.DpBottomUp solutionBottomUp =
      new OutOfBoundaryPaths_576.DpBottomUp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(2, 2, 2, 0, 0, 6), arguments(1, 3, 3, 0, 1, 12));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findPathsTopDown(
      int m, int n, int maxMove, int startRow, int startColumn, int expectedResult) {
    int actualResult = solutionTopDown.findPaths(m, n, maxMove, startRow, startColumn);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findPathsBottomUp(
      int m, int n, int maxMove, int startRow, int startColumn, int expectedResult) {
    int actualResult = solutionBottomUp.findPaths(m, n, maxMove, startRow, startColumn);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
