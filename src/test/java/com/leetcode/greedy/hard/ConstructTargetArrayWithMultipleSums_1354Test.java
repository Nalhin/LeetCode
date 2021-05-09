package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConstructTargetArrayWithMultipleSums_1354Test {

  private final ConstructTargetArrayWithMultipleSums_1354 solution =
      new ConstructTargetArrayWithMultipleSums_1354();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {9, 3, 5}, true),
          arguments(new int[] {1, 1, 1, 2}, false),
          arguments(new int[] {8, 5}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPossible(int[] arr, boolean expectedResult) {
    boolean actualResult = solution.isPossible(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
