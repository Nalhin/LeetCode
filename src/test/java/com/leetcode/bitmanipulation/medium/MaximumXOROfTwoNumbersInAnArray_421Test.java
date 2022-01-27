package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumXOROfTwoNumbersInAnArray_421Test {

  private final MaximumXOROfTwoNumbersInAnArray_421 solution =
      new MaximumXOROfTwoNumbersInAnArray_421();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3,10,5,25,2,8}, 28),
          arguments(new int[] {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMaximumXOR(int[] nums, int expectedResult) {
    int actualResult = solution.findMaximumXOR(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
