package com.leetcode.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInsertPosition_35Test {

  SearchInsertPosition_35 solution = new SearchInsertPosition_35();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {1, 3, 5, 6}, 5, 2),
          arguments(new int[] {1, 3, 5, 6}, 1, 0),
          arguments(new int[] {1, 3, 5, 6}, 3, 1),
          arguments(new int[] {1, 3, 5, 6}, 6, 3),
          arguments(new int[] {1, 3, 5, 6}, 7, 4),
          arguments(new int[] {1, 3, 5, 6}, 0, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchInsert(int[] nums, int target, int expected) {
    int result = solution.searchInsert(nums, target);

    assertThat(result).isEqualTo(expected);
  }
}
