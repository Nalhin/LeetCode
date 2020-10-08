package com.leetcode.arrays.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinarySearch_704Test {

  private final BinarySearch_704 solution = new BinarySearch_704();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-1, 0, 3, 5, 9, 12}, 9, 4),
          arguments(new int[] {-1, 0, 3, 5, 9, 12}, 2, -1),
          arguments(new int[] {5}, 5, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void search(int[] array, int target, int expectedResult) {

    int actualResult = solution.search(array, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
