package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RearrangeArrayElementsBySign_2149Test {

  private final RearrangeArrayElementsBySign_2149 solution =
      new RearrangeArrayElementsBySign_2149();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 1, -2, -5, 2, -4}, new int[] {3, -2, 1, -5, 2, -4}),
          arguments(new int[] {-1, 1}, new int[] {1, -1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rearrangeArray(int[] nums, int[] expectedResult) {
    int[] actualResult = solution.rearrangeArray(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
