package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthSmallestNumberInMultiplicationTable_668Test {

  private final KthSmallestNumberInMultiplicationTable_668 solution =
      new KthSmallestNumberInMultiplicationTable_668();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, 3, 5), arguments(2, 3, 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findKthNumber(int m, int n, int k, int expectedResult) {
    int actualResult = solution.findKthNumber(m, n, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
