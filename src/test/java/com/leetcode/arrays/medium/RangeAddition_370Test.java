package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RangeAddition_370Test {
  private final RangeAddition_370 solution = new RangeAddition_370();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[][] {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}}, new int[] {-2, 0, 3, 5, 3}),
          arguments(
              10,
              new int[][] {{2, 4, 6}, {5, 6, 8}, {1, 9, -4}},
              new int[] {0, -4, 2, 2, 2, 4, 4, -4, -4, -4}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getModifiedArray(int length, int[][] updates, int[] expectedResult) {
    int[] actualResult = solution.getModifiedArray(length, updates);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
