package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KidsWithTheGreatestNumberOfCandies_1431Test {

  private final KidsWithTheGreatestNumberOfCandies_1431 solution =
      new KidsWithTheGreatestNumberOfCandies_1431();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
          arguments(new int[] {4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
          arguments(new int[] {12, 1, 12}, 10, List.of(true, false, true)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kidsWithCandies(int[] candies, int extraCandies, List<Boolean> expectedResult) {

    List<Boolean> actualResult = solution.kidsWithCandies(candies, extraCandies);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
