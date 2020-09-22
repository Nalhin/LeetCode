package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CanPlaceFlowers_605Test {

  CanPlaceFlowers_605 solution = new CanPlaceFlowers_605();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {1, 0, 0, 0, 1}, 1, true),
          arguments(new int[] {1, 0, 0, 0, 1}, 2, false),
          arguments(new int[] {0, 0}, 2, false),
          arguments(new int[] {0}, 0, true),
          arguments(new int[] {0}, 1, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canPlaceFlowers(int[] input, int count, boolean expectedResult) {

    boolean actualResult = solution.canPlaceFlowers(input, count);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
