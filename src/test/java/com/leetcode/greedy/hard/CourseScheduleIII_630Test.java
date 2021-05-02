package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CourseScheduleIII_630Test {

  private final CourseScheduleIII_630 solution = new CourseScheduleIII_630();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}, 3),
          arguments(new int[][] {{1, 2}}, 1),
          arguments(new int[][] {{3, 2}, {4, 3}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void scheduleCourse(int[][] courses, int expectedResult) {
    int actualResult = solution.scheduleCourse(courses);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
