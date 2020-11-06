package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInRotatedSortedArray_33Test {

  private final SearchInRotatedSortedArray_33.SingleSearch singleSearch =
      new SearchInRotatedSortedArray_33.SingleSearch();
  private final SearchInRotatedSortedArray_33.TwoSearches twoSearches =
      new SearchInRotatedSortedArray_33.TwoSearches();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 4),
          arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 3, -1),
          arguments(new int[] {1}, 0, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchSingleSearch(int[] input, int target, int expectedResult) {
    int actualResult = singleSearch.search(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchTwoSearches(int[] input, int target, int expectedResult) {
    int actualResult = twoSearches.search(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
