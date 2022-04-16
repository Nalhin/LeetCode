package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfWaysToBuyPensAndPencils_2240Test {

  private final NumberOfWaysToBuyPensAndPencils_2240 solution =
      new NumberOfWaysToBuyPensAndPencils_2240();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(20, 10, 5, 9), arguments(5, 10, 10));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void waysToBuyPensPencils(int total, int cost1, int cost2, long expectedResult) {
    long actualResult = solution.waysToBuyPensPencils(total, cost1, cost2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
