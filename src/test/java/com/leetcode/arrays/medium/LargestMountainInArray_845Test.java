package com.leetcode.arrays.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestMountainInArray_845Test {

  private final LargestMountainInArray_845 solution = new LargestMountainInArray_845();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 1, 4, 7, 3, 2, 5}, 5),
          arguments(new int[] {2, 2, 2}, 0),
          arguments(new int[] {1, 2, 3}, 0),
          arguments(new int[] {1, 2, 1}, 3),
          arguments(new int[] {}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestMountain(int[] input, int expectedResult) {

    int actualResult = solution.longestMountain(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
