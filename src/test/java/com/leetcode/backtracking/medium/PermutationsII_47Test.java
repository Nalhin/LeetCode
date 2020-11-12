package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PermutationsII_47Test {

  private final PermutationsII_47 solution = new PermutationsII_47();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {1, 2, 3},
              List.of(
                  List.of(1, 2, 3),
                  List.of(1, 3, 2),
                  List.of(2, 1, 3),
                  List.of(2, 3, 1),
                  List.of(3, 1, 2),
                  List.of(3, 2, 1))),
          arguments(
              new int[] {1, 2, 3},
              List.of(
                  List.of(1, 2, 3),
                  List.of(1, 3, 2),
                  List.of(2, 1, 3),
                  List.of(2, 3, 1),
                  List.of(3, 1, 2),
                  List.of(3, 2, 1))),
          arguments(new int[] {0, 2}, List.of(List.of(2, 0), List.of(0, 2))),
          arguments(
              new int[] {1, -2, -3},
              List.of(
                  List.of(-3, -2, 1),
                  List.of(-3, 1, -2),
                  List.of(-2, -3, 1),
                  List.of(-2, 1, -3),
                  List.of(1, -3, -2),
                  List.of(1, -2, -3))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void permuteUnique(int[] array, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.permuteUnique(array);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
