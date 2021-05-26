package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwoSum_1Test {

  private final TwoSum_1 solution = new TwoSum_1();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
          arguments(new int[] {3, 3}, 6, new int[] {0, 1}),
          arguments(new int[] {3, 2, 4}, 6, new int[] {1, 2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonPrefix(int[] input, int target, int[] expectedResult) {

    int[] actualResult = solution.twoSum(input, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
