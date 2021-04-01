package com.leetcode.graph.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheTownJudge_997Test {
  private final FindTheTownJudge_997 solution = new FindTheTownJudge_997();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2, new int[][] {{1, 2}}, 2),
          arguments(3, new int[][] {{1, 3}, {2, 3}}, 3),
          arguments(3, new int[][] {{1, 2}, {2, 3}}, -1),
          arguments(3, new int[][] {{1, 2}, {2, 3}}, -1),
          arguments(4, new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findJudge(int n, int[][] relations, int expectedResult) {
    int actualResult = solution.findJudge(n, relations);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
