package com.leetcode.greedy.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LastStoneWeight_1046Test {

  private final LastStoneWeight_1046 solution = new LastStoneWeight_1046();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {2, 7, 4, 1, 8, 1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lastStoneWeight(int[] input, int expectedResult) {

    int actualResult = solution.lastStoneWeight(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
