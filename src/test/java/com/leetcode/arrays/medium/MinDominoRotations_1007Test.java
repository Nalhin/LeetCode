package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinDominoRotations_1007Test {

  private final MinDominoRotations_1007 solution = new MinDominoRotations_1007();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 1, 2, 4, 2, 2}, new int[] {5, 2, 6, 2, 3, 2}, 2),
          arguments(new int[] {3, 5, 1, 2, 3}, new int[] {3, 6, 3, 3, 4}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDominoRotations(int[] firstArr, int[] secondArr, int expectedResult) {

    int actualResult = solution.minDominoRotations(firstArr, secondArr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
