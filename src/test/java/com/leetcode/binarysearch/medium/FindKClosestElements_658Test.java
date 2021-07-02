package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindKClosestElements_658Test {
  private final FindKClosestElements_658.TwoPointers solutionTwoPointers =
      new FindKClosestElements_658.TwoPointers();
  private final FindKClosestElements_658.BinarySearch solutionBinarySearch =
      new FindKClosestElements_658.BinarySearch();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5}, 4, 3, List.of(1, 2, 3, 4)),
          arguments(new int[] {1, 2, 3, 4, 5}, 4, -1, List.of(1, 2, 3, 4)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findClosestElementsTwoPointers(int[] arr, int k, int x, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionTwoPointers.findClosestElements(arr, k, x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findClosestElementsBinarySearch(int[] arr, int k, int x, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionBinarySearch.findClosestElements(arr, k, x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
