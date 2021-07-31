package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthSmallestElementInASortedMatrix_378Test {

  private final KthSmallestElementInASortedMatrix_378 solution =
      new KthSmallestElementInASortedMatrix_378();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8, 13),
          arguments(new int[][] {{-5}}, 1, -5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void kthSmallest(int[][] matrix, int k, int expectedResult) {
    int actualResult = solution.kthSmallest(matrix, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
