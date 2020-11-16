package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HighFive_1086Test {

  private final HighFive_1086 solution = new HighFive_1086();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100},
                {2, 100}, {2, 76}
              },
              new int[][] {{1, 87}, {2, 88}}),
          arguments(
              new int[][] {
                {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100},
                {1, 100}, {7, 100}
              },
              new int[][] {{1, 100}, {7, 100}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void highFive(int[][] items, int[][] expectedResult) {

    int[][] actualResult = solution.highFive(items);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
