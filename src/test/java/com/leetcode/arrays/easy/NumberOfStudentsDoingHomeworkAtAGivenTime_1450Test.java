package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfStudentsDoingHomeworkAtAGivenTime_1450Test {

  private final NumberOfStudentsDoingHomeworkAtAGivenTime_1450 solution =
      new NumberOfStudentsDoingHomeworkAtAGivenTime_1450();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3}, new int[] {3, 2, 7}, 4, 1),
          arguments(new int[] {4}, new int[] {4}, 5, 0),
          arguments(new int[] {1, 1, 1, 1}, new int[] {1, 3, 2, 4}, 7, 0),
          arguments(
              new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1},
              new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10},
              5,
              5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void busyStudent(int[] startTime, int[] endTime, int queryTime, int expectedResult) {
    int actualResult = solution.busyStudent(startTime, endTime, queryTime);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
