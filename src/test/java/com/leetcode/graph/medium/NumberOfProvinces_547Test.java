package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfProvinces_547Test {
  private final NumberOfProvinces_547.Dfs solutionDfs = new NumberOfProvinces_547.Dfs();
  private final NumberOfProvinces_547.Dsu solutionDsu = new NumberOfProvinces_547.Dsu();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
          arguments(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findCircleNumDfs(int[][] heights, int expectedResult) {
    int actualResult = solutionDfs.findCircleNum(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findCircleNumDsu(int[][] heights, int expectedResult) {
    int actualResult = solutionDsu.findCircleNum(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
