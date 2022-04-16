package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindClosestNumberToZero_2239Test {

  private final FindClosestNumberToZero_2239 solution = new FindClosestNumberToZero_2239();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-4, -2, 1, 4, 8}, 1), arguments(new int[] {2, -1, 1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findClosestNumber(int[] input, int expectedResult) {
    int actualResult = solution.findClosestNumber(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
