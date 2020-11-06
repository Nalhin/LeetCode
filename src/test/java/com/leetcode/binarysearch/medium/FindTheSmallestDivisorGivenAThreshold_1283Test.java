package com.leetcode.binarysearch.medium;

import com.leetcode.binarysearch.medium.FindTheSmallestDivisorGivenAThreshold_1283;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheSmallestDivisorGivenAThreshold_1283Test {
  private final FindTheSmallestDivisorGivenAThreshold_1283 solution =
      new FindTheSmallestDivisorGivenAThreshold_1283();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 5, 9}, 6, 5),
          arguments(new int[] {2, 3, 5, 7, 11}, 11, 3),
          arguments(new int[] {19}, 5, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestDivisor(int[] input, int threshold, int expectedResult) {

    int actualResult = solution.smallestDivisor(input, threshold);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
