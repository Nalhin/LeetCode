package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniqueNumberOfOccurrences_1207Test {

  private final UniqueNumberOfOccurrences_1207 solution = new UniqueNumberOfOccurrences_1207();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 2, 1, 1, 3}, true),
          arguments(new int[] {1, 2}, false),
          arguments(new int[] {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uniqueOccurrences(int[] input, boolean expectedResult) {

    boolean actualResult = solution.uniqueOccurrences(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
