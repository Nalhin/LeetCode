package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfAll1sAreAtLeastLengthKPlacesAway_1437Test {

  private final CheckIfAll1sAreAtLeastLengthKPlacesAway_1437 solution =
      new CheckIfAll1sAreAtLeastLengthKPlacesAway_1437();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2, true),
          arguments(new int[] {1, 0, 0, 1, 0, 1}, 2, false),
          arguments(new int[] {1, 1, 1, 1, 1}, 0, true),
          arguments(new int[] {0, 1, 0, 1}, 1, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kLengthApart(int[] arr, int k, boolean expectedResult) {
    boolean actualResult = solution.kLengthApart(arr, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
