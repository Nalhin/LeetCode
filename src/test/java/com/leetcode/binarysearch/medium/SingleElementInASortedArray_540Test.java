package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleElementInASortedArray_540Test {

  private final SingleElementInASortedArray_540 solution = new SingleElementInASortedArray_540();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}, 2),
          arguments(new int[] {3, 3, 7, 7, 10, 11, 11}, 10),
          arguments(new int[] {1}, 1),
          arguments(new int[] {1, 1, 2, 2, 3, 3, 4}, 4),
          arguments(new int[] {1, 1, 2, 2, 3}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void singleNonDuplicate(int[] input, int expectedResult) {
    int actualResult = solution.singleNonDuplicate(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
