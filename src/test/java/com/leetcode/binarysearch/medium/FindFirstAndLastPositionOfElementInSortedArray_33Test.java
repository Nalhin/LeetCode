package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindFirstAndLastPositionOfElementInSortedArray_33Test {

  private final FindFirstAndLastPositionOfElementInSortedArray_33 solution =
      new FindFirstAndLastPositionOfElementInSortedArray_33();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 7, 7, 8, 8, 10}, 8, new int[] {3, 4}),
          arguments(new int[] {5, 7, 7, 8, 8, 10}, 6, new int[] {-1, -1}),
          arguments(new int[] {1}, 1, new int[] {0, 0}),
          arguments(new int[] {}, 0, new int[] {-1, -1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchRange(int[] array, int target, int[] expectedResult) {
    int[] actualResult = solution.searchRange(array, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
