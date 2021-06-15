package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestDistanceToTargetColor_1182Test {

  private final ShortestDistanceToTargetColor_1182 solution =
      new ShortestDistanceToTargetColor_1182();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {1, 1, 2, 1, 3, 2, 2, 3, 3},
              new int[][] {{1, 3}, {2, 2}, {6, 1}},
              List.of(3, 0, 3)),
          arguments(new int[] {1, 2}, new int[][] {{0, 3}}, List.of(-1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestDistanceColor(int[] colors, int[][] queries, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.shortestDistanceColor(colors, queries);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
