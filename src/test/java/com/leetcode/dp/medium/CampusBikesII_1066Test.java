package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CampusBikesII_1066Test {

  private final CampusBikesII_1066 solution = new CampusBikesII_1066();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0}, {2, 1}}, new int[][] {{1, 2}, {3, 3}}, 6),
          arguments(new int[][] {{0, 0}, {1, 1}, {2, 0}}, new int[][] {{1, 0}, {2, 2}, {2, 1}}, 4),
          arguments(
              new int[][] {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
              new int[][] {{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}},
              4995));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void assignBikes(int[][] workers, int[][] bikes, int expectedResult) {
    int actualResult = solution.assignBikes(workers, bikes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
