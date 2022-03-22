package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximizeNumberOfSubsequencesInAString_2207Test {

  private final MaximizeNumberOfSubsequencesInAString_2207 solution =
      new MaximizeNumberOfSubsequencesInAString_2207();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abdcdbc", "ac", 4), arguments("aabb", "ab", 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumSubsequenceCount(String input, String pattern, long expectedResult) {
    long actualResult = solution.maximumSubsequenceCount(input, pattern);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
