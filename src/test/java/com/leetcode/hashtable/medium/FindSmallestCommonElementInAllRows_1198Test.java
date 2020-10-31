package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindSmallestCommonElementInAllRows_1198Test {

  private final FindSmallestCommonElementInAllRows_1198.HashMapSolution solutionHashMap =
      new FindSmallestCommonElementInAllRows_1198.HashMapSolution();

  private final FindSmallestCommonElementInAllRows_1198.LinkedMapBinarySearchSolution
      solutionBinarySearch =
          new FindSmallestCommonElementInAllRows_1198.LinkedMapBinarySearchSolution();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}},
              5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestCommonElementHashMap(int[][] matrix, int expectedResult) {

    int actualResult = solutionHashMap.smallestCommonElement(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestCommonElementBinarySearch(int[][] matrix, int expectedResult) {

    int actualResult = solutionBinarySearch.smallestCommonElement(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
