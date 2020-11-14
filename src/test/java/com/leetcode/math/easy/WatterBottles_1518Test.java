package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WatterBottles_1518Test {
  private final WatterBottles_1518 solution = new WatterBottles_1518();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(9, 3, 13),
          arguments(15, 4, 19),
          arguments(5, 5, 6),
          arguments(2, 3, 2),
          arguments(15, 8, 17));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numWaterBottles(int bottles, int exchange, int expectedResult) {
    int actualResult = solution.numWaterBottles(bottles, exchange);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
