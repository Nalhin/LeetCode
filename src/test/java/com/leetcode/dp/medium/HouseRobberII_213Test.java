package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HouseRobberII_213Test {

  private final HouseRobberII_213 solution = new HouseRobberII_213();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 2}, 3),
          arguments(new int[] {1, 2, 3, 1}, 4),
          arguments(
              new int[] {
                1, 2,
              },
              2),
          arguments(new int[] {0}, 0),
          arguments(new int[] {200, 3, 140, 20, 10}, 340));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rob(int[] array, int expectedResult) {
    int actualResult = solution.rob(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
