package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoCityScheduling_1029Test {

  private final TwoCityScheduling_1029 solution = new TwoCityScheduling_1029();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}}, 110),
          arguments(
              new int[][] {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}},
              1859),
          arguments(
              new int[][] {
                {515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359},
                {631, 42}
              },
              3086));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void twoCitySchedCost(int[][] nums, int expectedResult) {
    int actualResult = solution.twoCitySchedCost(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
