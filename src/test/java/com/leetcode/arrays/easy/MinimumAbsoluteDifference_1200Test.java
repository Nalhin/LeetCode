package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumAbsoluteDifference_1200Test {

  private final MinimumAbsoluteDifference_1200 solution = new MinimumAbsoluteDifference_1200();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 2, 1, 3}, List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4))),
          arguments(new int[] {1, 3, 6, 10, 15}, List.of(List.of(1, 3))),
          arguments(
              new int[] {3, 8, -10, 23, 19, -4, -14, 27},
              List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumAbsDifference(int[] arr, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.minimumAbsDifference(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
