package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchA2DMatrix_74Test {
  private final SearchA2DMatrix_74.TwoSearches twoSearchesSolution =
      new SearchA2DMatrix_74.TwoSearches();
  private final SearchA2DMatrix_74.SingleSearch singleSearchSolution =
      new SearchA2DMatrix_74.SingleSearch();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3, true),
          arguments(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13, false),
          arguments(new int[][] {}, 0, false),
          arguments(new int[][] {{}}, 1, false),
          arguments(new int[][] {{1, 3}}, 3, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchMatrixTwoSearches(int[][] input, int target, boolean expectedResult) {
    boolean actualResult = twoSearchesSolution.searchMatrix(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchMatrixSingleSearch(int[][] input, int target, boolean expectedResult) {
    boolean actualResult = singleSearchSolution.searchMatrix(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
