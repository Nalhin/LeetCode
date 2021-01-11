package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShuffleTheArray_1470Test {

  private final ShuffleTheArray_1470 solution = new ShuffleTheArray_1470();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 5, 1, 3, 4, 7}, 3, new int[] {2, 3, 5, 4, 1, 7}),
          arguments(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, 4, new int[] {1, 4, 2, 3, 3, 2, 4, 1}),
          arguments(new int[] {1, 1, 2, 2}, 2, new int[] {1, 2, 1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shuffle(int[] input, int n, int[] expectedResult) {
    int[] actualResult = solution.shuffle(input, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
