package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FourSumII_454Test {

  private final FourSumII_454 solution = new FourSumII_454();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void fourSumCount(int[] A, int[] B, int[] C, int[] D, int expectedResult) {

    int actualResult = solution.fourSumCount(A, B, C, D);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
