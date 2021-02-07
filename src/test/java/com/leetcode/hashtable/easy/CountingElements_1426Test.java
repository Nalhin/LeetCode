package com.leetcode.hashtable.easy;

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

class CountingElements_1426Test {

  private final CountingElements_1426 solution = new CountingElements_1426();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3}, 2),
          arguments(new int[] {1, 1, 3, 3, 5, 5, 7, 7}, 0),
          arguments(new int[] {1, 3, 2, 3, 5, 0}, 3),
          arguments(new int[] {1, 1, 2, 2}, 2),
          arguments(new int[] {1, 1, 2}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countElements(int[] input, int expectedResult) {
    int actualResult = solution.countElements(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
