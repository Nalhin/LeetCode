package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TeemoAttacking_495Test {

  private final TeemoAttacking_495 solution = new TeemoAttacking_495();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {1, 4}, 2, 4), arguments(new int[] {1, 2}, 2, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findPoisonedDuration(int[] input, int duration, int expectedResult) {

    int actualResult = solution.findPoisonedDuration(input, duration);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
