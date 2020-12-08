package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SetMismatch_645Test {

  private final SetMismatch_645 solution = new SetMismatch_645();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 2, 4}, new int[] {2, 3}),
          arguments(new int[] {2, 3, 2}, new int[] {2, 1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findErrorNums(int[] input, int[] expectedResult) {
    int[] actualResult = solution.findErrorNums(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
