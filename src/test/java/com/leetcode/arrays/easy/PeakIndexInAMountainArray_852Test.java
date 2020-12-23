package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PeakIndexInAMountainArray_852Test {

  private final PeakIndexInAMountainArray_852 solution = new PeakIndexInAMountainArray_852();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {0, 1, 0}, 1),
          arguments(new int[] {0, 2, 1, 0}, 1),
          arguments(new int[] {0, 10, 5, 2}, 1),
          arguments(new int[] {3, 4, 5, 1}, 2),
          arguments(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void peakIndexInMountainArray(int[] arr, int expectedResult) {
    int actualResult = solution.peakIndexInMountainArray(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
