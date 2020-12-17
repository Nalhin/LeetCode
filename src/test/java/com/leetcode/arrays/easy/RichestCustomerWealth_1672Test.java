package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RichestCustomerWealth_1672Test {

  private final RichestCustomerWealth_1672 solution = new RichestCustomerWealth_1672();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {3, 2, 1}}, 6),
          arguments(new int[][] {{1, 5}, {7, 3}, {3, 5}}, 10),
          arguments(new int[][] {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumWealth(int[][] input, int expectedResult) {
    int actualResult = solution.maximumWealth(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
