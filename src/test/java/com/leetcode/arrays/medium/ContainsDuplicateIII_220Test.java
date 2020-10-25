package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicateIII_220Test {

  private final ContainsDuplicateIII_220 solution = new ContainsDuplicateIII_220();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 1}, 3, 0, true),
          arguments(new int[] {1, 0, 1, 1}, 1, 2, true),
          arguments(new int[] {1, 5, 9, 1, 5, 9}, 2, 3, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void containsNearbyAlmostDuplicate(int[] input, int k, int t, boolean expectedResult) {
    boolean actualResult = solution.containsNearbyAlmostDuplicate(input, k, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
