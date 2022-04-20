package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumRoundsToCompleteAllTasks_2244Test {

  private final MinimumRoundsToCompleteAllTasks_2244 solution =
      new MinimumRoundsToCompleteAllTasks_2244();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 2, 3, 3, 2, 4, 4, 4, 4, 4}, 4),
          arguments(new int[] {2, 3, 3}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumRounds(int[] tasks, int expectedResult) {
    int actualResult = solution.minimumRounds(tasks);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
