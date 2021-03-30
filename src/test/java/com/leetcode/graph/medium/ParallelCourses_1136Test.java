package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ParallelCourses_1136Test {
  private final ParallelCourses_1136 solution = new ParallelCourses_1136();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, new int[][] {{1, 3}, {2, 3}}, 2),
          arguments(3, new int[][] {{1, 2}, {2, 3}, {3, 1}}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumSemesters(int n, int[][] heights, int expectedResult) {
    int actualResult = solution.minimumSemesters(n, heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
