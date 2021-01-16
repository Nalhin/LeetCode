package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeleteAndEarn_740Test {

  private final DeleteAndEarn_740 solution = new DeleteAndEarn_740();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 4, 2}, 6),
          arguments(new int[] {2, 2, 3, 3, 3, 4}, 9),
          arguments(new int[] {}, 0),
          arguments(new int[] {3, 1}, 4),
          arguments(new int[] {1, 1, 1, 2, 4, 5, 5, 5, 6}, 18),
          arguments(new int[] {8, 10, 4, 9, 1, 3, 5, 9, 4, 10}, 37));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void deleteAndEarn(int[] nums, int expectedResult) {
    int actualResult = solution.deleteAndEarn(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
