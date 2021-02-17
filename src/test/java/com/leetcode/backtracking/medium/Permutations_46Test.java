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

class Permutations_46Test {
  private final Permutations_46 solution = new Permutations_46();

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
          arguments(new int[] {0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
          arguments(new int[] {1}, List.of(List.of(1))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void permute(int[] nums, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.permute(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
