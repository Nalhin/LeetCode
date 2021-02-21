package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RelativeSortArray_1122Test {
  private final RelativeSortArray_1122 solution = new RelativeSortArray_1122();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
              new int[] {2, 1, 4, 3, 9, 6},
              new int[] {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void relativeSortArray(int[] arr, int[] order, int[] expectedResult) {
    int[] actualResult = solution.relativeSortArray(arr, order);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
