package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumII_InputArrayIsSorted_167Test {

  private final TwoSumII_InputArrayIsSorted_167 solution = new TwoSumII_InputArrayIsSorted_167();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 7, 11, 15}, 9, new int[] {1, 2}),
          arguments(new int[] {2, 3, 4}, 6, new int[] {1, 3}),
          arguments(new int[] {-1, 0}, -1, new int[] {1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void twoSum(int[] input, int target, int[] expectedResult) {

    int[] actualResult = solution.twoSum(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
