package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CourseScheduleII_210Test {

  private final CourseScheduleII_210.Dfs solutionDfs = new CourseScheduleII_210.Dfs();
  private final CourseScheduleII_210.Kahn solutionKahn = new CourseScheduleII_210.Kahn();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2, new int[][] {{1, 0}}, new int[] {0, 1}),
          arguments(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}}, new int[] {0, 1, 2, 3}),
          arguments(1, new int[][] {}, new int[] {0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validTreeDfs(int numCourses, int[][] prerequisites, int[] expectedResult) {
    int[] actualResult = solutionDfs.findOrder(numCourses, prerequisites);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validTreeKahn(int numCourses, int[][] prerequisites, int[] expectedResult) {
    int[] actualResult = solutionKahn.findOrder(numCourses, prerequisites);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
