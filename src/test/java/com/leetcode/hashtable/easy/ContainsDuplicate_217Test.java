package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicate_217Test {

  private final ContainsDuplicate_217 solution = new ContainsDuplicate_217();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 1}, true),
          arguments(new int[] {1, 2, 3, 4}, false),
          arguments(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void containsDuplicate(int[] input, boolean expectedResult) {

    boolean actualResult = solution.containsDuplicate(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
