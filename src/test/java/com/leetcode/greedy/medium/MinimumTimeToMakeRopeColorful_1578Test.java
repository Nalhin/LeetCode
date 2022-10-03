package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumTimeToMakeRopeColorful_1578Test {

  private final MinimumTimeToMakeRopeColorful_1578 solution =
      new MinimumTimeToMakeRopeColorful_1578();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abaac",  new int[]{1,2,3,4,5}, 3), arguments("abc", new int[]{1,2,3}, 0), arguments("aabaa", new int[]{1,2,3,4,1}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(MinimumTimeToMakeRopeColorful_1578Test.TestArgumentsProvider.class)
  void minCost(String colors, int[] neededTime, int expectedResult) {
    int actualResult = solution.minCost(colors, neededTime);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
