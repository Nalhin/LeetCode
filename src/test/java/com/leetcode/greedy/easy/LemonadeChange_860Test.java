package com.leetcode.greedy.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LemonadeChange_860Test {
  private final LemonadeChange_860 solution = new LemonadeChange_860();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 5, 5, 10, 20}, true),
          arguments(new int[] {5, 5, 10}, true),
          arguments(new int[] {10, 10}, false),
          arguments(new int[] {5, 5, 10, 10, 20}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lemonadeChange(int[] input, boolean expectedResult) {
    boolean actualResult = solution.lemonadeChange(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
