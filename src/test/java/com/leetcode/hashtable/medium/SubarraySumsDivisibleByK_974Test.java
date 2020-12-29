package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubarraySumsDivisibleByK_974Test {

  private final SubarraySumsDivisibleByK_974 solution = new SubarraySumsDivisibleByK_974();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {4, 5, 0, -2, -3, 1}, 5, 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subarraysDivByK(int[] input, int k, int expectedResult) {
    int actualResult = solution.subarraysDivByK(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
