package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolvingQuestionsWithBrainpower_2140Test {

  private final SolvingQuestionsWithBrainpower_2140 solution =
      new SolvingQuestionsWithBrainpower_2140();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{3, 2}, {4, 3}, {4, 4}, {2, 5}}, 5),
          arguments(new int[][] {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mostPoints(int[][] questions, long expectedResult) {
    long actualResult = solution.mostPoints(questions);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
