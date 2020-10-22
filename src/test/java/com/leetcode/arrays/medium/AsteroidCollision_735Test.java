package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AsteroidCollision_735Test {

  AsteroidCollision_735 solution = new AsteroidCollision_735();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 10, -5}, new int[] {5, 10}),
          arguments(new int[] {8, -8}, new int[] {}),
          arguments(new int[] {10, 2, -5}, new int[] {10}),
          arguments(new int[] {-2, -1, 1, 2}, new int[] {-2, -1, 1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void asteroidCollision(int[] input, int[] expectedResult) {
    int[] actualResult = solution.asteroidCollision(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
