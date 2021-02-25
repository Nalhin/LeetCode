package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestUnsortedContinuousSubarray_581Test {

  private final ShortestUnsortedContinuousSubarray_581 solution =
      new ShortestUnsortedContinuousSubarray_581();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 6, 4, 8, 10, 9, 15}, 5),
          arguments(new int[] {1, 2, 3, 4}, 0),
          arguments(new int[] {1}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findUnsortedSubarray(int[] input, int expectedResult) {
    int actualResult = solution.findUnsortedSubarray(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
