package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SequentialDigits_1291Test {

  private final SequentialDigits_1291 solution = new SequentialDigits_1291();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(100, 300, List.of(123, 234)),
          arguments(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345)),
          arguments(234, 2314, List.of(234, 345, 456, 567, 678, 789, 1234)),
          arguments(1_000_000_00, 1_000_000_000, List.of(123_456_789)),
          arguments(15_753_396, 106_864_044, List.of(23456789)),
          arguments(89, 234, List.of(89, 123, 234)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sequentialDigits(int low, int high, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.sequentialDigits(low, high);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
