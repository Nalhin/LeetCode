package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindMinimumInRotatedSortedArray_153Test {

  private final FindMinimumInRotatedSortedArray_153.Assignment solutionAssignment =
      new FindMinimumInRotatedSortedArray_153.Assignment();
  private final FindMinimumInRotatedSortedArray_153.SmallerSpaceReduction
      solutionSmallerSpaceReduction =
          new FindMinimumInRotatedSortedArray_153.SmallerSpaceReduction();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 0),
          arguments(new int[] {3, 4, 5, 1, 2}, 1),
          arguments(new int[] {1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMinAssignment(int[] array, int expectedResult) {
    int actualResult = solutionAssignment.findMin(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMinSmallerSpaceReduction(int[] array, int expectedResult) {
    int actualResult = solutionSmallerSpaceReduction.findMin(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
