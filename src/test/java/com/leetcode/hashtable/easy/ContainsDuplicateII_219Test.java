package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicateII_219Test {
  private final ContainsDuplicateII_219 solution = new ContainsDuplicateII_219();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 1}, 3, true),
          arguments(
              new int[] {
                1, 0, 1, 1,
              },
              1,
              true),
          arguments(new int[] {1, 2, 3, 1, 2, 3}, 2, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void containsNearbyDuplicate(int[] input, int k, boolean expectedResult) {

    boolean actualResult = solution.containsNearbyDuplicate(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
