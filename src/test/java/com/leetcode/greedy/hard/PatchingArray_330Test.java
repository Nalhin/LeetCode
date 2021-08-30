package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PatchingArray_330Test {

  private final PatchingArray_330 solution = new PatchingArray_330();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3}, 6, 1),
          arguments(new int[] {1, 5, 10}, 20, 2),
          arguments(new int[] {1, 2, 2}, 5, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minPatches(int[] nums, int n, int expectedResult) {
    int actualResult = solution.minPatches(nums, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
