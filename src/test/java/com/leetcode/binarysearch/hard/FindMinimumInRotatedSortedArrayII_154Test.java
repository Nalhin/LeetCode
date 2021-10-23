package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindMinimumInRotatedSortedArrayII_154Test {

  private final FindMinimumInRotatedSortedArrayII_154 solution =
      new FindMinimumInRotatedSortedArrayII_154();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 5}, 1),
          arguments(new int[] {2, 2, 2, 0, 1}, 0),
          arguments(new int[] {1, 3, 3}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMin(int[] nums, int expectedResult) {
    int actualResult = solution.findMin(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
