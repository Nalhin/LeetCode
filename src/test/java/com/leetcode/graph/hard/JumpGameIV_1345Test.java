package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JumpGameIV_1345Test {

  private final JumpGameIV_1345 solution = new JumpGameIV_1345();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}, 3),
          arguments(new int[] {7}, 0),
          arguments(new int[] {7, 6, 9, 6, 9, 6, 9, 7}, 1),
          arguments(new int[] {6, 1, 9}, 2),
          arguments(new int[] {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minJumps(int[] input, int expectedResult) {
    int actualResult = solution.minJumps(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
