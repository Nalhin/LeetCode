package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInRotatedSortedArrayII_81Test {

  private final SearchInRotatedSortedArrayII_81 solution = new SearchInRotatedSortedArrayII_81();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, true),
          arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 3, false),
          arguments(new int[] {1}, 0, false),
          arguments(new int[] {1, 1, 2, 1, 1}, 2, true),
          arguments(new int[] {1, 3, 1, 1, 1}, 3, true),
          arguments(new int[] {1, 3, 5}, 1, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void search(int[] input, int target, boolean expectedResult) {
    boolean actualResult = solution.search(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
