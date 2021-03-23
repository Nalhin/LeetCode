package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThreeSumWithMultiplicity_923Test {
  private final ThreeSumWithMultiplicity_923 solution = new ThreeSumWithMultiplicity_923();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {11, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 4),
          arguments(new int[] {1, 1, 2, 2, 2, 2}, 5, 12));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void threeSumMulti(int[] arr, int target, int expectedResult) {
    int actualResult = solution.threeSumMulti(arr, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
