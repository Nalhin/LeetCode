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

  private final ShortestUnsortedContinuousSubarray_581.Sort solutionSort =
      new ShortestUnsortedContinuousSubarray_581.Sort();

  private final ShortestUnsortedContinuousSubarray_581.Stack solutionStack =
          new ShortestUnsortedContinuousSubarray_581.Stack();

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
  void findUnsortedSubarraySort(int[] input, int expectedResult) {
    int actualResult = solutionSort.findUnsortedSubarray(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }


  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findUnsortedSubarrayStack(int[] input, int expectedResult) {
    int actualResult = solutionStack.findUnsortedSubarray(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
