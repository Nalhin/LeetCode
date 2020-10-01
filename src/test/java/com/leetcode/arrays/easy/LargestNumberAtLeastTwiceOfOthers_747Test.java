package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestNumberAtLeastTwiceOfOthers_747Test {

  private final LargestNumberAtLeastTwiceOfOthers_747 solution =
      new LargestNumberAtLeastTwiceOfOthers_747();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {3, 6, 1, 0}, 1), arguments(new int[] {1, 2, 3, 4}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void dominantIndex(int[] input, int expectedResult) {

    int actualResult = solution.dominantIndex(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
