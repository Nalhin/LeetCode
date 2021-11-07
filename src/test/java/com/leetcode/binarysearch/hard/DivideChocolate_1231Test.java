package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DivideChocolate_1231Test {

  private final DivideChocolate_1231 solution = new DivideChocolate_1231();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 6),
          arguments(new int[] {5, 6, 7, 8, 9, 1, 2, 3, 4}, 8, 1),
          arguments(new int[] {1, 2, 2, 1, 2, 2, 1, 2, 2}, 2, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximizeSweetness(int[] sweetness, int k, int expectedResult) {
    int actualResult = solution.maximizeSweetness(sweetness, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
