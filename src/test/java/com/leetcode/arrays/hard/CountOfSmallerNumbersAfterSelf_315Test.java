package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountOfSmallerNumbersAfterSelf_315Test {

  private final CountOfSmallerNumbersAfterSelf_315 solution =
      new CountOfSmallerNumbersAfterSelf_315();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 2, 6, 1}, List.of(2, 1, 1, 0)),
          arguments(new int[] {-1}, List.of(0)),
          arguments(new int[] {-1, -1}, List.of(0, 0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countSmaller(int[] nums, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.countSmaller(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
