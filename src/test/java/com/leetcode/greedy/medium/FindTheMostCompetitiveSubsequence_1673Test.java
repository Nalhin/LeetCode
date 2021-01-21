package com.leetcode.greedy.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheMostCompetitiveSubsequence_1673Test {

  private final FindTheMostCompetitiveSubsequence_1673 solution =
      new FindTheMostCompetitiveSubsequence_1673();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 5, 2, 6}, 2, new int[] {2, 6}),
          arguments(new int[] {2, 4, 3, 3, 5, 4, 9, 6}, 4, new int[] {2, 3, 3, 4}),
          arguments(
              new int[] {71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3, new int[] {8, 80, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mostCompetitive(int[] nums, int k, int[] expectedResult) {
    int[] actualResult = solution.mostCompetitive(nums, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
