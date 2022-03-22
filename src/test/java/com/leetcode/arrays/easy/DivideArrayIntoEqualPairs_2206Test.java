package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DivideArrayIntoEqualPairs_2206Test {

  private final DivideArrayIntoEqualPairs_2206 solution = new DivideArrayIntoEqualPairs_2206();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3,2,3,2,2,2}, true), arguments(new int[] {1,2,3,4}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void divideArray(int[] nums, boolean expectedResult) {
    boolean actualResult = solution.divideArray(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
