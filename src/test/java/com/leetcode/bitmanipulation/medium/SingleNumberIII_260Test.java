package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleNumberIII_260Test {

  private final SingleNumberIII_260 solution = new SingleNumberIII_260();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 1, 3, 2, 5}, new int[] {3, 5}),
          arguments(new int[] {-1, 0}, new int[] {-1, 0}),
          arguments(new int[] {0, 1}, new int[] {1, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void singleNumber(int[] nums, int[] expectedResult) {
    int[] actualResult = solution.singleNumber(nums);

    assertThat(actualResult).containsExactlyInAnyOrder(expectedResult);
  }
}
