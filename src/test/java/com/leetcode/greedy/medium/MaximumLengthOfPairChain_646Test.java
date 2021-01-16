package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumLengthOfPairChain_646Test {

  private final MaximumLengthOfPairChain_646 solution = new MaximumLengthOfPairChain_646();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2}, {2, 3}, {3, 4}}, 2),
          arguments(
              new int[][] {
                {9, 10}, {9, 10}, {4, 5}, {-9, -3}, {-9, -1}, {0, 3}, {6, 10}, {-5, -4}, {-7, -6}
              },
              5),
          arguments(
              new int[][] {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}},
              4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLongestChain(int[][] pairs, int expectedResult) {
    int actualResult = solution.findLongestChain(pairs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
