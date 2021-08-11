package com.leetcode.greedy.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayOfDoubledPairs_954Test {

  private final ArrayOfDoubledPairs_954 solution = new ArrayOfDoubledPairs_954();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 1, 3, 6}, false),
          arguments(new int[] {2, 1, 2, 6}, false),
          arguments(new int[] {4, -2, 2, -4}, true),
          arguments(new int[] {1, 2, 4, 16, 8, 4}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canReorderDoubled(int[] arr, boolean expectedResult) {
    boolean actualResult = solution.canReorderDoubled(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
