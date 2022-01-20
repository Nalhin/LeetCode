package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KokoEatingBananas_875Test {

  private final KokoEatingBananas_875 solution = new KokoEatingBananas_875();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 6, 7, 11}, 8, 4),
          arguments(new int[] {30, 11, 23, 4, 20}, 5, 30),
          arguments(new int[] {30, 11, 23, 4, 20}, 6, 23));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minEatingSpeed(int[] input, int threshold, int expectedResult) {
    int actualResult = solution.minEatingSpeed(input, threshold);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
