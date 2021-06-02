package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InterleavingString_97Test {

  private final InterleavingString_97.SingleDimensionalDp solutionSingleDimensionalDp =
      new InterleavingString_97.SingleDimensionalDp();
  private final InterleavingString_97.TwoDimensionalDp solutionTwoDimensionalDp =
      new InterleavingString_97.TwoDimensionalDp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aabcc", "dbbca", "aadbbcbcac", true),
          arguments("aabcc", "dbbca", "adbbbaccc", false),
          arguments("", "", "", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isInterleaveSingleDimensionalDp(String s1, String s2, String s3, boolean expectedResult) {
    boolean actualResult = solutionSingleDimensionalDp.isInterleave(s1, s2, s3);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isInterleaveTwoDimensionalDp(String s1, String s2, String s3, boolean expectedResult) {
    boolean actualResult = solutionTwoDimensionalDp.isInterleave(s1, s2, s3);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
