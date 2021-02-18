package com.leetcode.bfs.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CutOffTreesForGolfEvent_675Test {

  private final CutOffTreesForGolfEvent_675 solution = new CutOffTreesForGolfEvent_675();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5)), 6),
          arguments(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5)), -1),
          arguments(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6)), 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void cutOffTree(List<List<Integer>> forest, int expectedResult) {
    int actualResult = solution.cutOffTree(forest);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
