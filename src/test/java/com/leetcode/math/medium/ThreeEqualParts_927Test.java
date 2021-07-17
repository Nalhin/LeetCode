package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThreeEqualParts_927Test {
  private final ThreeEqualParts_927 solution = new ThreeEqualParts_927();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 0, 1, 0, 1}, new int[] {0, 3}),
          arguments(new int[] {1, 1, 0, 1, 1}, new int[] {-1, -1}),
          arguments(new int[] {1, 1, 0, 0, 1}, new int[] {0, 2}),
          arguments(
              new int[] {
                1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0,
                0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0
              },
              new int[] {15, 32}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void threeEqualParts(int[] arr, int[] expectedResult) {
    int[] actualResult = solution.threeEqualParts(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
