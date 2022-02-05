package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountElementsWithStrictlySmallerAndGreaterElements_2148Test {

  private final CountElementsWithStrictlySmallerAndGreaterElements_2148 solution =
      new CountElementsWithStrictlySmallerAndGreaterElements_2148();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {11, 7, 2, 15}, 2), arguments(new int[] {-3, 3, 3, 90}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countElements(int[] nums, int expectedResult) {
    int actualResult = solution.countElements(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
