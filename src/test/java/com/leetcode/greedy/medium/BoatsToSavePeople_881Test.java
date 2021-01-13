package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BoatsToSavePeople_881Test {

  private final BoatsToSavePeople_881 solution = new BoatsToSavePeople_881();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2}, 3, 1),
          arguments(new int[] {3, 2, 2, 1}, 3, 3),
          arguments(new int[] {3, 5, 3, 4}, 5, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numRescueBoats(int[] people, int limit, int expectedResult) {
    int actualResult = solution.numRescueBoats(people, limit);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
