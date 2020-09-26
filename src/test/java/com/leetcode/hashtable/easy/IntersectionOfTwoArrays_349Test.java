package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntersectionOfTwoArrays_349Test {

  private final IntersectionOfTwoArrays_349 solution = new IntersectionOfTwoArrays_349();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 2, 1}, new int[] {2, 2}, new int[] {2}),
          arguments(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}, new int[] {4, 9}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void intersection(int[] input1, int[] input2, int[] expectedResult) {

    int[] actualResult = solution.intersection(input1, input2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
