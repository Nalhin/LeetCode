package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeSortedArray_88Test {

  MergeSortedArray_88 solution = new MergeSortedArray_88();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              new int[] {1, 2, 3, 0, 0, 0},
              3,
              new int[] {2, 5, 6},
              3,
              new int[] {1, 2, 2, 3, 5, 6}),
          arguments(new int[] {3, 4}, 2, new int[] {}, 0, new int[] {3, 4}),
          arguments(new int[] {0, 0}, 0, new int[] {1, 2}, 2, new int[] {1, 2}),
          arguments(
              new int[] {1, 2, 3, 0, 0, 0},
              3,
              new int[] {2, 5, 6},
              3,
              new int[] {1, 2, 2, 3, 5, 6}),
          arguments(
              new int[] {3, 4, 0, 0, 0}, 2, new int[] {2, 5, 6}, 3, new int[] {2, 3, 4, 5, 6}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void merge(int[] input1, int m, int[] input2, int n, int[] expectedResult) {

    solution.merge(input1, m, input2, n);

    assertThat(input1).isEqualTo(expectedResult);
  }
}
